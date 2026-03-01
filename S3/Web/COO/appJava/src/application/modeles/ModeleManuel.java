package application.modeles;

import application.controleurs.ControleurAccueil;
import application.controleurs.ControleurCreationMan;
import application.services.ServiceApi;
import application.vues.VueAccueil;
import application.vues.VueCreationMan;

import javax.swing.*;

public class ModeleManuel {
    private JFrame _frame;
    private ServiceApi _api;
    private Groupe[] _groupes;
    private int GroupeSelectionne;

    public ModeleManuel(JFrame frame) {
        this._frame = frame;
        this._api = new ServiceApi();
        chargerGroupes();
    }

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

    public void creationGroupeCreaMan() {
        ModeleCreationMan MCM = new ModeleCreationMan(_frame, GroupeSelectionne);
        VueCreationMan VCM = new VueCreationMan(MCM);
        ControleurCreationMan CCM = new ControleurCreationMan(MCM,VCM);

        _frame.setContentPane(VCM);
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