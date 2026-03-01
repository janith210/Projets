package groupe.creation.glouton;

import groupe.donnee.*;

import java.util.ArrayList;

// ================================================================================================
// Gabriel
// ================================================================================================

public class GroupeTaille {

    //algorithme glouton avec comme critère glouton la taille du groupe
    public static ArrayList<Etudiant> GloutonTaille(double pourcentage, int minTaille, int maxTaille, ArrayList<Etudiant> listeEtudiants) {
        ArrayList<Etudiant> groupe = new ArrayList<>();
        ArrayList<Etudiant> filles = GroupeFille(listeEtudiants);
        ArrayList<Etudiant> garcons = GroupeGarcon(listeEtudiants);

        while (groupe.size() < minTaille) {
            //ajout d'une personne pour augmenter l'effectif du groupe
            //(priorité à homme pour garder des filles afin d'ajuster le pourcentage par la suite
            if (!garcons.isEmpty()) {
                groupe.add(garcons.get(0));
                garcons.remove(0);
            }
            else if (!filles.isEmpty()) {
                groupe.add(filles.get(0));
                filles.remove(0);
            }
            else{
                break;
            }
        }
        //on ajoute des filles tant que la taille est inférieur à la max taille
        while (!filles.isEmpty() && groupe.size() < maxTaille ) {
            groupe.add(filles.remove(0));
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





}
