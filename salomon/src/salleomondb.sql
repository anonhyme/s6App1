/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     2015-05-07 2:37:45 PM                        */
/*==============================================================*/


-- drop index CAMPUS_PK;
--
-- drop table CAMPUS;
--
-- drop index CATEGORIE_LOCAUX_PK;
--
-- drop table CATEGORIE_LOCAUX;
--
-- drop index EVENEMENT_PK;
--
-- drop table EVENEMENT;
--
-- drop index FAIT_PARTI_DE_LA_CATEGORIE_FK;
--
-- drop index EST_DANS_LE_PAVILLON_FK;
--
-- drop index LOCAUX_PK;
--
-- drop table LOCAUX;
--
-- drop index LOCAUX_RESSOURCE_FK2;
--
-- drop index LOCAUX_RESSOURCE_FK;
--
-- drop index LOCAUX_RESSOURCE_PK;
--
-- drop table LOCAUX_RESSOURCE;
--
-- drop index POUR_LE_LOG_FK;
--
-- drop index EST_DANS_LE_LOG_FK;
--
-- drop index LOG_PK;
--
-- drop table LOG;
--
-- drop index EST_DANS_LE_CAPMUS_FK;
--
-- drop index PAVILLON_PK;
--
-- drop table PAVILLON;
--
-- drop index PERIODE_PK;
--
-- drop table PERIODE;
--
-- drop index PERIODE_DEBUT_FK;
--
-- drop index LOCAL_RESERVE_FK;
--
-- drop index UTILISATEUR_RESERVE_FK;
--
-- drop index RESERVATION_DEMANDE_PK;
--
-- drop table RESERVATION_DEMANDE;
--
-- drop index POUR_LA_PERIODE_FK;
--
-- drop index POUR_LA_RESERVATION_DEMANDE_FK;
--
-- drop index POUR_LE_LOCAL_FK;
--
-- drop index RESERVATION_PERIODE_PK;
--
-- drop table RESERVATION_PERIODE;
--
-- drop index RESSOURCE_PK;
--
-- drop table RESSOURCE;
--
-- drop index ROLE_PK;
--
-- drop table ROLE;
--
-- drop index USAGER_ROLE_FK2;
--
-- drop index USAGER_ROLE_FK;
--
-- drop index USAGER_ROLE_PK;
--
-- drop table USAGER_ROLE;
--
-- drop index UTILISATEUR_PK;
--
-- drop table UTILISATEUR;

/*==============================================================*/
/* Table: CAMPUS                                                */
/*==============================================================*/
CREATE TABLE CAMPUS (
  CAMPUS_ID   NUMERIC NOT NULL,
  LIBELLE     TEXT    NOT NULL,
  INSCRIPTION DATE    NOT NULL,
  CONSTRAINT PK_CAMPUS PRIMARY KEY (CAMPUS_ID),
  CONSTRAINT AK_AK_CAMPUS_CAMPUS UNIQUE (LIBELLE)
);

/*==============================================================*/
/* Index: CAMPUS_PK                                             */
/*==============================================================*/
CREATE UNIQUE INDEX CAMPUS_PK ON CAMPUS (
  CAMPUS_ID
);

/*==============================================================*/
/* Table: CATEGORIE_LOCAUX                                      */
/*==============================================================*/
CREATE TABLE CATEGORIE_LOCAUX (
  CATEGORIE_ID NUMERIC NOT NULL,
  LIBELLE      TEXT    NOT NULL,
  INSCRIPTION  DATE    NOT NULL DEFAULT current_date,
  CONSTRAINT PK_CATEGORIE_LOCAUX PRIMARY KEY (CATEGORIE_ID),
  CONSTRAINT AK_AK_CATEGORIE_CATEGORI UNIQUE (LIBELLE)
);

/*==============================================================*/
/* Index: CATEGORIE_LOCAUX_PK                                   */
/*==============================================================*/
CREATE UNIQUE INDEX CATEGORIE_LOCAUX_PK ON CATEGORIE_LOCAUX (
  CATEGORIE_ID
);

