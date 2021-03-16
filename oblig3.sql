DROP SCHEMA IF EXISTS oblig3 CASCADE;

CREATE SCHEMA oblig3;
SET search_path TO oblig3;   

CREATE TABLE avdeling
(
    id SERIAL,
    navn VARCHAR,
    sjefid INTEGER,
    
    CONSTRAINT avdeling_pk PRIMARY KEY (id)
    
);

CREATE TABLE ansatt
(
    id SERIAL,
    brukernavn VARCHAR(4),
    fornavn VARCHAR,
    etternavn VARCHAR,
    ansettelsesdato DATE,
    stilling VARCHAR,
    lonn INTEGER,
    avdelingid INTEGER,
    
    CONSTRAINT ansatt_pk PRIMARY KEY (id),
    CONSTRAINT ansattavdeling_fk FOREIGN KEY (avdelingid) references avdeling(id)
);

CREATE TABLE prosjekt
(
    id SERIAL,
    navn VARCHAR,
    beskrivelse VARCHAR,
    
    CONSTRAINT prosjekt_pk PRIMARY KEY (id)
);

CREATE TABLE prosjektansatte
(
    ansattid INTEGER,
    prosjektid INTEGER,
    timer INTEGER,
    
    
    CONSTRAINT prosjektansatte_pk PRIMARY KEY (ansattid,prosjektid),
    CONSTRAINT ansattprosjekt_fk FOREIGN KEY (ansattid) references ansatt(id) ON DELETE CASCADE,
    CONSTRAINT prosjektansatt_fk FOREIGN KEY (prosjektid) references prosjekt(id) ON DELETE CASCADE
    
);





INSERT INTO
  ansatt(brukernavn, fornavn, etternavn, ansettelsesdato, stilling, lonn, avdelingid)
VALUES
    ('dgl', 'Dag', 'Løtveit', 23/10/1984, 'Selger', 530000, 3)

