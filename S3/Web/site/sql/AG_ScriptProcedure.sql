-- =========================================
-- 1. PROCÉDURES
-- =========================================

-- PROCÉDURE ajouterContrainte
DROP PROCEDURE IF EXISTS ajouterContrainte;
DELIMITER $$
CREATE PROCEDURE `ajouterContrainte`(IN `p_nom` VARCHAR(50), IN `p_type` VARCHAR(50), IN `p_valeur` INT(11))
BEGIN
	    
    IF NOT fn_contrainteExiste(p_nom, p_type, p_valeur) THEN
    	INSERT INTO AG_Contrainte (nomContrainte,typeContrainte,valeurContrainte) VALUES (p_nom,p_type,p_valeur);
    ELSE
    	SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Erreur : La contrainte existe déjà.';
    END IF;
END$$
DELIMITER ;


-- PROCÉDURE ajouterEtudiant
DELIMITER $$
DROP PROCEDURE IF EXISTS ajouterEtudiant$$
CREATE PROCEDURE `ajouterEtudiant`(IN `p_nom` VARCHAR(30), IN `p_prenom` VARCHAR(30), IN `p_dateNaissance` DATE, IN `p_addr` VARCHAR(100), IN `p_telephone` VARCHAR(20), IN `p_genre` ENUM('M','F','A'), IN `p_mail` VARCHAR(50), IN `p_typeBac` ENUM('General','Techno'), IN `p_parcours` ENUM('A','B','C'), IN `p_OptionAnglais` BOOLEAN, IN `p_redoublement` ENUM('BUT-1','BUT-2','BUT-3'), IN `p_numEnseignantResponsable` INT(11), IN `p_numEnseignantFiliere` INT(11), IN `p_numCovoiturage` INT(11), IN `p_numPromotion` INT(11), IN `p_numGroupe` INT(11), IN `p_numEnseignant` INT(11))
BEGIN
	IF fn_enseignantExiste(p_numEnseignant) THEN
		IF fn_estResponsable(p_numEnseignantResponsable) THEN
        	IF fn_estResponsableFiliere(p_numEnseignantFiliere) THEN
            	IF fn_covoiturageExiste(p_numCovoiturage) THEN
               		IF fn_promotionExiste(p_numPromotion) THEN
						IF fn_groupeExiste(p_numGroupe) THEN
							INSERT INTO AG_Etudiant (
                                nomEtudiant, prenomEtudiant, dateNaissanceEtudiant, adresseEtudiant,
                                telephoneEtudiant, genreEtudiant, emailEtudiant, typeBacEtudiant,
                                parcoursEtudiant, optionAnglaisEtudiant, periodeRedoublementEtudiant,
                                numEnseignantResponsable, numEnseignantFiliere, numCovoiturage,
                                numPromotion, numGroupe
                            )
                            VALUES (
                                p_nom, p_prenom, p_dateNaissance, p_addr, p_telephone, p_genre,
                                p_mail, p_typeBac, p_parcours, p_OptionAnglais, p_redoublement,
                                p_numEnseignantResponsable, p_numEnseignantFiliere, p_numCovoiturage,
                                p_numPromotion, p_numGroupe
                            );
                        ELSE
            				SIGNAL SQLSTATE '45000'
            				SET MESSAGE_TEXT = 'Erreur : Le groupe n''existe pas.';
        				END IF;
                    ELSE
                        SIGNAL SQLSTATE '45000'
            			SET MESSAGE_TEXT = 'Erreur : La promotion n''existe pas.';
        			END IF;
               	ELSE
                    SIGNAL SQLSTATE '45000'
                    SET MESSAGE_TEXT = 'Erreur : Le covoiturage n''existe pas.';
        		END IF;
            ELSE
                SIGNAL SQLSTATE '45000'
                SET MESSAGE_TEXT = 'Erreur : L''enseignant de filière n''existe pas.';
        	END IF;
        ELSE	
        	SIGNAL SQLSTATE '45000'
        	SET MESSAGE_TEXT = 'Erreur : L''enseignant responsable n''existe pas.';
        END IF;	
    ELSE
        SIGNAL SQLSTATE '45000'
   		SET MESSAGE_TEXT = 'Erreur : L''enseignant n''existe pas.';
    END IF;
