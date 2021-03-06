/*
-- =========================================================================== A
Activité : MCEBD.SQL.A
Trimestre : 2021-3
Composant : MECA_drop.sql
Encodage : UTF-8, sans BOM; fin de ligne Unix (LF)
Plateforme : PostgreSQL 9.4 à 14
Responsables : Luc.Lavoie@USherbrooke.ca; Christina.Khnaisser@USherbrooke.ca; lorince.tawamba@ucac-icam.com
Version : 0.1.0a
Statut : solution préliminaire
-- =========================================================================== A
*/

/*
-- =========================================================================== B
   Modélisation des effectifs cliniques autonomes.
-- =========================================================================== B
*/
DROP TABLE Effectif CASCADE;
DROP TABLE Permis CASCADE;
DROP TABLE Type_activite CASCADE;
DROP TABLE Unite CASCADE;
DROP TABLE Prevision CASCADE;
DROP TABLE Permis_activite CASCADE;
DROP TABLE SOrg CASCADE;

DROP DOMAIN Unite_Code CASCADE;
DROP DOMAIN Unite_Nom CASCADE;
DROP DOMAIN Eff_Matr CASCADE;
DROP DOMAIN Eff_ID CASCADE;
DROP DOMAIN Type_activite_Code CASCADE;
DROP DOMAIN Type_activite_Nom CASCADE;
DROP DOMAIN Permis_ID CASCADE;
DROP DOMAIN Prevision_Code CASCADE;
DROP DOMAIN Permis_CODE CASCADE;
DROP DOMAIN Prevision_ID CASCADE;
DROP DOMAIN Prevision_quantite CASCADE;

DROP ROLE paulhenry;
DROP ROLE sonia;
DROP ROLE gregori;
DROP ROLE marlene;

DROP ROLE superAdmin;
DROP ROLE administrateur;
DROP ROLE utilisateur;
/*
-- =========================================================================== Z
Contributeurs :
  (PN) paul-henry.ngankam@2025.cac-icam.com,
  (ST) sonia.toukam@2025.ucac-icam.com,
  (GT) gregori.tema@2025.ucac-icam.com,
  (MJ) marlene.jodom@2025.ucac-icam.com

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
2021-11-14 (PN) : Revue.
2021-11-04 (YS) : Création initiale.

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
-- fin de MECA_drop.sql
-- =========================================================================== Z
*/
