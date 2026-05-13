  <?php 
    session_start();
    require_once("config/connexion.php");  
    connexion::connect();

    $tableauControleurs=["controleurEtudiant","controleurUtilisateur","controleurCovoiturage","controleurSondage","controleurEnseignant","controleurGroupe","controleurResponsableFormation","controleurResponsableFiliere","controleurResponsableAnnee"];
    $actionParDefaut=array(
      "controleurEtudiant" => "Accueil",
      "controleurUtilisateur" => "afficherFormulaire",
      "controleurCovoiturage" => "lireCovoiturages",
      "controleurSondage" => "lireSondages",
      "controleurEnseignant" => "Accueil",
      "controleurGroupe" => "lireGroupes",
      "controleurResponsableFormation" => "explorer",
      "controleurResponsableFiliere"=>"consulterSondages",
      "controleurResponsableAnnee"=>"AccueilGroupe"
    );

    $controleur="controleurUtilisateur";
    $action="afficherFormulaire";

    if(isset($_GET["controleur"]) && in_array($_GET["controleur"],$tableauControleurs)){
      $controleur=$_GET["controleur"];
    }
    
    require_once("controleur/$controleur.php");

    if(isset($_GET["action"]) && in_array($_GET["action"],get_class_methods($controleur))){
      $action=$_GET["action"];
    }
    else{
      $action=$actionParDefaut[$controleur];
    }

    
    $controleur::$action();
    
  ?>
