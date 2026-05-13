<?php
    include_once("modele.php");
    class Groupe extends Modele{
        protected static $objet = "AG_Groupe"; 
        protected static $cle = "NumGroupe";

        protected int $NumGroupe;
        protected String $TypeGroupe;
        protected int $CapaciteGroupe;

        protected ?int $NumEnseignantResponsableAnnee;
        protected ?int $NumEnseignantResponsable;

        public function __toString(){
            return "<p> Groupe " .$this->NumGroupe."</p>";
        }
        
        
    }