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
CREATE OR REPLACE PROCEDURE SOrg_ins
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
-- Renvoie un eff_id à partir du matricule
CREATE OR REPLACE FUNCTION Effectif
  (
    _eff_matr Eff_Matr
  )
RETURNS Eff_ID AS $$
DECLARE _eff_id Eff_ID;
BEGIN
  SELECT eff_id INTO _eff_id
  FROM Effectif
  WHERE eff_matr = _eff_matr;

  RETURN _eff_id;
END;
$$ LANGUAGE plpgsql;

-- Evaluer les effectifs
CREATE OR REPLACE VIEW Effectif_V AS
  SELECT eff_id, nom , prenom , datenaissance
  FROM Effectif;

-- Modifier le matricule d'un effectif
CREATE OR REPLACE PROCEDURE Effectif_mod_nom
  (
    _eff_matr_old Eff_Matr,
    _eff_matr_new Eff_Matr
  )
LANGUAGE SQL AS $$
  UPDATE Effectif
  SET
      eff_matr = _eff_matr_new
  WHERE
    eff_id = Effectif(_eff_matr_old)
$$;

-- Modifier le nom et le prénom d'un effectif
CREATE OR REPLACE PROCEDURE Effectif_mod_nom
  (
    _eff_matr Eff_Matr,
    _nom TEXT,
    _prenom TEXT
  )
LANGUAGE SQL AS $$
  UPDATE Effectif
  SET
    nom = _nom,
    prenom = _prenom
  WHERE
    eff_id = Effectif(_eff_matr)
$$;

-- Modifier la date de naissance d'un effectif
CREATE OR REPLACE PROCEDURE Effectif_mod_date_naiss
  (
    _eff_matr Eff_Matr,
    _dateNaissance DATE
  )
LANGUAGE SQL AS $$
  UPDATE Effectif
  SET
    dateNaissance = _dateNaissance
  WHERE eff_id = Effectif(_eff_matr)
$$;

-- Insérer un effectif
CREATE OR REPLACE PROCEDURE Effectif_ins
  (
    _eff_matr Eff_Matr,
    _nom TEXT,
    _prenom TEXT,
    _datenaissance DATE
  )
LANGUAGE SQL AS $$
  INSERT INTO Effectif(eff_matr, nom, prenom, datenaissance)
  VALUES(_eff_matr, _nom, _prenom, _datenaissance)
$$;

-- Retirer un effectif
CREATE OR REPLACE PROCEDURE Effectif_ret
  (
    _eff_matr Eff_Matr
  )
LANGUAGE SQL AS $$
  DELETE FROM Effectif
  WHERE Eff_id = Effectif(_eff_matr)
$$;

--
-- Type_activite
--
--Evaluer les types d'activités
CREATE OR REPLACE VIEW Type_activite_V AS
  SELECT type, nom, description, actif
  FROM Type_activite;

-- Modifier le nom d'un type d'activité
CREATE OR REPLACE PROCEDURE Type_activite_mod_nom
  (
    _type Type_activite_Code,
    _nom Type_activite_Nom
  )
LANGUAGE SQL AS $$
  UPDATE Type_activite
  SET nom = _nom
  WHERE type = _type
$$;

-- Insérer un type d'activité
CREATE OR REPLACE PROCEDURE Type_activite_ins
  (
    _type Type_activite_Code,
    _nom Type_activite_Nom,
    _description TEXT,
    _actif BOOLEAN
  )
LANGUAGE SQL AS $$
  INSERT INTO Type_activite(type, nom, description, actif)
  VALUES(_type, _nom, _description, _actif)
$$;

-- Retirer un type d'ativité
CREATE OR REPLACE PROCEDURE Type_activite_ret
  (
    _type Type_activite_Code
  )
LANGUAGE SQL AS $$
  DELETE FROM Type_activite
  WHERE type = _type
$$;

--
-- Permis
--
-- Renvoie un permis_id à partir du code
CREATE OR REPLACE FUNCTION Permis
  (
    _permis_code Permis_Code
  )
RETURNS Permis_ID AS $$
DECLARE id Permis_ID;
BEGIN
  SELECT permis_ID INTO id
  FROM Permis
  WHERE permis_code = _permis_code;

  RETURN id;
END;
$$ LANGUAGE plpgsql;

--Evaluer les permis
CREATE OR REPLACE VIEW Permis_V AS
  SELECT permis_id, permis_code , effectif , valide_debut , valide_fin
  FROM Permis;

-- Modifier le code d'un permis
CREATE OR REPLACE PROCEDURE Permis_mod_code
  (
    _permis_code_old Permis_Code,
    _permis_code_new Permis_Code
  )
