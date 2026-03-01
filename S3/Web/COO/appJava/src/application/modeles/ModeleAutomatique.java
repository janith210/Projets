package application.modeles;

import application.controleurs.ControleurAccueil;
import application.controleurs.ControleurCreationAut;
import application.services.ServiceApi;
import application.vues.VueAccueil;
import application.vues.VueCreationAut;

import javax.swing.*;

public class ModeleAutomatique {
    private JFrame _frame;
    private ServiceApi _api;
    private Groupe[] _groupes;
    private int GroupeSelectionne;

    public ModeleAutomatique(JFrame frame) {
        this._frame = frame;
        this._api = new ServiceApi();
        chargerGroupes();
    }

    // Méthode pour récupérer les groupes via l'API
    public void chargerGroupes() {
        this._groupes = _api.recupererGroupes();
    }

    public void creationGroupeAccueil() {
        ModeleAccueil MA = new ModeleAccueil(_frame);
        VueAccueil VA = new VueAccueil(MA);
        ControleurAccueil CA = new ControleurAccueil(MA, VA);

        _frame.setContentPane(VA);
        _frame.revalidate();
        _frame.repaint();
    }

    public void creationGroupeCreaAut() {
        ModeleCreationAut MCA = new ModeleCreationAut(_frame, GroupeSelectionne);
        VueCreationAut VCA = new VueCreationAut(MCA);
        ControleurCreationAut CCA = new ControleurCreationAut(MCA,VCA);

        _frame.setContentPane(VCA);
        _frame.revalidate();
        _frame.repaint();
    }

    public Groupe[] getGroupes() {
        return _groupes;
    }

    public int getGroupeSelectionne() {
        return GroupeSelectionne;
    }

    public void setGroupeSelectionne(int groupeSelectionne) {
        GroupeSelectionne = groupeSelectionne;
    }

}
