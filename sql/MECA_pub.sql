/*
-- =========================================================================== A
Activité : MCEBD.SQL.A
Trimestre : 2021-3
Composant : MECA_pub.sql
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
create domain Unite_Code
  VARCHAR(8)
  constraint unite_code_dom check (value similar to '[A-Z]{5}[0-9]{3}');
comment on domain Unite_code is $$
Code unique d’une unité organisationnelle.
$$;
--
create domain Unite_Nom
  VARCHAR(240);
comment on domain Unite_Nom is $$
Nom d’une unité organisationnelle.
$$;

--
-- =================== Effectif clinique autonome
--
create domain Eff_ID
  INTEGER
  constraint eff_id_dom check (value > 0);
comment on domain Unite_nom is $$
Identifiant artificiel d’un effectif médical
$$;

create domain Eff_Matr
  VARCHAR(8)
  constraint eff_matr_dom check(value similar to '[0-9]{8}');
comment on domain Eff_Matr is $$
Matricule d’un effectif médical
$$;

--
-- =================== Type d’activité
--
create domain Type_activite_Code
  VARCHAR(7)
  constraint type_activite_code_dom check (value similar to '[a-zA-Z][a-zA-Z0-9]{2,7}');
comment on domain Type_activite_Code is $$
Code unique d’un type d’activité.
$$;
--
create domain Type_activite_Nom
  VARCHAR(40);
comment on domain Type_activite_Nom is $$
Nom de référence d’un type d’activité.
$$;
--
-- =================== Permis
--
create domain Permis_ID
  INTEGER
  constraint permis_id_dom check(value > 0);
comment on domain Permis_ID is $$
Identifiant artificiel unique d’un permis d’exercice.
$$;
--
create domain Permis_CODE
  VARCHAR(7)
  constraint permis_code_dom check (value similar to '[a-zA-Z]{4}[0-9]{3}');
comment on domain Permis_CODE is $$
Code unique d’un permis d’exercice.
$$;

--
-- =================== Prévision d’activité
--
create domain Prevision_ID
  INTEGER
  constraint Prevision_ID_dom check (value > 0);
comment on domain Prevision_ID is $$
Identifiant unique artificiel d’une prévision.
$$;
--

create domain Prevision_Code
  VARCHAR(8)
  constraint prevision_code_dom check (value similar to 'Prev[0-9]{4}');
--

create domain Prevision_quantite
  NUMERIC(12,2)
  constraint Prevision_quantite_dom check (value > 0);
comment on domain Prevision_quantite is $$
La quantité de travail d’une prévision est exprimée en heures-personnes
(qui est plutôt une mesure de l’effort, mais les us et coutumes du réseau sont ainsi).
$$;
--

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
2021-11-23 (MJ) : Revue.

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
-- fin de MECA_pub.sql
-- =========================================================================== Z
*/
