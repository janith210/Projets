package groupe.creation.glouton;

import groupe.donnee.*;

import java.util.ArrayList;

// =================================================================================================
// Gabriel
// ================================================================================================

public class GroupeFille {


    public static ArrayList<Etudiant> GloutonFille(double pourcentage, int minTaille, int maxTaille, ArrayList<Etudiant> listeGroupeEtudiants) {
        ArrayList<Etudiant> groupe = new ArrayList<>();
        ArrayList<Etudiant> filles = GroupeFille(listeGroupeEtudiants);
        ArrayList<Etudiant> garcons = GroupeGarcon(listeGroupeEtudiants);

        //tant que taille en dessous de minTaille
        while (groupe.size() < minTaille) {

            if (filles.isEmpty() && garcons.isEmpty()) {
                break;
            }

            double pourcentageFilleActuel = PourcentageFille(groupe);

            if (pourcentageFilleActuel < pourcentage && !filles.isEmpty()) {
                // Ajout d'une fille si le pourcentage n'est pas bon
                groupe.add(filles.get(0));
                filles.remove(0);

            } else {
                //sinon ajout d'une personne pour augmenter l'effectif du groupe
                //(priorité à homme pour garder des filles afin d'ajuster le pourcentage par la suite
                if (!garcons.isEmpty()){
                    groupe.add(garcons.get(0));
                    garcons.remove(0);
                }
                else if (!filles.isEmpty()){
                    groupe.add(filles.get(0));
                    filles.remove(0);
                }
            }

            //si on dépasse la taille max, on stoppe
            if (groupe.size() >= maxTaille){
                break;
            }
        }

        //critère glouton = pourcentage de fille >= pourcentage
        //Ajout de fille pour respecter le pource,tage si il ne l'est pas déjà
        while (PourcentageFille(groupe) < pourcentage && !filles.isEmpty() ) {
            groupe.add(filles.get(0));
            filles.remove(0);
        }
        return groupe;
    }

    public static ArrayList<Etudiant> GroupeGarcon(ArrayList<Etudiant> listeEtudiants) {
        if (listeEtudiants.isEmpty()) {
            return new ArrayList<>();
        }
        ArrayList<Etudiant> groupeFinal = new ArrayList<>();
        for (Etudiant etudiant : listeEtudiants) {
            if (etudiant.getGenre() == 'M') {
                groupeFinal.add(etudiant);
            }
        }
        return groupeFinal;
    }

    public static ArrayList<Etudiant> GroupeFille(ArrayList<Etudiant> listeEtudiants) {
        if (listeEtudiants.isEmpty()) {
            return new ArrayList<>();
        }
        ArrayList<Etudiant> groupeFinal = new ArrayList<>();
        for (Etudiant etudiant : listeEtudiants) {
            if (etudiant.getGenre() == 'F') {
                groupeFinal.add(etudiant);
            }
        }
        return groupeFinal;
    }

    public static double PourcentageFille(ArrayList<Etudiant> groupe) {
        if (groupe.isEmpty()) {
            return 00.0;
        }

        int nbFilles = 0;
        for (int i = 0; i < groupe.size(); i++) {
            if (groupe.get(i).getGenre() == 'F') {
                nbFilles++;
            }
        }
        return (nbFilles * 100.0) / groupe.size();
    }
}