package application.modeles;

import application.controleurs.ControleurAccueil;
import application.services.ServiceApi;
import application.vues.VueAccueil;
import application.vues.VueCreationMan;

import javax.swing.*;

public class ModeleCreationMan {
    private JFrame _frame;
    private int _idGroupe;
    private Etudiant[] _etudiants;
    private ServiceApi _api;

    private VueCreationMan _vue;


    public ModeleCreationMan(JFrame frame, int idGroupe) {
        this._frame = frame;
        this._idGroupe = idGroupe;
        this._api = new ServiceApi();
        chargeretudiants();
    }

    public void setVue(VueCreationMan vue) {
        this._vue = vue;
    }

    public void chargeretudiants() {
        this._etudiants = _api.recupererEtudiants();
    }

    // --- FONCTIONS AUXILIAIRES ---

    public void ajouterEtudiantAuGroupe(int idEtudiant) {
        Etudiant e = trouverEtudiantParId(idEtudiant);

        if (e != null) {
            e.setNumGroupe(this._idGroupe);
            System.out.println("Etudiant " + idEtudiant + " ajouté au groupe " + _idGroupe);

            boolean succes = _api.updateEtudiant(e);

            if (succes) {
                refreshVueCreationMan();
            } else {
                JOptionPane.showMessageDialog(_frame,
                        "Erreur API : Impossible d'ajouter l'étudiant. Le groupe est sûrement complet.",
                        "Erreur", JOptionPane.ERROR_MESSAGE);
                e.setNumGroupe(0);
                refreshVueCreationMan();
            }
        }
    }

    public void retirerEtudiantDuGroupe(int idEtudiant) {
        Etudiant e = trouverEtudiantParId(idEtudiant);

        if (e != null) {
            e.setNumGroupe(0);
            System.out.println("Etudiant " + idEtudiant + " retiré du groupe.");

            boolean succes = _api.updateEtudiant(e);

            if (succes) {
                refreshVueCreationMan();
            } else {
                JOptionPane.showMessageDialog(_frame,
                        "Erreur API : Impossible de retirer l'étudiant.",
                        "Erreur", JOptionPane.ERROR_MESSAGE);
                e.setNumGroupe(this._idGroupe);
                refreshVueCreationMan();
            }
        }
    }

    private Etudiant trouverEtudiantParId(int id) {
        if (_etudiants == null) return null;
        for (Etudiant e : _etudiants) {
            if (e.getNumEtudiant() == id) {
                return e;
            }
        }
        return null;
    }

    public void refreshVueCreationMan() {
        if (_vue != null) {
            _vue.rafraichirListes();
        }
    }

    public void creationGroupeAccueil() {
        ModeleAccueil MA = new ModeleAccueil(_frame);
        VueAccueil VA = new VueAccueil(MA);
        ControleurAccueil CA = new ControleurAccueil(MA, VA);

        _frame.setContentPane(VA);
        _frame.revalidate();
        _frame.repaint();
    }

    public int get_idGroupe() {
        return _idGroupe;
    }

    public Etudiant[] get_etudiants() {
        return _etudiants;
    }
}