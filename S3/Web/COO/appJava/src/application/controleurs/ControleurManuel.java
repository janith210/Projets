package application.controleurs;

import application.modeles.ModeleManuel;
import application.vues.VueManuel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControleurManuel implements ActionListener {

    ModeleManuel _modele;
    VueManuel _vue;

    public ControleurManuel(ModeleManuel modele, VueManuel vue) {
        this._modele = modele;
        this._vue = vue;

        _vue.getBTNAccueil().addActionListener(this);


        for (JButton BTNGroupe :_vue.getButtonGroupe()) {
            BTNGroupe.addActionListener(this);
        }

    }

    public void actionPerformed(ActionEvent e) {
        String boutonNom = "";
        if (e.getSource() instanceof JButton) {
            JButton boutonSource = (JButton) e.getSource();
            boutonNom = boutonSource.getText();
        }

        if (e.getActionCommand() == "Accueil") {
            _modele.creationGroupeAccueil();
        }

        int idGroupe = Integer.parseInt(e.getActionCommand());
        System.out.println("Groupe cliqué : " + idGroupe);
        _modele.setGroupeSelectionne(idGroupe);
        _modele.creationGroupeCreaMan();



    }
}