END$$
DELIMITER ;


-- PROCÉDURE ajouterSondage
DELIMITER $$
DROP PROCEDURE IF EXISTS ajouterSondage$$
CREATE PROCEDURE `ajouterSondage`(IN `p_description` VARCHAR(255), IN `p_nom` VARCHAR(50), IN `p_numEnseignant` INT, IN `p_type` ENUM('unique','multiple'))
BEGIN    
	IF fn_enseignantExiste(p_numEnseignant) THEN
		INSERT INTO AG_Sondage (descriptionSondage, nomSondage, numEnseignant, typeSondage) VALUES (p_description, p_nom, p_numEnseignant, p_type);
    ELSE
    	SIGNAL SQLSTATE '45000'
    	SET MESSAGE_TEXT = 'Erreur : Le sondage renseigné n''existe pas dans la base.';
    END IF;
END$$
DELIMITER ;


-- PROCÉDURE modifierContrainte
DELIMITER $$
DROP PROCEDURE IF EXISTS modifierContrainte$$
CREATE PROCEDURE `modifierContrainte`(IN `p_num` INT(11), IN `p_nom` VARCHAR(50), IN `p_type` VARCHAR(50), IN `p_valeur` INT(11))
BEGIN
    IF fn_contrainteExiste(p_num) THEN
    	UPDATE AG_Contrainte SET nomContrainte=p_nom, typeContrainte=p_type, valeurContrainte=p_valeur WHERE numContrainte=p_num;
    ELSE
    	SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Erreur : La contrainte n''existe pas dans la base.';
    END IF;
END$$
DELIMITER ;


-- PROCÉDURE modifierEtudiant
DELIMITER $$
DROP PROCEDURE IF EXISTS modifierEtudiant$$
CREATE PROCEDURE `modifierEtudiant`(
    IN p_num INT(11),
    IN p_nom VARCHAR(30),
    IN p_prenom VARCHAR(30),
    IN p_dateNaissance DATE,
    IN p_addr VARCHAR(100),
    IN p_telephone VARCHAR(20),
    IN p_genre ENUM('M','F','A'),
    IN p_mail VARCHAR(50),
    IN p_typeBac ENUM('General','Techno'),
    IN p_parcours ENUM('A','B','C'),
    IN p_OptionAnglais BOOLEAN,
    IN p_redoublement ENUM('BUT-1','BUT-2','BUT-3'),
    IN p_numEnseignantResponsable INT(11),
    IN p_numEnseignantFiliere INT(11),
    IN p_numCovoiturage INT(11),
    IN p_numPromotion INT(11),
    IN p_numGroupe INT(11),
    IN p_numEnseignant INT(11))
BEGIN
	IF fn_etudiantExiste(p_num) THEN
        IF fn_enseignantExiste(p_numEnseignant) THEN
            IF fn_estResponsable(p_numEnseignantResponsable) THEN
                IF fn_estResponsableFiliere(p_numEnseignantFiliere) THEN
                    IF fn_covoiturageExiste(p_numCovoiturage) THEN
                        IF fn_promotionExiste(p_numPromotion) THEN
                            IF fn_groupeExiste(p_numGroupe) THEN
                                UPDATE AG_Etudiant SET nomEtudiant=p_nom, prenomEtudiant=p_prenom, dateNaissanceEtudiant=p_dateNaissance,
                                adresseEtudiant=p_addr, telephoneEtudiant=p_telephone, genreEtudiant=p_genre, emailEtudiant=p_mail, 
                                typeBacEtudiant=p_typeBac, parcoursEtudiant=p_parcours, optionAnglaisEtudiant=p_OptionAnglais, 
                                periodeRedoublementEtudiant=p_redoublement, numEnseignantResponsable=p_numEnseignantResponsable, 
                                numEnseignantFiliere=p_numEnseignantFiliere,numCovoiturage=p_numCovoiturage,numPromotion=p_numPromotion, 
                                numGroupe=p_numGroupe
                                WHERE numEtudiant = p_num;
                            ELSE
                                SIGNAL SQLSTATE '45000'
                                SET MESSAGE_TEXT = 'Erreur : Le groupe n''existe pas.';
                            END IF;
                        ELSE
                            SIGNAL SQLSTATE '45000'
                            SET MESSAGE_TEXT = 'Erreur : La promotion n''existe pas.';
                        END IF;
                    ELSE
                        SIGNAL SQLSTATE '45000'
                        SET MESSAGE_TEXT = 'Erreur : Le covoiturage n''existe pas.';
                    END IF;
                ELSE
                    SIGNAL SQLSTATE '45000'
                    SET MESSAGE_TEXT = 'Erreur : L''enseignant de filière n''existe pas.';
                END IF;
            ELSE	
                SIGNAL SQLSTATE '45000'
                SET MESSAGE_TEXT = 'Erreur : L''enseignant responsable n''existe pas.';
            END IF;	
        ELSE
            SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Erreur : L''enseignant n''existe pas.';
        END IF;
    ELSE
    	SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Erreur : L''etudiant n''existe pas.';
    END IF;
