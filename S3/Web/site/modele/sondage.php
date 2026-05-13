<?php
    include_once("modele.php");
    class Sondage extends Modele{
        protected static $objet ="AG_Sondage"; 
        protected static $cle = "NumSondage";

        protected int $NumSondage;
        protected String $NomSondage;
        protected String $DescriptionSondage;
        protected String $TypeSondage;

        protected int $NumEnseignant;

        public function __toString(){
            return "<p> Sondage : " .$this->NomSondage." Description : ".$this->DescriptionSondage."</p>";
        }

        public static function ajouterSondage($nomSondage,$descriptionSondage,$typeSondage,$numEnseignant){
            $requete="INSERT INTO " . static::$objet . " (NomSondage,DescriptionSondage,TypeSondage,NumEnseignant) VALUES (:NomS,:Descr,:Typ,:NumE)";
            $resultat=connexion::pdo()->prepare($requete);
            $valeurs=array("NomS"=>$nomSondage,
            "Descr"=>$descriptionSondage,
            "Typ"=>$typeSondage,
            "NumE"=>$numEnseignant);
            try{
                $resultat->execute($valeurs);
                return true ;
            }
            catch(PDOException $e){
                echo $e->getMessage();
            }
        }
        
        public static function supprimer($numSondage){

            $requete="DELETE FROM AG_ReponseSondage WHERE NumSondage=:num";
            $resultat=connexion::pdo()->prepare($requete);
            $valeurs=array("num"=>$numSondage);

            $requete="DELETE FROM " . static::$objet . " WHERE NumSondage=:num";
            $resultat=connexion::pdo()->prepare($requete);
            $valeurs=array("num"=>$numSondage);
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