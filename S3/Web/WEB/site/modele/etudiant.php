<?php
    include_once("modele.php");
    class Etudiant extends Modele{
        protected static $objet = "AG_Etudiant"; 
        protected static $cle = "NumEtudiant";

        protected int $NumEtudiant;
        protected String $NomEtudiant;
        protected String $PrenomEtudiant;
        protected String $DateNaissanceEtudiant;
        protected String $AdresseEtudiant;
        protected String $TelephoneEtudiant;
        protected String $GenreEtudiant;
        protected String $EmailEtudiant;
        protected String $TypeBacEtudiant;
        protected String $ParcoursEtudiant;
        protected bool $OptionAnglaisEtudiant;
        protected String $PeriodeRedoublementEtudiant;

        protected int $NumUtilisateur;
        protected ?int $NumCovoiturage;
        protected ?int $NumGroupe; 

        public function __toString(){
            return "<p> Etudiant " .$this->NomEtudiant. " " .$this->PrenomEtudiant. "(" .$this->EmailEtudiant. ")</p>";
        }

        public static function rejoindreCovoiturage($numEtudiant,$numCovoiturage){
            $requete="UPDATE " . static::$objet . " SET NumCovoiturage =:covoiturage WHERE NumEtudiant=:etudiant";
            $resultat=connexion::pdo()->prepare($requete);
            $valeurs=array("covoiturage"=>$numCovoiturage,
            "etudiant"=>$numEtudiant);
            try{
                $resultat->execute($valeurs);
                return true ;
            }
            catch(PDOException $e){
                echo $e->getMessage();
            }
        }
        
        

        public static function affecterGroupe($numEtudiant, $numGroupe){
            $requete = "UPDATE " . static::$objet . " SET NumGroupe = :groupe WHERE NumEtudiant = :etudiant";
            $resultat = connexion::pdo()->prepare($requete);
            $valeurs = array(
                "groupe" => $numGroupe,
                "etudiant" => $numEtudiant
            );
            try {
                $resultat->execute($valeurs);
                return true;
            } catch(PDOException $e) {
                echo $e->getMessage();
                return false;
            }
        }

        public static function getTousLesEtudiants($orderBy = "NomEtudiant"){
            $table = static::$objet;
            $classe = get_called_class();
            $requete = "SELECT * FROM $table ORDER BY $orderBy"; 
            
            $resultat = connexion::pdo()->query($requete);
            $resultat->setFetchmode(PDO::FETCH_CLASS, $classe);
            return $resultat->fetchAll();
        }


        public static function compterEtudiantsGroupe($numGroupe){
            $table = static::$objet;
            $requete = "SELECT COUNT(*) as nb FROM $table WHERE NumGroupe = :groupe";
            $resultat = connexion::pdo()->prepare($requete);
            $resultat->execute(array("groupe" => $numGroupe));
            return $resultat->fetchColumn(); 
        }

        public static function viderGroupe($numGroupe){
            $table = static::$objet;
            $requete = "UPDATE $table SET NumGroupe = NULL WHERE NumGroupe = :groupe";
            $resultat = connexion::pdo()->prepare($requete);
            try {
                $resultat->execute(array("groupe" => $numGroupe));
                return true;
            } catch(PDOException $e) {
                return false;
            }
        }

        public static function getEtudiantsSansGroupe($orderBy = "NomEtudiant"){
            $table = static::$objet;
            $classe = get_called_class();
            
            $requete = "SELECT * FROM $table WHERE NumGroupe IS NULL ORDER BY $orderBy"; 
            
            $resultat = connexion::pdo()->query($requete);
            $resultat->setFetchmode(PDO::FETCH_CLASS, $classe);
            return $resultat->fetchAll();
        }
        
    }