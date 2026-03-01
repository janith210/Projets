package groupe.creation.forcebrut;

import groupe.donnee.*;
import java.util.ArrayList;

// =================================================================================================
// Rémy
// Classe Force brut contrainte :
// parcours et Bac
// =================================================================================================

public class GroupeFBPB {

    /**
     * Cherche et renvoie un groupe valide respectant les critères, par Force Brute
     * Priorise les groupes de grande taille (commence par maxTaille)
     *
     * @param etudiants Liste des étudiants disponibles
     * @param minTaille Taille minimale du groupe
     * @param maxTaille Taille maximale du groupe
     * @return Une ArrayList contenant les étudiants du groupe formé, ou null si aucun groupe valide ne peut être créé
     */
    public static ArrayList<Etudiant> trouverUnGroupe(ArrayList<Etudiant> etudiants, int minTaille, int maxTaille) {

        // On ne peut pas faire de groupe si on n'a pas assez d'étudiants
        if (etudiants.size() < minTaille) {
            return null;
        }

        // On détermine la taille maximale réelle qu'on peut tester
        int limiteMax = Math.min(etudiants.size(), maxTaille);

        // On itère de la taille MAX vers la taille MIN, pour essayer d'avoir la meilleur efficacité
        for (int taille = limiteMax; taille >= minTaille; taille--) {

            ArrayList<Etudiant> resultat = new ArrayList<>();
            // Lancement de la recherche de combinaison
            if (ChercheCombinaison(etudiants, taille, 0, resultat)) {
                return resultat;
            }
        }

        return null; // Aucune combinaison valide trouvée
    }

    /**
     * Fonction récursive qui génère les combinaisons de taille 'etuRestantAjouter'
     *
     * @param etudiant Liste source des étudiants
     * @param etuRestantAjouter Nombre d'étudiants restant à ajouter au groupe en cours
     * @param indexDepart Index pour éviter les doublons et parcourir la liste
     * @param groupeEnCours Liste accumulant le groupe en construction
     * @return true si un groupe valide est trouvé, false sinon
     */
    private static boolean ChercheCombinaison(ArrayList<Etudiant> etudiant, int etuRestantAjouter, int indexDepart, ArrayList<Etudiant> groupeEnCours) {
        // Cas de base : Le groupe a atteint la taille souhaitée
        if (etuRestantAjouter == 0) {
            // Vérification des contraintes
            return estGroupeValide(groupeEnCours);
        }

        // Parcours des étudiants restants pour compléter le groupe
        for (int i = indexDepart; i < etudiant.size(); i++) {
            Etudiant candidat = etudiant.get(i);

            groupeEnCours.add(candidat);

            // Appel récursif : on cherche encore (k-1) étudiants à partir de l'index suivant
            if (ChercheCombinaison(etudiant, etuRestantAjouter - 1, i + 1, groupeEnCours)) {
                return true; // Si vrai return true
            }

            // on retire le dernier ajouté pour tester le suivant
            groupeEnCours.remove(groupeEnCours.size() - 1);
        }

        return false;
    }

    /**
     * Vérifie la validité d'un groupe formé selon les contraintes de bac
     *
     * @param groupe Liste des étudiants rassemblés en groupe
     */
    private static boolean estGroupeValide(ArrayList<Etudiant> groupe) {
        int techno = 0;
        int general = 0;

        for (Etudiant e : groupe) {
            if ("Techno".equals(e.getTypeBac())) {
                techno++;
            } else {
                general++;
            }
        }

        // Contrainte : différence <= 1
        return Math.abs(techno - general) <= 1;
    }
}