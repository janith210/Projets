DELIMITER $$

-- =========================================
-- AG_Utilisateur
-- =========================================
DROP TRIGGER IF EXISTS tr_utilisateur_insert$$
CREATE TRIGGER tr_utilisateur_insert
BEFORE INSERT ON AG_Utilisateur
FOR EACH ROW
BEGIN

    IF fn_utilisateurExiste(NEW.NumUtilisateur) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Action annulée : Cet utilisateur existe déjà dans la table AG_Utilisateur.';
    END IF;
END$$

DROP TRIGGER IF EXISTS tr_utilisateur_update$$
CREATE TRIGGER tr_utilisateur_update
BEFORE UPDATE ON AG_Utilisateur
FOR EACH ROW
BEGIN

    IF NEW.NumUtilisateur != OLD.NumUtilisateur AND fn_utilisateurExiste(NEW.NumUtilisateur) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Action annulée : Cet utilisateur existe déjà dans la table AG_Utilisateur.';
    END IF;
END$$

-- =========================================
-- AG_Enseignant
-- =========================================
DROP TRIGGER IF EXISTS tr_enseignant_insert$$
CREATE TRIGGER tr_enseignant_insert
BEFORE INSERT ON AG_Enseignant
FOR EACH ROW
BEGIN

    IF fn_enseignantExiste(NEW.NumEnseignant) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Action annulée : Cet enseignant existe déjà dans la table AG_Enseignant.';
    END IF;

    IF NOT fn_utilisateurExiste(NEW.NumUtilisateur) THEN
        SIGNAL SQLSTATE '45001'
        SET MESSAGE_TEXT = 'Action annulée : L''utilisateur lié n''existe pas dans la table AG_Utilisateur.';
    END IF;
END$$

DROP TRIGGER IF EXISTS tr_enseignant_update$$
CREATE TRIGGER tr_enseignant_update
BEFORE UPDATE ON AG_Enseignant
FOR EACH ROW
BEGIN
    IF NEW.NumEnseignant != OLD.NumEnseignant AND fn_enseignantExiste(NEW.NumEnseignant) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Action annulée : Cet enseignant existe déjà dans la table AG_Enseignant.';
    END IF;

    IF NOT fn_utilisateurExiste(NEW.NumUtilisateur) THEN
        SIGNAL SQLSTATE '45001'
        SET MESSAGE_TEXT = 'Action annulée : L''utilisateur lié n''existe pas dans la table AG_Utilisateur.';
    END IF;
END$$

-- =========================================
-- AG_Promotion
-- =========================================
DROP TRIGGER IF EXISTS tr_promotion_insert$$
CREATE TRIGGER tr_promotion_insert
BEFORE INSERT ON AG_Promotion
FOR EACH ROW
BEGIN

    IF fn_promotionExiste(NEW.NumPromotion) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Action annulée : Cette promotion existe déjà dans la table AG_Promotion.';
    END IF;
END$$

DROP TRIGGER IF EXISTS tr_promotion_update$$
CREATE TRIGGER tr_promotion_update
BEFORE UPDATE ON AG_Promotion
FOR EACH ROW
BEGIN
    IF NEW.NumPromotion != OLD.NumPromotion AND fn_promotionExiste(NEW.NumPromotion) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Action annulée : Cette promotion existe déjà dans la table AG_Promotion.';
    END IF;
END$$

-- =========================================
-- AG_Covoiturage
-- =========================================
DROP TRIGGER IF EXISTS tr_covoiturage_insert$$
CREATE TRIGGER tr_covoiturage_insert
BEFORE INSERT ON AG_Covoiturage
FOR EACH ROW
BEGIN

    IF fn_covoiturageExiste(NEW.NumCovoiturage) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Action annulée : Ce covoiturage existe déjà dans la table AG_Covoiturage.';
    END IF;
END$$

