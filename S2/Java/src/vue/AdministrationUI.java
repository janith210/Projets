package vue;

import javax.swing.*;
import java.awt.*;

/**
 * Interface graphique pour afficher les horaires d'ouverture de l'administration.
 * @author Jimmy Zheng
 */
public class AdministrationUI extends JFrame {
    /**
     * Constructeur qui initialise l'interface avec les horaires d'ouverture.
     */
    public AdministrationUI() {
        setTitle("Administration");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JTextPane pane = new JTextPane();
        pane.setContentType("text/html");
        pane.setText(
            "<html><body style='background-color:red; color:white; font-family:Arial; font-size:14px; padding:10px;'>"
            + "<b>Lundi :</b> 7h30 - 13h30<br>"
            + "<b>Mardi :</b> 7h30 - 13h30 & 17h30 - 19h<br>"
            + "<b>Mercredi :</b> 7h30 - 17h<br>"
            + "<b>Jeudi :</b> 7h30 - 13h30 & 17h30 - 19h<br>"
            + "<b>Vendredi :</b> 7h30 - 13h30 & 17h30 - 19h<br>"
            + "<b>Samedi :</b> 7h - 18h<br>"
            + "<b>Dimanche :</b> 7h - 13h30"
            + "</body></html>"
        );
        pane.setEditable(false);
        add(new JScrollPane(pane));
    }

    /**
     * Méthode principale pour lancer l'interface.
     * @param args Arguments de la ligne de commande (non utilisés)
     */
    public static void main(String[] args) {
        new AdministrationUI().setVisible(true);
    }
}