LANGUAGE SQL AS $$
  UPDATE Permis
  SET permis_code = _permis_code_new
  WHERE permis_id = Permis(_permis_code_old)
$$;

-- Modifier le code d'un permis
CREATE OR REPLACE PROCEDURE Permis_mod_code
  (
    _permis_code_old Permis_Code,
    _permis_code_new Permis_Code
  )
LANGUAGE SQL AS $$
  UPDATE Permis
  SET permis_code = _permis_code_new
  WHERE permis_id = Permis(_permis_code_old)
$$;

-- Insérer un permis
CREATE OR REPLACE PROCEDURE Permis_ins
  (
    _permis_code Permis_Code,
    _eff_matr Eff_Matr,
    _valide_debut DATE,
    _valide_fin DATE
  )
LANGUAGE SQL AS $$
  INSERT INTO Permis(permis_code, effectif, valide_debut, valide_fin)
  VALUES(_permis_code, Effectif(_eff_matr), _valide_debut, _valide_fin)
$$;

-- Retirer un Permis
CREATE OR REPLACE PROCEDURE Permis_ret
  (
    _permis_code Permis_Code
  )
LANGUAGE SQL AS $$
  DELETE FROM Permis
  WHERE permis_id = Permis(_permis_code)
$$;

--
-- Permis_activite
--
-- Evaluer les associations Permis_activite
CREATE OR REPLACE VIEW Permis_activite_V AS
  SELECT permis, type_activite
  FROM Permis_activite;

-- Modifier une association Permis_activite
CREATE OR REPLACE PROCEDURE Permis_activite_mod
  (
    _permis_old Permis_Code,
    _type_activite_old Type_activite_code,
    _permis_new Permis_Code,
    _type_activite_new Type_activite_code
  )
LANGUAGE SQL AS $$
  UPDATE Permis_activite
  SET
    permis = Permis(_permis_new),
    type_activite = _type_activite_new
  WHERE
    permis = Permis(_permis_old)
    AND type_activite = _type_activite_old
$$;

-- Insérer une association Permis_activite
CREATE OR REPLACE PROCEDURE Permis_activite_ins
  (
    _permis Permis_Code,
    _type_activite Type_activite_code
  )
LANGUAGE SQL AS $$
  INSERT INTO Permis_activite(permis, type_activite)
  VALUES(Permis(_permis), _type_activite)
$$;

-- Retirer une association Permis_activite
CREATE OR REPLACE PROCEDURE Permis_activite_ret
  (
    _permis Permis_Code,
    _type_activite Type_activite_code
  )
LANGUAGE SQL AS $$
  DELETE FROM Permis_activite
  WHERE
    permis = Permis(_permis)
    AND type_activite = _type_activite
$$;


--
-- Prevision
--
-- Renvoie un prévision_id à partir du code
CREATE OR REPLACE FUNCTION Prevision
  (
    _prevision_code Prevision_Code
  )
RETURNS Prevision_ID AS $$
DECLARE id Prevision_ID;
BEGIN
  SELECT prevision_id INTO id
  FROM prevision
  WHERE prevision_code = _prevision_code;

  RETURN id;
END;
$$;

--Evaluer les prévisions
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

-- Modifier l'effectif d'une prévision
CREATE OR REPLACE PROCEDURE Prevision_mod_eff
  (
    _prevision_code Prevision_Code,
    _effectif Eff_Matr
  )
LANGUAGE SQL AS $$
  UPDATE Prevision
  SET effectif = Effectif(_effectif)
  WHERE prevision_code = _prevision_code
$$;

-- Insérer une prévision
CREATE OR REPLACE PROCEDURE Prevision_ins
  (
    _prevision_code Prevision_Code,
    _prevision_date DATE,
    _effectif Eff_Matr,
    _unite Unite_Code,
    _type_activite Type_activite_Code,
    _quantite Prevision_quantite,
    _periode_debut DATE,
    _periode_fin DATE
  )
LANGUAGE SQL AS $$
  INSERT INTO Prevision(prevision_code, prevision_date, effectif, unite, type_activite, quantite, periode_debut, periode_fin)
  VALUES(_prevision_code, _prevision_date, Effectif(_effectif), _unite, _type_activite, _quantite, _periode_debut, _periode_fin)
$$;

-- Retirer une prévision
CREATE OR REPLACE PROCEDURE Prevision_ret
  (
    _prevision_code Prevision_Code
  )
LANGUAGE SQL AS $$
  DELETE FROM Prevision
  WHERE prevision_id = Prevision(_prevision_code)
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