DROP TRIGGER IF EXISTS tr_covoiturage_update$$
CREATE TRIGGER tr_covoiturage_update
BEFORE UPDATE ON AG_Covoiturage
FOR EACH ROW
BEGIN
    IF NEW.NumCovoiturage != OLD.NumCovoiturage AND fn_covoiturageExiste(NEW.NumCovoiturage) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Action annulée : Ce covoiturage existe déjà dans la table AG_Covoiturage.';
    END IF;
END$$

-- =========================================
-- AG_EnseignantResponsable
-- =========================================
DROP TRIGGER IF EXISTS tr_ensResp_insert$$
CREATE TRIGGER tr_ensResp_insert
BEFORE INSERT ON AG_EnseignantResponsable
FOR EACH ROW
BEGIN

    IF fn_estResponsable(NEW.NumEnseignant) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Action annulée : Cet enseignant responsable existe déjà dans la table AG_EnseignantResponsable.';
    END IF;

    IF NOT fn_enseignantExiste(NEW.NumEnseignant) THEN
        SIGNAL SQLSTATE '45001'
        SET MESSAGE_TEXT = 'Action annulée : L''enseignant de base n''existe pas dans la table AG_Enseignant.';
    END IF;
END$$

DROP TRIGGER IF EXISTS tr_ensResp_update$$
CREATE TRIGGER tr_ensResp_update
BEFORE UPDATE ON AG_EnseignantResponsable
FOR EACH ROW
BEGIN
    IF NEW.NumEnseignant != OLD.NumEnseignant AND fn_estResponsable(NEW.NumEnseignant) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Action annulée : Cet enseignant responsable existe déjà dans la table AG_EnseignantResponsable.';
    END IF;

    IF NOT fn_enseignantExiste(NEW.NumEnseignant) THEN
        SIGNAL SQLSTATE '45001'
        SET MESSAGE_TEXT = 'Action annulée : L''enseignant de base n''existe pas dans la table AG_Enseignant.';
    END IF;
END$$

-- =========================================
-- AG_EnseignantResponsableFormation
-- =========================================
DROP TRIGGER IF EXISTS tr_ensRespForm_insert$$
CREATE TRIGGER tr_ensRespForm_insert
BEFORE INSERT ON AG_EnseignantResponsableFormation
FOR EACH ROW
BEGIN

    IF fn_estResponsableFormation(NEW.NumEnseignant) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Action annulée : Ce responsable de formation existe déjà dans la table AG_EnseignantResponsableFormation.';
    END IF;

    IF NOT fn_enseignantExiste(NEW.NumEnseignant) THEN
        SIGNAL SQLSTATE '45001'
        SET MESSAGE_TEXT = 'Action annulée : L''enseignant de base n''existe pas dans la table AG_Enseignant.';
    END IF;
END$$

DROP TRIGGER IF EXISTS tr_ensRespForm_update$$
CREATE TRIGGER tr_ensRespForm_update
BEFORE UPDATE ON AG_EnseignantResponsableFormation
FOR EACH ROW
BEGIN
    IF NEW.NumEnseignant != OLD.NumEnseignant AND fn_estResponsableFormation(NEW.NumEnseignant) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Action annulée : Ce responsable de formation existe déjà dans la table AG_EnseignantResponsableFormation.';
    END IF;

    IF NOT fn_enseignantExiste(NEW.NumEnseignant) THEN
        SIGNAL SQLSTATE '45001'
        SET MESSAGE_TEXT = 'Action annulée : L''enseignant de base n''existe pas dans la table AG_Enseignant.';
    END IF;
END$$

-- =========================================
-- AG_EnseignantResponsableFilière
-- =========================================
DROP TRIGGER IF EXISTS tr_ensRespFil_insert$$
CREATE TRIGGER tr_ensRespFil_insert
BEFORE INSERT ON AG_EnseignantResponsableFilière
FOR EACH ROW
BEGIN

    IF fn_estResponsableFiliere(NEW.NumEnseignant) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Action annulée : Ce responsable de filière existe déjà dans la table AG_EnseignantResponsableFilière.';
    END IF;

    IF NOT fn_estResponsable(NEW.NumEnseignant) THEN
        SIGNAL SQLSTATE '45001'
        SET MESSAGE_TEXT = 'Action annulée : L''enseignant responsablen''existe pas dans la table AG_EnseignantResponsable.';
    END IF;
