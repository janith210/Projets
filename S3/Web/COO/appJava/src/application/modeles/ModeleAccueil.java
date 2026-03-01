package application.modeles;

import application.controleurs.ControleurAutomatique;
import application.controleurs.ControleurManuel;
import application.vues.VueAutomatique;
import application.vues.VueManuel;

import javax.swing.*;


public class ModeleAccueil{

    private JFrame _frame;

    public ModeleAccueil(JFrame frame) {
        this._frame = frame;
    }

    public void creationGroupeManuel() {
        ModeleManuel MM = new ModeleManuel(_frame);
        VueManuel VM = new VueManuel(MM);
        ControleurManuel CM = new ControleurManuel(MM,VM);

        _frame.setContentPane(VM);
        _frame.revalidate();
        _frame.repaint();
    }

    public void creationGroupeAutomatique() {
        ModeleAutomatique MA = new ModeleAutomatique(_frame);
        VueAutomatique VA = new VueAutomatique(MA);
        ControleurAutomatique CA = new ControleurAutomatique(MA,VA);

        _frame.setContentPane(VA);
        _frame.revalidate();
        _frame.repaint();
    }
}