/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     2015-05-07 2:37:45 PM                        */
/*==============================================================*/


drop index CAMPUS_PK;

drop table CAMPUS;

drop index CATEGORIE_LOCAUX_PK;

drop table CATEGORIE_LOCAUX;

drop index EVENEMENT_PK;

drop table EVENEMENT;

drop index FAIT_PARTI_DE_LA_CATEGORIE_FK;

drop index EST_DANS_LE_PAVILLON_FK;

drop index LOCAUX_PK;

drop table LOCAUX;

drop index LOCAUX_RESSOURCE_FK2;

drop index LOCAUX_RESSOURCE_FK;

drop index LOCAUX_RESSOURCE_PK;

drop table LOCAUX_RESSOURCE;

drop index POUR_LE_LOG_FK;

drop index EST_DANS_LE_LOG_FK;

drop index LOG_PK;

drop table LOG;

drop index EST_DANS_LE_CAPMUS_FK;

drop index PAVILLON_PK;

drop table PAVILLON;

drop index PERIODE_PK;

drop table PERIODE;

drop index PERIODE_DEBUT_FK;

drop index LOCAL_RESERVE_FK;

drop index UTILISATEUR_RESERVE_FK;

drop index RESERVATION_DEMANDE_PK;

drop table RESERVATION_DEMANDE;

drop index POUR_LA_PERIODE_FK;

drop index POUR_LA_RESERVATION_DEMANDE_FK;

drop index POUR_LE_LOCAL_FK;

drop index RESERVATION_PERIODE_PK;

drop table RESERVATION_PERIODE;

drop index RESSOURCE_PK;

drop table RESSOURCE;

drop index ROLE_PK;

drop table ROLE;

drop index USAGER_ROLE_FK2;

drop index USAGER_ROLE_FK;

drop index USAGER_ROLE_PK;

drop table USAGER_ROLE;

drop index UTILISATEUR_PK;

drop table UTILISATEUR;

/*==============================================================*/
/* Table: CAMPUS                                                */
/*==============================================================*/
create table CAMPUS (
   CAMPUS_ID            NUMERIC              not null,
   LIBELLE              TEXT                 not null,
   INSCRIPTION          DATE                 not null,
   constraint PK_CAMPUS primary key (CAMPUS_ID),
   constraint AK_AK_CAMPUS_CAMPUS unique (LIBELLE)
);

/*==============================================================*/
/* Index: CAMPUS_PK                                             */
/*==============================================================*/
create unique index CAMPUS_PK on CAMPUS (
CAMPUS_ID
);

/*==============================================================*/
/* Table: CATEGORIE_LOCAUX                                      */
/*==============================================================*/
create table CATEGORIE_LOCAUX (
   CATEGORIE_ID         NUMERIC              not null,
   LIBELLE              TEXT                 not null,
   INSCRIPTION          DATE                 not null default current_date,
   constraint PK_CATEGORIE_LOCAUX primary key (CATEGORIE_ID),
   constraint AK_AK_CATEGORIE_CATEGORI unique (LIBELLE)
);

/*==============================================================*/
/* Index: CATEGORIE_LOCAUX_PK                                   */
/*==============================================================*/
create unique index CATEGORIE_LOCAUX_PK on CATEGORIE_LOCAUX (
CATEGORIE_ID
);

/*==============================================================*/
/* Table: EVENEMENT                                             */
/*==============================================================*/
create table EVENEMENT (
   EVENEMENT_ID         NUMERIC              not null,
   LIBELLE              TEXT                 not null,
   INSCRIPTION          DATE                 not null default 'now()',
   constraint PK_EVENEMENT primary key (EVENEMENT_ID),
   constraint AK_AK_EVENEMENT_EVENEMEN unique (LIBELLE)
);

/*==============================================================*/
/* Index: EVENEMENT_PK                                          */
/*==============================================================*/
create unique index EVENEMENT_PK on EVENEMENT (
EVENEMENT_ID
);

/*==============================================================*/
/* Table: LOCAUX                                                */
/*==============================================================*/
create table LOCAUX (
   PAVILLON_ID          CHAR(2)              not null,
   LOCAL_ID             TEXT                 not null,
   CATEGORIE_ID         NUMERIC              null,
   NOTE                 TEXT                 null,
   INSCRIPTION          DATE                 not null,
   constraint PK_LOCAUX primary key (PAVILLON_ID, LOCAL_ID)
);

/*==============================================================*/
/* Index: LOCAUX_PK                                             */
/*==============================================================*/
create unique index LOCAUX_PK on LOCAUX (
PAVILLON_ID,
LOCAL_ID
);