END$$

DROP TRIGGER IF EXISTS tr_ensRespFil_update$$
CREATE TRIGGER tr_ensRespFil_update
BEFORE UPDATE ON AG_EnseignantResponsableFilière
FOR EACH ROW
BEGIN
    IF NEW.NumEnseignant != OLD.NumEnseignant AND fn_estResponsableFiliere(NEW.NumEnseignant) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Action annulée : Ce responsable de filière existe déjà dans la table AG_EnseignantResponsableFilière.';
    END IF;

    IF NOT fn_estResponsable(NEW.NumEnseignant) THEN
        SIGNAL SQLSTATE '45001'
        SET MESSAGE_TEXT = 'Action annulée : L''enseignant responsable n''existe pas dans la table AG_EnseignantResponsable.';
    END IF;
END$$

-- =========================================
-- AG_EnseignantResponsableAnnée
-- =========================================
DROP TRIGGER IF EXISTS tr_ensRespAnn_insert$$
CREATE TRIGGER tr_ensRespAnn_insert
BEFORE INSERT ON AG_EnseignantResponsableAnnée
FOR EACH ROW
BEGIN

    IF fn_estResponsableAnnee(NEW.NumEnseignant) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Action annulée : Ce responsable d''année existe déjà dans la table AG_EnseignantResponsableAnnée.';
    END IF;

    IF NOT fn_estResponsable(NEW.NumEnseignant) THEN
        SIGNAL SQLSTATE '45001'
        SET MESSAGE_TEXT = 'Action annulée : L''enseignant responsable n''existe pas dans la table AG_EnseignantResponsable.';
    END IF;
END$$

DROP TRIGGER IF EXISTS tr_ensRespAnn_update$$
CREATE TRIGGER tr_ensRespAnn_update
BEFORE UPDATE ON AG_EnseignantResponsableAnnée
FOR EACH ROW
BEGIN
    IF NEW.NumEnseignant != OLD.NumEnseignant AND fn_estResponsableAnnee(NEW.NumEnseignant) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Action annulée : Ce responsable d''année existe déjà dans la table AG_EnseignantResponsableAnnée.';
    END IF;

    IF NOT fn_estResponsable(NEW.NumEnseignant) THEN
        SIGNAL SQLSTATE '45001'
        SET MESSAGE_TEXT = 'Action annulée : L''enseignant responsable n''existe pas dans la table AG_EnseignantResponsable.';
    END IF;
END$$

-- =========================================
-- AG_EnseignantResponsableSemestre
-- =========================================
DROP TRIGGER IF EXISTS tr_ensRespSem_insert$$
CREATE TRIGGER tr_ensRespSem_insert
BEFORE INSERT ON AG_EnseignantResponsableSemestre
FOR EACH ROW
BEGIN

    IF fn_estResponsableSemestre(NEW.NumEnseignant) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Action annulée : Ce responsable de semestre existe déjà dans la table AG_EnseignantResponsableSemestre.';
    END IF;

    IF NOT fn_estResponsable(NEW.NumEnseignant) THEN
        SIGNAL SQLSTATE '45001'
        SET MESSAGE_TEXT = 'Action annulée : L''enseignant responsable n''existe pas dans la table AG_EnseignantResponsable.';
    END IF;
END$$

DROP TRIGGER IF EXISTS tr_ensRespSem_update$$
CREATE TRIGGER tr_ensRespSem_update
BEFORE UPDATE ON AG_EnseignantResponsableSemestre
FOR EACH ROW
BEGIN
    IF NEW.NumEnseignant != OLD.NumEnseignant AND fn_estResponsableSemestre(NEW.NumEnseignant) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Action annulée : Ce responsable de semestre existe déjà dans la table AG_EnseignantResponsableSemestre.';
    END IF;

    IF NOT fn_estResponsable(NEW.NumEnseignant) THEN
        SIGNAL SQLSTATE '45001'
        SET MESSAGE_TEXT = 'Action annulée : L''enseignant responsable n''existe pas dans la table AG_EnseignantResponsable.';
    END IF;
