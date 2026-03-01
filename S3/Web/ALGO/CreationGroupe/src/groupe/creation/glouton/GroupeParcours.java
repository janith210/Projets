package groupe.creation.glouton;

import groupe.donnee.*;
import java.util.ArrayList;

// ================================================================================================
// Rémy
// ================================================================================================

public class GroupeParcours {

    public static ArrayList<Etudiant> GenererGroupeParcours(int tailleCible, char parcoursCible, ArrayList<Etudiant> etudiantsPromo) {

        // Liste prioritaire
        ArrayList<Etudiant> candidatsPrio = FiltrerParParcours(etudiantsPromo, parcoursCible);

        // Liste secondaire
        ArrayList<Etudiant> candidatsReste = FiltrerAutresParcours(etudiantsPromo, parcoursCible);

        ArrayList<Etudiant> groupe = new ArrayList<>();

        // Remplissage avec le parcours cible
        RemplirGroupe(groupe, candidatsPrio, tailleCible);

        // Complément si nécessaire
        if (groupe.size() < tailleCible) {
            RemplirGroupe(groupe, candidatsReste, tailleCible);
        }

        return groupe;
    }

    private static void RemplirGroupe(ArrayList<Etudiant> groupe, ArrayList<Etudiant> candidats, int tailleCible) {
        int i = 0;
        while (i < candidats.size() && groupe.size() < tailleCible) {
            Etudiant e = candidats.get(i);

            // Vérification de l'équilibre
            boolean besoinTechno = !EstBacEquilibre(groupe);

            if (besoinTechno) {
                if (EstTechno(e)) {
                    groupe.add(e);
                    candidats.remove(i);
                } else {
                    i++;
                }
            } else {
                groupe.add(e);
                candidats.remove(i);
            }
        }
    }

    private static ArrayList<Etudiant> FiltrerParParcours(ArrayList<Etudiant> source, char parcours) {
        ArrayList<Etudiant> resultat = new ArrayList<>();
        for (Etudiant e : source) {
            if (e.getParcours() == parcours) {
                resultat.add(e);
            }
        }
        return resultat;
    }

    // Nouvelle méthode pour récupérer les autres parcours
    private static ArrayList<Etudiant> FiltrerAutresParcours(ArrayList<Etudiant> source, char parcoursExclu) {
        ArrayList<Etudiant> resultat = new ArrayList<>();
        for (Etudiant e : source) {
            if (e.getParcours() != parcoursExclu) { // On prend tout sauf le parcours cible
                resultat.add(e);
            }
        }
        return resultat;
    }

    private static boolean EstBacEquilibre(ArrayList<Etudiant> groupe) {
        int nbTechno = 0;
        int nbGeneral = 0;

        for (Etudiant e : groupe) {
            if (EstTechno(e)) nbTechno++;
            else nbGeneral++;
        }

        if (nbGeneral > nbTechno + 2) {
            return false;
        }
        return true;
    }

    private static boolean EstTechno(Etudiant e) {
        return "Techno".equalsIgnoreCase(e.getTypeBac());
    }
}