/*==============================================================*/
/* Index: EST_DANS_LE_PAVILLON_FK                               */
/*==============================================================*/
create  index EST_DANS_LE_PAVILLON_FK on LOCAUX (
PAVILLON_ID
);

/*==============================================================*/
/* Index: FAIT_PARTI_DE_LA_CATEGORIE_FK                         */
/*==============================================================*/
create  index FAIT_PARTI_DE_LA_CATEGORIE_FK on LOCAUX (
CATEGORIE_ID
);

/*==============================================================*/
/* Table: LOCAUX_RESSOURCE                                      */
/*==============================================================*/
create table LOCAUX_RESSOURCE (
   PAVILLON_ID          CHAR(2)              not null,
   LOCAL_ID             TEXT                 not null,
   RESSOURCE_ID         NUMERIC              not null,
   QUANTITE             NUMERIC              null,
   INSCRIPTION          DATE                 not null,
   constraint PK_LOCAUX_RESSOURCE primary key (PAVILLON_ID, LOCAL_ID, RESSOURCE_ID)
);

/*==============================================================*/
/* Index: LOCAUX_RESSOURCE_PK                                   */
/*==============================================================*/
create unique index LOCAUX_RESSOURCE_PK on LOCAUX_RESSOURCE (
PAVILLON_ID,
LOCAL_ID,
RESSOURCE_ID
);

/*==============================================================*/
/* Index: LOCAUX_RESSOURCE_FK                                   */
/*==============================================================*/
create  index LOCAUX_RESSOURCE_FK on LOCAUX_RESSOURCE (
PAVILLON_ID,
LOCAL_ID
);

/*==============================================================*/
/* Index: LOCAUX_RESSOURCE_FK2                                  */
/*==============================================================*/
create  index LOCAUX_RESSOURCE_FK2 on LOCAUX_RESSOURCE (
RESSOURCE_ID
);

/*==============================================================*/
/* Table: LOG                                                   */
/*==============================================================*/
create table LOG (
   LOG_ID               INT4                 not null,
   CIP                  CHAR(8)              not null,
   EVENEMENT_ID         NUMERIC              not null,
   COMMENTAIRE          TEXT                 null,
   _INSCRIPTION         DATE                 not null,
   constraint PK_LOG primary key (LOG_ID)
);

/*==============================================================*/
/* Index: LOG_PK                                                */
/*==============================================================*/
create unique index LOG_PK on LOG (
LOG_ID
);

/*==============================================================*/
/* Index: EST_DANS_LE_LOG_FK                                    */
/*==============================================================*/
create  index EST_DANS_LE_LOG_FK on LOG (
CIP
);

/*==============================================================*/
/* Index: POUR_LE_LOG_FK                                        */
/*==============================================================*/
create  index POUR_LE_LOG_FK on LOG (
EVENEMENT_ID
);

/*==============================================================*/
/* Table: PAVILLON                                              */
/*==============================================================*/
create table PAVILLON (
   PAVILLON_ID          CHAR(2)              not null,
   CAMPUS_ID            NUMERIC              null,
   LIBELLE              TEXT                 not null,
   INSCRIPTION          DATE                 not null default 'now()',
   constraint PK_PAVILLON primary key (PAVILLON_ID),
   constraint AK_AK_PAVILLON_PAVILLON unique (LIBELLE)
);

/*==============================================================*/
/* Index: PAVILLON_PK                                           */
/*==============================================================*/
create unique index PAVILLON_PK on PAVILLON (
PAVILLON_ID
);

/*==============================================================*/
/* Index: EST_DANS_LE_CAPMUS_FK                                 */
/*==============================================================*/
create  index EST_DANS_LE_CAPMUS_FK on PAVILLON (
CAMPUS_ID
);

/*==============================================================*/
/* Table: PERIODE                                               */
/*==============================================================*/
create table PERIODE (
   HEURE                TIME                 not null,
   INSCRIPTION          DATE                 not null,
   constraint PK_PERIODE primary key (HEURE)
);

/*==============================================================*/
/* Index: PERIODE_PK                                            */
/*==============================================================*/
create unique index PERIODE_PK on PERIODE (
HEURE
);

/*==============================================================*/
/* Table: RESERVATION_DEMANDE                                   */
/*==============================================================*/
create table RESERVATION_DEMANDE (
   RESERVATION_DEMANDE_ID SERIAL               not null,
   HEURE                TIME                 not null,
   PAVILLON_ID          CHAR(2)              not null,
   LOCAL_ID             TEXT                 not null,
   CIP                  CHAR(8)              not null,
   JOUR                 DATE                 not null,
   DUREE                INT4                 not null,
   DESCRIPTION          TEXT                 null,
   INSCRIPTION          DATE                 not null,
   constraint PK_RESERVATION_DEMANDE primary key (RESERVATION_DEMANDE_ID)
);