END$$

-- =========================================
-- AG_Groupe
-- =========================================
DROP TRIGGER IF EXISTS tr_groupe_insert$$
CREATE TRIGGER tr_groupe_insert
BEFORE INSERT ON AG_Groupe
FOR EACH ROW
BEGIN

    IF fn_groupeExiste(NEW.NumGroupe) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Action annulée : Ce groupe existe déjà dans la table AG_Groupe.';
    END IF;

    IF NEW.NumEnseignantResponsableAnnee IS NOT NULL AND NOT fn_estResponsableAnnee(NEW.NumEnseignantResponsableAnnee) THEN
        SIGNAL SQLSTATE '45001'
        SET MESSAGE_TEXT = 'Action annulée : Le responsable d''année n''existe pas dans la table AG_EnseignantResponsableAnnée.';
    END IF;

    IF NOT fn_estResponsable(NEW.NumEnseignantResponsable) THEN
        SIGNAL SQLSTATE '45002'
        SET MESSAGE_TEXT = 'Action annulée : L''enseignant responsable n''existe pas dans la table AG_EnseignantResponsable.';
    END IF;
END$$

DROP TRIGGER IF EXISTS tr_groupe_update$$
CREATE TRIGGER tr_groupe_update
BEFORE UPDATE ON AG_Groupe
FOR EACH ROW
BEGIN
    IF NEW.NumGroupe != OLD.NumGroupe AND fn_groupeExiste(NEW.NumGroupe) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Action annulée : Ce groupe existe déjà dans la table AG_Groupe.';
    END IF;

    IF NEW.NumEnseignantResponsableAnnee IS NOT NULL AND NOT fn_estResponsableAnnee(NEW.NumEnseignantResponsableAnnee) THEN
        SIGNAL SQLSTATE '45001'
        SET MESSAGE_TEXT = 'Action annulée : Le responsable d''année n''existe pas dans la table AG_EnseignantResponsableAnnée.';
    END IF;

    IF NOT fn_estResponsable(NEW.NumEnseignantResponsable) THEN
        SIGNAL SQLSTATE '45002'
        SET MESSAGE_TEXT = 'Action annulée : L''enseignant responsable n''existe pas dans la table AG_EnseignantResponsable.';
    END IF;
END$$

-- =========================================
-- AG_Sondage
-- =========================================
DROP TRIGGER IF EXISTS tr_sondage_insert$$
CREATE TRIGGER tr_sondage_insert
BEFORE INSERT ON AG_Sondage
FOR EACH ROW
BEGIN

    IF fn_sondageExiste(NEW.NumSondage) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Action annulée : Ce sondage existe déjà dans la table AG_Sondage.';
    END IF;

    IF NOT fn_estResponsable(NEW.NumEnseignant) THEN
        SIGNAL SQLSTATE '45001'
        SET MESSAGE_TEXT = 'Action annulée : L''enseignant responsable lié au sondage n''existe pas dans la table AG_EnseignantResponsable.';
    END IF;
END$$

DROP TRIGGER IF EXISTS tr_sondage_update$$
CREATE TRIGGER tr_sondage_update
BEFORE UPDATE ON AG_Sondage
FOR EACH ROW
BEGIN
    IF NEW.NumSondage != OLD.NumSondage AND fn_sondageExiste(NEW.NumSondage) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Action annulée : Ce sondage existe déjà dans la table AG_Sondage.';
    END IF;

    IF NOT fn_estResponsable(NEW.NumEnseignant) THEN
        SIGNAL SQLSTATE '45001'
        SET MESSAGE_TEXT = 'Action annulée : L''enseignant responsable lié au sondage n''existe pas dans la table AG_EnseignantResponsable.';
    END IF;
END$$

