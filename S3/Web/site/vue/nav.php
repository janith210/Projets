<header>
    <nav>
      <?php 
        $mesRoles = [];
        if (isset($_SESSION['role']) ){
          if($_SESSION['role']=='etudiant'){
            echo "<a href='routeur.php?controleur=controleurEtudiant&action=Information'><button>Information personnelle</button></a>";
            echo "<a href='routeur.php?controleur=controleurCovoiturage&action=lireCovoiturages'><button>Covoiturage</button></a>";
            echo "<a href='routeur.php?controleur=controleurSondage&action=lireSondages'><button>Sondage</button></a>";
          }
          elseif($_SESSION['role']=='enseignant'){
            echo "<a href='routeur.php?controleur=controleurEnseignant&action=consulterEtudiants'><button>Consulter les étudiants </button></a>";
            echo "<a href='routeur.php?controleur=controleurGroupe&action=lireGroupes'><button>Consulter les groupes </button></a>";
            if (isset($_SESSION['responsabilites']) && is_array($_SESSION['responsabilites'])) {
              foreach ($_SESSION['responsabilites'] as $res) {
                if (isset($res['type'])) {
                  $mesRoles[] = $res['type']; 
                }
              }
            }
            if(in_array("Semestre",$mesRoles)){
              echo "<a href='routeur.php?controleur=controleurResponsableFiliere&action=consulterSondages'><button>Consulter les sondages</button></a>";
              echo "<a href='routeur.php?controleur=controleurResponsableFiliere&action=listeEtudiants'><button>Consulter les notes</button></a>";
            }
            }
            if(in_array("Annee",$mesRoles)){
              echo "<a href='routeur.php?controleur=controleurResponsableFiliere&action=consulterSondages'><button>Consulter les sondages</button></a>";
              echo "<a href='routeur.php?controleur=controleurResponsableFiliere&action=listeEtudiants'><button>Consulter les notes</button></a>";
              echo "<a href='routeur.php?controleur=controleurResponsableAnnee&action=AccueilGroupe'><button>Generer un groupe</button></a>";
            }
            if(in_array("Filiere",$mesRoles)){
              echo "<a href='routeur.php?controleur=controleurResponsableFiliere&action=consulterSondages'><button>Consulter les sondages</button></a>";
              echo "<a href='routeur.php?controleur=controleurResponsableFiliere&action=listeEtudiants'><button>Consulter les notes</button></a>";
              echo "<a href=routeur.php?controleur=controleurResponsableFiliere&action=afficherFormulaireImport><button>Importer fichier csv</button></a>";
              echo "<a href='routeur.php?controleur=controleurResponsableAnnee&action=AccueilGroupe'><button>Generer un groupe</button></a>";
            }
            if(in_array("Formation",$mesRoles)){
              echo "<a href='routeur.php?controleur=controleurResponsableFormation&action=lireFichiers'><button>Modifier le site</button></a>";
              echo "<a href='routeur.php?controleur=controleurResponsableFormation&action=consulterEnseignants'><button>Modifier les droits </button></a>";
            }
          }
      ?>
    </nav>
</header>