package vue;

//import CiteUniversitaire.*;
import modeles.Etudiant;
import modeles.Maison;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class EtudiantUI extends JFrame{

    Maison maisonetudiant;
    JPanel etudiantpannel;
    private HomePageMaison.CardClickListener cardClickListener;
    
    void SetMaison (Maison maisonetudiant) {
        this.maisonetudiant = maisonetudiant;
    }
    
    public EtudiantUI(HomePageMaison.CardClickListener listener) {
        this.cardClickListener = listener;
        initializeUI();
    }
    
    EtudiantUI() {
        this.cardClickListener = null;
        initializeUI();
    }
    
    //public maisonOriginelle()
    
    private void initializeUI() {
        etudiantpannel = new JPanel();
        etudiantpannel.setLayout(new BorderLayout());

        JPanel formPanel = new JPanel();
        formPanel.setBackground(new Color(255, 235, 238));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        formPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        String[] labels = {"Prénom", "Nom", "Nationalité", "Date Naissance", "Etude", "Email"};
        JTextField[] fields = new JTextField[labels.length];

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        JLabel title = new JLabel("Ajouter un étudiant");
        title.setFont(new Font("Arial", Font.BOLD, 16));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        formPanel.add(title, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;

        for (int i = 0; i < labels.length; i++) {
            gbc.gridx = 0;
            JLabel lbl = new JLabel(labels[i]);
            formPanel.add(lbl, gbc);

            gbc.gridx = 1;
            fields[i] = new JTextField(15);
            fields[i].setBackground(Color.DARK_GRAY);
            fields[i].setForeground(Color.WHITE);
            formPanel.add(fields[i], gbc);

            gbc.gridy++;
        }

        gbc.gridx = 0;
        gbc.gridwidth = 1;
        JButton saveButton = new JButton("Enregistrer");
        saveButton.setBackground(Color.GREEN);
        saveButton.setForeground(Color.WHITE);
        formPanel.add(saveButton, gbc);

        gbc.gridx = 1;
        JButton clearButton = new JButton("Effacer");
        clearButton.setBackground(Color.RED);
        clearButton.setForeground(Color.WHITE);
        formPanel.add(clearButton, gbc);

        ArrayList<Etudiant> listeEtudiants = new ArrayList<>();

        saveButton.addActionListener(e -> {
            String prenom = fields[0].getText();
            String nom = fields[1].getText();
            String nationalite = fields[2].getText();
            String dateNaissance = fields[3].getText();
            String etude = fields[4].getText();
            String email = fields[5].getText(); 


            int id = listeEtudiants.size() + 1;

            Etudiant nouvelEtudiant = new Etudiant(id, nom, prenom, nationalite, dateNaissance, etude, email);
            listeEtudiants.add(nouvelEtudiant);
            maisonetudiant.ajouteEtudiant(nouvelEtudiant);

            System.out.println("Etudiant enregistré : "
                    + nouvelEtudiant.get_prenomEtudiant() + " "
                    + nouvelEtudiant.get_nomEtudiant()
                    + ", Nationalité : " + nouvelEtudiant.get_nationaliteEtudiant()
                    + ", Date naissance : " + dateNaissance
                    + ", Etude : " + etude
                    + ", ID : " + id + ", email : " + email);

            System.out.println("Liste actuelle dans Maison :");            
            maisonetudiant.afficheetudiant();
            
            JOptionPane.showMessageDialog(etudiantpannel, "Étudiant ajouté avec succès!");
            
            for (JTextField field : fields) {
                field.setText("");
            }
        });

        clearButton.addActionListener(e -> {
            for (JTextField field : fields) {
                field.setText("");
            }
        });

        etudiantpannel.add(formPanel, BorderLayout.CENTER);

        JPanel navigationPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        navigationPanel.setBackground(new Color(255, 235, 238));
        
        JButton backButton = new JButton("← Retour à la maison");
        backButton.setBackground(new Color(0, 128, 0));
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Arial", Font.BOLD, 14));
        backButton.setFocusPainted(false);
        
        backButton.addActionListener(e -> {
            if (cardClickListener != null && maisonetudiant != null) {
                cardClickListener.onCardClick(maisonetudiant.get_nomMaison());
            }
        });
        
        navigationPanel.add(backButton);
        etudiantpannel.add(navigationPanel, BorderLayout.SOUTH);
    }
    
    public JPanel getEtudiantPanel() {
        return etudiantpannel;
    }
}