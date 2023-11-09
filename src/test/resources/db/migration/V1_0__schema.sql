CREATE TABLE EyeUser (
                         id BIGSERIAL  NOT NULL,
                         username CHARACTER VARYING(255)  NOT NULL,
                         email CHARACTER VARYING(255)  NOT NULL,
                         password CHARACTER VARYING(255)  NOT NULL,
                         role CHARACTER VARYING(255)  NOT NULL,
                         CONSTRAINT PK_User PRIMARY KEY (id)
);

CREATE TABLE Expedition (
                            id BIGSERIAL NOT NULL ,
                            name varchar(255)  NOT NULL,
                            startdate TIMESTAMP,
                            enddate TIMESTAMP,
                            userid BIGINT  NOT NULL,
                            CONSTRAINT PK_Expedition PRIMARY KEY (id)
);

CREATE TABLE Category (
                          id BIGSERIAL  NOT NULL,
                          name CHARACTER VARYING(255)  NOT NULL,
                          CONSTRAINT PK_Category PRIMARY KEY (id)
);

CREATE TABLE Tag (
                     id BIGSERIAL  NOT NULL,
                     name CHARACTER VARYING(255)  NOT NULL,
                     CONSTRAINT PK_Tag PRIMARY KEY (id)
);

CREATE TABLE Animal (
                        id BIGSERIAL  NOT NULL,
                        categoryid BIGINT  NOT NULL,
                        imageData bytea,
                        CONSTRAINT PK_Animal PRIMARY KEY (id)
);

CREATE TABLE AnimalLocalization (
                                    id BIGSERIAL  NOT NULL,
                                    animalid BIGSERIAL  NOT NULL,
                                    locale CHARACTER VARYING(10)  NOT NULL,
                                    localization CHARACTER VARYING(255)  NOT NULL,
                                    CONSTRAINT PK_AnimalLocalization PRIMARY KEY (id)
);

CREATE TABLE ExpeditionTarget (
                                  id BIGSERIAL  NOT NULL,
                                  animalid BIGINT  NOT NULL,
                                  expeditionid BIGINT  NOT NULL,
                                  CONSTRAINT PK_ExpeditionTarget PRIMARY KEY (id)
);


CREATE TABLE AnimalTag (
                           id BIGSERIAL  NOT NULL,
                           animalid BIGINT  NOT NULL,
                           tagid BIGINT  NOT NULL,
                           CONSTRAINT PK_AnimalTag PRIMARY KEY (id)
);

CREATE TABLE Sighting (
                          id BIGSERIAL  NOT NULL,
                          longitude CHARACTER VARYING(4000) ,
                          latitude CHARACTER VARYING(4000) ,
                          creationtime TIMESTAMP NOT NULL,
                          expeditiontargetid BIGINT  NOT NULL,
                          CONSTRAINT PK_Sighting PRIMARY KEY (id)
);

ALTER TABLE Expedition ADD CONSTRAINT User_Expedition
    FOREIGN KEY (userid) REFERENCES EyeUser (id);
ALTER TABLE AnimalLocalization ADD CONSTRAINT Animal_Localization
    FOREIGN KEY (animalid) REFERENCES Animal (id);
ALTER TABLE Sighting ADD CONSTRAINT ExpeditionTarget_Sighting
    FOREIGN KEY (expeditiontargetid) REFERENCES ExpeditionTarget (id);
ALTER TABLE Animal ADD CONSTRAINT Category_Animal
    FOREIGN KEY (categoryid) REFERENCES Category (id);
ALTER TABLE ExpeditionTarget ADD CONSTRAINT Expedition_ExpeditionTarget
    FOREIGN KEY (expeditionid) REFERENCES Expedition (id);
ALTER TABLE ExpeditionTarget ADD CONSTRAINT Animal_ExpeditionTarget
    FOREIGN KEY (animalid) REFERENCES Animal (id);
ALTER TABLE AnimalTag ADD CONSTRAINT Animal_AnimalTag
    FOREIGN KEY (animalid) REFERENCES Animal (id);
ALTER TABLE AnimalTag ADD CONSTRAINT Tag_AnimalTag
    FOREIGN KEY (tagid) REFERENCES Tag (id);