-- =========================================
-- AG_Contrainte
-- =========================================
DROP TRIGGER IF EXISTS tr_contrainte_insert$$
CREATE TRIGGER tr_contrainte_insert
BEFORE INSERT ON AG_Contrainte
FOR EACH ROW
BEGIN

    DECLARE v_pk_exist INT DEFAULT 0;
    SELECT COUNT(*) INTO v_pk_exist FROM AG_Contrainte WHERE NumContrainte = NEW.NumContrainte;
    
    IF v_pk_exist > 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Action annulée : Cette contrainte existe déjà dans la table AG_Contrainte.';
    END IF;

    IF NOT fn_estResponsable(NEW.NumEnseignant) THEN
        SIGNAL SQLSTATE '45001'
        SET MESSAGE_TEXT = 'Action annulée : L''enseignant responsable lié à la contrainte n''existe pas dans la table AG_EnseignantResponsable.';
    END IF;
END$$

DROP TRIGGER IF EXISTS tr_contrainte_update$$
CREATE TRIGGER tr_contrainte_update
BEFORE UPDATE ON AG_Contrainte
FOR EACH ROW
BEGIN
    DECLARE v_pk_exist INT DEFAULT 0;
    
    IF NEW.NumContrainte != OLD.NumContrainte THEN
        SELECT COUNT(*) INTO v_pk_exist FROM AG_Contrainte WHERE NumContrainte = NEW.NumContrainte;
        IF v_pk_exist > 0 THEN
            SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Action annulée : Cette contrainte existe déjà dans la table AG_Contrainte.';
        END IF;
    END IF;

    IF NOT fn_estResponsable(NEW.NumEnseignant) THEN
        SIGNAL SQLSTATE '45001'
        SET MESSAGE_TEXT = 'Action annulée : L''enseignant responsable lié à la contrainte n''existe pas dans la table AG_EnseignantResponsable.';
    END IF;
END$$

-- =========================================
-- AG_Note
-- =========================================
DROP TRIGGER IF EXISTS tr_note_insert$$
CREATE TRIGGER tr_note_insert
BEFORE INSERT ON AG_Note
FOR EACH ROW
BEGIN

    IF fn_noteExiste(NEW.NumNote) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Action annulée : Cette note existe déjà dans la table AG_Note.';
    END IF;

    IF NOT fn_etudiantExiste(NEW.NumEtudiant) THEN
        SIGNAL SQLSTATE '45001'
        SET MESSAGE_TEXT = 'Action annulée : L''étudiant lié n''existe pas dans la table AG_Etudiant.';
    END IF;
END$$

DROP TRIGGER IF EXISTS tr_note_update$$
CREATE TRIGGER tr_note_update
BEFORE UPDATE ON AG_Note
FOR EACH ROW
BEGIN
    IF NEW.NumNote != OLD.NumNote AND fn_noteExiste(NEW.NumNote) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Action annulée : Cette note existe déjà dans la table AG_Note.';
    END IF;

    IF NOT fn_etudiantExiste(NEW.NumEtudiant) THEN
        SIGNAL SQLSTATE '45001'
        SET MESSAGE_TEXT = 'Action annulée : L''étudiant lié n''existe pas dans la table AG_Etudiant.';
    END IF;
END$$

-- =========================================
-- AG_ReponseSondage
-- =========================================
DROP TRIGGER IF EXISTS tr_reponseSondage_insert$$
CREATE TRIGGER tr_reponseSondage_insert
BEFORE INSERT ON AG_ReponseSondage
FOR EACH ROW
BEGIN

    DECLARE v_pk_exist INT DEFAULT 0;
    SELECT COUNT(*) INTO v_pk_exist FROM AG_ReponseSondage WHERE NumReponseSondage = NEW.NumReponseSondage;
    
    IF v_pk_exist > 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Action annulée : Cette réponse existe déjà dans la table AG_ReponseSondage.';
    END IF;

    IF NEW.NumEnseignant IS NOT NULL AND NOT fn_enseignantExiste(NEW.NumEnseignant) THEN
        SIGNAL SQLSTATE '45001'
        SET MESSAGE_TEXT = 'Action annulée : L''enseignant lié n''existe pas dans la table AG_Enseignant.';
    END IF;

    IF NEW.NumSondage IS NOT NULL AND NOT fn_sondageExiste(NEW.NumSondage) THEN
        SIGNAL SQLSTATE '45002'
        SET MESSAGE_TEXT = 'Action annulée : Le sondage lié n''existe pas dans la table AG_Sondage.';
    END IF;

    IF NEW.NumEtudiant IS NOT NULL AND NOT fn_etudiantExiste(NEW.NumEtudiant) THEN
        SIGNAL SQLSTATE '45003'
        SET MESSAGE_TEXT = 'Action annulée : L''étudiant lié n''existe pas dans la table AG_Etudiant.';
    END IF;
