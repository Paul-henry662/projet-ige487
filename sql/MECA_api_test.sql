/*
-- =========================================================================== A
Activité : MCEBD.SQL.A
Trimestre : 2021-3
Composant : MECA_api_test.sql
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
--
-- Unite
--
-- Afficher les UO
SELECT *
FROM Unite_V;

-- Insérer une UO
CALL Unite_ins
/*
-- =========================================================================== Z

Contributeurs :
  (CK) Christina.Khnaisser@USherbrooke.ca,
  (LL) Luc.Lavoie@USherbrooke.ca,
  (PN) paul-henry.ngankam@2025.ucac-icam.com,
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
2021-11-23 (MJ) : Complétion du composant

Tâches réalisées :
2021-11-23 (PN) : Création initiale.

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
-- fin de MECA_api_test.sql
-- =========================================================================== Z
*/
