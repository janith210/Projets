<div class="container">
    <div>
        <a href="routeur.php?controleur=controleurResponsableFormation&action=consulterEnseignants"><button>Retour à la liste</button></a>
        <h2>Droits de : <?php echo $enseignant->get('NomEnseignant') . " " . $enseignant->get('PrenomEnseignant'); ?></h2>
    </div>
    <div>
        <h3>Responsabilités Actuelles</h3>
        
        <?php 
            if (empty($sonRole)) { 
                echo "<p>Cet enseignant n'a aucune responsabilité particulière pour le moment.</p>";
            } else { ?>
                <table class="styled-table">
                <thead>
                    <tr>
                        <th>Type de Droit</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <?php foreach ($sonRole as $role) { ?>
                        <tr>
                            <td>
                                <?php echo $role['type']; ?>
                            </td>
                            <td>
                                <form action="routeur.php?controleur=controleurResponsableFormation&action=actionDroit&mode=suppr" method="post">
                                    <input type="hidden" name="NumEnseignant" value="<?php echo $enseignant->get('NumEnseignant'); ?>">
                                    <input type="hidden" name="typeDroit" value="<?php echo $role['type']?>">
                                    <input type="hidden" name="valeurDroit" value="<?php echo $role['valeur']?>">
                                    <button type="submit">Supprimer</button>
                                </form>
                            </td>
                        </tr>
                    <?php } ?>
                </tbody>
            </table>
        <?php } ?>
    </div>
    <div>
        <h3>Ajouter une responsabilité</h3>
        
        <form action="routeur.php?controleur=controleurResponsableFormation&action=actionDroit&mode=ajout" method="post">
            
            <input type="hidden" name="NumEnseignant" value="<?php echo $enseignant->get('NumEnseignant'); ?>">

            <div>
                <label>Type de responsabilité</label>
                <select name="typeDroit" id="selectType" required >
                    <option value="" disabled selected>Choisir</option>
                    <option value="Filiere">Responsable Filière</option>
                    <option value="Annee">Responsable Année</option>
                    <option value="Semestre">Responsable Semestre</option>
                    <option value="Formation">Responsable Formation</option>
                </select>
            </div>

            <div class="form-group" id="divValeur">
                <label>Valeur (ex: Info, 2024, S3)</label>
                <input type="text" name="valeurDroit" placeholder="Nom de la filière, année...">
            </div>
            <button type="submit">Ajouter</button>
        </form>
    </div>
</div>