import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Cours {
    private String titre;
    private Instrument instrument;
    private int duree; //durée en minutes
    private LinkedList<Etudiant> etudiantsInscrit = new LinkedList<Etudiant>();
    private static LinkedList<Cours> listeCours = new LinkedList<Cours>();

    public Cours(String titre, Instrument instrument, int duree) {
        this.titre = titre;
        this.instrument = instrument;
        this.duree = duree;

        listeCours.add(this);
    }

    public void inscrireEtudiant(Etudiant etudiant){
        etudiantsInscrit.add(etudiant);
    }
    public void desinscrireEtudiant(Etudiant etudiant){
        etudiantsInscrit.remove(etudiant);
    }


    public static String[] getListeCoursNom(){
        String[] listeCoursName = new String[listeCours.size()];
        int i = 0;
        for(Cours cours : listeCours){
            listeCoursName[i] = cours.getTitre();
            i++;
        }
        return listeCoursName;
    }
    public Etudiant rechercheEtudiant(String nom){
        for(Etudiant etudiant : etudiantsInscrit){
            if(etudiant.getNom() == nom){
                return etudiant;
            }
        }
        return null;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public String getTitre() {
        return titre;
    }

    public LinkedList<Etudiant> getEtudiantsInscrit() {
        return etudiantsInscrit;
    }

    public int getDuree() {
        return duree;
    }

    public static Cours rechercheCours(String titre){
        for(Cours cours : listeCours){
            if(cours.getTitre().equals(titre)){
                return cours;
            }
        }
        return null;
    }

    public static LinkedList<Cours> getListeCours() {
        return listeCours;
    }

    public void supprimerCours(){
        listeCours.remove(this);

        for(Etudiant etudiant : this.getEtudiantsInscrit()){
            etudiant.getCoursInscrit().remove(this);
        }
    }


    @Override
    public String toString(){
        ArrayList<Professeur> listeProf = ListeProfesseurs.rechercheProfesseurParCours(this);
        String nomProf = "Aucun professeur";
        if(listeProf.size() > 0){
            nomProf = "";
            for(Professeur prof : listeProf){
                nomProf += prof.getNomPrenom() + " | ";
            }
        }
        return "Cours de " + titre + " Durée: " + duree + " minutes" + " Instrument: " + instrument +  " Professeur: " + nomProf + "\n";
    }
}
