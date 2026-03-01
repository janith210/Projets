<?php
    include_once("modele.php");
    include_once("responsableformation.php");
    class Enseignant extends Modele{
        protected static $objet = "AG_Enseignant"; 

        protected static $cle = "NumEnseignant";

        protected int $NumEnseignant;
        protected String $NomEnseignant;
        protected String $PrenomEnseignant;
        protected String $DateNaissanceEnseignant;
        protected String $AdresseEnseignant;
        protected String $TelephoneEnseignant;
        protected String $GenreEnseignant;
        protected String $EmailEnseignant;

        public function __toString(){
            return "<p> Enseignant " .$this->NomEnseignant. " " .$this->PrenomEnseignant. "(" .$this->EmailEnseignant. ")</p>";
        }



    public static function getDetailsResponsabilite($numEnseignant) {
        $infos =[]; 

        $req = "SELECT NomFiliere FROM AG_EnseignantResponsableFilière WHERE NumEnseignant = :num";
        $stmt = connexion::pdo()->prepare($req);
        $param=['num' => $numEnseignant];
        $stmt->execute($param);
        
        foreach($stmt->fetchAll() as $res) {
            $infos[]=["type"=> "Filiere",
                    "valeur"=> $res['NomFiliere']];
        }

        $req = "SELECT NomAnnee FROM AG_EnseignantResponsableAnnée WHERE NumEnseignant = :num";
        $stmt = connexion::pdo()->prepare($req);
        $param=['num' => $numEnseignant];
        $stmt->execute($param);
        
        foreach($stmt->fetchAll() as $res) {
            $infos[]=["type"=> "Annee",
                    "valeur"=> $res['NomAnnee']];
        }

        $req = "SELECT NomSemestre FROM AG_EnseignantResponsableSemestre WHERE NumEnseignant = :num";
        $stmt = connexion::pdo()->prepare($req);
        $param=['num' => $numEnseignant];
        $stmt->execute($param);
        
        foreach($stmt->fetchAll() as $res) {
            $infos[]=["type"=> "Semestre",
                    "valeur"=> $res['NomSemestre']];
        }
        
        $res=responsableformation::getBy("NumEnseignant",$numEnseignant);
        
        if ($res) {
            $infos[]=["type"=> "Formation",
                    "valeur"=> "Tout"];
        }

        return $infos;
    }

    public static function ajouterResponsabilite($numEnseignant, $type, $valeur) {
        $table = "";
        $colonneVal = "";
        
        if ($type == 'Filiere') { 
            $table = "AG_EnseignantResponsableFilière"; 
            $colonneVal = "NomFiliere";
        }
        elseif ($type == 'Annee') { 
            $table = "AG_EnseignantResponsableAnnée"; 
            $colonneVal = "NomAnnee";
        }
        elseif ($type == 'Semestre') { 
            $table = "AG_EnseignantResponsableSemestre"; 
            $colonneVal = "NomSemestre";
        }
        elseif ($type == 'Formation') { 
            $table = "AG_EnseignantResponsableFormation"; 
            
            $req = "INSERT INTO $table (NumEnseignant, DateDebutFormation) VALUES (:num, NOW())";
            $resultat = connexion::pdo()->prepare($req);
            $param=['num' => $numEnseignant];
            $resultat->execute($param);
            return $resultat;
        }

        if ($table != "") {
            $req = "INSERT INTO $table (NumEnseignant, $colonneVal) VALUES (:num, :val)";
            $resultat = connexion::pdo()->prepare($req);
            $param=['num' => $numEnseignant, 'val' => $valeur];
            return $resultat->execute($param);
        }
        
        return false;
    }

    public static function supprimerResponsabilite($numEnseignant, $type, $valeur) {
        $table = "";
        $condition = "";

        if ($type == 'Filiere') { 
            $req = "UPDATE AG_Etudiant SET NumEnseignantResponsableFiliere = NULL WHERE NumEnseignantResponsableFiliere = :num";
            $resultat = connexion::pdo()->prepare($req);
            $param=['num' => $numEnseignant];
            $resultat->execute($param);

            $table = "AG_EnseignantResponsableFilière"; 
            $condition = "NomFiliere = :val";
        }
        elseif ($type == 'Annee') {
            $req = "UPDATE AG_Groupe SET NumEnseignantResponsableAnnee = NULL WHERE NumEnseignantResponsableAnnee = :num";
            $resultat = connexion::pdo()->prepare($req);
            $param=['num' => $numEnseignant];
            $resultat->execute($param);
            
            $table = "AG_EnseignantResponsableAnnée"; 
            $condition = "NomAnnee = :val";
        }
        elseif ($type == 'Semestre') { 
            $table = "AG_EnseignantResponsableSemestre"; 
            $condition = "NomSemestre = :val";
        }
        elseif ($type == 'Formation') { 
            $table = "AG_EnseignantResponsableFormation"; 
            $condition = "1=1"; 
        }

        if ($table != "") {
            $req = "DELETE FROM $table WHERE NumEnseignant = :num AND $condition";
            $stmt = connexion::pdo()->prepare($req);
            $param = ['num' => $numEnseignant];
            
            if ($type != 'Formation') {
                $param['val'] = $valeur;
            }
            
            return $stmt->execute($param);
        }
        
        return false;
    }
   
}