<?php 
  class Modele{
    public function get($attribut){
      return $this->$attribut;
    }

    public function set($attribut,$valeur){
      $this->$attribut=$valeur;
    }

    public function __construct($donnees=NULL){
      if(!is_null($donnees)){
        foreach($donnees as $attribut => $valeur){
          $this->set($attribut,$valeur);
        }
      }
    }

    public static function lireObjets(){
      $table= static::$objet;
      $requete="SELECT * FROM ".$table.";";
      $nomClasse = get_called_class();
      $resultat=connexion::pdo()->query($requete);
      $resultat->setFetchmode(PDO::FETCH_CLASS,$nomClasse);
      $All=$resultat->fetchAll();
      return $All;
    }

    public static function lireObjet($valeur){
      $table= static::$objet;
      $cleP= static::$cle;

      $classe=get_called_class();

      $requete="SELECT * FROM ".$table." WHERE ".$cleP."=:attribut;";
      $resultat=connexion::pdo()->prepare($requete);
      $valeurs=array("attribut"=>$valeur);
      try{
        $resultat->execute($valeurs);
        $resultat->setFetchmode(PDO::FETCH_CLASS,$classe);
        $retour=$resultat->fetch();
        return $retour;
        }
      catch(PDOException $e){
        echo $e->getMessage();
      }
    }

    public static function getAllBy($nomColonne,$valeur){
      $table= static::$objet;

      $classe=get_called_class();

      $requete="SELECT * FROM ".$table." WHERE ".$nomColonne."=:attribut;";
      $resultat=connexion::pdo()->prepare($requete);
      $valeurs=array("attribut"=>$valeur);
      try{
        $resultat->execute($valeurs);
        $resultat->setFetchmode(PDO::FETCH_CLASS,$classe);
        $retour=$resultat->fetchAll();
        return $retour;
        }
      catch(PDOException $e){
        echo $e->getMessage();
      }
    }

     public static function getBy($nomColonne,$valeur){
      $table= static::$objet;

      $classe=get_called_class();

      $requete="SELECT * FROM ".$table." WHERE ".$nomColonne."=:attribut;";
      $resultat=connexion::pdo()->prepare($requete);
      $valeurs=array("attribut"=>$valeur);
      try{
        $resultat->execute($valeurs);
        $resultat->setFetchmode(PDO::FETCH_CLASS,$classe);
        $retour=$resultat->fetch();
        return $retour;
        }
      catch(PDOException $e){
        echo $e->getMessage();
      }
    }


    public function creer() {
    $table = static::$objet;
    
    // On récupère les propriétés de l'objet (get_object_vars ne marche pas bien sur protected depuis l'extérieur, 
    // mais fonctionne à l'intérieur de la classe si on adapte la logique).
    // Une approche simple avec votre structure actuelle :
    
    $champs = [];
    $marqueurs = [];
    $valeurs = [];

    // On suppose que l'objet est déjà hydraté via le constructeur ou les setters
    foreach ($this as $key => $value) {
        // On exclut la clé primaire si elle est auto-incrémentée et nulle
        if ($key != static::$cle && $value !== null) {
            $champs[] = $key;
            $marqueurs[] = ":$key";
            $valeurs[$key] = $value;
        }
    }

    $listeChamps = implode(", ", $champs);
    $listeMarqueurs = implode(", ", $marqueurs);

    $requete = "INSERT INTO $table ($listeChamps) VALUES ($listeMarqueurs)";
    
    try {
        $stmt = connexion::pdo()->prepare($requete);
        $stmt->execute($valeurs);
        return true;
    } catch (PDOException $e) {
        echo $e->getMessage();
        return false;
    }


  }
}

?>
