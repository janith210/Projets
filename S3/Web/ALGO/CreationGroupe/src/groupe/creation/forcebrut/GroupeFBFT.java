package groupe.creation.forcebrut;

import groupe.donnee.*;
import java.util.ArrayList;

// =================================================================================================
// Gabriel
// Classe Force brut contrainte :
// Fille et Taille
// =================================================================================================

public class GroupeFBFT {

    /**
     * Cherche un groupe qui respecte à la fois :
     * 1. La contrainte de taille (entre min et max)
     * 2. Le pourcentage minimal de filles
     *
     * @param etudiants Liste des étudiants à disposition pour les groupes
     * @param minTaille Taille minimale du groupe
     * @param maxTaille Taille maximale du groupe
     * @param pourcentageMin Pourcentage minimum de filles requis (ex: 50.0)
     * @return Le groupe formé (ArrayList<Etudiant>) ou null si aucune combinaison ne marche
     */
    public static ArrayList<Etudiant> trouverGroupeMixte(ArrayList<Etudiant> etudiants, int minTaille, int maxTaille, double pourcentageMin) {

        // Vérification de base : assez d'étudiants pour faire au moins le min
        if (etudiants.size() < minTaille) {
            return null;
        }

        // On limite la taille recherchée à ce qu'on a réellement de disponible
        int limiteMax = Math.min(etudiants.size(), maxTaille);

        // On teste les tailles de la plus GRANDE à la plus PETITE pour avoir un groupe le plus rempli possible
        for (int taille = limiteMax; taille >= minTaille; taille--) {

            ArrayList<Etudiant> resultat = new ArrayList<>();

            // Lancement de la recherche combinatoire pour cette taille précise
            if (chercherCombinaison(etudiants, taille, 0, resultat, pourcentageMin)) {
                return resultat;
            }
        }

        return null; // Impossible de former un groupe valide avec ces critères
    }

    /**
     * Fonction récursive pour générer les combinaisons
     *
     * @param etudiant Liste des étudiants à disposition pour les groupes
     * @param etudiantRestantAjouter Nombre d'étudiant restant à placer dans le groupe
     * @param indexDepart nombre d'étudiant placé provisoirement dans le groupe
     * @param groupeEnCours liste des étudiants étant déjà provisoirement placé dans le groupe
     * @param pourcentageMin Pourcentage minimum de filles requis (ex: 50.0)
     */
    private static boolean chercherCombinaison(ArrayList<Etudiant> etudiant, int etudiantRestantAjouter, int indexDepart, ArrayList<Etudiant> groupeEnCours, double pourcentageMin) {

        // Cas de base : Le groupe a atteint la taille cible 'etudiantRestantAjouter'
        if (etudiantRestantAjouter == 0) {
            // Vérification de la contrainte "Fille"
            return estGroupeValide(groupeEnCours, pourcentageMin);
        }

        // Exploration des étudiants restants
        for (int i = indexDepart; i < etudiant.size(); i++) {
            groupeEnCours.add(etudiant.get(i));

            // Appel récursif pour compléter le reste du groupe
            if (chercherCombinaison(etudiant, etudiantRestantAjouter - 1, i + 1, groupeEnCours, pourcentageMin)) {
                return true;
            }

            // Si pas de true, on enlève l'étudiant pour tester une autre possibilité
            groupeEnCours.remove(groupeEnCours.size() - 1);
        }

        return false;
    }

    /**
     * Vérification métier fusionnant les logiques Fille et Taille
     *
     * @param groupe Liste des étudiants forment un groupe à vérifier
     * @param pourcentageMin Pourcentage minimum de filles requis (ex: 50.0)
     */
    private static boolean estGroupeValide(ArrayList<Etudiant> groupe, double pourcentageMin) {
        if (groupe.isEmpty()) return false;

        // Calcul du nombre de filles
        int nbFilles = 0;
        for (Etudiant e : groupe) {
            if (e.getGenre() == 'F') {
                nbFilles++;
            }
        }

        // Vérification du pourcentage
        double pourcentageActuel = (nbFilles * 100.0) / groupe.size();

        return pourcentageActuel >= pourcentageMin;
    }
}