/*==============================================================*/
/* Index: RESERVATION_DEMANDE_PK                                */
/*==============================================================*/
create unique index RESERVATION_DEMANDE_PK on RESERVATION_DEMANDE (
RESERVATION_DEMANDE_ID
);

/*==============================================================*/
/* Index: UTILISATEUR_RESERVE_FK                                */
/*==============================================================*/
create  index UTILISATEUR_RESERVE_FK on RESERVATION_DEMANDE (
CIP
);

/*==============================================================*/
/* Index: LOCAL_RESERVE_FK                                      */
/*==============================================================*/
create  index LOCAL_RESERVE_FK on RESERVATION_DEMANDE (
PAVILLON_ID,
LOCAL_ID
);

/*==============================================================*/
/* Index: PERIODE_DEBUT_FK                                      */
/*==============================================================*/
create  index PERIODE_DEBUT_FK on RESERVATION_DEMANDE (
HEURE
);

/*==============================================================*/
/* Table: RESERVATION_PERIODE                                   */
/*==============================================================*/
create table RESERVATION_PERIODE (
   PAVILLON_ID          CHAR(2)              not null,
   LOCAL_ID             TEXT                 not null,
   HEURE                TIME                 not null,
   JOUR                 DATE                 not null,
   RESERVATION_DEMANDE_ID INT4                 not null,
   constraint PK_RESERVATION_PERIODE primary key (PAVILLON_ID, LOCAL_ID, HEURE, JOUR)
);

/*==============================================================*/
/* Index: RESERVATION_PERIODE_PK                                */
/*==============================================================*/
create unique index RESERVATION_PERIODE_PK on RESERVATION_PERIODE (
PAVILLON_ID,
LOCAL_ID,
HEURE,
JOUR
);

/*==============================================================*/
/* Index: POUR_LE_LOCAL_FK                                      */
/*==============================================================*/
create  index POUR_LE_LOCAL_FK on RESERVATION_PERIODE (
PAVILLON_ID,
LOCAL_ID
);

/*==============================================================*/
/* Index: POUR_LA_RESERVATION_DEMANDE_FK                        */
/*==============================================================*/
create  index POUR_LA_RESERVATION_DEMANDE_FK on RESERVATION_PERIODE (
RESERVATION_DEMANDE_ID
);

/*==============================================================*/
/* Index: POUR_LA_PERIODE_FK                                    */
/*==============================================================*/
create  index POUR_LA_PERIODE_FK on RESERVATION_PERIODE (
HEURE
);

/*==============================================================*/
/* Table: RESSOURCE                                             */
/*==============================================================*/
create table RESSOURCE (
   RESSOURCE_ID         NUMERIC              not null,
   LIBELLE              TEXT                 not null,
   INSCRIPTION          DATE                 not null,
   constraint PK_RESSOURCE primary key (RESSOURCE_ID),
   constraint AK_AK_RESSOURCE_RESSOURC unique (LIBELLE)
);

/*==============================================================*/
/* Index: RESSOURCE_PK                                          */
/*==============================================================*/
create unique index RESSOURCE_PK on RESSOURCE (
RESSOURCE_ID
);

/*==============================================================*/
/* Table: ROLE                                                  */
/*==============================================================*/
create table ROLE (
   ROLE_ID              SERIAL               not null,
   LIBELLE              TEXT                 not null,
   INSCRIPTION          DATE                 not null default 'now()',
   constraint PK_ROLE primary key (ROLE_ID)
);

/*==============================================================*/
/* Index: ROLE_PK                                               */
/*==============================================================*/
create unique index ROLE_PK on ROLE (
ROLE_ID
);

/*==============================================================*/
/* Table: USAGER_ROLE                                           */
/*==============================================================*/
create table USAGER_ROLE (
   CIP                  CHAR(8)              not null,
   ROLE_ID              INT4                 not null,
   constraint PK_USAGER_ROLE primary key (CIP, ROLE_ID)
);

/*==============================================================*/
/* Index: USAGER_ROLE_PK                                        */
/*==============================================================*/
create unique index USAGER_ROLE_PK on USAGER_ROLE (
CIP,
ROLE_ID
);