END$$

DROP TRIGGER IF EXISTS tr_reponseSondage_update$$
CREATE TRIGGER tr_reponseSondage_update
BEFORE UPDATE ON AG_ReponseSondage
FOR EACH ROW
BEGIN
    DECLARE v_pk_exist INT DEFAULT 0;

    IF NEW.NumReponseSondage != OLD.NumReponseSondage THEN
        SELECT COUNT(*) INTO v_pk_exist FROM AG_ReponseSondage WHERE NumReponseSondage = NEW.NumReponseSondage;
        IF v_pk_exist > 0 THEN
            SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Action annulée : Cette réponse existe déjà dans la table AG_ReponseSondage.';
        END IF;
    END IF;

    IF NEW.NumEnseignant IS NOT NULL AND NOT fn_enseignantExiste(NEW.NumEnseignant) THEN
        SIGNAL SQLSTATE '45001'
        SET MESSAGE_TEXT = 'Action annulée : L''enseignant lié n''existe pas dans la table AG_Enseignant.';
    END IF;

    IF NEW.NumSondage IS NOT NULL AND NOT fn_sondageExiste(NEW.NumSondage) THEN
        SIGNAL SQLSTATE '45002'
        SET MESSAGE_TEXT = 'Action annulée : Le sondage lié n''existe pas dans la table AG_Sondage.';
    END IF;

    IF NEW.NumEtudiant IS NOT NULL AND NOT fn_etudiantExiste(NEW.NumEtudiant) THEN
        SIGNAL SQLSTATE '45003'
        SET MESSAGE_TEXT = 'Action annulée : L''étudiant lié n''existe pas dans la table AG_Etudiant.';
    END IF;
END$$

-- =========================================
-- AG_possede (Table de liaison)
-- =========================================
DROP TRIGGER IF EXISTS tr_possede_insert$$
CREATE TRIGGER tr_possede_insert
BEFORE INSERT ON AG_possede
FOR EACH ROW
BEGIN

    DECLARE v_pk_exist INT DEFAULT 0;
    SELECT COUNT(*) INTO v_pk_exist FROM AG_possede 
    WHERE NumGroupe = NEW.NumGroupe AND NumContrainte = NEW.NumContrainte;
    
    IF v_pk_exist > 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Action annulée : Cette association Groupe/Contrainte existe déjà dans la table AG_possede.';
    END IF;

    IF NOT fn_groupeExiste(NEW.NumGroupe) THEN
        SIGNAL SQLSTATE '45001'
        SET MESSAGE_TEXT = 'Action annulée : Le groupe n''existe pas dans la table AG_Groupe.';
    END IF;

    IF (SELECT COUNT(*) FROM AG_Contrainte WHERE NumContrainte = NEW.NumContrainte) = 0 THEN
        SIGNAL SQLSTATE '45002'
        SET MESSAGE_TEXT = 'Action annulée : La contrainte n''existe pas dans la table AG_Contrainte.';
    END IF;
END$$