END$$
DELIMITER ;


-- PROCÉDURE modifierSondage
DELIMITER $$
DROP PROCEDURE IF EXISTS modifierSondage$$
CREATE PROCEDURE `modifierSondage`(
    IN p_num INT(11),
    IN p_description VARCHAR(255),
    IN p_nom VARCHAR(50),
    IN p_numEnseignant INT,
    IN p_type ENUM('unique','multiple')
)
BEGIN    
	IF fn_sondageexiste(p_num) THEN 
    	IF fn_enseignantExiste(p_numEnseignant) THEN
			UPDATE AG_Sondage SET descriptionSondage=p_description, nomSondage=p_nom, numEnseignant=p_numEnseignant, typeSondage=p_type
            WHERE numSondage=p_num;
        ELSE
        	SIGNAL SQLSTATE '45001'
            SET MESSAGE_TEXT = 'Erreur : L''enseignant renseigne n''existe pas dans la base.';
        END IF;
    ELSE
    	SIGNAL SQLSTATE '45000'
    	SET MESSAGE_TEXT = 'Erreur : Le sondage renseigné n''existe pas dans la base.';
    END IF;
END$$
DELIMITER ;


-- PROCÉDURE supprimerContrainte
DELIMITER $$
DROP PROCEDURE IF EXISTS supprimerContrainte$$
CREATE PROCEDURE `supprimerContrainte`(
    IN p_num int(11)
)
BEGIN
	IF fn_contrainteExiste(p_num) THEN
    	DELETE FROM AG_possede WHERE p_num = NumContrainte;
    	DELETE FROM AG_Contrainte WHERE p_num = NumContrainte;
    ELSE
    	SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Erreur : La contrainte n''existe pas.';
    END IF;
END$$
DELIMITER ;


-- PROCÉDURE supprimerEtudiant
DELIMITER $$
DROP PROCEDURE IF EXISTS supprimerEtudiant$$
CREATE PROCEDURE `supprimerEtudiant`(IN `p_num` INT)
BEGIN
    IF not fn_etudiantExiste(p_num) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Erreur : L''etudiant renseigné n''existe pas dans la base.';
    ELSE
        DELETE FROM AG_Note WHERE numEtudiant = p_num;
        DELETE FROM AG_Etudiant WHERE NumEtudiant = p_num;
    END IF;
END$$
DELIMITER ;


-- PROCÉDURE supprimerSondage
DELIMITER $$
DROP PROCEDURE IF EXISTS supprimerSondage$$
CREATE PROCEDURE `supprimerSondage`(
    IN p_num INT(11))
BEGIN
	IF NOT fn_sondageExiste(p_num) THEN
		DELETE FROM AG_Sondage WHERE p_num = numSondage;
    ELSE
    	SIGNAL SQLSTATE '45000'
    	SET MESSAGE_TEXT = 'Erreur : Le sondage renseigné n''existe pas dans la base.';
    END IF;
END$$
DELIMITER ;