/*==============================================================*/
/* Table: EVENEMENT                                             */
/*==============================================================*/
CREATE TABLE EVENEMENT (
  EVENEMENT_ID NUMERIC NOT NULL,
  LIBELLE      TEXT    NOT NULL,
  INSCRIPTION  DATE    NOT NULL DEFAULT 'now()',
  CONSTRAINT PK_EVENEMENT PRIMARY KEY (EVENEMENT_ID),
  CONSTRAINT AK_AK_EVENEMENT_EVENEMEN UNIQUE (LIBELLE)
);

/*==============================================================*/
/* Index: EVENEMENT_PK                                          */
/*==============================================================*/
CREATE UNIQUE INDEX EVENEMENT_PK ON EVENEMENT (
  EVENEMENT_ID
);

/*==============================================================*/
/* Table: LOCAUX                                                */
/*==============================================================*/
CREATE TABLE LOCAUX (
  PAVILLON_ID  CHAR(2) NOT NULL,
  LOCAL_ID     TEXT    NOT NULL,
  CATEGORIE_ID NUMERIC NULL,
  NOTE         TEXT    NULL,
  INSCRIPTION  DATE    NOT NULL,
  CONSTRAINT PK_LOCAUX PRIMARY KEY (PAVILLON_ID, LOCAL_ID)
);

/*==============================================================*/
/* Index: LOCAUX_PK                                             */
/*==============================================================*/
CREATE UNIQUE INDEX LOCAUX_PK ON LOCAUX (
  PAVILLON_ID,
  LOCAL_ID
);

/*==============================================================*/
/* Index: EST_DANS_LE_PAVILLON_FK                               */
/*==============================================================*/
CREATE INDEX EST_DANS_LE_PAVILLON_FK ON LOCAUX (
  PAVILLON_ID
);

/*==============================================================*/
/* Index: FAIT_PARTI_DE_LA_CATEGORIE_FK                         */
/*==============================================================*/
CREATE INDEX FAIT_PARTI_DE_LA_CATEGORIE_FK ON LOCAUX (
  CATEGORIE_ID
);

/*==============================================================*/
/* Table: LOCAUX_RESSOURCE                                      */
/*==============================================================*/
CREATE TABLE LOCAUX_RESSOURCE (
  PAVILLON_ID  CHAR(2) NOT NULL,
  LOCAL_ID     TEXT    NOT NULL,
  RESSOURCE_ID NUMERIC NOT NULL,
  QUANTITE     NUMERIC NULL,
  INSCRIPTION  DATE    NOT NULL,
  CONSTRAINT PK_LOCAUX_RESSOURCE PRIMARY KEY (PAVILLON_ID, LOCAL_ID, RESSOURCE_ID)
);

/*==============================================================*/
/* Index: LOCAUX_RESSOURCE_PK                                   */
/*==============================================================*/
CREATE UNIQUE INDEX LOCAUX_RESSOURCE_PK ON LOCAUX_RESSOURCE (
  PAVILLON_ID,
  LOCAL_ID,
  RESSOURCE_ID
);

/*==============================================================*/
/* Index: LOCAUX_RESSOURCE_FK                                   */
/*==============================================================*/
CREATE INDEX LOCAUX_RESSOURCE_FK ON LOCAUX_RESSOURCE (
  PAVILLON_ID,
  LOCAL_ID
);

/*==============================================================*/
/* Index: LOCAUX_RESSOURCE_FK2                                  */
/*==============================================================*/
CREATE INDEX LOCAUX_RESSOURCE_FK2 ON LOCAUX_RESSOURCE (
  RESSOURCE_ID
);

/*==============================================================*/
/* Table: LOG                                                   */
/*==============================================================*/
CREATE TABLE LOG (
  LOG_ID       INT4    NOT NULL,
  CIP          CHAR(8) NOT NULL,
  EVENEMENT_ID NUMERIC NOT NULL,
  COMMENTAIRE  TEXT    NULL,
  _INSCRIPTION DATE    NOT NULL,
  CONSTRAINT PK_LOG PRIMARY KEY (LOG_ID)
);

/*==============================================================*/
/* Index: LOG_PK                                                */
/*==============================================================*/
CREATE UNIQUE INDEX LOG_PK ON LOG (
  LOG_ID
);

