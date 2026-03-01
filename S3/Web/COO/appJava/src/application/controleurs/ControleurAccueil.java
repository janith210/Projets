package application.controleurs;

import application.modeles.ModeleAccueil;
import application.vues.VueAccueil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControleurAccueil implements ActionListener{

    static public final String ACTION_MANUEL = "Manuellement";
    static public final String ACTION_AUTOMATIQUE = "Automatiquement";

    ModeleAccueil _modele;
    VueAccueil _vue;

    public ControleurAccueil(ModeleAccueil modele, VueAccueil vue) {
        this._modele = modele;
        this._vue = vue;

        _vue.getBTNautomatique().addActionListener(this);
        _vue.getBTNmanuel().addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String boutonNom = "";
        if (e.getSource() instanceof JButton) {
            JButton boutonSource = (JButton) e.getSource();
            boutonNom = boutonSource.getText();
        }
        if (e.getActionCommand() == ACTION_AUTOMATIQUE) {
            _modele.creationGroupeAutomatique();
        }
        else if (e.getActionCommand() == ACTION_MANUEL) {
            _modele.creationGroupeManuel();
        }
    }

}