CREATE OR REPLACE FUNCTION public.get_reservation_table(in p_cat text, in p_jour date, in p_start_time time, in p_end_time time)
  RETURNS SETOF record
AS
$BODY$
  SELECT
  PERIODE_LOCAUX_CATEGORIE.heure,
  PERIODE_LOCAUX_CATEGORIE.pavillon_id::text || '-' || PERIODE_LOCAUX_CATEGORIE.local_id::text AS pav_local_id,
  RESERVATIONS.description

FROM
  (SELECT
    heure,
    local_id,
    pavillon_id
  FROM
    periode cross join locaux, categorie_locaux
--   WHERE
--     locaux.categorie_id = categorie_locaux.categorie_id AND
--     periode.heure >= p_start_time AND
--     periode.heure <= p_end_time AND
--     categorie_locaux.libelle = p_cat ---VARIABLE CATEGORIE
  ) AS PERIODE_LOCAUX_CATEGORIE

  LEFT JOIN
   (SELECT
     --*
     reservation_periode.heure, reservation_demande.description, reservation_periode.local_id, reservation_periode.jour
     FROM
      reservation_periode, reservation_demande
     WHERE
      reservation_periode.reservation_demande_id = reservation_demande.reservation_demande_id
     ) AS RESERVATIONS
    ON
    PERIODE_LOCAUX_CATEGORIE.heure = RESERVATIONS.heure AND
    PERIODE_LOCAUX_CATEGORIE.local_id = RESERVATIONS.local_ID AND
    RESERVATIONS.jour = p_jour
ORDER BY
  PERIODE_LOCAUX_CATEGORIE.heure;
$BODY$
LANGUAGE sql VOLATILE;
