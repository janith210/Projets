package application.vues;

import application.modeles.Etudiant;
import application.modeles.ModeleCreationMan;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class VueCreationMan extends JPanel {

    private ModeleCreationMan _modele;

    private JButton BTNAccueil;
    private JButton BTNValider;
    private JLabel LBLtitreGroupe;

    private JPanel PNLListeGroupe;
    private JPanel PNLListeEtudiants;

    public ArrayList<JButton> btnsRetirer = new ArrayList<>();
    public ArrayList<JButton> btnsAjouter = new ArrayList<>();

    public VueCreationMan(ModeleCreationMan modele) {
        this._modele = modele;

        setLayout(new BorderLayout());
        setBackground(Color.decode("#F0F4F8")); // Fond Gris Clair

        JPanel PNLEntete = new JPanel(new BorderLayout());
        PNLEntete.setOpaque(false);
        PNLEntete.setBorder(new EmptyBorder(10, 10, 10, 10));

        BTNAccueil = new BoutonArrondi("Accueil", Color.decode("#64748B"), Color.WHITE);
        BTNAccueil.setPreferredSize(new Dimension(100, 35));

        JPanel PNLConteneurBouton = new JPanel(new FlowLayout(FlowLayout.LEFT));
        PNLConteneurBouton.setOpaque(false);
        PNLConteneurBouton.add(BTNAccueil);

        JLabel LBLtitre = new JLabel("Constituer un groupe");
        LBLtitre.setFont(new Font("Arial", Font.BOLD, 22));
        LBLtitre.setForeground(Color.decode("#1E3A8A")); // Bleu Nuit
        LBLtitre.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel LBLsousTitre = new JLabel("Manuellement");
        LBLsousTitre.setFont(new Font("Arial", Font.BOLD, 18));
        LBLsousTitre.setForeground(Color.decode("#334155")); // Gris Foncé
        LBLsousTitre.setHorizontalAlignment(SwingConstants.CENTER);

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


        JPanel PNLCentre = new JPanel(new GridLayout(1, 2, 40, 0)); // 40px d'écart
        PNLCentre.setOpaque(false);
        PNLCentre.setBorder(new EmptyBorder(20, 50, 20, 50));

        JPanel PNLColonneGauche = new JPanel(new BorderLayout(0, 10));
        PNLColonneGauche.setOpaque(false);

        LBLtitreGroupe = new JLabel("Groupe " + _modele.get_idGroupe());
        LBLtitreGroupe.setFont(new Font("Arial", Font.BOLD, 20));
        LBLtitreGroupe.setForeground(Color.decode("#1E3A8A")); // Bleu Nuit
        LBLtitreGroupe.setHorizontalAlignment(SwingConstants.CENTER);

        PNLListeGroupe = new PanelArrondi(Color.WHITE);
        PNLListeGroupe.setLayout(new BoxLayout(PNLListeGroupe, BoxLayout.Y_AXIS));
        PNLListeGroupe.setBorder(new EmptyBorder(10, 10, 10, 10));

        JScrollPane scrollGauche = new JScrollPane(PNLListeGroupe);
        scrollGauche.setBorder(null);
        scrollGauche.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollGauche.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollGauche.getVerticalScrollBar().setUnitIncrement(16);
        scrollGauche.setOpaque(false);
        scrollGauche.getViewport().setOpaque(false);

        PNLColonneGauche.add(LBLtitreGroupe, BorderLayout.NORTH);
        PNLColonneGauche.add(scrollGauche, BorderLayout.CENTER);


        JPanel PNLColonneDroite = new JPanel(new BorderLayout(0, 10));
        PNLColonneDroite.setOpaque(false);

        JLabel LBLtitreListe = new JLabel("Liste des Etudiants Disponibles");
        LBLtitreListe.setFont(new Font("Arial", Font.BOLD, 20));
        LBLtitreListe.setForeground(Color.decode("#1E3A8A")); // Bleu Nuit
        LBLtitreListe.setHorizontalAlignment(SwingConstants.CENTER);

        PNLListeEtudiants = new PanelArrondi(Color.WHITE);
        PNLListeEtudiants.setLayout(new BoxLayout(PNLListeEtudiants, BoxLayout.Y_AXIS));
        PNLListeEtudiants.setBorder(new EmptyBorder(10, 10, 10, 10));

        JScrollPane scrollDroite = new JScrollPane(PNLListeEtudiants);
        scrollDroite.setBorder(null);
        scrollDroite.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollDroite.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollDroite.getVerticalScrollBar().setUnitIncrement(16);
        scrollDroite.setOpaque(false);
        scrollDroite.getViewport().setOpaque(false);

        PNLColonneDroite.add(LBLtitreListe, BorderLayout.NORTH);
        PNLColonneDroite.add(scrollDroite, BorderLayout.CENTER);

        PNLCentre.add(PNLColonneGauche);
        PNLCentre.add(PNLColonneDroite);


        JPanel PNLBas = new JPanel(new FlowLayout(FlowLayout.CENTER));
        PNLBas.setOpaque(false);
        PNLBas.setBorder(new EmptyBorder(10, 0, 20, 0));

        BTNValider = new BoutonArrondi("Valider", Color.decode("#22C55E"), Color.WHITE);
        BTNValider.setPreferredSize(new Dimension(150, 45));

        PNLBas.add(BTNValider);

        add(PNLEntete, BorderLayout.NORTH);
        add(PNLCentre, BorderLayout.CENTER);
        add(PNLBas, BorderLayout.SOUTH);

        rafraichirListes();
    }


    public void rafraichirListes() {
        // 1. Nettoyage complet
        PNLListeGroupe.removeAll();
        PNLListeEtudiants.removeAll();
        btnsRetirer.clear();
        btnsAjouter.clear();
        Etudiant[] lesEtudiants = _modele.get_etudiants();
        int idGroupeActuel = _modele.get_idGroupe();

        if (lesEtudiants != null) {
            for (Etudiant e : lesEtudiants) {

                if (e.getNumGroupe() == idGroupeActuel) {
                    JPanel PNLLigne = creerLigneEtudiant(e, true);
                    PNLListeGroupe.add(PNLLigne);
                    PNLListeGroupe.add(Box.createRigidArea(new Dimension(0, 5))); // Espace
                }

                else if (e.getNumGroupe() == 0) {
                    JPanel PNLLigne = creerLigneEtudiant(e, false);
                    PNLListeEtudiants.add(PNLLigne);
                    PNLListeEtudiants.add(Box.createRigidArea(new Dimension(0, 5))); // Espace
                }
            }
        }

        PNLListeGroupe.revalidate();
        PNLListeGroupe.repaint();
        PNLListeEtudiants.revalidate();
        PNLListeEtudiants.repaint();
    }

     private JPanel creerLigneEtudiant(Etudiant e, boolean isDansLeGroupe) {

        JPanel PNLLigneEtudiant = new JPanel(new BorderLayout());
        PNLLigneEtudiant.setBackground(Color.WHITE); // Fond blanc pour se fondre dans la liste
        PNLLigneEtudiant.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        PNLLigneEtudiant.setBorder(new EmptyBorder(5, 10, 5, 10));

        JLabel lblNom = new JLabel(e.getNomEtudiant() + " " + e.getPrenomEtudiant());
        lblNom.setFont(new Font("Arial", Font.PLAIN, 14));
        lblNom.setForeground(Color.decode("#334155"));

        JButton btnAction = new JButton();

        btnAction.setMargin(new Insets(0, 0, 0, 0));

        btnAction.setPreferredSize(new Dimension(45, 30));
        btnAction.setBorderPainted(false);
        btnAction.setContentAreaFilled(false);
        btnAction.setFocusPainted(false);
        btnAction.setFont(new Font("Arial", Font.BOLD, 22));

        btnAction.setActionCommand(String.valueOf(e.getNumEtudiant()));

        if (isDansLeGroupe) {
            btnAction.setText("-");
            btnAction.setForeground(Color.RED);
            btnsRetirer.add(btnAction);
        } else {
            btnAction.setText("+");
            btnAction.setForeground(Color.decode("#22C55E"));
            btnsAjouter.add(btnAction);
        }

        PNLLigneEtudiant.add(lblNom, BorderLayout.CENTER);
        PNLLigneEtudiant.add(btnAction, BorderLayout.EAST);

        return PNLLigneEtudiant;
    }

    public JButton getBTNAccueil() { return BTNAccueil; }
    public JButton getBTNValider() { return BTNValider; }
    public ArrayList<JButton> getBtnsRetirer() { return btnsRetirer; }
    public ArrayList<JButton> getBtnsAjouter() { return btnsAjouter; }

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