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
CALL Unite_ins('UNITE006', 'nomUnite6');

-- Retirer une UO
CALL Unite_ret('UNITE006');

-- Modifier le nom d'une UO
CALL Unite_mod_nom('UNITE007', 'NomUnite7Renommee');

--
-- Sorg
--
-- Afficher les Sorg
SELECT *
FROM Sorg

-- Inserer une Sorg
CALL Sorg_ins('UNITE010','UNITE007');

-- Retirer une Sorg
CALL Unite_ret('UNITE001','UNITE002');

--Modifier une Sorg
CALL Sorg_mod ('UNITE002','UNITE001','UNITE003','UNITE001');

--
-- Effectif
--
-- Afficher les ECA
SELECT *
FROM Effectif_V;

-- Modifier le nom d'un effectif
CALL Effectif_mod_nom('00000001', 'Sonia', 'Toukam');

-- Modifier la date de naissance d'un effectif
CALL Effectif_mod_date_naiss('00000001', '2021-11-19');

-- Insérer un effectif
CALL Effectif_ins('0000007', 'JODOM', 'Marlène', '2003-06-01');

-- Retirer un effectif
CALL Effectif_ret('0000007');

--
-- Type_activite
--
-- Afficher les types d'activités
SELECT *
FROM Type_activite_V;

-- Modifier le nom d'un type d'activité
CALL Type_activite_mod_nom('TAA1', 'typeActivite1Renommé');

-- Insérer un type d'activité
CALL Type_activite_ins('TAA6', 'typeActvite6', 'description du type d activité', FALSE);

-- Retirer un type d'activité
CALL Type_activite_ret('TAA6');

--
-- Permis
--
-- Afficher les permis
SELECT *
FROM Permis_V;

-- Insérer un permis
CALL Permis_ins('Perm006', '0000001', '2021-11-24', '2021-12-24');

-- Retirer un permis
CALL Permis_ret('Perm006');

--
-- Permis_activite
--
-- Afficher les associations Permis_activite
SELECT *
FROM Permis_activite_V;

-- Insérer une association Permis_activite
CALL Permis_activite_ins('Perm005', 'TAA1');

-- Retirer une association Permis_activite
CALL Permis_activite_ret('Perm0005', 'TAA1');

-- Afficher les prévisions
SELECT *
FROM Prevision_V;

-- Insérer une prévision
CALL Prevision_ins('Prev0008', '2021-11-24', '00000001', 'UNITE002', '2022-01-01', '2026-08-01');

-- Modifier l'effectif d'une prévision
CALL Prevision_mod_eff('Prev0008', '00000002');

-- Retirer une prévision
CALL Prevision_ret('Prev0008');

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
