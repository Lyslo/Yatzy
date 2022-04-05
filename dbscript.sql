DROP SCHEMA IF EXISTS prosjekt CASCADE;
CREATE SCHEMA prosjekt;
SET search_path = prosjekt;

CREATE TABLE Bruker
(
	epost CHARACTER VARYING(256),
	brukernavn CHARACTER VARYING(32),
	navn CHARACTER VARYING(64),
	passord CHARACTER VARYING(32),
	PRIMARY KEY (epost)
);

INSERT INTO Bruker VALUES
	('arnegiacomo@gmail.com', 'arnegutten', 'Arne Giacomo Munthe-Kaas','passord123');
