package groupe.creation.glouton;

import groupe.donnee.*;
import java.util.ArrayList;

// ================================================================================================
// Rémy
// ================================================================================================

public class GroupeBac {

    public static ArrayList<Etudiant> GenererGroupeBac(int tailleGroupe, ArrayList<Etudiant> etudiantsPromo, char parcoursPrio) {

        // FILTRAGE : Séparation par type de bac
        ArrayList<Etudiant> listTechno = new ArrayList<>();
        ArrayList<Etudiant> listGeneral = new ArrayList<>();

        for (Etudiant e : etudiantsPromo) {
            String bac = (e.getTypeBac() != null) ? e.getTypeBac().trim() : "";
            if ("Techno".equalsIgnoreCase(bac)) {
                listTechno.add(e);
            } else {
                listGeneral.add(e);
            }
        }

        // DÉFINITION DES QUOTAS (50/50)
        int quotaTechno = tailleGroupe / 2;
        int quotaGeneral = tailleGroupe - quotaTechno;

        ArrayList<Etudiant> groupe = new ArrayList<>();

        // Remplir avec les TECHNOS
        for (int i = 0; i < quotaTechno; i++) {
            if (listTechno.isEmpty()) break;
            Etudiant best = ChoisirEtudiantAvecPriorite(listTechno, groupe, parcoursPrio);
            groupe.add(best);
            listTechno.remove(best);
        }

        // Remplir avec les GÉNÉRAUX
        for (int i = 0; i < quotaGeneral; i++) {
            if (listGeneral.isEmpty()) break;
            Etudiant best = ChoisirEtudiantAvecPriorite(listGeneral, groupe, parcoursPrio);
            groupe.add(best);
            listGeneral.remove(best);
        }

        // Complément (si manque des étudiant du parcours souhaité)
        while (groupe.size() < tailleGroupe && (!listTechno.isEmpty() || !listGeneral.isEmpty())) {
            if (!listTechno.isEmpty()) {
                Etudiant best = ChoisirEtudiantAvecPriorite(listTechno, groupe, parcoursPrio);
                groupe.add(best);
                listTechno.remove(best);
            } else {
                Etudiant best = ChoisirEtudiantAvecPriorite(listGeneral, groupe, parcoursPrio);
                groupe.add(best);
                listGeneral.remove(best);
            }
        }

        return groupe;
    }

    private static Etudiant ChoisirEtudiantAvecPriorite(ArrayList<Etudiant> candidats, ArrayList<Etudiant> groupeActuel, char parcoursPrio) {
        if (candidats.isEmpty()) return null;

        // Essayer de trouver le parcours prioritaire
        for (Etudiant e : candidats) {
            if (e.getParcours() == parcoursPrio) {
                return e; // Priorité trouvée
            }
        }

        // Sinon, choisir un autre parcours parmi les étudiants de la liste actuel
        return ChoisirMeilleurParcours(candidats, groupeActuel);
    }

    private static Etudiant ChoisirMeilleurParcours(ArrayList<Etudiant> candidats, ArrayList<Etudiant> groupeActuel) {
        if (candidats.isEmpty()) return null;

        // Compter les parcours présents
        int nbA = 0, nbB = 0, nbC = 0;
        for (Etudiant e : groupeActuel) {
            if (e.getParcours() == 'A') nbA++;
            else if (e.getParcours() == 'B') nbB++;
            else if (e.getParcours() == 'C') nbC++;
        }

        // Trouver le parcours minoritaire
        char parcoursCible = 'A';
        int minCount = nbA;

        if (nbB < minCount) { minCount = nbB; parcoursCible = 'B'; }
        if (nbC < minCount) { parcoursCible = 'C'; }

        // Chercher un candidat correspondant
        for (Etudiant e : candidats) {
            if (e.getParcours() == parcoursCible) return e;
        }

        // Sinon, le premier de la liste
        return candidats.get(0);
    }
}