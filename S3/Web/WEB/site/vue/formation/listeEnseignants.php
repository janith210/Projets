<div>
    <h2>Gérer Les Rôles</h2>
    <h3>Liste des Enseignants</h3>

    <div>
        <?php foreach ($tabAff as $enseignant) {
            echo "<div>";
            echo "<h4>";
            echo $enseignant->get('NomEnseignant') . " " . $enseignant->get('PrenomEnseignant');
            echo "</h4>";
            echo'<a href="routeur.php?controleur=controleurResponsableFormation&action=gererEnseignant&NumEnseignant='.$enseignant->get('NumEnseignant').'"><button >Gérer les rôles</button></a>';
            echo "</div>";
        } ?>
    </div>
    <br><a href="routeur.php?controleur=controleurEnseignant&action=Accueil">Retour Accueil</a>
</div>