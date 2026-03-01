<div class="container" style="margin-top: 30px;">

    <div class="alert alert-success" style="background-color: #d4edda; color: #155724; padding: 20px; border-radius: 5px; margin-bottom: 20px;">
        <h2 style="margin-top:0;">Génération terminée avec succès !</h2>
        <p>L'algorithme <strong><?php echo htmlspecialchars($algo); ?></strong> a été exécuté.</p>
        <p>Total étudiants traités : <strong><?php echo $misesAJour; ?></strong></p>
    </div>

    <div class="card" style="border: 1px solid #ddd; padding: 20px; border-radius: 10px;">
        <h3>Répartition par groupe</h3>
        <p>Voici comment les étudiants ont été distribués :</p>

        <table style="width: 100%; border-collapse: collapse; margin-top: 15px;">
            <thead>
                <tr style="background-color: #f8f9fa; text-align: left;">
                    <th style="padding: 12px; border-bottom: 2px solid #ddd;">Numéro du Groupe</th>
                    <th style="padding: 12px; border-bottom: 2px solid #ddd;">Nombre d'étudiants affectés</th>
                </tr>
            </thead>
            <tbody>
                <?php
                foreach ($statsRepartion as $numGroupe => $nombre) {
                    echo "<tr>";
                    echo "<td style='padding: 12px; border-bottom: 1px solid #eee;'>Groupe " . $numGroupe . "</td>";
                    echo "<td style='padding: 12px; border-bottom: 1px solid #eee;'><strong>" . $nombre . "</strong> étudiants</td>";
                    echo "</tr>";
                }
                ?>
            </tbody>
        </table>
    </div>

    <div style="margin-top: 30px; text-align: center;">
        <a href="routeur.php?controleur=controleurResponsableAnnee&action=pageAccueil" class="btn btn-primary" style="background-color: #007bff; color: white; padding: 10px 20px; text-decoration: none; border-radius: 5px;">
            Retour à la gestion des groupes
        </a>
        
        <a href="routeur.php?controleur=controleurGroupe&action=lireGroupes" class="btn btn-secondary" style="background-color: #6c757d; color: white; padding: 10px 20px; text-decoration: none; border-radius: 5px; margin-left: 10px;">
            Voir le détail des groupes
        </a>
    </div>

</div>