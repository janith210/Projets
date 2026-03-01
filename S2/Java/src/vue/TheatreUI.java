package vue;

import javax.swing.*;
import java.awt.*;

/**
 * Interface graphique pour afficher les spectacles du théâtre.
 * @author Jimmy Zheng
 */
public class TheatreUI extends JFrame {
    /**
     * Constructeur qui initialise l'interface avec les spectacles programmés.
     */
    public TheatreUI() {
        setTitle("Théâtre");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JTextPane pane = new JTextPane();
        pane.setContentType("text/html");
        pane.setText(
            "<html><body style='background-color:#c62828; color:black; font-family:Arial; font-size:14px; padding:10px;'>"
            + "<b>Mon Petit Grand Frère - Comédie Bastille :</b><br>"
            + "Du 14/03/25 au 20/03/25 à 19h<br><br>"

            + "<b>Et Si c'était Elle ? :</b><br>"
            + "Du 21/03/25 au 28/03/25 à 16h<br><br>"

            + "<b>Chaos - Tout Rentrera dans le Désordre :</b><br>"
            + "Du 29/03/25 au 02/04/25 à 22h"
            + "</body></html>"
        );
        pane.setEditable(false);

        JScrollPane scroll = new JScrollPane(pane);
        scroll.setBorder(BorderFactory.createLineBorder(new Color(0, 230, 230), 1));
        scroll.setBackground(new Color(198, 40, 40));

        add(scroll);
    }

    /**
     * Méthode principale pour lancer l'interface.
     * @param args Arguments de la ligne de commande (non utilisés)
     */
    public static void main(String[] args) {
        new TheatreUI().setVisible(true);
    }
}