/*
-- =========================================================================== A
Activité : MCEBD.SQL.A
Trimestre : 2021-3
Composant : MECA_priv.sql
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
-- =================== Unité organisationnelle
--
create table Unite
(
  unite_code Unite_Code not null,
  unite_nom  Unite_Nom not null,
  constraint unite_cc0 primary key (unite_code),
  constraint unite_cc1 unique (unite_nom)
);
comment on table Unite is $$
Une unité organisationnelle est identifiée par "id" et nommée par "nom".
$$;
--
-- =================== Structure organisationnelle
--
create table SOrg
(
  unite Unite_Code not null,
  super_unite Unite_Code not null,
  constraint sorg_cc0 primary key (unite, super_unite),
  constraint sorg_cr0 foreign key (unite) references unite(unite_code) ON DELETE CASCADE ON UPDATE CASCADE,
  constraint sorg_cr1 foreign key (super_unite) references unite(unite_code) ON DELETE CASCADE ON UPDATE CASCADE,
  constraint sorg_struct check(unite <> super_unite)

);
comment on table SOrg is $$
Une unité "unite" dépend administrativement de l’unité "super_unite".
La structure doit strictement respecter une topologie hiérarchique
(un graphe connexe sans cycle).
$$;
--
-- =================== Effectif clinique autonome
--
create table Effectif
(
  eff_id INTEGER not null generated always as identity (minvalue 1),
  eff_matr Eff_Matr not null,
  nom text not null,
  prenom text not null,
  dateNaissance Date not null,
  constraint effectif_cc0 primary key (eff_id),
  constraint effectif_cc1 unique (eff_matr)
);
comment on table Effectif is $$
Un effectif est identifié par "id" et "matr", nommé par "nom" et "prenom" et est né le "dateNaissance".
$$;
--
-- =================== Type d’activité
--
create table Type_activite
(
  type Type_activite_Code not null,
  nom Type_activite_Nom not null,
  description TEXT not null,
  actif BOOLEAN not null,
  constraint Type_activite_cc0 primary key (type),
  constraint Type_activite_cc1 unique (nom)
);
comment on table Type_activite is $$
Un type d’activités.
$$;
--
-- =================== Permis
--
create table Permis
(
  permis_id INTEGER not null generated always as identity (minvalue 1),
  permis_code Permis_CODE not null,
  effectif Eff_ID not null,
  valide_debut DATE not null,
  valide_fin DATE not null,
  constraint permis_cc0 primary key (permis_id),
  constraint permis_cr0 foreign key (effectif) references effectif(eff_id) ON DELETE CASCADE,
  constraint permis_dates check(valide_debut < valide_fin)
);
comment on table Permis is $$
Le permis d’exercice d’un effectif pour une durée de validité spécifique.
Une effectif peut détenir plus d’un permis, mais leurs périodes de validité ne peuvent se chevaucher.
$$;
--
create table Permis_activite
(
  permis Permis_ID not null,
  type_activite Type_activite_CODE not null,
  constraint permis_activite_c00 primary key (permis, type_activite),
  constraint permis_activite_cr0 foreign key (permis) references Permis(permis_id) ON DELETE CASCADE,
  constraint permis_activite_cr1 foreign key (type_activite) references Type_activite(type) ON UPDATE CASCADE ON DELETE CASCADE
);
comment on table Permis_activite is $$
Le permis permet d’exercer pour un ou plusieurs types d’acitivtés.
$$;
--
-- =================== Prévision d’activité
--
create table Prevision
(
  prevision_id INTEGER not null generated always as identity (minvalue 1),
  prevision_code Prevision_Code,
  prevision_date DATE,
  effectif Eff_ID not null,
  unite Unite_Code not null,
  type_activite Type_activite_CODE not null,
  quantite Prevision_quantite not null,
  periode_debut DATE not null,
  periode_fin DATE not null,
  constraint prevision_cc0 primary key (prevision_id),
  constraint prevision_cc1 unique (prevision_code),
  constraint prevision_cr0 foreign key (effectif) references Effectif(eff_id) ON DELETE CASCADE,
  constraint prevision_cr1 foreign key (unite) references Unite(unite_code) ON DELETE CASCADE,
  constraint prevision_cr2 foreign key (type_activite) references Type_activite(type) ON UPDATE CASCADE ON DELETE CASCADE,
  constraint prevision_periode check(periode_debut < periode_fin)
);
comment on table Prevision is $$
Une prévision d’activité estime la quantité de travail d’un type d’activités à être réalisée
par un effectif médical au sein d’une unité organisationnelle pendant une période donnée.
Une prévision ne peut être saisie que si l’effectif possède un permis valide permettant
d’accomplir le type d’activité durant toute la période prévue.
$$;

--
-- =================== Triggers et Trigger functions
--
CREATE OR REPLACE FUNCTION sorg_val()
RETURNS TRIGGER
LANGUAGE plpgsql AS $$
BEGIN
  IF NOT EXISTS(
      SELECT *
      FROM SOrg
      WHERE unite = NEW.super_unite
      AND super_unite = NEW.unite
    )
  THEN
    RETURN NEW;
  ELSE
    RAISE EXCEPTION 'Structure hiérarchique des unités violée';
    RETURN NULL;
  END IF;
END
$$;


CREATE OR REPLACE TRIGGER sorg_valide
  AFTER INSERT OR UPDATE ON Sorg
  FOR EACH ROW
  EXECUTE PROCEDURE sorg_val();

CREATE OR REPLACE FUNCTION prevision_permis()
RETURNS TRIGGER
LANGUAGE plpgsql AS $$
BEGIN
  IF EXISTS(
      SELECT *
      FROM Permis JOIN Permis_activite Pa on Permis.permis_id = Pa.permis
      WHERE effectif = NEW.effectif
      AND type_activite = NEW.type_activite
      AND (NEW.periode_debut BETWEEN  valide_debut AND valide_fin)
      AND (NEW.periode_fin BETWEEN valide_debut AND valide_fin)
    )
  THEN
    RETURN NEW;
  ELSE
    RAISE EXCEPTION 'Cet ECA ne possède pas de permis pour cette activité dans cet intervalle de temps';
    RETURN NULL;
  END IF;
END
$$;

CREATE OR REPLACE TRIGGER prevision_permis
  AFTER INSERT OR UPDATE ON Prevision
  FOR EACH ROW
  EXECUTE PROCEDURE prevision_permis();

CREATE OR REPLACE FUNCTION permis_dates()
RETURNS TRIGGER
LANGUAGE plpgsql AS $$
BEGIN
  IF EXISTS(
      SELECT *
      FROM Permis p1 JOIN Permis p2 USING (effectif)
      WHERE p1.permis_id <> p2.permis_id
      AND p1.valide_debut <= p2.valide_fin
      AND p1.valide_fin >= p2.valide_debut
    )
  THEN
    RAISE EXCEPTION 'Cet ECA possède déjà un permis dont les dates chevauchent avec celui-ci';
    RETURN NULL;
  ELSE
    RETURN NEW;
  END IF;
END
$$;


CREATE OR REPLACE TRIGGER permis_dates
  AFTER INSERT OR UPDATE ON Permis
  FOR EACH ROW
  EXECUTE PROCEDURE permis_dates();
/*
-- =========================================================================== Z
Contributeurs :
  (CK) Christina.Khnaisser@USherbrooke.ca,
  (LL) Luc.Lavoie@USherbrooke.ca,
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
2021-11-23 (ST) : Revue.

Tâches réalisées :
2021-11-22 (PN) : Création initiale.

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
-- fin de MECA_priv.sql
-- =========================================================================== Z
*/