-- PROCÉDURE affecterRoleEnseignantResponsableFormation
DELIMITER $$
DROP PROCEDURE IF EXISTS affecterRoleEnseignantResponsableFormation$$
CREATE PROCEDURE `affecterRoleEnseignantResponsableFormation`(
    IN p_num INT(11),
    IN p_dateDebut DATE,
    IN p_dateFin DATE
)
BEGIN
    IF NOT fn_enseignantExiste(p_num) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Erreur : L''enseignant n''existe pas dans la base.';
    ELSEIF NOT fn_estResponsable(p_num) THEN
            INSERT INTO AG_EnseignantResponsableFormation (DateDebutFormation, DateFinFormation)
            VALUES (p_dateDebut, p_dateFin);  
    END IF;
END$$
DELIMITER ;


-- PROCÉDURE SupprimerRoleEnseignantResponsableFormation
DELIMITER $$
DROP PROCEDURE IF EXISTS SupprimerRoleEnseignantResponsableFormation$$
CREATE PROCEDURE `SupprimerRoleEnseignantResponsableFormation`(
    IN p_num INT(11)
)
BEGIN
    IF NOT fn_estResponsableFormation(p_num) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Erreur : L''enseignant n''existe pas dans la base.';
    ELSE
    	DELETE FROM AG_EnseignantResponsableFormation WHERE numEnseignant = p_num;
    END IF;
END$$
DELIMITER ;


-- PROCÉDURE ModifierInfoEnseignantResponsableFormation
DELIMITER $$
DROP PROCEDURE IF EXISTS ModifierInfoEnseignantResponsableFormation$$
CREATE PROCEDURE `ModifierInfoEnseignantResponsableFormation`(
    IN p_num INT(11),
    IN p_dateDebut DATE,
    IN p_dateFin DATE
)
BEGIN
    IF NOT fn_estResponsableFormation(p_num) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Erreur : L''enseignant n''existe pas dans la base.';
    ELSE
    	UPDATE AG_EnseignantResponsableFormation SET dateDebutFormation=p_dateDebut, dateFinFormation=p_dateFin
        WHERE numEnseignant = p_num;
    END IF;
END$$
DELIMITER ;


-- PROCÉDURE ajouterNote
DROP PROCEDURE IF EXISTS ajouterNote;
DELIMITER $$
CREATE PROCEDURE ajouterNote(p_nom_note VARCHAR(50), p_num_etudiant INT, p_valeur_note VARCHAR(50))
BEGIN
    IF fn_etudiantExiste(p_num_etudiant) THEN
    	IF CAST(p_valeur_note AS DECIMAL(4, 2)) >= 0 AND CAST(p_valeur_note AS DECIMAL(4, 2)) <= 20 THEN
        	INSERT INTO AG_Note (nomNote, numEtudiant, valeurNote) VALUES (p_nom_note, p_num_etudiant, p_valeur_note);
        ELSE
        	SIGNAL SQLSTATE '45001'
        	SET MESSAGE_TEXT = 'Erreur : La note n''est pas comprise entre 0 et 20.';
        END IF;
    ELSE
		SIGNAL SQLSTATE '45002'
       	SET MESSAGE_TEXT = 'Erreur : L''etudiant selectione n''existe pas dans la base de donnée.';
    END IF;
END$$
DELIMITER ;


-- PROCÉDURE modifierNote
DROP PROCEDURE IF EXISTS modifierNote;
DELIMITER $$
CREATE PROCEDURE modifierNote(p_num_Note INT, p_nom_note VARCHAR(50), p_num_etudiant INT, p_valeur_note VARCHAR(50))
BEGIN
    IF fn_etudiantExiste(p_num_etudiant) AND fn_noteExiste(p_num_note) THEN
    	IF CAST(p_valeur_note AS DECIMAL(4, 2)) >= 0 AND CAST(p_valeur_note AS DECIMAL(4, 2)) <= 20 THEN
        	UPDATE AG_Note SET nomNote = p_nom_note, numEtudiant = p_num_etudiant, valeurNote = p_valeur_note WHERE numNote = p_num;
        ELSE
        	SIGNAL SQLSTATE '45001'
        	SET MESSAGE_TEXT = 'Erreur : La note n''est pas comprise entre 0 et 20.';
        END IF;
    ELSE
		SIGNAL SQLSTATE '45002'
       	SET MESSAGE_TEXT = 'Erreur : L''etudiant ou la note selectione n''existe pas dans la base de donnée.';
    END IF;
