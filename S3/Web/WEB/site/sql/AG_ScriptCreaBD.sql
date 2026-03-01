USE login;

-- ================================================
-- 1. DROP DES TABLES POUR UNE CREATION PLUS APTE 
-- ================================================

DROP TABLE AG_possede;
DROP TABLE AG_ReponseSondage;
DROP TABLE AG_Note;
DROP TABLE AG_Etudiant;
DROP TABLE AG_Contrainte;
DROP TABLE AG_Sondage;
DROP TABLE AG_Groupe;
DROP TABLE AG_EnseignantResponsableSemestre;
DROP TABLE AG_EnseignantResponsableAnnée;
DROP TABLE AG_EnseignantResponsableFilière;
DROP TABLE AG_EnseignantResponsable;
DROP TABLE AG_EnseignantResponsableFormation;
DROP TABLE AG_Covoiturage;
DROP TABLE AG_Promotion;
DROP TABLE AG_Enseignant;
DROP TABLE AG_Utilisateur;


-- ==================================================
-- 2. CREATE TABLE 
-- ==================================================

-- TABLE AG_Utilisateur
CREATE TABLE AG_Utilisateur(
   NumUtilisateur INT AUTO_INCREMENT,
   LoginUtilisateur VARCHAR(10) NOT NULL,
   MotDePasseUtilisateur VARCHAR(255) NOT NULL,
   TypeUtilisateur ENUM ('enseignant', 'etudiant') NOT NULL,
   PRIMARY KEY(NumUtilisateur)
);


-- TABLE AG_Enseignant
CREATE TABLE AG_Enseignant(
   NumEnseignant INT AUTO_INCREMENT,
   NomEnseignant VARCHAR(50) NOT NULL,
   PrenomEnseignant VARCHAR(50) NOT NULL,
   DateNaissanceEnseignant DATE NOT NULL,
   AdresseEnseignant VARCHAR(50) NOT NULL,
   TelephoneEnseignant VARCHAR(50) NOT NULL CHECK (TelephoneEnseignant REGEXP '^\\+[0-9]{1,3}[0-9]{6,12}$'),
   EmailEnseignant VARCHAR(50) NOT NULL CHECK (EmailEnseignant REGEXP '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$'),
   NumUtilisateur INT NOT NULL,
   PRIMARY KEY(NumEnseignant),
   FOREIGN KEY(NumUtilisateur) REFERENCES AG_Utilisateur(NumUtilisateur)
);


-- TABLE AG_Promotion
CREATE TABLE AG_Promotion(
   NumPromotion INT AUTO_INCREMENT,
   NomPromotion ENUM('BUT-1', 'BUT-2', 'BUT-3') NOT NULL,
   PRIMARY KEY(NumPromotion)
);


-- TABLE AG_Covoiturage
CREATE TABLE AG_Covoiturage(
   NumCovoiturage INT AUTO_INCREMENT,
   PRIMARY KEY(NumCovoiturage)
);


-- TABLE AG_EnseignantResponsableFormation
CREATE TABLE AG_EnseignantResponsableFormation(
   NumEnseignant INT AUTO_INCREMENT,
   DateDebutFormation DATE NOT NULL,
   DateFinFormation DATE NOT NULL,
   PRIMARY KEY(NumEnseignant),
   FOREIGN KEY(NumEnseignant) REFERENCES AG_Enseignant(NumEnseignant)
);


-- TABLE AG_EnseignantResponsable
CREATE TABLE AG_EnseignantResponsable(
   NumEnseignant INT AUTO_INCREMENT,
   DateDebutFonction DATE NOT NULL,
   DateFinFonction DATE NOT NULL,
   PRIMARY KEY(NumEnseignant),
   FOREIGN KEY(NumEnseignant) REFERENCES AG_Enseignant(NumEnseignant)
);


-- TABLE AG_EnseignantResponsableFilière
CREATE TABLE AG_EnseignantResponsableFilière(
   NumEnseignant INT AUTO_INCREMENT,
   NomFiliere ENUM('BUT-Informatique', 'BUT-Chimie', 'BUT-MesurePhysique') NOT NULL,
   PRIMARY KEY(NumEnseignant),
   FOREIGN KEY(NumEnseignant) REFERENCES AG_EnseignantResponsable(NumEnseignant)
);


-- TABLE AG_EnseignantResponsableAnnée
CREATE TABLE AG_EnseignantResponsableAnnée(
   NumEnseignant INT AUTO_INCREMENT,
   NomAnnee ENUM('BUT-1', 'BUT-2', 'BUT-3') NOT NULL,
   PRIMARY KEY(NumEnseignant),
   FOREIGN KEY(NumEnseignant) REFERENCES AG_EnseignantResponsable(NumEnseignant)
);


-- TABLE AG_EnseignantResponsableSemestre
CREATE TABLE AG_EnseignantResponsableSemestre(
   NumEnseignant INT AUTO_INCREMENT,
   NomSemestre ENUM('S1','S2','S3','S4','S5','S6') NOT NULL,
   PRIMARY KEY(NumEnseignant),
   FOREIGN KEY(NumEnseignant) REFERENCES AG_EnseignantResponsable(NumEnseignant)
);


