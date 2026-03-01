
-- =========================================
-- 1. FONCTIONS
-- =========================================


-- FONCTION fn_etudiantExiste
DELIMITER $$

DROP FUNCTION IF EXISTS fn_etudiantExiste$$

CREATE FUNCTION fn_etudiantExiste(p_num INT) 
RETURNS BOOLEAN
DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE v_existe INT DEFAULT 0;

    SELECT COUNT(*) INTO v_existe
    FROM AG_Etudiant
    WHERE numEtudiant = p_num;

    RETURN (v_existe > 0);
END$$

DELIMITER ;


-- FONCTION fn_enseignantExiste
DELIMITER $$

DROP FUNCTION IF EXISTS fn_enseignantExiste$$

CREATE FUNCTION fn_enseignantExiste(p_num INT)
RETURNS BOOLEAN
DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE v_existe INT DEFAULT 0;

    SELECT COUNT(*) INTO v_existe
    FROM AG_Enseignant
    WHERE numEnseignant = p_num;

    RETURN (v_existe > 0);
END$$

DELIMITER ;


-- FONCTION fn_groupeExiste
DELIMITER $$

DROP FUNCTION IF EXISTS fn_groupeExiste$$

CREATE FUNCTION fn_groupeExiste(p_num INT) 
RETURNS BOOLEAN
DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE v_existe INT DEFAULT 0;

    SELECT COUNT(*) INTO v_existe
    FROM AG_Groupe
    WHERE numGroupe = p_num;

    RETURN (v_existe > 0);
END$$

DELIMITER ;


-- FONCTION fn_promotionExiste
DELIMITER $$

DROP FUNCTION IF EXISTS fn_promotionExiste$$

CREATE FUNCTION fn_promotionExiste(p_num INT) 
RETURNS BOOLEAN
DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE v_existe INT DEFAULT 0;

    SELECT COUNT(*) INTO v_existe
    FROM AG_Promotion
    WHERE numPromotion = p_num;

    RETURN (v_existe > 0);
END$$

DELIMITER ;


-- FONCTION fn_covoiturageExiste
DELIMITER $$

DROP FUNCTION IF EXISTS fn_covoiturageExiste$$

CREATE FUNCTION fn_covoiturageExiste(p_num INT) 
RETURNS BOOLEAN
DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE v_existe INT DEFAULT 0;

    SELECT COUNT(*) INTO v_existe
    FROM AG_Covoiturage
    WHERE numCovoiturage = p_num;

    RETURN (v_existe > 0);
END$$

DELIMITER ;


-- FONCTION fn_sondageExiste
DELIMITER $$

DROP FUNCTION IF EXISTS fn_sondageExiste$$

CREATE FUNCTION fn_sondageExiste(p_num INT) 
RETURNS BOOLEAN
DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE v_existe INT DEFAULT 0;

    SELECT COUNT(*) INTO v_existe
    FROM AG_Sondage
    WHERE numSondage = p_num;

    RETURN (v_existe > 0);
END$$

DELIMITER ;


-- FONCTION fn_utilisateurExiste
DELIMITER $$

DROP FUNCTION IF EXISTS fn_utilisateurExiste$$

CREATE FUNCTION fn_utilisateurExiste(p_num INT) 
RETURNS BOOLEAN
DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE v_existe INT DEFAULT 0;

    SELECT COUNT(*) INTO v_existe
    FROM AG_Utilisateur
    WHERE numUtilisateur = p_num;

    RETURN (v_existe > 0);
END$$

DELIMITER ;


-- FONCTION fn_estResponsableFormation
DELIMITER $$

DROP FUNCTION IF EXISTS fn_estResponsableFormation$$

CREATE FUNCTION fn_estResponsableFormation(p_num INT) 
RETURNS BOOLEAN
DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE v_existe INT DEFAULT 0;

    SELECT COUNT(*) INTO v_existe
    FROM AG_EnseignantResponsableFormation
    WHERE numEnseignant = p_num;

    RETURN (v_existe > 0);
END$$

DELIMITER ;


-- FONCTION fn_estResponsableSemestre
DELIMITER $$

DROP FUNCTION IF EXISTS fn_estResponsableSemestre$$

CREATE FUNCTION fn_estResponsableSemestre(p_num INT) 
RETURNS BOOLEAN
DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE v_existe INT DEFAULT 0;

    SELECT COUNT(*) INTO v_existe
    FROM AG_EnseignantResponsableSemestre
    WHERE numEnseignant = p_num;

    RETURN (v_existe > 0);
