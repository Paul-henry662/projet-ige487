/*
-- =========================================================================== A
Activité : MCEBD.SQL.A
Trimestre : 2021-3
Composant : MECA_ess-inv.sql
Encodage : UTF-8, sans BOM; fin de ligne Unix (LF)
Plateforme : PostgreSQL 9.4 à 14
Responsables : Luc.Lavoie@USherbrooke.ca; Christina.Khnaisser@USherbrooke.ca; lorince.tawamba@ucac-icam.com
Version : 0.1.0a
Statut : solution préliminaire
-- =========================================================================== A
*/

/*
-- =========================================================================== B
   Jeu de données invalides aux fins de test du modèle.
-- =========================================================================== B
*/

\echo ========================================================================
\echo Insertions dans Unite
\echo ========================================================================
-- Le code doit avoir exactement 5 lettres en majuscule suivies de 3 chiffres
INSERT INTO Unite(unite_code, unite_nom)
VALUES ('Unite001xx', 'nomUnite1');
-- Le code existe déjà
INSERT INTO Unite(unite_code, unite_nom)
VALUES ('UNITE001', 'nomUnite1');
-- Le nom existe déjà
INSERT INTO Unite(unite_code, unite_nom)
VALUES ('UNITE101', 'nomUnite1');

\echo ========================================================================
\echo Insertions dans SOrg
\echo ========================================================================
-- L'unité subordonnée n'existe pas
INSERT INTO SOrg(unite, super_unite)
VALUES('UNITE108', 'UNITE001');
-- La super unité n'existe pas
INSERT INTO SOrg(unite, super_unite)
VALUES('UNITE001', 'UNITE153');
-- L'association (unite, super_unite) existe déjà
INSERT INTO SOrg(unite, super_unite)
VALUES('UNITE002', 'UNITE001');

\echo ========================================================================
\echo Insertions dans Type_activite
\echo ========================================================================
-- type doit respecter '[a-zA-Z][a-zA-Z0-9]{2,7}'
INSERT INTO Type_activite(type, nom, description, actif)
VALUES('TAB1xxxxxxxx', 'typeActiviteB1', 'description du type d activite B1', FALSE);
-- type existe déjà
INSERT INTO Type_activite(type, nom, description, actif)
VALUES('TAA1', 'typeActiviteA8', 'description du type d activite A8', FALSE);
-- nom existe déjà
INSERT INTO Type_activite(type, nom, description, actif)
VALUES('TAB2', 'typeActiviteA2', 'description du type d activite B2', FALSE);

\echo ========================================================================
\echo Insertions dans Permis
\echo ========================================================================
-- permis_code doit respecter '[a-zA-Z]{4}[0-9]{3}'
INSERT INTO Permis(permis_code, effectif, valide_debut, valide_fin)
VALUES('Perm001xx', 1, '2021-11-20', '2022-11-20');
-- effectif n'existe pas
INSERT INTO Permis(permis_code, effectif, valide_debut, valide_fin)
VALUES('Perm003', 100, '2021-11-20', '2022-11-20');
-- valideDebut >= valideFin
INSERT INTO Permis(permis_code, effectif, valide_debut, valide_fin)
VALUES('Perm004', 2, '2022-11-20', '2021-11-20');

\echo ========================================================================
\echo Insertions dans Permis_activite
\echo ========================================================================
-- permis n'existe pas
INSERT INTO Permis_activite(permis, type_activite)
VALUES(101, 'TAA1');
-- type_activite n'existe pas
INSERT INTO Permis_activite(permis, type_activite)
VALUES(1, 'TAY5');
-- L'association (permis, type_activite) existe déjà
INSERT INTO Permis_activite(permis, type_activite)
VALUES(1, 'TAA1');

\echo ========================================================================
\echo Insertions dans Prevision
\echo ========================================================================
-- quantite doit être > 0
INSERT INTO Prevision(prevision_date, effectif, unite, type_activite, quantite, periode_debut, periode_fin)
VALUES('2021-11-20', 1, 'UNITE001', 'TAA1', 0, '2021-11-20', '2021-12-20');
-- effectif n'existe pas
INSERT INTO Prevision(prevision_date, effectif, unite, type_activite, quantite, periode_debut, periode_fin)
VALUES('2021-11-20', 101, 'UNITE002', 'TAA2', 3.2, '2022-11-20', '2023-12-20');
-- unite n'existe pas
INSERT INTO Prevision(prevision_date, effectif, unite, type_activite, quantite, periode_debut, periode_fin)
VALUES('2021-11-20', 2, 'UNITE202', 'TAA3', 8.3, '2021-11-20', '2022-03-20');
-- type_activite n'existe pas
INSERT INTO Prevision(prevision_date, effectif, unite, type_activite, quantite, periode_debut, periode_fin)
VALUES('2021-11-20', 1, 'UNITE003', 'TAB1', 10.03, '2026-11-20', '2026-12-20');
-- periode_debut >= periode_fin
INSERT INTO Prevision(prevision_date, effectif, unite, type_activite, quantite, periode_debut, periode_fin)
VALUES('2021-11-20', 101, 'UNITE202', 'TAA4', 3.2, '2024-11-20', '2023-12-20');

/*
-- =========================================================================== Z
Contributeurs :
  (PN) paul-henry.ngankam@2025.cac-icam.com,
  (YS) yves.syapze@2025.ucac-icam.com

Adresse, droits d’auteur et copyright :
  Groupe Groupe Μῆτις (Métis)
  Département d’informatique
  Faculté des sciences
  Université de Sherbrooke
  Sherbrooke (Québec)  J1K 2R1
  Canada
  http://info.usherbrooke.ca/llavoie/
  [CC-BY-NC-SA-4.0 (http://creativecommons.org/licenses/by-nc-sa/4.0)]

Tâches projetées :
S.O.

Tâches réalisées :
2021-11-04 (PN) : Création initiale.

Références :
[ddv] http://info.usherbrooke.ca/llavoie/enseignement/Exemples/MECA/
      MECA_DDV.pdf
[edv] http://info.usherbrooke.ca/llavoie/enseignement/Exemples/MECA/
      MECA_EDV.pdf (à venir)
[pre] http://info.usherbrooke.ca/llavoie/enseignement/Exemples/MECA/
      MECA_PRE.pdf (à venir)
[scl] http://info.usherbrooke.ca/llavoie/enseignement/Exemples/MECA/
      MECA_SCL.pdf (à venir)
[std] http://info.usherbrooke.ca/llavoie/enseignement/Modules/
      BD190-STD-SQL-01_NDC.pdf

-- -----------------------------------------------------------------------------
-- fin de MECA_ess-inv.sql
-- =========================================================================== Z
*/
