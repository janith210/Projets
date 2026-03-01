package application.controleurs;

import application.modeles.ModeleCreationMan;
import application.vues.VueCreationMan;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControleurCreationMan implements ActionListener {

    private ModeleCreationMan _modele;
    private VueCreationMan _vue;

    public ControleurCreationMan(ModeleCreationMan modele, VueCreationMan vue) {
        this._modele = modele;
        this._vue = vue;

        _vue.getBTNAccueil().addActionListener(this);
        _vue.getBTNValider().addActionListener(this);

        abonnerBoutonsDynamiques();
    }

    /**
     * Cette méthode est CRUCIALE.
     * Comme la Vue détruit et recrée les boutons à chaque changement,
     * il faut remettre "this" comme écouteur sur les NOUVEAUX boutons à chaque fois.
     */
    private void abonnerBoutonsDynamiques() {
        for (JButton btn : _vue.getBtnsRetirer()) {
            btn.removeActionListener(this);
            btn.addActionListener(this);
        }

        for (JButton btn : _vue.getBtnsAjouter()) {
            btn.removeActionListener(this);
            btn.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == _vue.getBTNAccueil()) {
            _modele.creationGroupeAccueil();
        }

        else if (source == _vue.getBTNValider()) {
            JOptionPane.showMessageDialog(_vue, "Modifications terminées !");
            _modele.creationGroupeAccueil();
        }

        else {
            try {
                int idEtudiant = Integer.parseInt(e.getActionCommand());

                if (_vue.getBtnsAjouter().contains(source)) {
                    _modele.ajouterEtudiantAuGroupe(idEtudiant);
                }
                else if (_vue.getBtnsRetirer().contains(source)) {
                    _modele.retirerEtudiantDuGroupe(idEtudiant);
                }

                _vue.rafraichirListes();

                abonnerBoutonsDynamiques();

            } catch (NumberFormatException ex) {
                System.err.println("Erreur : ID invalide dans le bouton");
            }
        }
    }
}