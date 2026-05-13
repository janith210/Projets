<?php
    include_once("modele.php");
    class Note extends Modele{
        protected static $objet = "AG_Note"; 
        protected static $cle = "NumNote";

        protected int $NumNote;
        protected int $ValeurNote;
        protected String $NomNote;

        protected int $NumEtudiant;

        public function __toString(){
            return "<p> Nom " .$this->NomNote. "</p>";
        }

        public static function getNotesByEtudiant($numEtudiant) {
            $req = "SELECT * FROM AG_Note WHERE NumEtudiant = :num";
            $resultat = connexion::pdo()->prepare($req);
            $valeurs=array('num' => $numEtudiant);
            try{
                $resultat->execute($valeurs);
                $resultat->setFetchMode(PDO::FETCH_CLASS, 'Note');
                return $resultat->fetchAll();
            }catch(PDOException $e){
                echo $e->getMessage();
            }
        }

        public static function ajouterNote($valeur, $nom, $numEtudiant) {
            $req = "INSERT INTO AG_Note (ValeurNote, NomNote, NumEtudiant) VALUES (:val, :nom, :num)";
            $resultat = connexion::pdo()->prepare($req);
            $valeurs=array('val' => $valeur, 'nom' => $nom, 'num' => $numEtudiant);
            try{
                $resultat->execute($valeurs);
                return true ;
            }catch(PDOException $e){
                echo $e->getMessage();
            }
        }
        
        
}