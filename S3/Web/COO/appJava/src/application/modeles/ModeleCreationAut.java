package application.modeles;

import application.controleurs.ControleurAccueil;
import application.services.ServiceApi;
import application.vues.VueAccueil;
import application.vues.VueCreationAut;

import javax.swing.*;
import java.util.ArrayList;

public class ModeleCreationAut {

    private JFrame _frame;
    private int _idGroupe;
    private Etudiant[] _etudiants;
    private ServiceApi _api;
    private VueCreationAut _vue;

    private final int TAILLE_MAX_GROUPE = 18;
    private final int TAILLE_MIN_GROUPE = 12;
    private final double POURCENTAGE_FILLE = 30.0;

    public ModeleCreationAut(JFrame frame, int groupeSelectionne) {
        this._frame = frame;
        this._idGroupe = groupeSelectionne;
        this._api = new ServiceApi();
        chargerEtudiants();
    }

    public void setVue(VueCreationAut vue) {
        this._vue = vue;
    }

    public void chargerEtudiants() {
        this._etudiants = _api.recupererEtudiants();
    }

    public void executerAffectation(String algoChoisi) {
        if (_etudiants == null) return;

        ArrayList<Etudiant> candidats = new ArrayList<>();
        for (Etudiant e : _etudiants) {
            if (e.getNumGroupe() == 0) candidats.add(e);
        }

        ArrayList<Etudiant> etudiantsSelectionnes = new ArrayList<>();

        if (algoChoisi == null) algoChoisi = "";

        switch (algoChoisi) {

            case "Parcours/Bac":
                for (Etudiant pivot : candidats) {
                    if (pivot.getNumPromotion() <= 0 || pivot.getParcoursEtudiant() == null) continue;
                    String parcoursCible = pivot.getParcoursEtudiant();
                    int promoCible = pivot.getNumPromotion();

                    ArrayList<Etudiant> filtres = GloutonParcoursEtudiant(candidats, parcoursCible, promoCible);
                    ArrayList<Etudiant> groupe = GloutonGroupeParcours(TAILLE_MAX_GROUPE, filtres);

                    if (!groupe.isEmpty()) {
                        etudiantsSelectionnes = groupe;
                        break;
                    }
                }
                break;

            case "Bac/Parcours":
                for (Etudiant pivot : candidats) {
                    if (pivot.getNumPromotion() <= 0) continue;
                    int promoCible = pivot.getNumPromotion();

                    ArrayList<Etudiant> filtres = FiltreParPromo(candidats, promoCible);
                    ArrayList<Etudiant> groupe = GloutonGroupeBac(TAILLE_MAX_GROUPE, filtres);

                    if (!groupe.isEmpty()) {
                        etudiantsSelectionnes = groupe;
                        break;
                    }
                }
                break;

            case "Taille/Fille":
                for (Etudiant pivot : candidats) {
                    if (pivot.getNumPromotion() <= 0) continue;
                    int promoCible = pivot.getNumPromotion();

                    ArrayList<Etudiant> filtres = FiltreParPromo(candidats, promoCible);
                    ArrayList<Etudiant> groupe = GloutonTaille(TAILLE_MIN_GROUPE, TAILLE_MAX_GROUPE, filtres);

                    if (!groupe.isEmpty()) {
                        etudiantsSelectionnes = groupe;
                        break;
                    }
                }
                break;

            case "Fille/Taille":
                for (Etudiant pivot : candidats) {
                    if (pivot.getNumPromotion() <= 0) continue;
                    int promoCible = pivot.getNumPromotion();

                    ArrayList<Etudiant> filtres = FiltreParPromo(candidats, promoCible);
                    ArrayList<Etudiant> groupe = GloutonFille(POURCENTAGE_FILLE, TAILLE_MIN_GROUPE, TAILLE_MAX_GROUPE, filtres);

                    if (!groupe.isEmpty()) {
                        etudiantsSelectionnes = groupe;
                        break;
                    }
                }
                break;

            case "Covoiturage/Anglophone":
                for (Etudiant pivot : candidats) {
                    if (pivot.getNumPromotion() <= 0) continue;
                    int promoCible = pivot.getNumPromotion();

                    ArrayList<Etudiant> filtres = FiltreParPromo(candidats, promoCible);
                    ArrayList<Etudiant> groupe = GloutonCovoituragePrioritaire(TAILLE_MAX_GROUPE, filtres);

                    if (!groupe.isEmpty()) {
                        etudiantsSelectionnes = groupe;
                        break;
                    }
                }
                break;

            case "Anglophone/Covoiturage":
                for (Etudiant pivot : candidats) {
                    if (pivot.getNumPromotion() <= 0) continue;
                    int promoCible = pivot.getNumPromotion();

                    ArrayList<Etudiant> filtres = FiltreParPromo(candidats, promoCible);

                    ArrayList<Etudiant> groupe = GloutonAnglophonePrioritaire(TAILLE_MAX_GROUPE, filtres);

                    if (!groupe.isEmpty()) {
                        etudiantsSelectionnes = groupe;
                        break;
                    }
                }
                break;

            default:
                JOptionPane.showMessageDialog(_frame, "Erreur : L'algorithme '" + algoChoisi + "' n'est pas reconnu.", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
        }

        if (!etudiantsSelectionnes.isEmpty()) {
            for (Etudiant e : _etudiants) {
                if (e.getNumGroupe() == this._idGroupe) {
                    e.setNumGroupe(0);
                    _api.updateEtudiant(e);
                }
            }
            int nb = 0;
            for (Etudiant e : etudiantsSelectionnes) {
                e.setNumGroupe(this._idGroupe);
                if (_api.updateEtudiant(e)) nb++;
            }
            JOptionPane.showMessageDialog(_frame, nb + " étudiants affectés !", "Succès", JOptionPane.INFORMATION_MESSAGE);
            if (_vue != null) _vue.afficherResultats(etudiantsSelectionnes);

        } else {
            if (candidats.isEmpty()) {
                JOptionPane.showMessageDialog(_frame, "Aucun étudiant disponible.", "Erreur", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(_frame, "Aucun groupe n'a pu être formé avec les critères de '" + algoChoisi + "'.", "Information", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    // =========================================================================
    // --- ALGO GLOUTON PARCOURS & BAC ---

    private ArrayList<Etudiant> GloutonGroupeParcours(int tailleMax, ArrayList<Etudiant> listeSource) {
        ArrayList<Etudiant> groupe = new ArrayList<>();
        ArrayList<Etudiant> copie = new ArrayList<>(listeSource);

        int i = 0;
        while (i < copie.size() && groupe.size() < tailleMax) {
            Etudiant e = copie.get(i);
            String bac = (e.getTypeBacEtudiant() != null) ? e.getTypeBacEtudiant().trim() : "";

            if (!GloutonVerifTypeBac(groupe)) {
                if ("Techno".equalsIgnoreCase(bac)) {
                    groupe.add(e);
                    copie.remove(i);
                    continue;
                }
                i++;
            } else {
                groupe.add(e);
                copie.remove(i);
            }
        }
        return groupe;
    }

    // --- ALGO GLOUTON BAC & PARCOURS ---

    private ArrayList<Etudiant> GloutonGroupeBac(int tailleMax, ArrayList<Etudiant> candidatsPromo) {
        ArrayList<Etudiant> groupe = new ArrayList<>();
        ArrayList<Etudiant> listTechno = new ArrayList<>();
        ArrayList<Etudiant> listGeneral = new ArrayList<>();

        for (Etudiant e : candidatsPromo) {
            String bac = (e.getTypeBacEtudiant() != null) ? e.getTypeBacEtudiant().trim() : "";
            if ("Techno".equalsIgnoreCase(bac)) {
                listTechno.add(e);
            } else {
                listGeneral.add(e);
            }
        }

        int quotaTechno = tailleMax / 2;
        int quotaGeneral = tailleMax - quotaTechno;

        int nbAjoutTechno = 0;
        while (nbAjoutTechno < quotaTechno && !listTechno.isEmpty()) {
            groupe.add(listTechno.remove(0));
            nbAjoutTechno++;
        }
        int nbAjoutGeneral = 0;
        while (nbAjoutGeneral < quotaGeneral && !listGeneral.isEmpty()) {
            groupe.add(listGeneral.remove(0));
            nbAjoutGeneral++;
        }
        while (groupe.size() < tailleMax && (!listTechno.isEmpty() || !listGeneral.isEmpty())) {
            if (!listTechno.isEmpty()) {
                groupe.add(listTechno.remove(0));
            } else {
                groupe.add(listGeneral.remove(0));
            }
        }
        return groupe;
    }

    // --- ALGO GLOUTON TAILLE & FILLE ---

    private ArrayList<Etudiant> GloutonTaille(int minTaille, int maxTaille, ArrayList<Etudiant> listeEtudiants) {
        ArrayList<Etudiant> groupe = new ArrayList<>();
        ArrayList<Etudiant> filles = GroupeFille(listeEtudiants);
        ArrayList<Etudiant> garcons = GroupeGarcon(listeEtudiants);

        while (groupe.size() < minTaille) {
            if (!garcons.isEmpty()) {
                groupe.add(garcons.remove(0));
            } else if (!filles.isEmpty()) {
                groupe.add(filles.remove(0));
            } else {
                break;
            }
        }
        while (!filles.isEmpty() && groupe.size() < maxTaille) {
            groupe.add(filles.remove(0));
        }
        return groupe;
    }

    // --- ALGO GLOUTON FILLE & TAILLE ---

    private ArrayList<Etudiant> GloutonFille(double pourcentage, int minTaille, int maxTaille, ArrayList<Etudiant> listeGroupeEtudiants) {
        ArrayList<Etudiant> groupe = new ArrayList<>();
        ArrayList<Etudiant> filles = GroupeFille(listeGroupeEtudiants);
        ArrayList<Etudiant> garcons = GroupeGarcon(listeGroupeEtudiants);

        while (groupe.size() < minTaille) {
            if (filles.isEmpty() && garcons.isEmpty()) break;
            double pourcentageFilleActuel = PourcentageFille(groupe);

            if (pourcentageFilleActuel < pourcentage && !filles.isEmpty()) {
                groupe.add(filles.remove(0));
            } else {
                if (!garcons.isEmpty()){
                    groupe.add(garcons.remove(0));
                } else if (!filles.isEmpty()){
                    groupe.add(filles.remove(0));
                }
            }
            if (groupe.size() >= maxTaille) break;
        }
        while (PourcentageFille(groupe) < pourcentage && !filles.isEmpty() && groupe.size() < maxTaille) {
            groupe.add(filles.remove(0));
        }
        return groupe;
    }

    // --- ALGO GLOUTON COVOITURAGE & ANGLOPHONE ---

    public ArrayList<Etudiant> GloutonCovoituragePrioritaire(int tailleMax, ArrayList<Etudiant> listeEtudiants) {
        ArrayList<Etudiant> result = new ArrayList<>();
        if (listeEtudiants.isEmpty()) return result;

        ArrayList<Etudiant> prio1 = new ArrayList<>(); // Anglophone + Covoit
        ArrayList<Etudiant> prio2 = new ArrayList<>(); // Pas Anglophone + Covoit
        ArrayList<Etudiant> prio3 = new ArrayList<>(); // Anglophone + Pas Covoit
        ArrayList<Etudiant> prio4 = new ArrayList<>(); // Pas Anglophone + Pas Covoit

        for (Etudiant e : listeEtudiants) {
            boolean isAnglo = verifieAnglophone(e);
            boolean hasCovoit = verifieCovoiturage(e);

            if (isAnglo && hasCovoit) prio1.add(e);
            else if (!isAnglo && hasCovoit) prio2.add(e);
            else if (isAnglo && !hasCovoit) prio3.add(e);
            else prio4.add(e);
        }

        remplirListe(result, prio1, tailleMax);
        remplirListe(result, prio2, tailleMax);
        remplirListe(result, prio3, tailleMax);
        remplirListe(result, prio4, tailleMax);

        return result;
    }

    // --- ALGO GLOUTON ANGLOPHONE & COVOITURAGE ---

    public ArrayList<Etudiant> GloutonAnglophonePrioritaire(int tailleMax, ArrayList<Etudiant> listeEtudiants) {
        ArrayList<Etudiant> result = new ArrayList<>();
        if (listeEtudiants.isEmpty()) return result;

        // Ordre de priorité différent : D'abord les Anglophones (avec ou sans covoit)
        ArrayList<Etudiant> prio1 = new ArrayList<>(); // Anglophone + Covoit
        ArrayList<Etudiant> prio2 = new ArrayList<>(); // Anglophone + Pas Covoit (PRIORITÉ ICI)
        ArrayList<Etudiant> prio3 = new ArrayList<>(); // Pas Anglophone + Covoit
        ArrayList<Etudiant> prio4 = new ArrayList<>(); // Pas Anglophone + Pas Covoit

        for (Etudiant e : listeEtudiants) {
            boolean isAnglo = verifieAnglophone(e);
            boolean hasCovoit = verifieCovoiturage(e);

            if (isAnglo && hasCovoit) prio1.add(e);
            else if (isAnglo && !hasCovoit) prio2.add(e);
            else if (!isAnglo && hasCovoit) prio3.add(e);
            else prio4.add(e);
        }

        remplirListe(result, prio1, tailleMax);
        remplirListe(result, prio2, tailleMax);
        remplirListe(result, prio3, tailleMax);
        remplirListe(result, prio4, tailleMax);

        return result;
    }

    // =========================================================================

    // =========================================================================
    // --- FONCTIONS AUXILIAIRES DE TOUTS LES ALGOS

    private ArrayList<Etudiant> GloutonParcoursEtudiant(ArrayList<Etudiant> promoComplete, String parcoursVise, int promoVisee) {
        ArrayList<Etudiant> result = new ArrayList<>();
        for (Etudiant e : promoComplete) {
            String p = (e.getParcoursEtudiant() != null) ? e.getParcoursEtudiant().trim() : "";
            if (e.getNumPromotion() == promoVisee && p.equalsIgnoreCase(parcoursVise.trim())) {
                result.add(e);
            }
        }
        return result;
    }

    private boolean GloutonVerifTypeBac(ArrayList<Etudiant> groupe) {
        int techno = 0;
        int general = 0;
        for (Etudiant e : groupe) {
            String bac = (e.getTypeBacEtudiant() != null) ? e.getTypeBacEtudiant().trim() : "";
            if ("Techno".equalsIgnoreCase(bac)) techno++;
            else general++;
        }
        return Math.abs(techno - general) <= 1;
    }

    private void remplirListe(ArrayList<Etudiant> destination, ArrayList<Etudiant> source, int max) {
        while (destination.size() < max && !source.isEmpty()) {
            destination.add(source.remove(0));
        }
    }

    private boolean verifieCovoiturage(Etudiant e) {
        return e.getNumCovoiturage() > 0;
    }

    private boolean verifieAnglophone(Etudiant e) {
        return e.getOptionAnglaisEtudiant() == 1;
    }

    private ArrayList<Etudiant> FiltreParPromo(ArrayList<Etudiant> candidats, int promoVisee) {
        ArrayList<Etudiant> result = new ArrayList<>();
        for (Etudiant e : candidats) {
            if (e.getNumPromotion() == promoVisee) {
                result.add(e);
            }
        }
        return result;
    }

    private ArrayList<Etudiant> GroupeGarcon(ArrayList<Etudiant> listeEtudiants) {
        ArrayList<Etudiant> groupeFinal = new ArrayList<>();
        for (Etudiant etudiant : listeEtudiants) {
            String genre = (etudiant.getGenreEtudiant() != null) ? etudiant.getGenreEtudiant().trim() : "";
            if ("M".equalsIgnoreCase(genre)) {
                groupeFinal.add(etudiant);
            }
        }
        return groupeFinal;
    }

    private ArrayList<Etudiant> GroupeFille(ArrayList<Etudiant> listeEtudiants) {
        ArrayList<Etudiant> groupeFinal = new ArrayList<>();
        for (Etudiant etudiant : listeEtudiants) {
            String genre = (etudiant.getGenreEtudiant() != null) ? etudiant.getGenreEtudiant().trim() : "";
            if ("F".equalsIgnoreCase(genre)) {
                groupeFinal.add(etudiant);
            }
        }
        return groupeFinal;
    }

    private double PourcentageFille(ArrayList<Etudiant> groupe) {
        if (groupe.isEmpty()) return 0.0;
        int nbFilles = 0;
        for (Etudiant e : groupe) {
            String genre = (e.getGenreEtudiant() != null) ? e.getGenreEtudiant().trim() : "";
            if ("F".equalsIgnoreCase(genre)) nbFilles++;
        }
        return (nbFilles * 100.0) / groupe.size();
    }

    public void creationGroupeAccueil() {
        ModeleAccueil MA = new ModeleAccueil(_frame);
        VueAccueil VA = new VueAccueil(MA);
        ControleurAccueil CA = new ControleurAccueil(MA, VA);
        _frame.setContentPane(VA);
        _frame.revalidate();
        _frame.repaint();
    }
    public int get_idGroupe() { return _idGroupe; }
    public Etudiant[] get_etudiants() { return _etudiants; }
}