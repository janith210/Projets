<?php
    include_once("modele.php");
    class ResponsableSemestre extends Modele{
        protected static $objet = "AG_EnseignantResponsableFiliere"; 
        protected static $cle = "NumEnseignant";

        protected int $NumEnseignant;
        protected String $NomSemestre;

        
    }