DROP TRIGGER IF EXISTS tr_possede_update$$
CREATE TRIGGER tr_possede_update
BEFORE UPDATE ON AG_possede
FOR EACH ROW
BEGIN
    DECLARE v_pk_exist INT DEFAULT 0;

    IF (NEW.NumGroupe != OLD.NumGroupe OR NEW.NumContrainte != OLD.NumContrainte) THEN
        SELECT COUNT(*) INTO v_pk_exist FROM AG_possede 
        WHERE NumGroupe = NEW.NumGroupe AND NumContrainte = NEW.NumContrainte;
        
        IF v_pk_exist > 0 THEN
            SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Action annulée : Cette association Groupe/Contrainte existe déjà dans la table AG_possede.';
        END IF;
    END IF;

    IF NOT fn_groupeExiste(NEW.NumGroupe) THEN
        SIGNAL SQLSTATE '45001'
        SET MESSAGE_TEXT = 'Action annulée : Le groupe n''existe pas dans la table AG_Groupe.';
    END IF;

    IF (SELECT COUNT(*) FROM AG_Contrainte WHERE NumContrainte = NEW.NumContrainte) = 0 THEN
        SIGNAL SQLSTATE '45002'
        SET MESSAGE_TEXT = 'Action annulée : La contrainte n''existe pas dans la table AG_Contrainte.';
    END IF;
END$$

-- =========================================
-- AG_Etudiant
-- =========================================
DROP TRIGGER IF EXISTS tr_etudiant_insert$$
CREATE TRIGGER tr_etudiant_insert
BEFORE INSERT ON AG_Etudiant
FOR EACH ROW
BEGIN

    IF fn_etudiantExiste(NEW.NumEtudiant) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Action annulée : Cet étudiant existe déjà dans la table AG_Etudiant.';
    END IF;

    IF NOT fn_utilisateurExiste(NEW.NumUtilisateur) THEN
        SIGNAL SQLSTATE '45001'
        SET MESSAGE_TEXT = 'Action annulée : L''utilisateur lié n''existe pas dans la table AG_Utilisateur.';
    END IF;

    IF NEW.NumEnseignant IS NOT NULL AND NOT fn_enseignantExiste(NEW.NumEnseignant) THEN
        SIGNAL SQLSTATE '45002'
        SET MESSAGE_TEXT = 'Action annulée : L''enseignant lié n''existe pas dans la table AG_Enseignant.';
    END IF;

    IF NEW.NumEnseignantResponsable IS NOT NULL AND NOT fn_estResponsable(NEW.NumEnseignantResponsable) THEN
        SIGNAL SQLSTATE '45003'
        SET MESSAGE_TEXT = 'Action annulée : L''enseignant responsable lié n''existe pas dans la table AG_EnseignantResponsable.';
    END IF;

    IF NEW.NumEnseignantResponsableFiliere IS NOT NULL AND NOT fn_estResponsableFiliere(NEW.NumEnseignantResponsableFiliere) THEN
        SIGNAL SQLSTATE '45004'
        SET MESSAGE_TEXT = 'Action annulée : Le responsable de filière lié n''existe pas dans la table AG_EnseignantResponsableFiliere.';
    END IF;

    IF NEW.NumCovoiturage IS NOT NULL THEN
        IF NOT fn_covoiturageExiste(NEW.NumCovoiturage) THEN
            SIGNAL SQLSTATE '45005'
            SET MESSAGE_TEXT = 'Action annulée : Le covoiturage lié n''existe pas dans la table AG_Covoiturage.';
        END IF;
        
        IF fn_covoiturageEstPlein(NEW.NumCovoiturage) THEN
            SIGNAL SQLSTATE '45008'
            SET MESSAGE_TEXT = 'Action annulée : Ce covoiturage a atteint sa capacité maximale.';
        END IF;
    END IF;

    IF NEW.NumPromotion IS NOT NULL AND NOT fn_promotionExiste(NEW.NumPromotion) THEN
        SIGNAL SQLSTATE '45006'
        SET MESSAGE_TEXT = 'Action annulée : La promotion liée n''existe pas dans la table AG_Promotion.';
    END IF;

    IF NEW.NumGroupe IS NOT NULL THEN
        IF NOT fn_groupeExiste(NEW.NumGroupe) THEN
            SIGNAL SQLSTATE '45007'
            SET MESSAGE_TEXT = 'Action annulée : Le groupe lié n''existe pas dans la table AG_Groupe.';
        END IF;

        IF fn_groupeEstPlein(NEW.NumGroupe) THEN
            SIGNAL SQLSTATE '45009'
            SET MESSAGE_TEXT = 'Action annulée : Ce groupe a atteint sa capacité maximale.';
        END IF;
    END IF;
