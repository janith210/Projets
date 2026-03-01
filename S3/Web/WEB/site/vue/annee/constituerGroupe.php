<div class="container" style="margin-top: 20px;">

    <div class="row" style="display:flex; justify-content:space-around; align-items:flex-start;">
        
        <div class="card" style="width: 40%; padding: 20px; border: 1px solid #ddd; border-radius: 10px; text-align: center; box-shadow: 0 4px 8px rgba(0,0,0,0.1);">
            
            <h3 style="color: #2c3e50; margin-bottom: 20px;">Zone d'affectation</h3>

            <form action="routeur.php?controleur=controleurResponsableAnnee&action=genererRepartion" method="POST">
                
                <div style="margin-bottom: 20px; text-align: left;">
                    <label style="font-weight: bold;">1. Choisir le groupe cible :</label>
                    <select name="NumGroupeCible" class="form-control" style="width: 100%; padding: 10px; margin-top:5px; border-radius: 5px; border: 1px solid #ccc;">
                        <?php
                        if(isset($lesGroupes) && !empty($lesGroupes)) {
                            foreach ($lesGroupes as $grp) {
                                $id = $grp->get('NumGroupe');
                                $cap = $grp->get('CapaciteGroupe');
                                echo "<option value='$id'>Groupe $id (Capacité max : $cap)</option>";
                            }
                        } else {
                            echo "<option disabled>Aucun groupe disponible</option>";
                        }
                        ?>
                    </select>
                </div>

                <div style="background-color: #f8f9fa; padding: 20px; margin: 20px 0; border-radius: 10px; border: 1px dashed #2c3e50;">
                    <h4 style="margin: 0; color: #555;">Algorithme choisi :</h4>
                    <h3 style="margin: 10px 0; color: #27ae60; text-transform: uppercase;">
                        <?php 
                        $algoActuel = $_GET['algo'] ?? 'parcours_bac'; 
                        echo htmlspecialchars($algoActuel); 
                        ?>
                    </h3>
                    <input type="hidden" name="algo" value="<?php echo $algoActuel; ?>">
                </div>

                <button type="submit" class="btn btn-success" style="width:100%; padding: 15px; font-size: 1.1em; background-color: #28a745; color: white; border: none; border-radius: 5px; cursor: pointer;">
                    Affecter les Etudiants
                </button>
            </form>

        </div>

        <div class="card" style="width: 40%; text-align: center;">
            <h3 style="color: #003366;">Algorithmes disponibles</h3>
            <p style="font-size: 0.9em; color: #666;">Cliquez pour sélectionner un critère de tri</p>
            
            <div class="d-grid gap-2">
                <a href="routeur.php?controleur=controleurResponsableAnnee&action=AccueilGroupe&algo=parcours_bac" 
                   class="btn" style="display:block; margin: 10px 0; padding: 15px; background-color: #34495e; color: white; text-decoration: none; border-radius: 5px;">
                   Parcours / Bac
                </a>

                <a href="routeur.php?controleur=controleurResponsableAnnee&action=AccueilGroupe&algo=taille_fille" 
                   class="btn" style="display:block; margin: 10px 0; padding: 15px; background-color: #34495e; color: white; text-decoration: none; border-radius: 5px;">
                   Taille / Fille (Genre)
                </a>

                <a href="routeur.php?controleur=controleurResponsableAnnee&action=AccueilGroupe&algo=covoiturage" 
                   class="btn" style="display:block; margin: 10px 0; padding: 15px; background-color: #34495e; color: white; text-decoration: none; border-radius: 5px;">
                   Covoiturage
                </a>
                
                 <a href="routeur.php?controleur=controleurResponsableAnnee&action=AccueilGroupe&algo=anglophone" 
                   class="btn" style="display:block; margin: 10px 0; padding: 15px; background-color: #34495e; color: white; text-decoration: none; border-radius: 5px;">
                   Option Anglais
                </a>
            </div>
        </div>

    </div>
</div>
<a href="routeur.php?controleur=controleurEnseignant&action=Accueil">
    <button>Retour à l'accueil</button>
</a>