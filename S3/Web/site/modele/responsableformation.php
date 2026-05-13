<?php
    include_once("modele.php");
    class ResponsableFormation extends Modele{
        protected static $objet = "AG_EnseignantResponsableFormation"; 
        protected static $cle = "NumEnseignant";

        protected int $NumEnseignant;
        protected String $DateDebutFormation;
        protected String $DateFinFormation;
    }