/*==============================================================*/
/* Index: EST_DANS_LE_LOG_FK                                    */
/*==============================================================*/
CREATE INDEX EST_DANS_LE_LOG_FK ON LOG (
  CIP
);

/*==============================================================*/
/* Index: POUR_LE_LOG_FK                                        */
/*==============================================================*/
CREATE INDEX POUR_LE_LOG_FK ON LOG (
  EVENEMENT_ID
);

/*==============================================================*/
/* Table: PAVILLON                                              */
/*==============================================================*/
CREATE TABLE PAVILLON (
  PAVILLON_ID CHAR(2) NOT NULL,
  CAMPUS_ID   NUMERIC NULL,
  LIBELLE     TEXT    NOT NULL,
  INSCRIPTION DATE    NOT NULL DEFAULT 'now()',
  CONSTRAINT PK_PAVILLON PRIMARY KEY (PAVILLON_ID),
  CONSTRAINT AK_AK_PAVILLON_PAVILLON UNIQUE (LIBELLE)
);

/*==============================================================*/
/* Index: PAVILLON_PK                                           */
/*==============================================================*/
CREATE UNIQUE INDEX PAVILLON_PK ON PAVILLON (
  PAVILLON_ID
);

/*==============================================================*/
/* Index: EST_DANS_LE_CAPMUS_FK                                 */
/*==============================================================*/
CREATE INDEX EST_DANS_LE_CAPMUS_FK ON PAVILLON (
  CAMPUS_ID
);

/*==============================================================*/
/* Table: PERIODE                                               */
/*==============================================================*/
CREATE TABLE PERIODE (
  HEURE       TIME NOT NULL,
  INSCRIPTION DATE NOT NULL,
  CONSTRAINT PK_PERIODE PRIMARY KEY (HEURE)
);

/*==============================================================*/
/* Index: PERIODE_PK                                            */
/*==============================================================*/
CREATE UNIQUE INDEX PERIODE_PK ON PERIODE (
  HEURE
);

/*==============================================================*/
/* Table: RESERVATION_DEMANDE                                   */
/*==============================================================*/
CREATE TABLE RESERVATION_DEMANDE (
  RESERVATION_DEMANDE_ID SERIAL  NOT NULL,
  HEURE                  TIME    NOT NULL,
  PAVILLON_ID            CHAR(2) NOT NULL,
  LOCAL_ID               TEXT    NOT NULL,
  CIP                    CHAR(8) NOT NULL,
  JOUR                   DATE    NOT NULL,
  DUREE                  INT4    NOT NULL,
  DESCRIPTION            TEXT    NULL,
  INSCRIPTION            DATE    NOT NULL,
  CONSTRAINT PK_RESERVATION_DEMANDE PRIMARY KEY (RESERVATION_DEMANDE_ID)
);

/*==============================================================*/
/* Index: RESERVATION_DEMANDE_PK                                */
/*==============================================================*/
CREATE UNIQUE INDEX RESERVATION_DEMANDE_PK ON RESERVATION_DEMANDE (
  RESERVATION_DEMANDE_ID
);

/*==============================================================*/
/* Index: UTILISATEUR_RESERVE_FK                                */
/*==============================================================*/
CREATE INDEX UTILISATEUR_RESERVE_FK ON RESERVATION_DEMANDE (
  CIP
);

/*==============================================================*/
/* Index: LOCAL_RESERVE_FK                                      */
/*==============================================================*/
CREATE INDEX LOCAL_RESERVE_FK ON RESERVATION_DEMANDE (
  PAVILLON_ID,
  LOCAL_ID
);

/*==============================================================*/
/* Index: PERIODE_DEBUT_FK                                      */
/*==============================================================*/
CREATE INDEX PERIODE_DEBUT_FK ON RESERVATION_DEMANDE (
  HEURE
);

