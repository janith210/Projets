-- =========================================
-- 1. REQUETES : SELECT 
-- =========================================


-- PREMIER SELECT
SELECT numEtudiant,nomEtudiant,prenomEtudiant
FROM  Vue_Consulter_Etudiant_Groupe
WHERE numGroupe=4;


-- DEUXIÈME SELECT
SELECT  E.numEtudiant,E.nomEtudiant,E.prenomEtudiant
FROM AG_Etudiant E
INNER JOIN AG_Covoiturage C ON E.numCovoiturage=C.numCovoiturage
WHERE E.numCovoiturage IS NOT NULL
AND OptionAnglaisEtudiant=True;


-- TROISIÈME SELECT
SELECT ValeurReponseSondage
FROM Vue_Consulter_Reponses_Sondage
WHERE nomEtudiant='SOUNOUVOU'
AND prenomEtudiant='Pierre'
AND NomSondage='QUALITE'; 


-- QUATRIÈME SELECT
SELECT E.nomEnseignant,E.prenomEnseignant
FROM AG_EnseignantResponsableFilière ERF
INNER JOIN AG_Enseignant E ON ERF.numEnseignant=E.numEnseignant;


-- CINQUIÈME SELECT
SELECT numGroupe, nomContrainte
FROM Vue_Consulter_Groupe_Contraintes
WHERE NumGroupe=5;


-- SIXIÈME SELECT
SELECT  numEtudiant,NomEtudiant,PrenomEtudiant,EmailEtudiant
FROM Vue_Consulter_Etudiant_Groupe
WHERE NumGroupe=3
ORDER BY NomEtudiant;


-- SEPTIÈME SELECT
SELECT * 
FROM Vue_Consulter_Etudiant_Sans_Groupe
ORDER BY NomEtudiant;


-- HUITIÈME SELECT
SELECT *
FROM Vue_Consulter_ListePromotion_Prive
WHERE PrenomEtudiant='Matthieu'
AND NomEtudiant='Charroin';


-- NEUFIÈME SELECT
SELECT NomEtudiant,PrenomEtudiant,ValeurNote
FROM Vue_Consulter_Etudiant_NoteGroupe
WHERE numGroupe=1
AND nomNote='Mathématique';


-- DIXIÈME SELECT
SELECT *
FROM Vue_Consulter_Donnees_Pedagogiques
WHERE NomEtudiant='Martin'
AND PrenomEtudiant='Lucas';


-- ONZIÈME SELECT
SELECT NomEtudiant,PrenomEtudiant,EmailEtudiant
FROM Vue_Consulter_Covoiturage
WHERE NumCovoiturage= ( SELECT NumCovoiturage FROM AG_Etudiant WHERE NumEtudiant=15);


-- =========================================
-- 2. REQUETES : UPDATE 
-- =========================================


-- PREMIER UPDATE
UPDATE AG_Etudiant
SET NumGroupe=5
WHERE NumEtudiant=4;


-- DEUXIÈME UPDATE
UPDATE AG_Etudiant
SET NumGroupe=NULL
WHERE NumEtudiant=4;


-- TROISIÈME UPDATE
UPDATE AG_Etudiant
SET NumCovoiturage=50
WHERE NumEtudiant=10;


-- =========================================
-- 3. REQUETES : INSERT 
-- =========================================


-- PREMIER INSERT
INSERT INTO AG_ReponseSondage(NumReponseSondage, ValeurReponseSondage, NumEnseignant, NumSondage, NumEtudiant)
VALUES (2,'Mathématique',1,5,10);


-- DEUXIÈME INSERT
INSERT INTO AG_Covoiturage DEFAULT VALUES;


-- TROISIÈME INSERT
INSERT INTO AG_Etudiant (NomEtudiant, PrenomEtudiant, DateNaissanceEtudiant, AdresseEtudiant, TelephoneEtudiant, GenreEtudiant, EmailEtudiant, TypeBacEtudiant, OptionAnglaisEtudiant,NumPromotion) VALUES ( 'Karl'', 'Hugo', '2005-05-12', '7 rue Jean Macé', '0612345678', 'M', 'Karl.Hugo@universite-paris-saclay.com', 'General', 1,1);


-- =========================================
-- 4. REQUETES : DELETE 
-- =========================================


-- PREMIER DELETE
DELETE FROM AG_Etudiant 
WHERE NumEtudiant=4;
