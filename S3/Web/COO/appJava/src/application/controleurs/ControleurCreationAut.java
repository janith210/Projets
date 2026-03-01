package application.controleurs;

import application.modeles.ModeleCreationAut;
import application.vues.VueCreationAut;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControleurCreationAut implements ActionListener {

    private ModeleCreationAut _modele;
    private VueCreationAut _vue;

    public ControleurCreationAut(ModeleCreationAut modele, VueCreationAut vue) {
        this._modele = modele;
        this._vue = vue;

        this._modele.setVue(this._vue);
        _vue.getBTNAccueil().addActionListener(this);

        _vue.getBTNAffecter().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == _vue.getBTNAccueil()) {
            _modele.creationGroupeAccueil();
        }

        else if (source == _vue.getBTNAffecter()) {
            String algoChoisi = _vue.getAlgoSelectionne();

            if (algoChoisi == null) {
                JOptionPane.showMessageDialog(_vue,
                        "Veuillez d'abord sélectionner un algorithme dans la liste de droite !",
                        "Attention", JOptionPane.WARNING_MESSAGE);
                return;
            }

            _modele.executerAffectation(algoChoisi);
        }
    }
}