/*==============================================================*/
/* Table: RESERVATION_PERIODE                                   */
/*==============================================================*/
CREATE TABLE RESERVATION_PERIODE (
  PAVILLON_ID            CHAR(2) NOT NULL,
  LOCAL_ID               TEXT    NOT NULL,
  HEURE                  TIME    NOT NULL,
  JOUR                   DATE    NOT NULL,
  RESERVATION_DEMANDE_ID INT4    NOT NULL,
  CONSTRAINT PK_RESERVATION_PERIODE PRIMARY KEY (PAVILLON_ID, LOCAL_ID, HEURE, JOUR)
);

/*==============================================================*/
/* Index: RESERVATION_PERIODE_PK                                */
/*==============================================================*/
CREATE UNIQUE INDEX RESERVATION_PERIODE_PK ON RESERVATION_PERIODE (
  PAVILLON_ID,
  LOCAL_ID,
  HEURE,
  JOUR
);

/*==============================================================*/
/* Index: POUR_LE_LOCAL_FK                                      */
/*==============================================================*/
CREATE INDEX POUR_LE_LOCAL_FK ON RESERVATION_PERIODE (
  PAVILLON_ID,
  LOCAL_ID
);

/*==============================================================*/
/* Index: POUR_LA_RESERVATION_DEMANDE_FK                        */
/*==============================================================*/
CREATE INDEX POUR_LA_RESERVATION_DEMANDE_FK ON RESERVATION_PERIODE (
  RESERVATION_DEMANDE_ID
);

/*==============================================================*/
/* Index: POUR_LA_PERIODE_FK                                    */
/*==============================================================*/
CREATE INDEX POUR_LA_PERIODE_FK ON RESERVATION_PERIODE (
  HEURE
);

/*==============================================================*/
/* Table: RESSOURCE                                             */
/*==============================================================*/
CREATE TABLE RESSOURCE (
  RESSOURCE_ID NUMERIC NOT NULL,
  LIBELLE      TEXT    NOT NULL,
  INSCRIPTION  DATE    NOT NULL,
  CONSTRAINT PK_RESSOURCE PRIMARY KEY (RESSOURCE_ID),
  CONSTRAINT AK_AK_RESSOURCE_RESSOURC UNIQUE (LIBELLE)
);

/*==============================================================*/
/* Index: RESSOURCE_PK                                          */
/*==============================================================*/
CREATE UNIQUE INDEX RESSOURCE_PK ON RESSOURCE (
  RESSOURCE_ID
);

/*==============================================================*/
/* Table: ROLE                                                  */
/*==============================================================*/
CREATE TABLE ROLE (
  ROLE_ID     SERIAL NOT NULL,
  LIBELLE     TEXT   NOT NULL,
  INSCRIPTION DATE   NOT NULL DEFAULT 'now()',
  CONSTRAINT PK_ROLE PRIMARY KEY (ROLE_ID)
);

/*==============================================================*/
/* Index: ROLE_PK                                               */
/*==============================================================*/
CREATE UNIQUE INDEX ROLE_PK ON ROLE (
  ROLE_ID
);

/*==============================================================*/
/* Table: USAGER_ROLE                                           */
/*==============================================================*/
CREATE TABLE USAGER_ROLE (
  CIP     CHAR(8) NOT NULL,
  ROLE_ID INT4    NOT NULL,
  CONSTRAINT PK_USAGER_ROLE PRIMARY KEY (CIP, ROLE_ID)
);

/*==============================================================*/
/* Index: USAGER_ROLE_PK                                        */
/*==============================================================*/
CREATE UNIQUE INDEX USAGER_ROLE_PK ON USAGER_ROLE (
  CIP,
  ROLE_ID
);

/*==============================================================*/
/* Index: USAGER_ROLE_FK                                        */
/*==============================================================*/
CREATE INDEX USAGER_ROLE_FK ON USAGER_ROLE (
  CIP
);

/*==============================================================*/
/* Index: USAGER_ROLE_FK2                                       */
/*==============================================================*/
CREATE INDEX USAGER_ROLE_FK2 ON USAGER_ROLE (
  ROLE_ID
);

/*==============================================================*/
/* Table: UTILISATEUR                                           */
/*==============================================================*/
CREATE TABLE UTILISATEUR (
  CIP         CHAR(8) NOT NULL,
  _NOM        TEXT    NOT NULL,
  PRENOM      TEXT    NOT NULL,
  COURRIEL    TEXT    NULL,
  TELEPHONE   TEXT    NULL,
  LOCAL       TEXT    NULL,
  INSCRIPTION DATE    NOT NULL,
  CONSTRAINT PK_UTILISATEUR PRIMARY KEY (CIP)
);

