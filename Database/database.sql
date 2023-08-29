


DROP DATABASE IF EXIST heietudiant;

CREATE DATABASE  heietudiant;

\C heietudiant;

CREATE TABLE Club (
    Club_id            SERIAL PRIMARY KEY NOT NULL,
    Club_name          VARCHAR(200) NOT NULL,
    Club_description   VARCHAR(2000) NOT NULL,
    Creation_date      DATE NOT NULL
);

CREATE TABLE Student (
    Student_id       SERIAL PRIMARY KEY NOT NULL,
    First_name       VARCHAR(200) NOT NULL,
    Last_name        VARCHAR(200) NOT NULL,
    Date_of_birth    DATE NOT NULL,
    Email            VARCHAR(200) NOT NULL
);

CREATE TABLE Event (
    Event_id            SERIAL PRIMARY KEY NOT NULL,
    Event_name          VARCHAR(200) NOT NULL,
    Event_description   VARCHAR(2000) NOT NULL,
    Start_date_time     TIMESTAMP NOT NULL,
    End_date_time       TIMESTAMP NOT NULL,
    Club_id             INT NOT NULL,
    FOREIGN KEY (Club_id) REFERENCES Club(Club_id)
);

CREATE TABLE Membre (
    Membre_id           SERIAL PRIMARY KEY NOT NULL,
    Membership_date     DATE,
    Role                VARCHAR(200) NOT NULL,
    Club_id             INT NOT NULL,
    FOREIGN KEY (Club_id) REFERENCES Club(Club_id)
);

CREATE TABLE Event_Participation (
    Participation_id     SERIAL PRIMARY KEY NOT NULL,
    Participation_date   DATE NOT NULL,
    Event_id             INT,
    Student_id           INT,
    FOREIGN KEY (Event_id) REFERENCES Event(Event_id),
    FOREIGN KEY (Student_id) REFERENCES Student(Student_id)
);

--INSERT
     -- Insertion de clubs
INSERT INTO Club (Club_name, Club_description, Creation_date) 
VALUES ('Club de Théâtre', 'Club dédié aux passionnés de théâtre et de l art dramatique.', '2023-08-20');

INSERT INTO Club (Club_name, Club_description, Creation_date) 
VALUES ('Club de Musique', 'Club pour les amateurs de musique qui veulent jouer et chanter ensemble.', '2023-08-20');

INSERT INTO Club (Club_name, Club_description, Creation_date) 
VALUES ('Club de Débats', 'Club où les étudiants peuvent discuter et débattre de sujets variés.', '2023-08-20');

-- Insertion d étudiants
INSERT INTO Student (First_name, Last_name, Date_of_birth, Email)
VALUES ('Alice', 'Dubois', '2000-03-15', 'alice.dubois@example.com');

INSERT INTO Student (First_name, Last_name, Date_of_birth, Email)
VALUES ('Martin', 'Lefebvre', '2001-06-25', 'martin.lefebvre@example.com');

INSERT INTO Student (First_name, Last_name, Date_of_birth, Email)
VALUES ('Sophie', 'Gagnon', '2000-12-10', 'sophie.gagnon@example.com');

-- Insertion d'événements
INSERT INTO Event (Event_name, Event_description, Start_date_time, End_date_time, Club_id)
VALUES ('Spectacle de Théâtre', 'Une représentation de notre dernier spectacle théâtral.', '2023-09-10 18:00:00', '2023-09-10 20:00:00', 1);

INSERT INTO Event (Event_name, Event_description, Start_date_time, End_date_time, Club_id)
VALUES ('Concert Acoustique', 'Une soirée musicale acoustique avec des performances live.', '2023-09-15 19:30:00', '2023-09-15 22:00:00', 2);

INSERT INTO Event (Event_name, Event_description, Start_date_time, End_date_time, Club_id)
VALUES ('Débat sur l Environnement', 'Un débat ouvert sur les problématiques environnementales actuelles.', '2023-09-20 16:00:00', '2023-09-20 18:00:00', 3);

-- Insertion de membres
INSERT INTO Membre (Membership_date, Role, Club_id)
VALUES ('2023-08-21', 'Président', 1);

INSERT INTO Membre (Membership_date, Role, Club_id)
VALUES ('2023-08-21', 'Trésorier', 2);

INSERT INTO Membre (Membership_date, Role, Club_id)
VALUES ('2023-08-21', 'Membre', 3);

-- Insertion de participations aux événements
INSERT INTO Event_Participation (Participation_date, Event_id, Student_id)
VALUES ('2023-09-10', 1, 1);

INSERT INTO Event_Participation (Participation_date, Event_id, Student_id)
VALUES ('2023-09-15', 2, 2);

INSERT INTO Event_Participation (Participation_date, Event_id, Student_id)
VALUES ('2023-09-20', 3, 3);

