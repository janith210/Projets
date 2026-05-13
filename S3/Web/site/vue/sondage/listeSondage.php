<?php
echo "<h2>Liste des sondages</h2>";
foreach($tabAff as $ligne){
    echo $ligne;
    $id=$ligne->get($cle);
    echo '<a href="routeur.php?controleur='.$cible.'&action='.$action.'&'.$cle.'='.$id.'"><button>Repondre</button></a>';
}
echo "<a href=routeur.php?controleur=controleurEtudiant&action=Accueil><button>Retour</button></a>";
?>