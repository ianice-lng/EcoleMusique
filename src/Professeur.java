import java.util.ArrayList;

public class Professeur extends Personne{
    private Instrument specialite;
    private ArrayList<Cours> coursDonnes = new ArrayList<Cours>();
    public Professeur(String nom, String prenom, int age, Instrument specialite) {
        super(nom, prenom, age);
        this.specialite = specialite;
        ListeProfesseurs.ajouterProfesseur(this);
    }

    public Instrument getSpecialite(){
        return this.specialite;
    }

    public void donnerCours(Cours cours){
        if(cours.getInstrument() == this.specialite){
            coursDonnes.add(cours);
        }
    }
    public void arreterCours(Cours cours){
                coursDonnes.remove(cours);
    }
    public ArrayList<Cours> getCoursDonnes(){
        return coursDonnes;
    }

    public Cours rechercheCours(String titre){
        for(Cours cours : coursDonnes){
            if(cours.getTitre().equals(titre)){
                return cours;
            }
        }
        return null;
    }



    public void afficherCoursDonnes(){
        for(Cours cours : coursDonnes){
            System.out.println(cours.getTitre());
        }
    }
    @Override
    public String toString(){
        return super.getNomPrenom() + " Spécialité: " + specialite;
    }
}
