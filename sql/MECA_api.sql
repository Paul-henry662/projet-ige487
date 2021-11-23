/*
-- =========================================================================== A
Activité : MCEBD.SQL.A
Trimestre : 2021-3
Composant : MECA_api.sql
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


-- Fonctionnalités EMIR (Evaluer, Modifier, Insérer, Retirer)


--
-- Unite
--
-- Evaluer les UO
CREATE OR REPLACE VIEW Unite_V AS
  SELECT unite_code AS code, unite_nom AS nom
  FROM Unite;

-- Modifier le nom d'une UO
CREATE OR REPLACE PROCEDURE Unite_mod_nom
  (
    _code Unite_Code,
    _nom Unite_Nom
  )
LANGUAGE SQL AS $$
  UPDATE Unite
  SET unite_nom = _nom
  WHERE unite_code = _code
$$;

-- Insérer une UO
CREATE OR REPLACE PROCEDURE Unite_ins
  (
    _code Unite_Code,
    _nom Unite_Nom
  )
LANGUAGE SQL AS $$
  INSERT INTO Unite(unite_code, unite_nom)
  VALUES(_code, _nom)
$$;

-- Retirer une UO
CREATE OR REPLACE PROCEDURE Unite_ret
  (
    _code Unite_Code
  )
LANGUAGE SQL AS $$
  DELETE FROM Unite
  WHERE unite_code = _code
$$;


--
-- SOrg
--
-- Evaluer les SOrg
CREATE OR REPLACE VIEW SOrg_V AS
  SELECT unite, super_unite
  FROM SOrg;

-- Modifier une SOrg
CREATE OR REPLACE PROCEDURE SOrg_mod
  (
    _unite_old Unite_Code,
    _super_unite_old Unite_Code,
    _unite_new Unite_Code,
    _super_unite_new Unite_Code
  )
LANGUAGE SQL AS $$
  UPDATE SOrg
  SET
    unite = _unite_new,
    super_unite = _super_unite_new
  WHERE
    unite = _unite_old
    AND super_unite = _super_unite_old
$$;

-- Insérer une SOrg
CREATE OR REPLACE PROCEDURE Unite_ins
  (
    _unite Unite_Code,
    _super_unite Unite_Code
  )
LANGUAGE SQL AS $$
  INSERT INTO SOrg(unite, super_unite)
  VALUES(_unite, _super_unite)
$$;

-- Retirer une SOrg
CREATE OR REPLACE PROCEDURE Unite_ret
  (
    _unite Unite_Code,
    _super_unite Unite_Code
  )
LANGUAGE SQL AS $$
  DELETE FROM SOrg
  WHERE
    unite = _unite
    AND super_unite = _super_unite
$$;
--
-- Effectif
--


--
-- Type_activite
--

--
-- Permis
--

--
-- Permis_activite
--

--
-- Prevision
--

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
-- fin de MECA_api.sql
-- =========================================================================== Z
*/