/*==============================================================*/
/* Index: UTILISATEUR_PK                                        */
/*==============================================================*/
CREATE UNIQUE INDEX UTILISATEUR_PK ON UTILISATEUR (
  CIP
);

ALTER TABLE LOCAUX
ADD CONSTRAINT FK_LOCAUX_EST_DANS__PAVILLON FOREIGN KEY (PAVILLON_ID)
REFERENCES PAVILLON (PAVILLON_ID)
ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE LOCAUX
ADD CONSTRAINT FK_LOCAUX_FAIT_PART_CATEGORI FOREIGN KEY (CATEGORIE_ID)
REFERENCES CATEGORIE_LOCAUX (CATEGORIE_ID)
ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE LOCAUX_RESSOURCE
ADD CONSTRAINT FK_LOCAUX_R_LOCAUX_RE_LOCAUX FOREIGN KEY (PAVILLON_ID, LOCAL_ID)
REFERENCES LOCAUX (PAVILLON_ID, LOCAL_ID)
ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE LOCAUX_RESSOURCE
ADD CONSTRAINT FK_LOCAUX_R_LOCAUX_RE_RESSOURC FOREIGN KEY (RESSOURCE_ID)
REFERENCES RESSOURCE (RESSOURCE_ID)
ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE LOG
ADD CONSTRAINT FK_LOG_EST_DANS__UTILISAT FOREIGN KEY (CIP)
REFERENCES UTILISATEUR (CIP)
ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE LOG
ADD CONSTRAINT FK_LOG_POUR_LE_L_EVENEMEN FOREIGN KEY (EVENEMENT_ID)
REFERENCES EVENEMENT (EVENEMENT_ID)
ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE PAVILLON
ADD CONSTRAINT FK_PAVILLON_EST_DANS__CAMPUS FOREIGN KEY (CAMPUS_ID)
REFERENCES CAMPUS (CAMPUS_ID)
ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE RESERVATION_DEMANDE
ADD CONSTRAINT FK_RESERVAT_LOCAL_RES_LOCAUX FOREIGN KEY (PAVILLON_ID, LOCAL_ID)
REFERENCES LOCAUX (PAVILLON_ID, LOCAL_ID)
ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE RESERVATION_DEMANDE
ADD CONSTRAINT FK_RESERVAT_PERIODE_D_PERIODE FOREIGN KEY (HEURE)
REFERENCES PERIODE (HEURE)
ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE RESERVATION_DEMANDE
ADD CONSTRAINT FK_RESERVAT_UTILISATE_UTILISAT FOREIGN KEY (CIP)
REFERENCES UTILISATEUR (CIP)
ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE RESERVATION_PERIODE
ADD CONSTRAINT FK_RESERVAT_POUR_LA_P_PERIODE FOREIGN KEY (HEURE)
REFERENCES PERIODE (HEURE)
ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE RESERVATION_PERIODE
ADD CONSTRAINT FK_RESERVAT_POUR_LA_R_RESERVAT FOREIGN KEY (RESERVATION_DEMANDE_ID)
REFERENCES RESERVATION_DEMANDE (RESERVATION_DEMANDE_ID)
ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE RESERVATION_PERIODE
ADD CONSTRAINT FK_RESERVAT_POUR_LE_L_LOCAUX FOREIGN KEY (PAVILLON_ID, LOCAL_ID)
REFERENCES LOCAUX (PAVILLON_ID, LOCAL_ID)
ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE USAGER_ROLE
ADD CONSTRAINT FK_USAGER_R_USAGER_RO_ROLE FOREIGN KEY (ROLE_ID)
REFERENCES ROLE (ROLE_ID)
ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE USAGER_ROLE
ADD CONSTRAINT FK_USAGER_R_USAGER_RO_UTILISAT FOREIGN KEY (CIP)
REFERENCES UTILISATEUR (CIP)
ON DELETE RESTRICT ON UPDATE RESTRICT;