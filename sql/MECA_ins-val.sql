/*
-- =========================================================================== A
Activité : MCEBD.SQL.A
Trimestre : 2021-3
Composant : MECA_ins-val.sql
Encodage : UTF-8, sans BOM; fin de ligne Unix (LF)
Plateforme : PostgreSQL 9.4 à 14
Responsables : Luc.Lavoie@USherbrooke.ca; Christina.Khnaisser@USherbrooke.ca; lorince.tawamba@ucac-icam.com
Version : 0.1.0a
Statut : solution préliminaire
-- =========================================================================== A
*/

/*
-- =========================================================================== B
   Jeu de données valides aux fins de test du modèle.
-- =========================================================================== B
*/
-- ========================================================================
-- Insertions dans Unite
-- ========================================================================
INSERT INTO Unite(unite_code, unite_nom)
VALUES ('UNITE001', 'nomUnite1');

INSERT INTO Unite(unite_code, unite_nom)
VALUES ('UNITE002', 'nomUnite2');

INSERT INTO Unite(unite_code, unite_nom)
VALUES ('UNITE003', 'nomUnite3');

INSERT INTO Unite(unite_code, unite_nom)
VALUES ('UNITE004', 'nomUnite4');

INSERT INTO Unite(unite_code, unite_nom)
VALUES ('UNITE005', 'nomUnite5');

-- ========================================================================
-- Insertions dans SOrg
-- ========================================================================
INSERT INTO SOrg(unite, super_unite)
VALUES('UNITE002', 'UNITE001');

INSERT INTO SOrg(unite, super_unite)
VALUES('UNITE003', 'UNITE002');

INSERT INTO SOrg(unite, super_unite)
VALUES('UNITE004', 'UNITE003');

INSERT INTO SOrg(unite, super_unite)
VALUES('UNITE005', 'UNITE004');

-- ========================================================================
-- Insertions dans Effectif
-- ========================================================================
INSERT INTO Effectif(eff_matr, nom, prenom, dateNaissance)
VALUES('00000001','Ngankam', 'Paul-henry', '2002-06-06');

INSERT INTO Effectif(eff_matr, nom, prenom, dateNaissance)
VALUES('00000002', 'Syapze', 'Yves', '2002-04-21');

INSERT INTO Effectif(eff_matr, nom, prenom, dateNaissance)
VALUES('00000003', 'Kamga', 'Jean', '1997-03-21');

INSERT INTO Effectif(eff_matr, nom, prenom, dateNaissance)
VALUES('00000004', 'Kenfack', 'Etienne', '2000-10-02');

INSERT INTO Effectif(eff_matr, nom, prenom, dateNaissance)
VALUES('00000005', 'Ngounou', 'Junior', '1999-04-04');

INSERT INTO Effectif(eff_matr, nom, prenom, dateNaissance)
VALUES('00000006', 'Seck', 'Alain', '1986-02-01');

-- ========================================================================
-- Insertions dans Type_activite
-- ========================================================================
INSERT INTO Type_activite(type, nom, description, actif)
VALUES('TAA1', 'typeActiviteA1', 'description du type d activite A1', TRUE);

INSERT INTO Type_activite(type, nom, description, actif)
VALUES('TAA2', 'typeActiviteA2', 'description du type d activite A2', TRUE);

INSERT INTO Type_activite(type, nom, description, actif)
VALUES('TAA3', 'typeActiviteA3', 'description du type d activite A3', FALSE);

INSERT INTO Type_activite(type, nom, description, actif)
VALUES('TAA4', 'typeActiviteA4', 'description du type d activite A4', TRUE);

INSERT INTO Type_activite(type, nom, description, actif)
VALUES('TAA5', 'typeActiviteA5', 'description du type d activite A5', FALSE);

