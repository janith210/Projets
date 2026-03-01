package groupe.creation.glouton;

import groupe.donnee.*;

import java.util.ArrayList;
// =================================================================================================
// Janith
// ================================================================================================

public class GroupeAnglophone {

    public static boolean verifieCovoiturage(Etudiant E) {
        if (E.getCovoiturage() == -1) {
            return false;
        } else {
            return true;
        }
    }

    public static ArrayList<Etudiant> gloutonAnglophonePrioritaire(ArrayList<Etudiant> listeEtudiants) {
        ArrayList<Etudiant> result = new ArrayList<>();
        if (listeEtudiants.isEmpty()) {
            return new ArrayList<>();
        }
        //tant que la taille de la classe n'est pas supérieur à 16 on ne sort pas de la boucle while
        for (int i = 0; i < listeEtudiants.size() && result.size() < 16; i++) {
            //verifie si l'étudiant est anglophone ET qu'il a un covoiturage
            if (listeEtudiants.get(i).getAnglophone() && verifieCovoiturage(listeEtudiants.get(i))) {
                result.add(listeEtudiants.get(i));
            }
        }

        for (int i = 0; i < listeEtudiants.size() && result.size() < 16; i++) {
            //verifie si l'étudiant est anglophone ET qu'il n'a pas un covoiturage
            if (listeEtudiants.get(i).getAnglophone() && !verifieCovoiturage(listeEtudiants.get(i))) {
                result.add(listeEtudiants.get(i));
            }
        }

        for (int i = 0; i < listeEtudiants.size() && result.size() < 16; i++) {
            //verifie si l'étudiant n'est pas anglophone ET qu'il a un covoiturage
            if (!listeEtudiants.get(i).getAnglophone() && verifieCovoiturage(listeEtudiants.get(i))) {
                result.add(listeEtudiants.get(i));
            }
        }

        for (int i = 0; i < listeEtudiants.size() && result.size() < 16; i++) {
            //verifie si l'étudiant n'est pas anglophone ET qu'il n'a pas un covoiturage
            if (!listeEtudiants.get(i).getAnglophone() && !verifieCovoiturage(listeEtudiants.get(i))) {
                result.add(listeEtudiants.get(i));
            }
        }

        return result;
    }
}
