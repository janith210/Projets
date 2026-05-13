
-- =========================================
-- 1. VUES
-- =========================================


-- PREMIÈRE VUE
CREATE VIEW Vue_Consulter_Reponses_Sondage AS
SELECT E.numEtudiant,E.nomEtudiant,E.prenomEtudiant,S.nomSondage,RS.ValeurReponseSondage
FROM AG_Etudiant E
INNER JOIN AG_ReponseSondage RS ON E.numEtudiant=RS.numEtudiant
INNER JOIN AG_Sondage S ON RS.numSondage=S.numSondage;


-- DEUXIÈME VUE
CREATE VIEW Vue_Consulter_Etudiant_Note AS 
SELECT E.nomEtudiant,E.prenomEtudiant,N.NomNote,N.ValeurNote
FROM AG_Etudiant E
INNER JOIN AG_Note N ON E.numEtudiant=N.numEtudiant;


-- TROISIÈME VUE
CREATE VIEW Vue_Consulter_Etudiant_Groupe AS 
SELECT  E.numEtudiant,E.nomEtudiant,E.prenomEtudiant,E.EmailEtudiant,G.NumGroupe,G.TypeGroupe
FROM AG_Etudiant E
INNER JOIN AG_Groupe G ON E.NumGroupe=G.NumGroupe
ORDER BY G.NumGroupe,E.NomEtudiant;


-- QUATRIÈME VUE
CREATE VIEW Vue_Consulter_Etudiant_NoteGroupe AS 
SELECT G.NumGroupe, E.numEtudiant,E.nomEtudiant,E.prenomEtudiant,N.NomNote,N.ValeurNote
FROM AG_Etudiant E
INNER JOIN AG_Note N ON E.numEtudiant=N.numEtudiant
INNER JOIN AG_Groupe G ON E.numGroupe=G.numGroupe
ORDER BY G.NumGroupe,E.NomEtudiant;


-- CINQUIÈME VUE
CREATE VIEW Vue_Consulter_Groupe_Contraintes AS
SELECT G.NumGroupe,G.TypeGroupe,G.CapaciteGroupe,NomContrainte
FROM AG_Groupe G
INNER JOIN AG_possede P ON G.NumGroupe=P.NumGroupe
INNER JOIN AG_Contrainte C ON P.NumContrainte=C.NumContrainte;


-- SIXIÈME VUE
CREATE VIEW Vue_Consulter_Enseignant AS 
SELECT nomEnseignant,prenomEnseignant,emailEnseignant
FROM AG_Enseignant E;


-- SEPTIÈME VUE
CREATE VIEW  Vue_Consulter_ListePromotion_Public AS
SELECT  E.nomEtudiant,E.PrenomEtudiant,E.EmailEtudiant,G.NumGroupe,G.TypeGroupe
FROM AG_Etudiant E
INNER JOIN AG_Groupe G ON E.numGroupe=G.numGroupe;


-- HUITIÈME VUE
CREATE VIEW  Vue_Consulter_ListePromotion_Prive AS
SELECT E.numEtudiant,E.nomEtudiant,E.PrenomEtudiant,E.DateNaissanceEtudiant,E.AdresseEtudiant,E.TelephoneEtudiant,
E.GenreEtudiant,E.EmailEtudiant,E.TypeBacEtudiant,E.ParcoursEtudiant,E.OptionAnglaisEtudiant,E.PeriodeRedoublementEtudiant,NumCovoiturage,NumPromotion,G.NumGroupe,G.TypeGroupe
FROM AG_Etudiant E
INNER JOIN AG_Groupe G ON E.numGroupe=G.numGroupe;


-- NEUFIÈME VUE
CREATE VIEW Vue_Consulter_Covoiturage AS 
SELECT C.NumCovoiturage,E.numEtudiant,E.nomEtudiant,E.PrenomEtudiant,E.EmailEtudiant
FROM AG_Etudiant E
INNER JOIN AG_Covoiturage C ON E.NumCovoiturage=C.NumCovoiturage;


-- DIXIÈME VUE
CREATE VIEW Vue_Consulter_Donnees_Pedagogiques AS 
SELECT  E.numEtudiant,E.NomEtudiant,E.PrenomEtudiant,E.EmailEtudiant,E.TypeBacEtudiant,
E.PeriodeRedoublementEtudiant,G.NumGroupe
FROM AG_Etudiant E
INNER JOIN AG_Groupe G ON E.numGroupe=G.numGroupe;


-- ONZIÈME VUE
CREATE VIEW Vue_Consulter_Etudiant_Sans_Groupe AS 
SELECT E.NumEtudiant,E.NomEtudiant,E.PrenomEtudiant
FROM AG_Etudiant E
WHERE E.NumGroupe IS NULL;


-- DOUZIÈME VUE
CREATE VIEW Vue_Consulter_ExportResponsable AS 
SELECT *
FROM AG_Etudiant;