/*==============================================================*/
/* Index: USAGER_ROLE_FK                                        */
/*==============================================================*/
create  index USAGER_ROLE_FK on USAGER_ROLE (
CIP
);

/*==============================================================*/
/* Index: USAGER_ROLE_FK2                                       */
/*==============================================================*/
create  index USAGER_ROLE_FK2 on USAGER_ROLE (
ROLE_ID
);

/*==============================================================*/
/* Table: UTILISATEUR                                           */
/*==============================================================*/
create table UTILISATEUR (
   CIP                  CHAR(8)              not null,
   _NOM                 TEXT                 not null,
   PRENOM               TEXT                 not null,
   COURRIEL             TEXT                 null,
   TELEPHONE            TEXT                 null,
   LOCAL                TEXT                 null,
   INSCRIPTION          DATE                 not null,
   constraint PK_UTILISATEUR primary key (CIP)
);

/*==============================================================*/
/* Index: UTILISATEUR_PK                                        */
/*==============================================================*/
create unique index UTILISATEUR_PK on UTILISATEUR (
CIP
);

alter table LOCAUX
   add constraint FK_LOCAUX_EST_DANS__PAVILLON foreign key (PAVILLON_ID)
      references PAVILLON (PAVILLON_ID)
      on delete restrict on update restrict;

alter table LOCAUX
   add constraint FK_LOCAUX_FAIT_PART_CATEGORI foreign key (CATEGORIE_ID)
      references CATEGORIE_LOCAUX (CATEGORIE_ID)
      on delete restrict on update restrict;

alter table LOCAUX_RESSOURCE
   add constraint FK_LOCAUX_R_LOCAUX_RE_LOCAUX foreign key (PAVILLON_ID, LOCAL_ID)
      references LOCAUX (PAVILLON_ID, LOCAL_ID)
      on delete restrict on update restrict;

alter table LOCAUX_RESSOURCE
   add constraint FK_LOCAUX_R_LOCAUX_RE_RESSOURC foreign key (RESSOURCE_ID)
      references RESSOURCE (RESSOURCE_ID)
      on delete restrict on update restrict;

alter table LOG
   add constraint FK_LOG_EST_DANS__UTILISAT foreign key (CIP)
      references UTILISATEUR (CIP)
      on delete restrict on update restrict;

alter table LOG
   add constraint FK_LOG_POUR_LE_L_EVENEMEN foreign key (EVENEMENT_ID)
      references EVENEMENT (EVENEMENT_ID)
      on delete restrict on update restrict;

alter table PAVILLON
   add constraint FK_PAVILLON_EST_DANS__CAMPUS foreign key (CAMPUS_ID)
      references CAMPUS (CAMPUS_ID)
      on delete restrict on update restrict;

alter table RESERVATION_DEMANDE
   add constraint FK_RESERVAT_LOCAL_RES_LOCAUX foreign key (PAVILLON_ID, LOCAL_ID)
      references LOCAUX (PAVILLON_ID, LOCAL_ID)
      on delete restrict on update restrict;

alter table RESERVATION_DEMANDE
   add constraint FK_RESERVAT_PERIODE_D_PERIODE foreign key (HEURE)
      references PERIODE (HEURE)
      on delete restrict on update restrict;

alter table RESERVATION_DEMANDE
   add constraint FK_RESERVAT_UTILISATE_UTILISAT foreign key (CIP)
      references UTILISATEUR (CIP)
      on delete restrict on update restrict;

alter table RESERVATION_PERIODE
   add constraint FK_RESERVAT_POUR_LA_P_PERIODE foreign key (HEURE)
      references PERIODE (HEURE)
      on delete restrict on update restrict;

alter table RESERVATION_PERIODE
   add constraint FK_RESERVAT_POUR_LA_R_RESERVAT foreign key (RESERVATION_DEMANDE_ID)
      references RESERVATION_DEMANDE (RESERVATION_DEMANDE_ID)
      on delete restrict on update restrict;

alter table RESERVATION_PERIODE
   add constraint FK_RESERVAT_POUR_LE_L_LOCAUX foreign key (PAVILLON_ID, LOCAL_ID)
      references LOCAUX (PAVILLON_ID, LOCAL_ID)
      on delete restrict on update restrict;

alter table USAGER_ROLE
   add constraint FK_USAGER_R_USAGER_RO_ROLE foreign key (ROLE_ID)
      references ROLE (ROLE_ID)
      on delete restrict on update restrict;

alter table USAGER_ROLE
   add constraint FK_USAGER_R_USAGER_RO_UTILISAT foreign key (CIP)
      references UTILISATEUR (CIP)
      on delete restrict on update restrict;