END$$
DELIMITER ;


-- PROCÉDURE ajouterEnseignant
DROP PROCEDURE IF EXISTS ajouterEnseignant;
DELIMITER $$
CREATE PROCEDURE ajouterEnseignant(p_nom_enseignant VARCHAR(50), p_adresse_enseignant VARCHAR(50), p_date_naissance_enseignant date, p_email_enseignant VARCHAR(50), p_num_utilisateur int(11), p_prenom_enseignant VARCHAR(50), p_telephone_enseignant VARCHAR(50))
BEGIN
    IF fn_utilisateurExiste(p_num_utilisateur) THEN
        INSERT INTO AG_Enseignant (adresseEnseignant, dateNaissanceEnseignant, emailenseignant, nomEnseignant, numUtilisateur, prenomEnseignant, telephoneEnseignant) VALUES (p_adresse_enseignant, p_date_naissance_enseignant, p_email_enseignant, p_nom_enseignant, p_num_utilisateur, p_prenom_enseignant, p_telephone_enseignant);
    ELSE
		SIGNAL SQLSTATE '45002'
       	SET MESSAGE_TEXT = 'Erreur : L''utilisateur selectione n''existe pas dans la base de donnée.';
    END IF;
END$$
DELIMITER ;


-- PROCÉDURE modifierEnseignant
DROP PROCEDURE IF EXISTS modifierEnseignant;
DELIMITER $$
CREATE PROCEDURE modifierEnseignant(p_num_enseignant int(11), p_nom_enseignant VARCHAR(50), p_adresse_enseignant VARCHAR(50), p_date_naissance_enseignant date, p_email_enseignant VARCHAR(50), p_num_utilisateur int(11), p_prenom_enseignant VARCHAR(50), p_telephone_enseignant VARCHAR(50))
BEGIN
    IF fn_utilisateurExiste(p_num_utilisateur) AND fn_enseignantExiste(p_num_enseignant) THEN
        UPDATE AG_Enseignant SET adresseEnseignant=p_adresse_enseignant, dateNaissanceEnseignant=p_date_naissance_enseignant, emailenseignant=p_email_enseignant, nomEnseignant=p_nom_enseignant, numUtilisateur=p_num_utilisateur, prenomEnseignant=p_prenom_enseignant, telephoneEnseignant=p_telephone_enseignant WHERE p_num_enseignant=numEnseignant;
    ELSE
		SIGNAL SQLSTATE '45002'
       	SET MESSAGE_TEXT = 'Erreur : L''utilisateur ou l''enseignant selectione n''existe pas dans la base de donnée.';
    END IF;
END$$
DELIMITER ;


-- PROCÉDURE supprimerEnseignant
DROP PROCEDURE IF EXISTS supprimerEnseignant;
DELIMITER $$
CREATE PROCEDURE supprimerEnseignant(p_num_enseignant int(11))
BEGIN
    IF fn_enseignantExiste(p_num_enseignant) THEN
        DELETE FROM AG_Enseignant WHERE p_num_enseignant=numEnseignant;
    ELSE
		SIGNAL SQLSTATE '45002'
       	SET MESSAGE_TEXT = 'Erreur : L''enseignant selectione n''existe pas dans la base de donnée.';
    END IF;
END$$
DELIMITER ;


-- PROCÉDURE supprimercovoiturage
DROP PROCEDURE IF EXISTS supprimercovoiturage;
DELIMITER $$
CREATE PROCEDURE supprimercovoiturage(p_num_covoiturage int(11))
BEGIN
    IF fn_covoiturageExiste(p_num_covoiturage) THEN
        DELETE FROM AG_Covoiturage WHERE p_num_covoiturage=numCovoiturage;
    ELSE
		SIGNAL SQLSTATE '45002'
       	SET MESSAGE_TEXT = 'Erreur : Le covoiturage selectione n''existe pas dans la base de donnée.';
    END IF;
