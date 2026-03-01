package CiteUniversitaireTest;
import java.util.*;

import modeles.Etudiant;
import modeles.Maison;
import modeles.RestoU;

public class MaisonTest {
   // Test pour vérifier que le nombre d'étudiant dans la maison
    private static void maisonTest_ListeEtudiantSup30_ThrowsInvalideArgument() {
        Maison maison = new Maison("Maison Test", "France", "Mme Dupont", "Paris");
        try {
            for (int i = 0; i < 31; i++) {
                Etudiant e = new Etudiant(i, "Nom" + i, "Prénom" + i, "Nationalité");
                maison.ajouteEtudiant(e);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("maisonTest_ListeEtudiantSup30_ThrowsInvalideArgument réussi.");
            return;
        }
        assert false : "maisonTest_ListeEtudiantSup30_ThrowsInvalideArgument échoué : aucune exception lancée.";
    }

    // Test pour vérifier si on peut ajouter un étudiant dans une maison
    private static void maisonTest_AjoutEtudiant_ThrowsInvalideArgument() {
        Maison maison = new Maison("Maison Test", "France", "Mme Dupont", "Paris");

        for (int i = 0; i < 30; i++) {
            Etudiant e = new Etudiant(i, "Nom" + i, "Prenom" + i, "Nationalité");
            maison.ajouteEtudiant(e);
        }

        assert maison.getEtudiants().size() == 30 : "Erreur : le nombre d'étudiants devrait être 30.";

        try {
            Etudiant etudiantSup = new Etudiant(30, "Nom30", "Prenom30", "Nationalité");
            maison.ajouteEtudiant(etudiantSup);
            assert false : "Erreur : l'exception n'a pas été levée lors du dépassement.";
        } catch (IllegalArgumentException e) {
            System.out.println("maisonTest_AjoutEtudiant_ThrowsInvalideArgument réussi.");
        }
    }

    // Test pour vérifier si on peut afficher le RestoU
    private static void maisonTest_AfficheMenu_ThrowsInvalideArgument() {
        Maison maison = new Maison("Maison Portugal", "Portugal", "Marcelo Rebelo de Sousa", "Lisbonne");

        maison.ajouteMenu(null);

        try {
            maison.afficheRestoU();
        } catch (IllegalArgumentException e) {
            System.out.println("maisonTest_AfficheMenu_ThrowsInvalideArgument réussi.");
            return;
        }

        assert false : " maisonTest_AfficheMenu_ThrowsInvalideArgument échoué : aucune exception levée alors que le RestoU est null.";
    }
    
    private static void runTests() {
        maisonTest_ListeEtudiantSup30_ThrowsInvalideArgument();
        maisonTest_AjoutEtudiant_ThrowsInvalideArgument();
        maisonTest_AfficheMenu_ThrowsInvalideArgument();
    }
    
    public static void main(String[] arg){
    	runTests();
    }
}
