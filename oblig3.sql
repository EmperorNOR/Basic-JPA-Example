DROP SCHEMA IF EXISTS oblig3 CASCADE;

CREATE SCHEMA oblig3;
SET search_path TO oblig3;   

CREATE TABLE Avdeling
(
    Id SERIAL,
    Navn VARCHAR(30),
    Sjef_Id INTEGER,
    
    CONSTRAINT avdeling_pk PRIMARY KEY (id)
    
);

CREATE TABLE Ansatt
(
    Id SERIAL,
    Brukernavn VARCHAR(4),
    Fornavn VARCHAR(30),
    Etternavn VARCHAR(30),
    Ansettelsesdato DATE,
    Stilling VARCHAR,
    Lonn INTEGER,
    Avdeling_Id INTEGER,
    
    CONSTRAINT ansatt_pk PRIMARY KEY (Id),
    CONSTRAINT ansattavdeling_fk FOREIGN KEY (Avdeling_Id) references Avdeling(Id)
);

INSERT INTO
  avdeling(Navn)
VALUES
    ('It'),
    ('Rengjoring'),
    ('Markedsføring');

INSERT INTO
  ansatt(brukernavn, fornavn, etternavn, ansettelsesdato, stilling, lonn, avdeling_id)
VALUES
    ('dgl', 'Dag', 'Løtveit', '23/10/1984', 'Selger', 530000, 3),
    ('kga', 'Kristian', 'Amundsen', '30/11/2005', 'Salgsjef', 730000, 3),
    ('ml', 'Markus', 'Løtveit', '22/08/2013', 'Programmerer', 660000, 1),
    ('aa', 'Atilla', 'Arkensen', '15/03/1990', 'It Ansvarlig', 960000, 1),
    ('am', 'Anette', 'Moen', '12/05/1986', 'Rengjoring Sjef', 480000, 2);
    

UPDATE Avdeling
	SET Sjef_Id = 2 WHERE ID = 3;
	
UPDATE Avdeling
	SET Sjef_Id = 4 WHERE ID = 1;
	
UPDATE Avdeling
	SET Sjef_Id = 5 WHERE ID = 2;


ALTER TABLE Avdeling
	ADD FOREIGN KEY (Sjef_Id) references Ansatt(Id),
	ALTER COLUMN Sjef_Id SET NOT NULL;

ALTER TABLE Ansatt
	ALTER COLUMN Avdeling_Id SET NOT NULL;


CREATE TABLE Prosjekt
(
    Id SERIAL,
    Navn VARCHAR(30),
    Beskrivelse VARCHAR,
    
    CONSTRAINT prosjekt_pk PRIMARY KEY (Id)
);

CREATE TABLE ProsjektAnsatte
(
    Ansatt_Id INTEGER,
    Prosjekt_Id INTEGER,
    Navn VARCHAR(30),
    Beskrivelse VARCHAR,
    Rolle VARCHAR,
    Timer INTEGER,
    
    
    CONSTRAINT prosjektansatte_pk PRIMARY KEY (Ansatt_Id,Prosjekt_Id),
    CONSTRAINT ansattprosjekt_fk FOREIGN KEY (Ansatt_Id) references Ansatt(Id) ON DELETE CASCADE,
    CONSTRAINT prosjektansatt_fk FOREIGN KEY (Prosjekt_Id) references Prosjekt(Id) ON DELETE CASCADE
    
);







