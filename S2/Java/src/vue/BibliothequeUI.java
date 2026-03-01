package vue;

import javax.swing.*;
import java.awt.*;

/**
 * Interface graphique pour afficher les horaires d'ouverture de la bibliothèque.
 * @author Jimmy Zheng
 */
public class BibliothequeUI extends JFrame {
    /**
     * Constructeur qui initialise l'interface avec les horaires d'ouverture.
     */
    public BibliothequeUI() {
        setTitle("Bibliothèque");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JTextPane pane = new JTextPane();
        pane.setContentType("text/html");
        pane.setText(
            "<html><body style='background-color:#8d6e63; color:white; font-family:Arial; font-size:14px; padding:10px;'>"
            + "<b>Lundi :</b> 7h - 19h30<br>"
            + "<b>Mardi :</b> 8h - 13h30 & 17h30 - 19h<br>"
            + "<b>Mercredi :</b> 11h30 - 17h<br>"
            + "<b>Jeudi :</b> 11h30 - 13h30 & 17h30 - 19h<br>"
            + "<b>Vendredi :</b> 11h30 - 13h30 & 17h30 - 19h<br>"
            + "<b>Samedi :</b> 9h - 18h<br>"
            + "<b>Dimanche :</b> 9h - 13h30"
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
        new BibliothequeUI().setVisible(true);
    }
}