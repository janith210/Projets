<?php
  foreach($tabAff as $ligne){
    echo $ligne;
    $id=$ligne->get($cle);
    if (isset($action) && $action != false) {
        $id = $ligne->get($cle);
        echo '<a href="routeur.php?controleur='.$cible.'&action='.$action.'&'.$cle.'='.$id.'"><button>Détails</button></a>';
    }
  }
?>
