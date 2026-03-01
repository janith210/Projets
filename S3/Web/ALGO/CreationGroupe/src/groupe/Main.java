package groupe;

import groupe.creation.glouton.*;
import groupe.creation.forcebrut.*;
import groupe.donnee.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] arg) {
        Etudiant etudiant1 = new Etudiant('A', "Techno", "Martin", "Lucas", 4,'M', false, -1);
        Etudiant etudiant2 = new Etudiant('A', "Techno", "Dubois", "Emma", 4,'F', false, 1);
        Etudiant etudiant3 = new Etudiant('A', "General", "Bernard", "Chloé", 4,'F', false, 2);
        Etudiant etudiant4 = new Etudiant('A', "Techno", "Lefèvre", "Hugo", 4,'A', false, 1);
        Etudiant etudiant5 = new Etudiant('A', "General", "Moreau", "Léa", 4,'A', false, 1);
        Etudiant etudiant6 = new Etudiant('A', "Techno", "Fontaine", "Thomas", 4,'M', false, 2);
        Etudiant etudiant7 = new Etudiant('A', "General", "Perrin", "Camille", 4,'F', false, 0);
        Etudiant etudiant8 = new Etudiant('A', "Techno", "Lambert", "Enzo", 4,'M', false, 3);
        Etudiant etudiant9 = new Etudiant('B', "General", "Gauthier", "Manon", 4,'A', false, 4);
        Etudiant etudiant10 = new Etudiant('B', "Techno", "Blanchet", "Arthur", 4,'M', false, 3);
        Etudiant etudiant11 = new Etudiant('B', "General", "Pelletier", "Sarah", 4,'F', false, 2);
        Etudiant etudiant12 = new Etudiant('B', "Techno", "Robert", "Mathis", 4,'M', false, 0);
        Etudiant etudiant13 = new Etudiant('B', "General", "Caron", "Clara", 4,'F', false, 3);
        Etudiant etudiant14 = new Etudiant('B', "Techno", "Marchand", "Jules", 4,'M', false, 0);
        Etudiant etudiant15 = new Etudiant('B', "General", "Colin", "Anaïs", 4,'F', false, -1);
        Etudiant etudiant16 = new Etudiant('B', "Techno", "Garcia", "Maxime", 4,'A', false, -1);
        Etudiant etudiant17 = new Etudiant('B', "General", "Millet", "Inès", 4,'F', false, -1);
        Etudiant etudiant18 = new Etudiant('B', "General", "Da Silva", "Noah", 4,'M', false, -1);
        Etudiant etudiant19 = new Etudiant('B', "General", "Laurent", "Eva", 4,'F', false, -1);
        Etudiant etudiant20 = new Etudiant('B', "Techno", "Renard", "Léo", 4,'M', false, 4);
        Etudiant etudiant21 = new Etudiant('B', "General", "Adam", "Margot", 4,'F', false, 5);
        Etudiant etudiant22 = new Etudiant('B', "General", "Rolland", "Timéo", 4,'A', false,6);
        Etudiant etudiant23 = new Etudiant('B', "Techno", "Barbier", "Zoé", 5,'A', false, 5);
        Etudiant etudiant24 = new Etudiant('B', "Techno", "Roger", "Gabriel", 5,'M', false, 4);
        Etudiant etudiant25 = new Etudiant('B', "General", "Vaillant", "Jade", 5,'F', false, 6);
        Etudiant etudiant26 = new Etudiant('B', "Techno", "Gérard", "Paul", 5,'A', false, 4);
        Etudiant etudiant27 = new Etudiant('B', "General", "Dupont", "Lina", 5,'F', false, 5);
        Etudiant etudiant28 = new Etudiant('B', "Techno", "Morel", "Elias", 5,'M', false,-1);

        // ------------------------------------------------------------------------------------------------------------------------------------------------------------------

        // Algorithme GroupeBac
        ArrayList<Etudiant> etudiantpromo = new ArrayList<>();
        for (int i=0; i<Etudiant.getEtudiantFiliere().size(); i++) {
            if (Etudiant.getEtudiantFiliere().get(i).getPromo() == 4) {
                etudiantpromo.add(Etudiant.getEtudiantFiliere().get(i));
            }
        }

        ArrayList<Etudiant> groupeBac = GroupeBac.GenererGroupeBac(18,etudiantpromo,'B');

        // --- AFFICHAGE DES GROUPES ---
        System.out.println();
        System.out.println("===== RÉSULTAT DES GROUPES BAC =====\n");

        int nbEtu = 0;
        for (Etudiant e : groupeBac) {
            System.out.println(
                e.getPrenom() + " " +
                e.getNom() + " | Bac : " +
                e.getTypeBac() + " | Parcours : " +
                e.getParcours() + " | Promo : " +
                e.getPromo()
            );
            nbEtu++;
        }
        System.out.println(nbEtu);


        System.out.println(); System.out.println(); System.out.println(); System.out.println();
        // ---------------------------------------------------------------------------------------------------------------------------------------------


        // Algorithme GroupeParcours
        ArrayList<Etudiant> groupesParcours = GroupeParcours.GenererGroupeParcours(18,'A',etudiantpromo);

        // --- AFFICHAGE DES GROUPES ---
        System.out.println();
        System.out.println("===== RÉSULTAT DES GROUPES PARCOURS =====\n");

        nbEtu = 0;
        for (Etudiant e : groupesParcours) {
            System.out.println(
                e.getPrenom() + " " +
                e.getNom() + " | Bac : " +
                e.getTypeBac() + " | Parcours : " +
                e.getParcours() + " | Promo : " +
                e.getPromo()
            );
            nbEtu++;
        }
        System.out.println(nbEtu);


        System.out.println(); System.out.println(); System.out.println(); System.out.println();
        // ---------------------------------------------------------------------------------------------------------------------------------------------

        ArrayList<Etudiant> listeEtudiants = new ArrayList<>();

        listeEtudiants.add(etudiant1);
        listeEtudiants.add(etudiant2);
        listeEtudiants.add(etudiant3);
        listeEtudiants.add(etudiant4);
        listeEtudiants.add(etudiant5);
        listeEtudiants.add(etudiant6);
        listeEtudiants.add(etudiant7);
        listeEtudiants.add(etudiant8);
        listeEtudiants.add(etudiant9);
        listeEtudiants.add(etudiant10);
        listeEtudiants.add(etudiant11);
        listeEtudiants.add(etudiant12);
        listeEtudiants.add(etudiant13);
        listeEtudiants.add(etudiant14);
        listeEtudiants.add(etudiant15);
        listeEtudiants.add(etudiant16);
        listeEtudiants.add(etudiant17);
        listeEtudiants.add(etudiant18);
        listeEtudiants.add(etudiant19);
        listeEtudiants.add(etudiant20);

        ArrayList<Etudiant> listeEtudiantsAnglophone = GroupeAnglophone.gloutonAnglophonePrioritaire(listeEtudiants);
        ArrayList<Etudiant> listeEtudiantsCovoiturage = GroupeCovoiturage.gloutonCovoituragePrioiritaire(listeEtudiants);

        System.out.println("---- Anglophones ----");
        nbEtu = 0;
        for (Etudiant e : listeEtudiantsAnglophone) {
            System.out.println(
                    e.getPrenom() + " " +
                            e.getNom() + " | Anglophone : " +
                            e.getAnglophone() + " | Covoiturage : " +
                            e.getCovoiturage()
            );
            nbEtu++;
        }
        System.out.println(nbEtu);
        nbEtu = 0;
        System.out.println("---- Covoiturage ----");
        for (Etudiant en : listeEtudiantsCovoiturage) {
            System.out.println(
                    en.getPrenom() + " " +
                            en.getNom() + " | Anglophone : " +
                            en.getAnglophone() + " | Covoiturage : " +
                            en.getCovoiturage()
            );
            nbEtu++;
        }
        System.out.println(nbEtu);

        System.out.println(); System.out.println(); System.out.println(); System.out.println();

        // Algorithme GroupeFille

        ArrayList<Etudiant> groupeFille = GroupeFille.GloutonFille(40,15,18,etudiantpromo);

        // --- AFFICHAGE DES GROUPES ---
        System.out.println();
        System.out.println("===== RÉSULTAT DES GROUPES FILLE =====\n");

        nbEtu = 0;
        for (Etudiant e : groupeFille) {
            System.out.println(
                    e.getPrenom() + " " +
                            e.getNom() + " | Genre : " +
                            e.getGenre()
            );
            nbEtu++;
        }
        System.out.println(nbEtu);

        System.out.println(); System.out.println(); System.out.println(); System.out.println();


        // Algorithme GroupeTaille

        ArrayList<Etudiant> groupeTaille = GroupeTaille.GloutonTaille(35,13,18,etudiantpromo);

        // --- AFFICHAGE DES GROUPES ---
        System.out.println();
        System.out.println("===== RÉSULTAT DES GROUPES TAILLE =====\n");

        nbEtu = 0;
        for (Etudiant e : groupeTaille) {
            System.out.println(
                    e.getPrenom() + " " +
                            e.getNom() + " | Genre : " +
                            e.getGenre()
            );
            nbEtu++;
        }
        System.out.println(nbEtu);
    }
}
