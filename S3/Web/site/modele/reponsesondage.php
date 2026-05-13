<?php
    include_once("modele.php");
    class ReponseSondage extends Modele{
        protected static $objet ="AG_ReponseSondage"; 
        protected static $cle = "NumResponseSondage";

        
        protected int $NumReponseSondage;
        protected String $ValeurReponseSondage;

        protected int $NumSondage;
        protected int $NumEtudiant;
        protected int $NumEnseignant;

        public function __toString(){
            return "<p> Sondage : " .$this->NomSondage." Description : ".$this->DescriptionSondage."</p>";
        }

        public static function EnvoyerReponse($numSondage,$numEtudiant,$valeurReponseSondage){
            $requete="INSERT INTO " . static::$objet . " (NumSondage,NumEtudiant,ValeurReponseSondage) VALUES (:NumS,:NumE,:Valeur)";
            $resultat=connexion::pdo()->prepare($requete);
            $valeurs=array("NumS"=>$numSondage,
            "NumE"=>$numEtudiant,
            "Valeur"=>$valeurReponseSondage);
            try{
                $resultat->execute($valeurs);
                return true ;
            }
            catch(PDOException $e){
                echo $e->getMessage();
            }
        }
        
    }
?>