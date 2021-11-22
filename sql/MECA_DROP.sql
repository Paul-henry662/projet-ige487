/*
-- =========================================================================== A
Activité : MCEBD.SQL.A
Trimestre : 2021-3
Composant : MECA_DROP.sql
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


DROP DOMAIN Unite_Code;
DROP DOMAIN Unite_Nom;
DROP DOMAIN Eff_ID;
DROP DOMAIN Type_activite_Code;
DROP DOMAIN Type_activite_Nom;
DROP DOMAIN Permis_ID;
DROP DOMAIN Permis_CODE;
DROP DOMAIN Prevision_ID;
DROP DOMAIN Prevision_quantite;

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
-- fin de MECA_DROP.sql
-- =========================================================================== Z
*/
