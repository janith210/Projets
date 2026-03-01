package groupe.creation.forcebrut;

import groupe.donnee.*;
import java.util.ArrayList;
import java.util.List;

// =================================================================================================
// Janith
// Classe Force brut contrainte :
// Covoiturage et Anglophone
// =================================================================================================

public class GroupeFBCA {


    static ArrayList<Etudiant> meilleurGroupe = new ArrayList<>();
    static double meilleureDiffMoyenne = Double.MAX_VALUE;
    static double moyennePromo = 12.0;

    public static ArrayList<Etudiant>AnglophoneFB(ArrayList<Etudiant> listeEtudiants) {
        //On calcule la moyenne de toute la promo
        moyennePromo = getMoyenne(listeEtudiants);
        //On teste avec un algorithme récursif
        testerCombinaison(listeEtudiants, new ArrayList<>(), 0);

        return meilleurGroupe;
    }


    private static void testerCombinaison(ArrayList<Etudiant> source, ArrayList<Etudiant> groupeEnCours, int index) {
        //Si on a parcouru tous les étudiants de la liste source
        if (index == source.size()) {
        //On vérifie la taille 
            if (groupeEnCours.size() >= 16 && groupeEnCours.size() <= 18) {
        //On vérifie si le groupe est valide
                if (estGroupeValide(groupeEnCours)) {
        //Calcul la moyenne de la promo et du groupe pour obtenir la valeur absolue de l'écart
                    double moyGroupe = getMoyenne(groupeEnCours);
                    double diff = Math.abs(moyGroupe - moyennePromo);

        //Si ce groupe a une diff plus petite que la meilleureDiffMoyenne 
                    if (diff < meilleureDiffMoyenne) {
                        meilleureDiffMoyenne = diff;
                        meilleurGroupe = new ArrayList<>(groupeEnCours); // On copie le groupe
                        System.out.println("Nouveau groupe trouvé ! Taille: " + groupeEnCours.size() + " | Diff Moyenne: " + diff);
                    }
                }
            }
            return;
        }
        // On choisit d'ajouter l'étudiant dans le groupe
        groupeEnCours.add(source.get(index));
        // On continue la récursion avec l'étudiant suivant
        testerCombinaison(source, groupeEnCours, index + 1);
        // On retire le dernier étudiant ajouté
        groupeEnCours.remove(groupeEnCours.size() - 1);
        // On continue la récursion sans l'étudiant retiré
        testerCombinaison(source, groupeEnCours, index + 1);
    }


    private static boolean estGroupeValide(List<Etudiant> groupe) {
        int nbAnglophones = 0;
        int nbCovoiturage = 0;
        // On parcourt le groupe pour compter le nombre d'Anglophones et Covoiturages
        for (Etudiant e : groupe) {
            if (e.getAnglophone()) nbAnglophones++;
            if (e.getCovoiturage() != -1) nbCovoiturage++;
        }


        boolean assezAnglophones = nbAnglophones >= (groupe.size() / 2);

        boolean assezCovoit = nbCovoiturage >= 2;

        return assezAnglophones && assezCovoit;
    }

    //pour calculer la moyenne des notes d'une liste d'étudiants
    private static double getMoyenne(List<Etudiant> groupe) {
        if (groupe.isEmpty()) return 0;
        double total = 0;
        for (Etudiant e : groupe) {
            total += e.getMoyenne();
        }
        return total / groupe.size();
    }
}
