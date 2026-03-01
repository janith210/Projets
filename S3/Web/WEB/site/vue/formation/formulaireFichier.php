<div>
    <h2>Remplacer un fichier</h2>
    <div>
        <p>Vous allez remplacer le fichier :</p>
        <h3><?php echo $_GET['file']; ?></h3>
        
        <form action="routeur.php?controleur=controleurResponsableFormation&action=traiter" method="post" enctype="multipart/form-data">
            
            <input type="hidden" name="cheminCible" value="<?php echo $_GET['file']; ?>">
            
            <input type="file" name="nouveauFichier" required>
            <br><br>
            <button type="submit">
                CONFIRMER LE REMPLACEMENT
            </button>
        </form>
    </div>
    
    <br><br>
    <a href="routeur.php?controleur=controleurResponsableFormation&action=explorer&dir=<?php echo dirname($_GET['file']); ?>"><button>Annuler</button></a>
</div>