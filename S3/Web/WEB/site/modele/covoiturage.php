<?php
    include_once("modele.php");
    class Covoiturage extends Modele{
        protected static $objet = "AG_Covoiturage"; 
        protected static $cle = "NumCovoiturage";

        protected int $NumCovoiturage;

        public function __toString(){
            return "<p> Covoiturage " .$this->NumCovoiturage. "</p>";
        }

        
        
    }