END$$
DELIMITER ;


-- PROCÉDURE ajouterCovoiturage
DROP PROCEDURE IF EXISTS ajouterCovoiturage;
DELIMITER $$
CREATE PROCEDURE ajouterCovoiturage()
BEGIN
    INSERT INTO AG_Covoiturage () VALUES ();
END$$
DELIMITER ;


-- PROCÉDURE affecterCovoiturageEtudiant
DROP PROCEDURE IF EXISTS affecterCovoiturageEtudiant;
DELIMITER $$
CREATE PROCEDURE affecterCovoiturageEtudiant(p_num_covoiturage int(11), p_num_etudiant int(11))
BEGIN    
    IF fn_etudiantExiste(p_num_etudiant) THEN
      	IF fn_covoiturageExiste(p_num_covoiturage) THEN
        	IF NOT fn_covoiturageEstPlein(p_num_covoiturage) THEN
				UPDATE AG_Etudiant SET numCovoiturage=p_num_covoiturage WHERE numEtudiant=p_num_etudiant;
			ELSE
            	SIGNAL SQLSTATE '45002'
                SET MESSAGE_TEXT = 'Erreur : Le covoiturage selectione est plein.';
           	END IF;
		ELSE
        	SIGNAL SQLSTATE '45001'
			SET MESSAGE_TEXT = 'Erreur : Le covoiturage selectione n''existe pas dans la base de donnée.';
		END IF;
	ELSE
    	SIGNAL SQLSTATE '45003'
		SET MESSAGE_TEXT = 'Erreur : L''etudiant selectione n''existe pas dans la base de donnée.';
    END IF;
END$$
DELIMITER ;


-- PROCÉDURE affecterGroupeEtudiant
DROP PROCEDURE IF EXISTS affecterGroupeEtudiant;
DELIMITER $$
CREATE PROCEDURE affecterGroupeEtudiant(p_num_groupe int(11), p_num_etudiant int(11))
BEGIN
    IF fn_etudiantExiste(p_num_etudiant) THEN
		IF fn_groupeExiste(p_num_groupe) THEN
        	IF not fn_groupeEstPlein(p_num_groupe) THEN
            	UPDATE AG_Etudiant SET numGroupe=p_num_groupe WHERE numEtudiant=p_num_etudiant;
			ELSE
		        SIGNAL SQLSTATE '45002'
        		SET MESSAGE_TEXT = 'Erreur : Le groupe selectione est plein.';
			END IF;
		ELSE
        	SIGNAL SQLSTATE '45001'
            SET MESSAGE_TEXT = 'Erreur : Le groupe selectione n''existe pas dans la base de donnée.';
		END IF;    
	ELSE
    	SIGNAL SQLSTATE '45003'
		SET MESSAGE_TEXT = 'Erreur : L''etudiant selectionne n''existe pas dans la base de donnée.';
    END IF;
END$$
DELIMITER ;


-- PROCÉDURE affecterPromotionEtudiant
DROP PROCEDURE IF EXISTS affecterPromotionEtudiant;
DELIMITER $$
CREATE PROCEDURE affecterPromotionEtudiant(p_num_etudiant int(11), p_num_promotion int(11))
BEGIN
    IF fn_etudiantExiste(p_num_etudiant) THEN
		IF fn_promotionExiste(p_num_promotion) THEN
				UPDATE AG_Etudiant SET numPromotion=p_num_promotion WHERE numEtudiant = p_num_etudiant;
		ELSE
        	SIGNAL SQLSTATE '45002'
            SET MESSAGE_TEXT = 'Erreur : La promotion selectione n''existe pas dans la base de donnée.';
        END IF;
	ELSE
    	SIGNAL SQLSTATE '45001'
        SET MESSAGE_TEXT = 'Erreur : L''etudiant selectione n''existe pas dans la base de donnée.';
	END IF;    
END$$
DELIMITER ;
