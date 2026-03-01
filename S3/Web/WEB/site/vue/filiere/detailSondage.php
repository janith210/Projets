<?php

echo "<h2>Details du Sondage </h2>";

echo "<p>Titre" .$sondage->get("NomSondage")."</p>";
echo "<p>Description Sondage " .$sondage->get("DescriptionSondage")."</p>";
echo "<p>Le type du Sondage " .$sondage->get("TypeSondage")."</p>";
echo "<p>Le numero Enseignant " .$sondage->get("NumEnseignant")."</p>";
echo "<a href=routeur.php?controleur=controleurResponsableFiliere&action=supprimerSondage&NumSondage=".$sondage->get('NumSondage')."><button>Supprimer</button></a>";
echo "<a href=routeur.php?controleur=controleurEnseignant&action=Accueil><button>Retour</button></a>";

?>
