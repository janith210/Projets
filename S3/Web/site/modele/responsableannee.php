<?php
    include_once("modele.php");
    class ResponsableAnnee extends Modele{
        protected static $objet = "AG_EnseignantResponsableAnnee"; 
        protected static $cle = "NumEnseignant";

        protected int $NumEnseignant;
        protected String $NomAnnee;

    }