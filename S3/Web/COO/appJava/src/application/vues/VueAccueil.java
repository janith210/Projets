package application.vues;

import application.modeles.ModeleAccueil;

import javax.swing.*;
import java.awt.*;

public class VueAccueil extends JPanel {

    private ModeleAccueil _modele;

    private JLabel LBLtitre;
    private JButton BTNautomatique;
    private JButton BTNmanuel;
    private JPanel PNLtitre;
    private JPanel PNLbouton;

    public VueAccueil(ModeleAccueil modele) {
        this._modele = modele;

        setBackground(Color.decode("#F0F4F8"));
        setLayout(new GridLayout(2, 1));

        LBLtitre = new JLabel("Constituer un groupe");
        LBLtitre.setForeground(Color.decode("#1E3A8A")); // Bleu nuit pour le contraste
        LBLtitre.setFont(new Font("Arial", Font.BOLD, 26)); // Un peu plus grand

        BTNautomatique = new BoutonArrondi("Automatiquement", Color.decode("#22C55E"), Color.WHITE);
        BTNautomatique.setPreferredSize(new Dimension(250, 55));

        BTNmanuel = new BoutonArrondi("Manuellement", Color.decode("#22C55E"), Color.WHITE);
        BTNmanuel.setPreferredSize(new Dimension(250, 55));

        PNLtitre = new JPanel();
        PNLtitre.setLayout(new FlowLayout());
        PNLtitre.setOpaque(false);
        PNLtitre.add(LBLtitre);

        PNLbouton = new JPanel();
        PNLbouton.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 0));
        PNLbouton.setOpaque(false);
        PNLbouton.add(BTNmanuel);
        PNLbouton.add(BTNautomatique);

        add(PNLtitre);
        add(PNLbouton);
    }

    public JButton getBTNautomatique() {
        return BTNautomatique;
    }

    public JButton getBTNmanuel() {
        return BTNmanuel;
    }

    // =========================================================================
    // --- CLASSES INTERNES POUR LE STYLE (ARRONDIS) ---
    // =========================================================================

    // 1. Bouton Arrondi (Sans hover complexe)
    private static class BoutonArrondi extends JButton {
        private Color couleurFond;
        private int rayon = 25; // Arrondi plus doux

        public BoutonArrondi(String texte, Color fond, Color texteCouleur) {
            super(texte);
            this.couleurFond = fond;

            // Configuration pour enlever le style par défaut moche
            setContentAreaFilled(false);
            setFocusPainted(false);
            setBorderPainted(false);
            setFont(new Font("Arial", Font.BOLD, 16));
            setForeground(texteCouleur);
            setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        // Permet de changer la couleur dynamiquement si besoin
        @Override
        public void setBackground(Color bg) {
            super.setBackground(bg);
            this.couleurFond = bg;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            // Anti-aliasing pour des bords lisses
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g2.setColor(couleurFond);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), rayon, rayon);

            super.paintComponent(g);
            g2.dispose();
        }
    }
}