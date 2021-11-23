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
Evaluer les UO
CREATE OR REPLACE VIEW Effectif_V AS
  SELECT eff_id, nom , prenom , datenaissance
  FROM Efectif;

-- Modifier le nom d'une UO
CREATE OR REPLACE PROCEDURE Effectif_mod_nom
  (
    _ eff_id,
    _nom_effectif,
  
  )
LANGUAGE SQL AS $$
  UPDATE Effectif
  SET nom = _nom
  WHERE eff_id = _id
$$;

-- Insérer une UO
CREATE OR REPLACE PROCEDURE Effectif_ins
  (
    _id_eff_id,
    _Nom
  )
LANGUAGE SQL AS $$
  INSERT INTO Effectif(eff_id,nom)
  VALUES(_id, _nom)
$$;

-- Retirer une UO
CREATE OR REPLACE PROCEDURE Effectif_ret
  (
    _id_eff_id
  )
LANGUAGE SQL AS $$
  DELETE FROM Effectif
  WHERE Eff_id = _id
$$;




--
-- Type_activite
--
--Evaluer les UO
CREATE OR REPLACE VIEW Type_activite_V AS
  SELECT  _type , nom 
  FROM Type_activite;

-- Modifier le nom d'une UO
CREATE OR REPLACE PROCEDURE Type_activite_mod_nom
  (
    _type,
    _nom
  )
LANGUAGE SQL AS $$
  UPDATE Type_activite
  SET nom = _nom
  WHERE _type = _code
$$;

-- Insérer une UO
CREATE OR REPLACE PROCEDURE Type_activite_ins
  (
    _type,
    _nom 
  )
LANGUAGE SQL AS $$
  INSERT INTO Type_activite(_type, _nom)
  VALUES(_type, _nom)
$$;

-- Retirer une UO
CREATE OR REPLACE PROCEDURE Type_activite_ret
  (
    _type
  )
LANGUAGE SQL AS $$
  DELETE FROM Type_activite
  WHERE _type = _type
$$;


--
-- Permis
--Evaluer les UO
CREATE OR REPLACE VIEW Permis_V 
  SELECT permis_id, permis_code , effectif , valide_debut , valide_fin
  FROM Permis;

-- Insérer une UO
CREATE OR REPLACE PROCEDURE Permis_ins
  (
    permis_id,
    _code permis_code
  )
LANGUAGE SQL AS $$
  INSERT INTO Permis(permis_id, permis_code)
  VALUES(_id, _code)
$$;

-- Retirer une UO
CREATE OR REPLACE PROCEDURE Permis_ret
  (
    permis_id
  )
LANGUAGE SQL AS $$
  DELETE FROM Permis
  WHERE permis_id = id
$$;



--
-- Permis_activite
--Evaluer les UO
CREATE OR REPLACE VIEW Permis_activite_V AS
  SELECT permis, type_activite
  FROM Permis_activite;

-- Modifier le nom d'une UO
CREATE OR REPLACE PROCEDURE Permis_activite_mod_nom
  (
    _permis,
    _type_activite
  )
LANGUAGE SQL AS $$
  UPDATE Permis_activite
  SET permis
  WHERE type_activite
$$;

-- Insérer une UO
CREATE OR REPLACE PROCEDURE Permis_activite_ins
  (
    _permis,
    _type_activite_code
  )
LANGUAGE SQL AS $$
  INSERT INTO Permis_activite(permis, type_activite)
  VALUES(_permis, _type_activite_code)
$$;

-- Retirer une UO
CREATE OR REPLACE PROCEDURE Permis_activite_ret
  (
    type_activite
  )
LANGUAGE SQL AS $$
  DELETE FROM Permis_activite
  WHERE type_activite = type_activite_code
$$;



--
-- Prevision
--Evaluer les UO
CREATE OR REPLACE VIEW Prevision_V AS
  SELECT 
    prevision_id , 
    prevision_date , 
    effectif , 
    unite , 
    type_activite , 
    quantite , 
    periode_debut , 
    periode_fin
  FROM Prevision;

-- Modifier le nom d'une UO
CREATE OR REPLACE PROCEDURE Prevision_mod_nom
  (
    prevision_id,
    prevision_date
  )
LANGUAGE SQL AS $$
  UPDATE Prevision
  SET prevision_id
  WHERE prevision_date = date
$$;

-- Insérer une UO
CREATE OR REPLACE PROCEDURE Prevision_ins
  (
    prevision_id,
    prevision_date
  )
LANGUAGE SQL AS $$
  INSERT INTO Prevision(prevision_id, prevision_date)
  VALUES(_id, _datz)
$$;

-- Retirer une UO
CREATE OR REPLACE PROCEDURE Prevision_ret
  (
  prevision_code
  )
LANGUAGE SQL AS $$
  DELETE FROM Prevision
  WHERE prevision_code = _code
$$;



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