-- TABLE AG_Groupe
CREATE TABLE AG_Groupe(
   NumGroupe INT AUTO_INCREMENT,
   TypeGroupe ENUM('TD', 'TP') NOT NULL,
   CapaciteGroupe INT NOT NULL CHECK (CapaciteGroupe > 0),
   NumEnseignantResponsableAnnee INT,
   NumEnseignantResponsable INT NOT NULL,
   PRIMARY KEY(NumGroupe),
   FOREIGN KEY(NumEnseignantResponsableAnnee) REFERENCES AG_EnseignantResponsableAnnée(NumEnseignant),
   FOREIGN KEY(NumEnseignantResponsable) REFERENCES AG_EnseignantResponsable(NumEnseignant)
);


-- TABLE AG_Sondage
CREATE TABLE AG_Sondage(
   NumSondage INT AUTO_INCREMENT,
   NomSondage VARCHAR(50) NOT NULL,
   DescriptionSondage VARCHAR(50) NOT NULL,
   TypeSondage ENUM('unique', 'multiple') NOT NULL,
   NumEnseignant INT NOT NULL,
   PRIMARY KEY(NumSondage),
   FOREIGN KEY(NumEnseignant) REFERENCES AG_EnseignantResponsable(NumEnseignant)
);


-- TABLE AG_Contrainte
CREATE TABLE AG_Contrainte(
   NumContrainte INT AUTO_INCREMENT,
   NomContrainte VARCHAR(50) NOT NULL,
   TypeContrainte VARCHAR(50) NOT NULL,
   ValeurContrainte INT NOT NULL,
   NumEnseignant INT NOT NULL,
   PRIMARY KEY(NumContrainte),
   FOREIGN KEY(NumEnseignant) REFERENCES AG_EnseignantResponsable(NumEnseignant)
);


-- TABLE AG_Etudiant
CREATE TABLE AG_Etudiant(
   NumEtudiant INT AUTO_INCREMENT,
   NomEtudiant VARCHAR(50) NOT NULL,
   PrenomEtudiant VARCHAR(50) NOT NULL,
   DateNaissanceEtudiant DATE NOT NULL,
   AdresseEtudiant VARCHAR(50) NOT NULL,
   TelephoneEtudiant VARCHAR(50) NOT NULL CHECK (TelephoneEtudiant REGEXP '^\\+[0-9]{1,3}[0-9]{6,15}$'),
   GenreEtudiant ENUM('M', 'F', 'A') NOT NULL,
   EmailEtudiant VARCHAR(50) NOT NULL CHECK (EmailEtudiant REGEXP '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$'),
   TypeBacEtudiant ENUM('General', 'Techno') NOT NULL,
   ParcoursEtudiant ENUM('A', 'B', 'C'),
   OptionAnglaisEtudiant BOOLEAN NOT NULL,
   PeriodeRedoublementEtudiant ENUM('BUT-1', 'BUT-2', 'BUT-3'),
   NumUtilisateur INT NOT NULL,
   NumEnseignant INT,
   NumEnseignantResponsable INT,
   NumEnseignantResponsableFiliere INT,
   NumCovoiturage INT,
   NumPromotion INT,
   NumGroupe INT,
   PRIMARY KEY(NumEtudiant),
   FOREIGN KEY(NumUtilisateur) REFERENCES AG_Utilisateur(NumUtilisateur), 
   FOREIGN KEY(NumEnseignantResponsableFiliere) REFERENCES AG_EnseignantResponsableFilière(NumEnseignant),
   FOREIGN KEY(NumEnseignant) REFERENCES AG_Enseignant(NumEnseignant),
   FOREIGN KEY(NumEnseignantResponsable) REFERENCES AG_EnseignantResponsable(NumEnseignant),
   FOREIGN KEY(NumCovoiturage) REFERENCES AG_Covoiturage(NumCovoiturage),
   FOREIGN KEY(NumPromotion) REFERENCES AG_Promotion(NumPromotion),
   FOREIGN KEY(NumGroupe) REFERENCES AG_Groupe(NumGroupe)
);


-- TABLE AG_Note
CREATE TABLE AG_Note(
   NumNote INT AUTO_INCREMENT,
   ValeurNote VARCHAR(50) NOT NULL CHECK (ValeurNote BETWEEN 0 AND 20),
   NomNote VARCHAR(50) NOT NULL,
   NumEtudiant INT NOT NULL,
   PRIMARY KEY(NumNote),
   FOREIGN KEY(NumEtudiant) REFERENCES AG_Etudiant(NumEtudiant)
);


-- TABLE AG_ReponseSondage
CREATE TABLE AG_ReponseSondage(
   NumReponseSondage INT AUTO_INCREMENT,
   ValeurReponseSondage VARCHAR(50) NOT NULL,
   NumEnseignant INT,
   NumSondage INT,
   NumEtudiant INT,
   PRIMARY KEY(NumReponseSondage),
   FOREIGN KEY(NumEnseignant) REFERENCES AG_Enseignant(NumEnseignant),
   FOREIGN KEY(NumSondage) REFERENCES AG_Sondage(NumSondage),
   FOREIGN KEY(NumEtudiant) REFERENCES AG_Etudiant(NumEtudiant)
);


-- TABLE AG_possede
CREATE TABLE AG_possede(
   NumGroupe INT,
   NumContrainte INT,
   OrdreContrainte INT,
   PRIMARY KEY(NumGroupe, NumContrainte),
   FOREIGN KEY(NumGroupe) REFERENCES AG_Groupe(NumGroupe),
   FOREIGN KEY(NumContrainte) REFERENCES AG_Contrainte(NumContrainte)
);
