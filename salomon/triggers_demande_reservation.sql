?--------------------------------------------- function To insert into reservation periode on successful demande ---------------------------------------------

CREATE OR REPLACE FUNCTION insert_to_reservation_periode()
  RETURNS TRIGGER AS $check_reservation$

DECLARE
  i INT;

BEGIN
  IF check_reservation_periode(NEW.duree, NEW.pavillon_id, NEW.local_id, NEW.heure, NEW.jour) IS
     TRUE
  THEN

    FOR i IN 0.. (NEW.duree - 1) LOOP
      INSERT INTO RESERVATION_PERIODE (PAVILLON_ID, LOCAL_ID, HEURE, JOUR, RESERVATION_DEMANDE_ID)
      VALUES (NEW.pavillon_id, NEW.local_id, NEW.heure + i * INTERVAL '30 minutes', NEW.jour,
              NEW.reservation_demande_id);
    END LOOP;
  ELSE
    DELETE FROM RESERVATION_DEMANDE
    WHERE reservation_demande_id = NEW.reservation_demande_id;
  END IF;
  RETURN NEW;
END;
$check_reservation$
LANGUAGE 'plpgsql';


--------------------------------------------- Function that checks if time period is free ---------------------------------------------
CREATE OR REPLACE FUNCTION check_reservation_periode(p_duree INT, p_pav TEXT, p_local TEXT,
                                                     p_heure TIME, p_jour DATE)
  RETURNS BOOLEAN AS
  $$
  BEGIN
    IF (
         SELECT count(*)

         FROM
           RESERVATION_PERIODE

         WHERE
           RESERVATION_PERIODE.heure >= p_heure AND --heure AND
           RESERVATION_PERIODE.heure <= p_heure + (p_duree - 1) * INTERVAL '30 minutes' AND
           RESERVATION_PERIODE.PAVILLON_ID = p_pav AND
           RESERVATION_PERIODE.LOCAL_ID = p_local AND
           RESERVATION_PERIODE.JOUR = p_jour
       ) > 0
    THEN
      RETURN FALSE;
      RAISE NOTICE 'Periode not available';
    ELSE
      RETURN TRUE;
      RAISE NOTICE 'Periode available';
    END IF;


  END;
  $$
LANGUAGE 'plpgsql';

-- SELECT * FROM check_reservation_periode(2, 'C1', '3035', '04:00:00', '2001-01-01');

	
--------------------------------------------- Trigger to check if reservation is allowed and add to reservations_periode if good ---------------------------------------------

DROP TRIGGER check_reservation ON reservation_demande;

CREATE TRIGGER check_reservation
AFTER INSERT ON reservation_demande
FOR EACH ROW
EXECUTE PROCEDURE insert_to_reservation_periode();


---------------------------------------------Requete pour insertions de reservation ---------------------------------------------

insert into RESERVATION_DEMANDE (RESERVATION_DEMANDE_ID, HEURE, PAVILLON_ID, LOCAL_ID, CIP, JOUR, DUREE, DESCRIPTION, INSCRIPTION) values (5, '00:00:00', 'C1', '3035', 'rice1902', '01-01-01', 3, 'S6-3035-4', '01-01-01');


---------------------------------------------Requete pour supression de reservation---------------------------------------------

CREATE OR REPLACE FUNCTION delete_from_reservation_periode()
  RETURNS TRIGGER AS $delete_reservation$

BEGIN
  DELETE FROM RESERVATION_PERIODE
  WHERE RESERVATION_PERIODE.reservation_demande_id = OLD.reservation_demande_id;
  RETURN OLD;
END;
$delete_reservation$
LANGUAGE 'plpgsql';


DROP TRIGGER delete_reservation ON reservation_demande;

CREATE TRIGGER delete_reservation
BEFORE DELETE ON reservation_demande
FOR EACH ROW
EXECUTE PROCEDURE delete_from_reservation_periode();


-- DELETE FROM RESERVATION_DEMANDE WHERE RESERVATION_DEMANDE_ID = 5;



---------------------------------------------Requete pour modification de reservation---------------------------------------------

CREATE OR REPLACE FUNCTION modify_reservation_periode()
  RETURNS TRIGGER AS $modify_reservation$
DECLARE
  i INT;

BEGIN

  IF check_reservation_periode_update(NEW.duree, NEW.pavillon_id, NEW.local_id, NEW.heure, NEW.jour,
                                      NEW.reservation_demande_id) IS TRUE
  THEN
    DELETE FROM RESERVATION_PERIODE
    WHERE RESERVATION_PERIODE.reservation_demande_id = OLD.reservation_demande_id;
    FOR i IN 0.. (NEW.duree - 1) LOOP
      INSERT INTO RESERVATION_PERIODE (PAVILLON_ID, LOCAL_ID, HEURE, JOUR, RESERVATION_DEMANDE_ID)
      VALUES (NEW.pavillon_id, NEW.local_id, NEW.heure + i * INTERVAL '30 minutes', NEW.jour,
              NEW.reservation_demande_id);
    END LOOP;
  ELSE
    NEW =  OLD;
  END IF;
  RETURN NEW;


END;
$modify_reservation$
LANGUAGE 'plpgsql';


--------------------------------------------- Function that checks if time period is free for update ---------------------------------------------
CREATE OR REPLACE FUNCTION check_reservation_periode_update(p_duree                  INT,
                                                            p_pav                    TEXT,
                                                            p_local                  TEXT,
                                                            p_heure                  TIME,
                                                            p_jour                   DATE,
                                                            p_reservation_demande_id INT)
  RETURNS BOOLEAN AS
  $$
  BEGIN
    IF (
         SELECT count(*)

         FROM
           RESERVATION_PERIODE

         WHERE
           RESERVATION_PERIODE.heure >= p_heure AND
           RESERVATION_PERIODE.heure <= p_heure + (p_duree - 1) * INTERVAL '30 minutes' AND
           RESERVATION_PERIODE.PAVILLON_ID = p_pav AND
           RESERVATION_PERIODE.LOCAL_ID = p_local AND
           RESERVATION_PERIODE.JOUR = p_jour AND
           RESERVATION_PERIODE.reservation_demande_id != p_reservation_demande_id
       ) > 0
    THEN
      RETURN FALSE;
      RAISE NOTICE 'Periode not available';
    ELSE
      RETURN TRUE;
      RAISE NOTICE 'Periode available';
    END IF;


  END;
  $$
LANGUAGE 'plpgsql';


---------------------------------------------Trigger pour modification de reservation- ---------------------------------------------

DROP TRIGGER modify_reservation ON reservation_demande;

CREATE TRIGGER modify_reservation
BEFORE UPDATE ON reservation_demande
FOR EACH ROW
EXECUTE PROCEDURE modify_reservation_periode();
--DELETE FROM reservation_demande WHERE  reservation_demande.reservation_demande_id = 5;

UPDATE reservation_demande
SET heure='02:30:00'
WHERE RESERVATION_DEMANDE_ID = 5;

SELECT *
FROM reservation_demande;
SELECT *
FROM reservation_periode;


-- insert into RESERVATION_DEMANDE (RESERVATION_DEMANDE_ID, HEURE, PAVILLON_ID, LOCAL_ID, CIP, JOUR, DUREE, DESCRIPTION, INSCRIPTION) values (4, '00:00:00', 'C1', '3035', 'rice1902', '01-01-01', 6, 'S6-3035-4', '01-01-01');

