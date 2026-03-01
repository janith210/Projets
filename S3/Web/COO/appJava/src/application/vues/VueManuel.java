package application.vues;

import application.modeles.Groupe;
import application.modeles.ModeleManuel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class VueManuel extends JPanel {

    ModeleManuel _modele;
    JButton BTNAccueil;
    JLabel LBLtitre;
    JLabel LBLsousTitre;
    JLabel LBLliste;

    JPanel PNLlisteGroupes;
    JScrollPane scrollPane;

    Groupe[] lesGroupes;
    ArrayList<JButton> ButtonGroupe = new ArrayList<>();

    public VueManuel(ModeleManuel modele) {
        _modele = modele;

        setLayout(new BorderLayout());
        setBackground(Color.decode("#F0F4F8")); // Fond Gris Clair

        LBLtitre = new JLabel("Constituer un groupe");
        LBLtitre.setFont(new Font("Arial", Font.BOLD, 22));
        LBLtitre.setForeground(Color.decode("#1E3A8A")); // Bleu Nuit
        LBLtitre.setHorizontalAlignment(SwingConstants.CENTER);

        LBLsousTitre = new JLabel("Manuellement");
        LBLsousTitre.setFont(new Font("Arial", Font.BOLD, 19));
        LBLsousTitre.setForeground(Color.decode("#334155")); // Gris Foncé
        LBLsousTitre.setHorizontalAlignment(SwingConstants.CENTER);

        LBLliste = new JLabel("Liste des Groupes");
        LBLliste.setFont(new Font("Arial", Font.BOLD, 22));
        LBLliste.setForeground(Color.decode("#1E3A8A")); // Bleu Nuit

        BTNAccueil = new BoutonArrondi("Accueil", Color.decode("#64748B"), Color.WHITE);
        BTNAccueil.setPreferredSize(new Dimension(100, 30));

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setOpaque(false);
        headerPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel buttonContainer = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonContainer.setOpaque(false);
        buttonContainer.add(BTNAccueil);

        JPanel titlesContainer = new JPanel(new GridLayout(2, 1));
        titlesContainer.setOpaque(false);
        titlesContainer.add(LBLtitre);
        titlesContainer.add(LBLsousTitre);

        JPanel centrage = new JPanel();
        centrage.setOpaque(false);
        centrage.setPreferredSize(buttonContainer.getPreferredSize());

        headerPanel.add(buttonContainer, BorderLayout.WEST);
        headerPanel.add(titlesContainer, BorderLayout.CENTER);
        headerPanel.add(centrage, BorderLayout.EAST);

        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setOpaque(false);
        contentPanel.setBorder(new EmptyBorder(30, 50, 30, 50));

        JPanel titrListPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        titrListPanel.setOpaque(false);
        titrListPanel.add(LBLliste);
        contentPanel.add(titrListPanel, BorderLayout.NORTH);

        PNLlisteGroupes = new JPanel();
        PNLlisteGroupes.setLayout(new GridLayout(0, 4, 15, 15)); // Espacement 15px
        PNLlisteGroupes.setOpaque(false);

        lesGroupes = _modele.getGroupes();

        if (lesGroupes != null) {
            for (Groupe g : lesGroupes) {
                JButton BTNGroupe = new BoutonArrondi("Groupe " + g.getNum(), Color.decode("#334155"), Color.WHITE);
                BTNGroupe.setActionCommand(String.valueOf(g.getNum()));
                BTNGroupe.setPreferredSize(new Dimension(100, 50));

                PNLlisteGroupes.add(BTNGroupe);
                this.ButtonGroupe.add(BTNGroupe);
            }
        } else {
            JLabel lblErreur = new JLabel("Aucun groupe trouvé ou erreur API");
            lblErreur.setForeground(Color.RED);
            PNLlisteGroupes.add(lblErreur);
        }

        // ScrollPane
        scrollPane = new JScrollPane(PNLlisteGroupes);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);

        contentPanel.add(scrollPane, BorderLayout.CENTER);

        add(headerPanel, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);
    }

    public JButton getBTNAccueil() {
        return BTNAccueil;
    }

    public ArrayList<JButton> getButtonGroupe() {
        return ButtonGroupe;
    }

    // =========================================================================
    // --- CLASSES INTERNES POUR LE STYLE (ARRONDIS) ---
    // =========================================================================

    // 1. Bouton Arrondi
    private static class BoutonArrondi extends JButton {
        private Color couleurFond;
        private int rayon = 20;

        public BoutonArrondi(String texte, Color fond, Color texteCouleur) {
            super(texte);
            this.couleurFond = fond;

            setContentAreaFilled(false);
            setFocusPainted(false);
            setBorderPainted(false);
            setFont(new Font("Arial", Font.BOLD, 14));
            setForeground(texteCouleur);
            setCursor(new Cursor(Cursor.HAND_CURSOR));
        }

        @Override
        public void setBackground(Color bg) {
            super.setBackground(bg);
            this.couleurFond = bg;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(couleurFond);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), rayon, rayon);
            super.paintComponent(g);
            g2.dispose();
        }
    }

    // 2. Panneau Arrondi (Au cas où tu voudrais encadrer la liste plus tard)
    private static class PanelArrondi extends JPanel {
        private Color couleurFond;
        private int rayon = 20;

        public PanelArrondi(Color couleurFond) {
            this.couleurFond = couleurFond;
            setOpaque(false);
        }

        @Override
        public void setBackground(Color bg) {
            super.setBackground(bg);
            this.couleurFond = bg;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(couleurFond);
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), rayon, rayon);
            g2.dispose();
        }
    }
}