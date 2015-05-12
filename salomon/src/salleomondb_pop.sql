insert into CAMPUS (CAMPUS_ID, LIBELLE, INSCRIPTION) values (1, 'Principal', '1-1-1');

insert into CATEGORIE_LOCAUX (CATEGORIE_ID, LIBELLE, INSCRIPTION) values (1, 'Laboratoire', '1-1-1');

insert into CATEGORIE_LOCAUX (CATEGORIE_ID, LIBELLE, INSCRIPTION) values (2, 'Projet', '1480-9-17');

insert into CATEGORIE_LOCAUX (CATEGORIE_ID, LIBELLE, INSCRIPTION) values (3, 'Réunion', '552-4-4');

insert into PERIODE (HEURE, INSCRIPTION) values ('00:00:00', '1-1-1');

insert into PERIODE (HEURE, INSCRIPTION) values ('00:30:00', '1182-1-1');

insert into PERIODE (HEURE, INSCRIPTION) values ('01:00:00', '922-6-22');

insert into PERIODE (HEURE, INSCRIPTION) values ('01:30:00', '360-9-26');

insert into PERIODE (HEURE, INSCRIPTION) values ('02:00:00', '361-9-26');

insert into PERIODE (HEURE, INSCRIPTION) values ('02:30:00', '361-9-26');

insert into PERIODE (HEURE, INSCRIPTION) values ('03:00:00', '361-9-26');

insert into PERIODE (HEURE, INSCRIPTION) values ('03:30:00', '361-9-26');

insert into PERIODE (HEURE, INSCRIPTION) values ('04:00:00', '361-9-26');

insert into PERIODE (HEURE, INSCRIPTION) values ('04:30:00', '361-9-26');

insert into ROLE (ROLE_ID, LIBELLE, INSCRIPTION) values (1, 'admin', '943-11-13');

insert into ROLE (ROLE_ID, LIBELLE, INSCRIPTION) values (2, 'étudiant', '266-2-2');

insert into ROLE (ROLE_ID, LIBELLE, INSCRIPTION) values (3, 'secrétaire', '556-2-7');

insert into ROLE (ROLE_ID, LIBELLE, INSCRIPTION) values (4, 'enseignant', '1-1-1');

insert into EVENEMENT (EVENEMENT_ID, LIBELLE, INSCRIPTION) values (1, 'connexion', '917-2-16');

insert into EVENEMENT (EVENEMENT_ID, LIBELLE, INSCRIPTION) values (2, 'modification', '1-1-1');

insert into EVENEMENT (EVENEMENT_ID, LIBELLE, INSCRIPTION) values (3, 'destruction', '322-10-14');

insert into EVENEMENT (EVENEMENT_ID, LIBELLE, INSCRIPTION) values (4, 'ajout usager', '586-2-17');

insert into RESSOURCE (RESSOURCE_ID, LIBELLE, INSCRIPTION) values (1, 'table', '371-7-13');

insert into RESSOURCE (RESSOURCE_ID, LIBELLE, INSCRIPTION) values (2, 'chaise', '1-1-1');

insert into RESSOURCE (RESSOURCE_ID, LIBELLE, INSCRIPTION) values (3, 'ordinateur', '946-6-1');

insert into RESSOURCE (RESSOURCE_ID, LIBELLE, INSCRIPTION) values (4, 'tableau', '1394-1-28');

insert into UTILISATEUR (CIP, _NOM, PRENOM, COURRIEL, TELEPHONE, LOCAL, INSCRIPTION) values ('rice1902', 'Etienne', 'Richan', 'er@udes.ca', '819-333-1234', 'SomeLocal', '1636-10-16');

insert into UTILISATEUR (CIP, _NOM, PRENOM, COURRIEL, TELEPHONE, LOCAL, INSCRIPTION) values ('pieb6669', 'Bob', 'Pierre', 'bp@udes.ca', '819-333-1235', 'SomeOtherLocal', '1177-6-16');

insert into USAGER_ROLE (CIP, ROLE_ID) values ('rice1902', 1);

insert into USAGER_ROLE (CIP, ROLE_ID) values ('pieb6669', 2);

insert into PAVILLON (PAVILLON_ID, CAMPUS_ID, LIBELLE, INSCRIPTION) values ('C1', 1, 'Genie connu', '1615-11-18');

insert into PAVILLON (PAVILLON_ID, CAMPUS_ID, LIBELLE, INSCRIPTION) values ('D1', 1, 'Sciences Loin', '581-3-27');

insert into PAVILLON (PAVILLON_ID, CAMPUS_ID, LIBELLE, INSCRIPTION) values ('D7', 1, 'Sciences moins loin', '1-1-1');

insert into PAVILLON (PAVILLON_ID, CAMPUS_ID, LIBELLE, INSCRIPTION) values ('C2', 1, 'Genie perdu', '1133-11-5');

insert into LOCAUX (PAVILLON_ID, LOCAL_ID, CATEGORIE_ID, NOTE, INSCRIPTION) values ('C1', '3035', 2, '', '1960-11-9');

insert into LOCAUX (PAVILLON_ID, LOCAL_ID, CATEGORIE_ID, NOTE, INSCRIPTION) values ('D1', '3024', 1, '', '1-1-1');

insert into LOCAUX (PAVILLON_ID, LOCAL_ID, CATEGORIE_ID, NOTE, INSCRIPTION) values ('D7', '5005', 2, '', '1431-6-25');

insert into LOCAUX (PAVILLON_ID, LOCAL_ID, CATEGORIE_ID, NOTE, INSCRIPTION) values ('C2', '3024', 3, '', '709-2-11');

insert into LOCAUX_RESSOURCE (PAVILLON_ID, LOCAL_ID, RESSOURCE_ID, QUANTITE, INSCRIPTION) values ('C1', '3035', 1, 6, '682-1-22');

insert into LOCAUX_RESSOURCE (PAVILLON_ID, LOCAL_ID, RESSOURCE_ID, QUANTITE, INSCRIPTION) values ('D1', '3024', 2, 2, '1-1-1');

insert into LOCAUX_RESSOURCE (PAVILLON_ID, LOCAL_ID, RESSOURCE_ID, QUANTITE, INSCRIPTION) values ('D7', '5005', 3, 3, '1034-2-16');

insert into LOCAUX_RESSOURCE (PAVILLON_ID, LOCAL_ID, RESSOURCE_ID, QUANTITE, INSCRIPTION) values ('C2', '3024', 4, 4, '1512-12-2');


insert into RESERVATION_DEMANDE (RESERVATION_DEMANDE_ID, HEURE, PAVILLON_ID, LOCAL_ID, CIP, JOUR, DUREE, DESCRIPTION, INSCRIPTION) values (2, '2:30:00', 'C1', '3035', 'rice1902', '01-01-01', 1, 'S6', '01-01-01');

insert into RESERVATION_PERIODE (PAVILLON_ID, LOCAL_ID, HEURE, JOUR, RESERVATION_DEMANDE_ID) values ('C1', '3035', '2:30:00', '01-01-01', 2);