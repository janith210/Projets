<?php

echo "<h2>Details des notes </h2>";

foreach($lesNotes as $note){
    echo "<p>La matière : " .$note->get("NomNote")."</p>";
    echo "<p>Note " .$note->get("ValeurNote")."</p>";
}
echo "<a href=routeur.php?controleur=controleurEnseignant&action=Accueil><button>Retour</button></a>";

?>