CREATE ROLE superAdmin;
GRANT ALL ON ALL TABLES IN SCHEMA public TO superAdmin;

CREATE ROLE administrateur;
GRANT SELECT, UPDATE ON ALL TABLES IN SCHEMA public TO administrateur;

CREATE ROLE utilisateur;
GRANT SELECT ON ALL TABLES IN SCHEMA public TO utilisateur;

CREATE ROLE paulhenry LOGIN PASSWORD 'azerty';
GRANT superAdmin TO paulhenry;

CREATE ROLE sonia LOGIN PASSWORD 'azerty';
GRANT administrateur TO sonia;

CREATE ROLE gregori LOGIN PASSWORD 'azerty';
GRANT utilisateur TO gregori;

CREATE ROLE marlene LOGIN PASSWORD 'azerty';
GRANT utilisateur TO marlene;