-- ========================================================================
-- Insertions dans Permis
-- ========================================================================
INSERT INTO Permis(permis_code, effectif, valide_debut, valide_fin)
VALUES('Perm001', Effectif('00000001'), '2021-11-20', '2022-11-20');

INSERT INTO Permis(permis_code, effectif, valide_debut, valide_fin)
VALUES('Perm002', Effectif('00000002'), '2021-12-20', '2022-01-20');

INSERT INTO Permis(permis_code, effectif, valide_debut, valide_fin)
VALUES('Perm003', Effectif('00000003'), '2021-11-20', '2022-05-20');

INSERT INTO Permis(permis_code, effectif, valide_debut, valide_fin)
VALUES('Perm004', Effectif('00000004'), '2022-10-22', '2025-10-22');

INSERT INTO Permis(permis_code, effectif, valide_debut, valide_fin)
VALUES('Perm005', Effectif('00000005'), '2021-12-01', '2023-12-01');

-- ========================================================================
-- Insertions dans Permis_activite
-- ========================================================================
INSERT INTO Permis_activite(permis, type_activite)
VALUES(Permis('Perm001'),'TAA1');

INSERT INTO Permis_activite(permis, type_activite)
VALUES(Permis('Perm002'), 'TAA2');

INSERT INTO Permis_activite(permis, type_activite)
VALUES(Permis('Perm003'), 'TAA3');

INSERT INTO Permis_activite(permis, type_activite)
VALUES(Permis('Perm004'), 'TAA4');

INSERT INTO Permis_activite(permis, type_activite)
VALUES(Permis('Perm005'), 'TAA5');

-- ========================================================================
-- Insertions dans Prevision
-- ========================================================================
INSERT INTO Prevision(prevision_code, prevision_date, effectif, unite, type_activite, quantite, periode_debut, periode_fin)
VALUES('Prev0001', '2021-11-20', Effectif('00000001'), 'UNITE001', 'TAA1', 3.6, '2021-11-20', '2022-03-20');

INSERT INTO Prevision(prevision_code, prevision_date, effectif, unite, type_activite, quantite, periode_debut, periode_fin)
VALUES('Prev0002', '2021-11-21', Effectif('00000002'), 'UNITE002', 'TAA2', 3.2, '2022-11-20', '2022-12-20');

INSERT INTO Prevision(prevision_code, prevision_date, effectif, unite, type_activite, quantite, periode_debut, periode_fin)
VALUES('Prev0003', '2021-11-22', Effectif('00000003'), 'UNITE002', 'TAA3', 0.3, '2021-11-20', '2022-03-20');

INSERT INTO Prevision(prevision_code, prevision_date, effectif, unite, type_activite, quantite, periode_debut, periode_fin)
VALUES('Prev0004', '2021-11-22', Effectif('00000001'), 'UNITE003', 'TAA1', 10.03, '2026-11-20', '2026-12-20');

INSERT INTO Prevision(prevision_code, prevision_date, effectif, unite, type_activite, quantite, periode_debut, periode_fin)
VALUES('Prev0005', '2021-11-22', Effectif('00000003'), 'UNITE001', 'TAA3', 4.3, '2023-11-20', '2024-12-20');

INSERT INTO Prevision(prevision_code, prevision_date, effectif, unite, type_activite, quantite, periode_debut, periode_fin)
VALUES('Prev0006', '2021-11-22', Effectif('00000004'), 'UNITE004', 'TAA1', 1.5, '2023-11-20', '2024-12-20');

INSERT INTO Prevision(prevision_code, prevision_date, effectif, unite, type_activite, quantite, periode_debut, periode_fin)
VALUES('Prev0007', '2021-11-22', Effectif('00000006'), 'UNITE005', 'TAA5', 0.8, '2022-11-20', '2023-01-20');
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
2021-11-20 (GT) : Revue.

Tâches réalisées :
2021-11-20 (PN) : Création initiale.

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
-- fin de MECA_ins-val.sql
-- =========================================================================== Z
*/