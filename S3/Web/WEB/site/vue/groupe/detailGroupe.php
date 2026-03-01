<?php
echo "<p style='text-align:center'>Numéro du groupe : " .$groupe->get("NumGroupe")."</p>";
echo "<p style='text-align:center'>Nombre étudiant : " .$groupe->get("CapaciteGroupe")."</p>";
echo "<p style='text-align:center'>Le type de groupe : " .$groupe->get("TypeGroupe")."</p>";

echo "<h2>La liste des étudiants</h2>";

foreach($LesEtudiants as $etudiant){ echo "<ul>";
echo "<li>Nom de l'étudiant : ".$etudiant->get("NomEtudiant")."</li>";
echo "<li>Prenom de l'étudiant : ".$etudiant->get("PrenomEtudiant")."</li>";
echo "</ul>"; 
}

echo "<a href=routeur.php?controleur=controleurEnseignant&action=Accueil><button>Retour</button></a>";
?>
