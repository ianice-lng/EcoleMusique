import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.creeDataBase();
        JFrame framePrincipal = new JFrame("Gestion des cours de musique");
        framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePrincipal.setSize(800, 600);
        JTextArea textArea = new JTextArea(10, 50);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setText(main.afficherListeCours());

        JButton buttonSupprimerCours = new JButton("Supprimer un cours");
        buttonSupprimerCours.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    Cours cours = Cours.rechercheCours((String) JOptionPane.showInputDialog(null, "Choisissez un étudiant", "Liste Etudiant", JOptionPane.QUESTION_MESSAGE, null, Cours.getListeCoursNom(), ""));

                    if (cours != null) {
                        cours.supprimerCours();
                        textArea.setText(main.afficherListeCours());
                        return;
                    }


                    JOptionPane.showMessageDialog(null, "Cours non trouvé");


            };
       });

        JButton buttonModifierNiveauCompetence = new JButton("Modifier le niveau de compétence d'un étudiant");
        buttonModifierNiveauCompetence.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String etudiantRecherche = (String) JOptionPane.showInputDialog(null, "Choisissez un étudiant", "Liste Etudiant", JOptionPane.QUESTION_MESSAGE, null, ListeEtudiants.getListeEtudiant(), "");
                Etudiant etudiant = ListeEtudiants.rechercheEtudiant(etudiantRecherche);
                    if (etudiant != null) {
                        String niveau = (String) JOptionPane.showInputDialog(null, "Choisissez le niveau de compétence", "Niveau de compétence", JOptionPane.QUESTION_MESSAGE, null, Etudiant.getListeNiveauCompetence(), etudiant.getNiveauCompotences());
                        if (niveau != null) {
                            etudiant.setNiveauCompotences(niveau);
                            textArea.setText(main.afficherListeCours());
                            return;
                        }

                }
                JOptionPane.showMessageDialog(null, "Etudiant non trouvé");
            }
        });

        JButton buttonAjouterEtudiant = new JButton("Ajouter un étudiant");
        buttonAjouterEtudiant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nom = JOptionPane.showInputDialog("Nom de l'étudiant");
                String prenom = JOptionPane.showInputDialog("Prénom de l'étudiant");
                int age = Integer.parseInt(JOptionPane.showInputDialog("Age de l'étudiant"));
                String niveau = (String) JOptionPane.showInputDialog(null, "Choisissez le niveau de compétence", "Niveau de compétence", JOptionPane.QUESTION_MESSAGE, null, Etudiant.getListeNiveauCompetence(), "");
                if (nom != null && prenom != null && niveau != null && age > 0) {
                    Etudiant etudiant = new Etudiant(nom, prenom, age, niveau);
                    textArea.setText(main.afficherListeCours());
                }
            }
        });

        JButton buttonAjouterCours = new JButton("Ajouter un cours");
        buttonAjouterCours.addActionListener(new ActionListener() {
                                                 @Override
                                                 public void actionPerformed(ActionEvent e) {
                                                     String titre = JOptionPane.showInputDialog("Titre du cours");
                                                     String instrument = (String) JOptionPane.showInputDialog(null, "Choisissez l'instrument", "Instrument", JOptionPane.QUESTION_MESSAGE, null, ListeInstrument.getListeInstrumentNom(), "");
                                                     int duree = Integer.parseInt(JOptionPane.showInputDialog("Durée du cours en minute"));
                                                     if (titre != null && instrument != null && duree > 0) {
                                                         Cours cours = new Cours(titre, ListeInstrument.rechercheInstrument(instrument), duree);
                                                         textArea.setText(main.afficherListeCours());
                                                     }
                                                 }
                                             });

        JButton buttonAjouterProfesseur = new JButton("Ajouter un professeur");
        buttonAjouterProfesseur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nom = JOptionPane.showInputDialog("Nom du professeur");
                String prenom = JOptionPane.showInputDialog("Prénom du professeur");
                int age = Integer.parseInt(JOptionPane.showInputDialog("Age du professeur"));
                String instrument = (String) JOptionPane.showInputDialog(null, "Choisissez l'instrument", "Instrument", JOptionPane.QUESTION_MESSAGE, null, ListeInstrument.getListeInstrumentNom(), "");
                if (nom != null && prenom != null && instrument != null && age > 0) {
                    Professeur professeur = new Professeur(nom, prenom, age, ListeInstrument.rechercheInstrument(instrument));
                    textArea.setText(main.afficherListeCours());
                }
            }
        });

        JButton buttonAjouterInstrument = new JButton("Ajouter un instrument");
        buttonAjouterInstrument.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nom = JOptionPane.showInputDialog("Nom de l'instrument");
                String type = (String) JOptionPane.showInputDialog(null, "Choisissez le type de l'instrument", "Type d'instrument", JOptionPane.QUESTION_MESSAGE, null, Instrument.getListeTypeInstrument(), "");
                if (nom != null && type != null) {
                    Instrument instrument = new Instrument(nom, type);
                    textArea.setText(main.afficherListeCours());
                }
            }
        });

        JButton buttonAjouterEtudiantCours = new JButton("Ajouter un étudiant à un cours");
        buttonAjouterEtudiantCours.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String etudiantRecherche = (String) JOptionPane.showInputDialog(null, "Choisissez un étudiant", "Liste Etudiant", JOptionPane.QUESTION_MESSAGE, null, ListeEtudiants.getListeEtudiant(), "");
                Etudiant etudiant = ListeEtudiants.rechercheEtudiant(etudiantRecherche);
                if (etudiant != null) {
                    String coursRecherche = (String) JOptionPane.showInputDialog(null, "Choisissez un cours", "Liste Cours", JOptionPane.QUESTION_MESSAGE, null, Cours.getListeCoursNom(), "");
                    Cours cours = Cours.rechercheCours(coursRecherche);
                    if (cours != null) {
                        etudiant.inscrireCours(cours);
                        textArea.setText(main.afficherListeCours());
                        return;
                    }
                }
                JOptionPane.showMessageDialog(null, "Etudiant ou cours non trouvé");
            }
        });

        JButton buttonDesinscrireEtudiantCours = new JButton("Désinscrire un étudiant d'un cours");
        buttonDesinscrireEtudiantCours.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String etudiantRecherche = (String) JOptionPane.showInputDialog(null, "Choisissez un étudiant", "Liste Etudiant", JOptionPane.QUESTION_MESSAGE, null, ListeEtudiants.getListeEtudiant(), "");
                Etudiant etudiant = ListeEtudiants.rechercheEtudiant(etudiantRecherche);
                if (etudiant != null) {
                    String coursRecherche = (String) JOptionPane.showInputDialog(null, "Choisissez un cours", "Liste Cours", JOptionPane.QUESTION_MESSAGE, null, Cours.getListeCoursNom(), "");
                    Cours cours = Cours.rechercheCours(coursRecherche);
                    if (cours != null) {
                        etudiant.desinscrireCours(cours);
                        textArea.setText(main.afficherListeCours());
                        return;
                    }
                }
                JOptionPane.showMessageDialog(null, "Etudiant ou cours non trouvé");
            }
        });

        JButton buttonAjouterProfesseurCours = new JButton("Ajouter un professeur à un cours");
        buttonAjouterProfesseurCours.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String professeurRecherche = (String) JOptionPane.showInputDialog(null, "Choisissez un professeur", "Liste Professeur", JOptionPane.QUESTION_MESSAGE, null, ListeProfesseurs.getListeProfesseurNom(), "");
                Professeur professeur = ListeProfesseurs.rechercheProfesseur(professeurRecherche);
                if (professeur != null) {
                    String coursRecherche = (String) JOptionPane.showInputDialog(null, "Choisissez un cours", "Liste Cours", JOptionPane.QUESTION_MESSAGE, null, Cours.getListeCoursNom(), "");
                    Cours cours = Cours.rechercheCours(coursRecherche);
                    if (cours != null) {
                        professeur.donnerCours(cours);
                        textArea.setText(main.afficherListeCours());
                        return;
                    }
                }
                JOptionPane.showMessageDialog(null, "Professeur ou cours non trouvé");
            }
        });

        JButton buttonInfoCours = new JButton("Info Cours");
        buttonInfoCours.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String coursRecherche = (String) JOptionPane.showInputDialog(null, "Choisissez un cours", "Liste Cours", JOptionPane.QUESTION_MESSAGE, null, Cours.getListeCoursNom(), "");
                Cours cours = Cours.rechercheCours(coursRecherche);
                if (cours != null) {
                    String info = cours.toString() + " Etudiants : \n";
                    for (Etudiant etudiant : cours.getEtudiantsInscrit()) {
                        info += " - " + etudiant.getNomPrenom() + "\n";
                    }
                    JOptionPane.showMessageDialog(null, info);
                    return;
                }
                JOptionPane.showMessageDialog(null, "Cours non trouvé");
            }
        });

        JButton buttonInfoEtudiant = new JButton("Info Etudiant");
        buttonInfoEtudiant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String etudiantRecherche = (String) JOptionPane.showInputDialog(null, "Choisissez un étudiant", "Liste Etudiant", JOptionPane.QUESTION_MESSAGE, null, ListeEtudiants.getListeEtudiant(), "");
                Etudiant etudiant = ListeEtudiants.rechercheEtudiant(etudiantRecherche);
                if (etudiant != null) {
                    String info = etudiant.toString() + " Age : " + etudiant.getAge() + " Niveau de compétence : " + etudiant.getNiveauCompotences() + "\n";
                    JOptionPane.showMessageDialog(null, info);
                    return;
                }
                JOptionPane.showMessageDialog(null, "Etudiant non trouvé");
            }
        });

        JButton buttonListeInstrument = new JButton("Liste des instruments");
        buttonListeInstrument.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String listeInstrument = "Liste des instruments : \n";
                for(Instrument instrument : ListeInstrument.getListeInstrument()){
                    listeInstrument += instrument.toString() + "\n";
                }
                JOptionPane.showMessageDialog(null, listeInstrument);
            }
        });


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 2, 10, 10));

        framePrincipal.setLayout(new FlowLayout());

        buttonPanel.add(buttonSupprimerCours);
        buttonPanel.add(buttonModifierNiveauCompetence);
        buttonPanel.add(buttonAjouterEtudiant);
        buttonPanel.add(buttonAjouterCours);
        buttonPanel.add(buttonAjouterProfesseur);
        buttonPanel.add(buttonAjouterInstrument);
        buttonPanel.add(buttonAjouterEtudiantCours);
        buttonPanel.add(buttonDesinscrireEtudiantCours);
        buttonPanel.add(buttonAjouterProfesseurCours);
        buttonPanel.add(buttonInfoCours);
        buttonPanel.add(buttonInfoEtudiant);
        buttonPanel.add(buttonListeInstrument);

        framePrincipal.add(scrollPane, BorderLayout.NORTH); // Texte en haut
        framePrincipal.add(buttonPanel, BorderLayout.CENTER);



        framePrincipal.setVisible(true);

    }


    public void creeDataBase(){
        Instrument piano = new Instrument("Piano", "cordes");
        Instrument guitare = new Instrument("Guitare", "cordes");
        Cours cours1 = new Cours("piano", piano, 60);
        Cours cours2 = new Cours("guitare", guitare, 60);
        Etudiant etudiant1 = new Etudiant("Dupont", "Jean", 20, "debutant");
        Etudiant etudiant2 = new Etudiant("Durand", "Marie", 25, "debutant");
        Etudiant etudiant3 = new Etudiant("Martin", "Paul", 30, "avance");
        Professeur professeur1 = new Professeur("Durand", "Pierre", 40, piano);

        professeur1.donnerCours(cours1);

        etudiant1.inscrireCours(cours1);
        etudiant2.inscrireCours(cours1);
        etudiant3.inscrireCours(cours1);
        etudiant1.inscrireCours(cours2);
        etudiant3.inscrireCours(cours2);
    }
    public  String afficherListeCours(){
        String listeCours = "Liste des cours : \n";

        for(Cours cours : Cours.getListeCours()){
            ArrayList<Professeur> listeProf = ListeProfesseurs.rechercheProfesseurParCours(cours);
            String nomProf = "Aucun professeur";
            if(listeProf.size() > 0){
                nomProf = "";
                for(Professeur prof : listeProf){
                    nomProf += prof.getNomPrenom() + " | ";
                }
            }

            listeCours += cours.getTitre() + "\n" + " -  Prof : "  + nomProf + "\n";
            for(Etudiant etudiant : cours.getEtudiantsInscrit()){
                listeCours += "  -  " + etudiant.getNomPrenom() + "\n";
            }
        }
        return listeCours;
    }
}