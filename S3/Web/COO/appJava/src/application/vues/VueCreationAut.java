package application.vues;

import application.modeles.ModeleCreationAut;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class VueCreationAut extends JPanel {

    private ModeleCreationAut _modele;

    private JButton BTNAccueil;
    private JButton BTNAffecter;
    private JLabel LBLtitreGroupe;
    private JLabel LBLtitreAlgo;

    private JPanel PNLListeAlgoDispo; // Droite (Les algos disponibles)
    private JPanel PNLListeAlgoChoisi; // Gauche (L'algo sélectionné)

    private final String[] LISTE_GLOUTONS = {
            "Parcours/Bac",
            "Bac/Parcours",
            "Taille/Fille",
            "Fille/Taille",
            "Covoiturage/Anglophone",
            "Anglophone/Covoiturage"
    };

    private String algoSelectionne = null;

    public ArrayList<JButton> btnsChoisir = new ArrayList<>();

    public VueCreationAut(ModeleCreationAut modele) {
        this._modele = modele;

        setLayout(new BorderLayout());
        setBackground(Color.decode("#F0F4F8")); // Fond Gris Clair

        JLabel LBLtitre = new JLabel("Constituer un groupe");
        LBLtitre.setFont(new Font("Arial", Font.BOLD, 22));
        LBLtitre.setForeground(Color.decode("#1E3A8A")); // Bleu Nuit
        LBLtitre.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel LBLsousTitre = new JLabel("Automatiquement");
        LBLsousTitre.setFont(new Font("Arial", Font.BOLD, 19));
        LBLsousTitre.setForeground(Color.decode("#334155")); // Gris Foncé
        LBLsousTitre.setHorizontalAlignment(SwingConstants.CENTER);

        BTNAccueil = new BoutonArrondi("Accueil", Color.decode("#64748B"), Color.WHITE);
        BTNAccueil.setPreferredSize(new Dimension(100, 35));

        JPanel PNLEntete = new JPanel(new BorderLayout());
        PNLEntete.setOpaque(false);
        PNLEntete.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel PNLConteneurBouton = new JPanel(new FlowLayout(FlowLayout.LEFT));
        PNLConteneurBouton.setOpaque(false);
        PNLConteneurBouton.add(BTNAccueil);

        JPanel PNLConteneurTitres = new JPanel(new GridLayout(2, 1));
        PNLConteneurTitres.setOpaque(false);
        PNLConteneurTitres.add(LBLtitre);
        PNLConteneurTitres.add(LBLsousTitre);

        JPanel PNLEquilibrage = new JPanel();
        PNLEquilibrage.setOpaque(false);
        PNLEquilibrage.setPreferredSize(PNLConteneurBouton.getPreferredSize());

        PNLEntete.add(PNLConteneurBouton, BorderLayout.WEST);
        PNLEntete.add(PNLConteneurTitres, BorderLayout.CENTER);
        PNLEntete.add(PNLEquilibrage, BorderLayout.EAST);

        JPanel PNLCentre = new JPanel(new GridLayout(1, 2, 40, 0));
        PNLCentre.setOpaque(false);
        PNLCentre.setBorder(new EmptyBorder(20, 50, 40, 50));

        JPanel PNLColonneGauche = new JPanel(new BorderLayout(0, 10));
        PNLColonneGauche.setOpaque(false);

        JPanel PNLTitreGauche = new JPanel(new GridLayout(2, 1, 0, 5));
        PNLTitreGauche.setOpaque(false);

        LBLtitreGroupe = new JLabel("Groupe " + (_modele != null ? _modele.get_idGroupe() : "X"));
        LBLtitreGroupe.setFont(new Font("Arial", Font.BOLD, 20));
        LBLtitreGroupe.setForeground(Color.decode("#1E3A8A")); // Bleu Nuit
        LBLtitreGroupe.setHorizontalAlignment(SwingConstants.CENTER);

        LBLtitreAlgo = new JLabel("Algorithme choisi");
        LBLtitreAlgo.setFont(new Font("Arial", Font.BOLD, 18));
        LBLtitreAlgo.setForeground(Color.decode("#1E3A8A")); // Bleu Nuit
        LBLtitreAlgo.setHorizontalAlignment(SwingConstants.CENTER);

        PNLTitreGauche.add(LBLtitreGroupe);
        PNLTitreGauche.add(LBLtitreAlgo);

        PNLListeAlgoChoisi = new PanelArrondi(Color.WHITE);
        PNLListeAlgoChoisi.setLayout(new BoxLayout(PNLListeAlgoChoisi, BoxLayout.Y_AXIS));
        PNLListeAlgoChoisi.setBorder(new EmptyBorder(10, 10, 10, 10));

        JScrollPane scrollGauche = new JScrollPane(PNLListeAlgoChoisi);
        scrollGauche.setBorder(null);
        scrollGauche.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollGauche.getViewport().setOpaque(false);
        scrollGauche.setOpaque(false);

        BTNAffecter = new BoutonArrondi("Affecter les Etudiants", Color.decode("#22C55E"), Color.WHITE);
        BTNAffecter.setPreferredSize(new Dimension(250, 45));

        JPanel PNLBoutonContainer = new JPanel(new FlowLayout(FlowLayout.CENTER));
        PNLBoutonContainer.setOpaque(false);
        PNLBoutonContainer.setBorder(new EmptyBorder(20, 0, 0, 0));
        PNLBoutonContainer.add(BTNAffecter);

        PNLColonneGauche.add(PNLTitreGauche, BorderLayout.NORTH);
        PNLColonneGauche.add(scrollGauche, BorderLayout.CENTER);
        PNLColonneGauche.add(PNLBoutonContainer, BorderLayout.SOUTH);

        JPanel PNLColonneDroite = new JPanel(new BorderLayout(0, 10));
        PNLColonneDroite.setOpaque(false);

        JLabel LBLtitreListe = new JLabel("Algorithmes disponibles");
        LBLtitreListe.setFont(new Font("Arial", Font.BOLD, 20));
        LBLtitreListe.setForeground(Color.decode("#1E3A8A")); // Bleu Nuit
        LBLtitreListe.setHorizontalAlignment(SwingConstants.CENTER);

        PNLListeAlgoDispo = new PanelArrondi(Color.WHITE);
        PNLListeAlgoDispo.setLayout(new BoxLayout(PNLListeAlgoDispo, BoxLayout.Y_AXIS));
        PNLListeAlgoDispo.setBorder(new EmptyBorder(10, 10, 10, 10));

        JScrollPane scrollDroite = new JScrollPane(PNLListeAlgoDispo);
        scrollDroite.setBorder(null);
        scrollDroite.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollDroite.getViewport().setOpaque(false);
        scrollDroite.setOpaque(false);

        PNLColonneDroite.add(LBLtitreListe, BorderLayout.NORTH);
        PNLColonneDroite.add(scrollDroite, BorderLayout.CENTER);

        PNLCentre.add(PNLColonneGauche);
        PNLCentre.add(PNLColonneDroite);

        add(PNLEntete, BorderLayout.NORTH);
        add(PNLCentre, BorderLayout.CENTER);

        mettreAJourListesAlgo();
    }

    public void mettreAJourListesAlgo() {
        PNLListeAlgoChoisi.removeAll();
        PNLListeAlgoDispo.removeAll();

        if (algoSelectionne != null) {
            JButton btn = creerBoutonAlgo(algoSelectionne, true);
            PNLListeAlgoChoisi.add(Box.createVerticalGlue());
            PNLListeAlgoChoisi.add(btn);
            PNLListeAlgoChoisi.add(Box.createVerticalGlue());
        } else {
            JLabel lbl = new JLabel("Aucun algorithme sélectionné");
            lbl.setForeground(Color.GRAY);
            lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
            PNLListeAlgoChoisi.add(Box.createVerticalGlue());
            PNLListeAlgoChoisi.add(lbl);
            PNLListeAlgoChoisi.add(Box.createVerticalGlue());
        }

        for (String algo : LISTE_GLOUTONS) {
            if (!algo.equals(algoSelectionne)) {
                JButton btn = creerBoutonAlgo(algo, false);
                PNLListeAlgoDispo.add(btn);
                PNLListeAlgoDispo.add(Box.createRigidArea(new Dimension(0, 10)));
            }
        }

        PNLListeAlgoChoisi.revalidate();
        PNLListeAlgoChoisi.repaint();
        PNLListeAlgoDispo.revalidate();
        PNLListeAlgoDispo.repaint();
    }

    private JButton creerBoutonAlgo(String nomAlgo, boolean estSelectionne) {
        JButton btn;

        if (estSelectionne) {
            btn = new BoutonArrondi(nomAlgo + "  (Retirer)", Color.decode("#22C55E"), Color.WHITE);
            btn.setMaximumSize(new Dimension(Short.MAX_VALUE, 45));
            btn.setAlignmentX(Component.CENTER_ALIGNMENT);

            // Action : On le retire
            btn.addActionListener(e -> {
                this.algoSelectionne = null;
                mettreAJourListesAlgo();
            });
        } else {
            btn = new BoutonArrondi(nomAlgo, Color.decode("#334155"), Color.WHITE);
            btn.setMaximumSize(new Dimension(Short.MAX_VALUE, 45));
            btn.setAlignmentX(Component.CENTER_ALIGNMENT);

            btn.addActionListener(e -> {
                this.algoSelectionne = nomAlgo;
                mettreAJourListesAlgo();
            });
        }
        return btn;
    }

    public void afficherResultats(ArrayList<application.modeles.Etudiant> etudiants) {
        PNLListeAlgoChoisi.removeAll();

        JLabel lblTitre = new JLabel("Groupe formé (" + etudiants.size() + ") :");
        lblTitre.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblTitre.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitre.setForeground(Color.decode("#1E3A8A")); // Bleu Nuit
        PNLListeAlgoChoisi.add(lblTitre);
        PNLListeAlgoChoisi.add(Box.createVerticalStrut(15)); // Espace

        for (application.modeles.Etudiant e : etudiants) {
            JPanel pnlEtu = new JPanel(new FlowLayout(FlowLayout.LEFT));
            pnlEtu.setBackground(new Color(240, 245, 255)); // Bleu très pâle
            pnlEtu.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
            pnlEtu.setMaximumSize(new Dimension(Short.MAX_VALUE, 40));
            pnlEtu.setAlignmentX(Component.CENTER_ALIGNMENT);

            JLabel lblNom = new JLabel("• " + e.getNomEtudiant() + " " + e.getPrenomEtudiant());
            lblNom.setFont(new Font("Arial", Font.PLAIN, 14));
            lblNom.setForeground(Color.decode("#334155")); // Texte gris foncé

            pnlEtu.add(lblNom);
            PNLListeAlgoChoisi.add(pnlEtu);
            PNLListeAlgoChoisi.add(Box.createVerticalStrut(5));
        }

        if (BTNAffecter != null) {
            BTNAffecter.setVisible(false);
        }

        PNLListeAlgoChoisi.revalidate();
        PNLListeAlgoChoisi.repaint();
    }

    public JButton getBTNAccueil() { return BTNAccueil; }
    public JButton getBTNAffecter() { return BTNAffecter; }
    public String getAlgoSelectionne() { return algoSelectionne; }

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

    // 2. Panneau Arrondi
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