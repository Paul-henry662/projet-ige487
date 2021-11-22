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
INSERT INTO Effectif(nom, prenom, dateNaissance)
VALUES('Ngankam', 'Paul-henry', '2002-06-06');

INSERT INTO Effectif(nom, prenom, dateNaissance)
VALUES('Syapze', 'Yves', '2002-04-21');

INSERT INTO Effectif(nom, prenom, dateNaissance)
VALUES('Kamga', 'Jean', '1997-03-21');

INSERT INTO Effectif(nom, prenom, dateNaissance)
VALUES('Kenfack', 'Etienne', '2000-10-02');

INSERT INTO Effectif(nom, prenom, dateNaissance)
VALUES('Ngounou', 'Junior', '1999-04-04');

INSERT INTO Effectif(nom, prenom, dateNaissance)
VALUES('Seck', 'Alain', '1986-02-01');

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
VALUES('Perm001', 1, '2021-11-20', '2022-11-20');

INSERT INTO Permis(permis_code, effectif, valide_debut, valide_fin)
VALUES('Perm002', 2, '2021-12-20', '2022-01-20');

INSERT INTO Permis(permis_code, effectif, valide_debut, valide_fin)
VALUES('Perm003', 3, '2021-11-20', '2022-05-20');

INSERT INTO Permis(permis_code, effectif, valide_debut, valide_fin)
VALUES('Perm004', 4, '2022-10-22', '2025-10-22');

INSERT INTO Permis(permis_code, effectif, valide_debut, valide_fin)
VALUES('Perm005', 5, '2021-12-01', '2023-12-01');

-- ========================================================================
-- Insertions dans Permis_activite
-- ========================================================================
INSERT INTO Permis_activite(permis, type_activite)
VALUES(1,'TAA1');

INSERT INTO Permis_activite(permis, type_activite)
VALUES(2, 'TAA2');

INSERT INTO Permis_activite(permis, type_activite)
VALUES(3, 'TAA3');

INSERT INTO Permis_activite(permis, type_activite)
VALUES(4, 'TAA4');

INSERT INTO Permis_activite(permis, type_activite)
VALUES(5, 'TAA5');

-- ========================================================================
-- Insertions dans Prevision
-- ========================================================================
INSERT INTO Prevision(prevision_date, effectif, unite, type_activite, quantite, periode_debut, periode_fin)
VALUES('2021-11-20', 1, 'UNITE001', 'TAA1', 3.6, '2021-11-20', '2022-03-20');

INSERT INTO Prevision(prevision_date, effectif, unite, type_activite, quantite, periode_debut, periode_fin)
VALUES('2021-11-21', 2, 'UNITE002', 'TAA2', 3.2, '2022-11-20', '2022-12-20');

INSERT INTO Prevision(prevision_date, effectif, unite, type_activite, quantite, periode_debut, periode_fin)
VALUES('2021-11-22', 3, 'UNITE002', 'TAA3', 0.3, '2021-11-20', '2022-03-20');

INSERT INTO Prevision(prevision_date, effectif, unite, type_activite, quantite, periode_debut, periode_fin)
VALUES('2021-11-22', 1, 'UNITE003', 'TAA1', 10.03, '2026-11-20', '2026-12-20');

INSERT INTO Prevision(prevision_date, effectif, unite, type_activite, quantite, periode_debut, periode_fin)
VALUES('2021-11-22', 3, 'UNITE001', 'TAA3', 4.3, '2023-11-20', '2024-12-20');

INSERT INTO Prevision(prevision_date, effectif, unite, type_activite, quantite, periode_debut, periode_fin)
VALUES('2021-11-22', 4, 'UNITE004', 'TAA1', 1.5, '2023-11-20', '2024-12-20');

INSERT INTO Prevision(prevision_date, effectif, unite, type_activite, quantite, periode_debut, periode_fin)
VALUES('2021-11-22', 6, 'UNITE005', 'TAA5', 0.8, '2022-11-20', '2023-01-20');