END$$

DELIMITER ;


-- FONCTION fn_estResponsableAnnee
DELIMITER $$

DROP FUNCTION IF EXISTS fn_estResponsableAnnee$$

CREATE FUNCTION fn_estResponsableAnnee(p_num INT) 
RETURNS BOOLEAN
DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE v_existe INT DEFAULT 0;

    SELECT COUNT(*) INTO v_existe
    FROM AG_EnseignantResponsableAnnée
    WHERE numEnseignant = p_num;

    RETURN (v_existe > 0);
END$$

DELIMITER ;


-- FONCTION fn_estResponsableFiliere
DELIMITER $$

DROP FUNCTION IF EXISTS fn_estResponsableFiliere$$

CREATE FUNCTION fn_estResponsableFiliere(p_num INT) 
RETURNS BOOLEAN
DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE v_existe INT DEFAULT 0;

    SELECT COUNT(*) INTO v_existe
    FROM AG_EnseignantResponsableFilière
    WHERE numEnseignant = p_num;

    RETURN (v_existe > 0);
END$$

DELIMITER ;


-- FONCTION fn_getNbEtudiantsDansGroupe
DELIMITER $$

DROP FUNCTION IF EXISTS fn_getNbEtudiantsDansGroupe$$

CREATE FUNCTION fn_getNbEtudiantsDansGroupe(p_num INT) 
RETURNS INT
DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE v_nb_etudiant INT DEFAULT 0;

    SELECT COUNT(*) INTO v_nb_etudiant
    FROM AG_Etudiant
    WHERE numGroupe = p_num;

    RETURN v_nb_etudiant;
END$$

DELIMITER ;


-- FONCTION fn_groupeEstPlein
DELIMITER $$

DROP FUNCTION IF EXISTS fn_groupeEstPlein$$

CREATE FUNCTION fn_groupeEstPlein(p_num INT) 
RETURNS BOOLEAN
DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE v_nb_etudiant INT DEFAULT 0;

    SELECT COUNT(*) INTO v_nb_etudiant
    FROM AG_Etudiant
    WHERE numGroupe = p_num;

    RETURN (v_nb_etudiant >= 18);
END$$

DELIMITER ;


-- FONCTION fn_covoiturageEstPlein
DELIMITER $$

DROP FUNCTION IF EXISTS fn_covoiturageEstPlein$$

CREATE FUNCTION fn_covoiturageEstPlein(p_num INT) 
RETURNS BOOLEAN
DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE v_nb_etudiant INT DEFAULT 0;

    SELECT COUNT(*) INTO v_nb_etudiant
    FROM AG_Etudiant
    WHERE numCovoiturage = p_num;

    RETURN (v_nb_etudiant >= 3);
END$$

DELIMITER ;


-- FONCTION fn_contrainteExiste
DELIMITER $$

DROP FUNCTION IF EXISTS fn_contrainteExiste$$

CREATE FUNCTION fn_contrainteExiste(`p_nom` VARCHAR(50), `p_type` VARCHAR(50), `p_valeur` INT(11)) 
RETURNS BOOLEAN
DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE v_existe INT DEFAULT 0;

    SELECT COUNT(*)
    INTO v_existe
    FROM AG_Contrainte C
    WHERE C.NomContrainte = p_nom AND C.TypeContrainte = p_type AND C.ValeurContrainte = p_valeur;

    RETURN (v_existe > 0);
END$$

DELIMITER ;


-- FONCTION fn_estResponsable
DELIMITER $$

DROP FUNCTION IF EXISTS fn_estResponsable$$

CREATE FUNCTION fn_estResponsable(p_num INT) 
RETURNS BOOLEAN
DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE v_existe INT DEFAULT 0;

    SELECT COUNT(*) INTO v_existe
    FROM AG_EnseignantResponsable
    WHERE numEnseignant = p_num;

    RETURN (v_existe > 0);
END$$

DELIMITER ;


-- FONCTION fn_noteExiste
DELIMITER $$

DROP FUNCTION IF EXISTS fn_noteExiste$$

CREATE FUNCTION fn_noteExiste(p_num INT(11)) 
RETURNS BOOLEAN
DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE v_existe INT DEFAULT 0;

    SELECT COUNT(*)
    INTO v_existe
    FROM AG_Note
    WHERE numNote = p_num;
    
    RETURN (v_existe > 0);
END$$

DELIMITER ;