END$$

DROP TRIGGER IF EXISTS tr_etudiant_update$$
CREATE TRIGGER tr_etudiant_update
BEFORE UPDATE ON AG_Etudiant
FOR EACH ROW
BEGIN

    IF NEW.NumEtudiant != OLD.NumEtudiant AND fn_etudiantExiste(NEW.NumEtudiant) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Action annulée : Cet étudiant existe déjà dans la table AG_Etudiant.';
    END IF;

    IF NOT fn_utilisateurExiste(NEW.NumUtilisateur) THEN
        SIGNAL SQLSTATE '45001'
        SET MESSAGE_TEXT = 'Action annulée : L''utilisateur lié n''existe pas dans la table AG_Utilisateur.';
    END IF;

    IF NEW.NumEnseignant IS NOT NULL AND NOT fn_enseignantExiste(NEW.NumEnseignant) THEN
        SIGNAL SQLSTATE '45002'
        SET MESSAGE_TEXT = 'Action annulée : L''enseignant lié n''existe pas dans la table AG_Enseignant.';
    END IF;

    IF NEW.NumEnseignantResponsable IS NOT NULL AND NOT fn_estResponsable(NEW.NumEnseignantResponsable) THEN
        SIGNAL SQLSTATE '45003'
        SET MESSAGE_TEXT = 'Action annulée : L''enseignant responsable lié n''existe pas dans la table AG_EnseignantResponsable.';
    END IF;

    IF NEW.NumEnseignantResponsableFiliere IS NOT NULL AND NOT fn_estResponsableFiliere(NEW.NumEnseignantResponsableFiliere) THEN
        SIGNAL SQLSTATE '45004'
        SET MESSAGE_TEXT = 'Action annulée : Le responsable de filière lié n''existe pas dans la table AG_EnseignantResponsableFiliere.';
    END IF;

    IF NEW.NumCovoiturage IS NOT NULL THEN
        IF NOT fn_covoiturageExiste(NEW.NumCovoiturage) THEN
            SIGNAL SQLSTATE '45005'
            SET MESSAGE_TEXT = 'Action annulée : Le covoiturage lié n''existe pas dans la table AG_Covoiturage.';
        END IF;
        
        IF (OLD.NumCovoiturage IS NULL OR NEW.NumCovoiturage != OLD.NumCovoiturage) THEN
            IF fn_covoiturageEstPlein(NEW.NumCovoiturage) THEN
                SIGNAL SQLSTATE '45008'
                SET MESSAGE_TEXT = 'Action annulée : Ce covoiturage a atteint sa capacité maximale.';
            END IF;
        END IF;
    END IF;

    IF NEW.NumPromotion IS NOT NULL AND NOT fn_promotionExiste(NEW.NumPromotion) THEN
        SIGNAL SQLSTATE '45006'
        SET MESSAGE_TEXT = 'Action annulée : La promotion liée n''existe pas dans la table AG_Promotion.';
    END IF;

    IF NEW.NumGroupe IS NOT NULL THEN
        IF NOT fn_groupeExiste(NEW.NumGroupe) THEN
            SIGNAL SQLSTATE '45007'
            SET MESSAGE_TEXT = 'Action annulée : Le groupe lié n''existe pas dans la table AG_Groupe.';
        END IF;

        IF (OLD.NumGroupe IS NULL OR NEW.NumGroupe != OLD.NumGroupe) THEN
            IF fn_groupeEstPlein(NEW.NumGroupe) THEN
                SIGNAL SQLSTATE '45009'
                SET MESSAGE_TEXT = 'Action annulée : Ce groupe a atteint sa capacité maximale.';
            END IF;
        END IF;
    END IF;
END$$

DELIMITER ;