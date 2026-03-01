package application;

import application.controleurs.ControleurAccueil;
import application.modeles.ModeleAccueil;
import application.vues.VueAccueil;

import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Gestion des groupes de l'IUT d'Orsay");

        ModeleAccueil modele = new ModeleAccueil(frame);
        VueAccueil vue = new VueAccueil(modele);
        ControleurAccueil controleur = new ControleurAccueil(modele, vue);
        frame.add(vue);
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}