<?php
  include_once("modele.php");
  class Utilisateur extends Modele{
    protected static $objet="AG_Utilisateur";
    protected static $cle="NumUtilisateur";

    protected String $LoginUtilisateur;
    protected String $MotDePasseUtilisateur;
    protected String $TypeUtilisateur;

    public function __toString(){
      return "<p> utilisateur " .$this->LoginUtilisateur. "(" .$this->TypeUtilisateur. ")</p>";
    }


    public static function CheckMDP($login,$motdepasse){
      $requete="SELECT * FROM " . static::$objet . " WHERE LoginUtilisateur=:login;";
      $requetePreparee = connexion::pdo()->prepare($requete);
      $requetePreparee->execute([':login' => $login]);
      $requetePreparee->setFetchMode(PDO::FETCH_CLASS,"Utilisateur");
      $user = $requetePreparee->fetch();
      if ($user) {
        //$test = password_verify($motdepasse,$user->MotDePasseUtilisateur);
        if($motdepasse == $user->MotDePasseUtilisateur){
          return $user;
        }
      }
      return false;
    }

  }
      
?>
