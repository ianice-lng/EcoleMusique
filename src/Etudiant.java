import java.util.LinkedList;

public class Etudiant extends Personne {
    private String niveauCompotences;
    private static String[] listeNiveauCompetence = new String[]{ "debutant", "intermediaire", "avance"};
    private LinkedList<Cours> coursInscrit = new LinkedList<Cours>();

    public Etudiant(String nom, String prenom, int age, String niveauCompotences) {
        super(nom, prenom, age);

        for(String niveauCompetence : listeNiveauCompetence){
            if(niveauCompetence == niveauCompotences){
                this.niveauCompotences = niveauCompotences;
                ListeEtudiants.ajouterEtudiant(this);
                return;
            }
        }
    }

    public static String[] getListeNiveauCompetence() {
        return listeNiveauCompetence;
    }

    public void setNiveauCompotences(String niveauCompotences){
        for(String niveauCompetence : listeNiveauCompetence){
            if(niveauCompetence.equals(niveauCompotences)){
                this.niveauCompotences = niveauCompotences;
                return;
            }
        }
    }
    public void inscrireCours(Cours cours){
        coursInscrit.add(cours);
        cours.inscrireEtudiant(this);
    }
    public LinkedList<Cours> getCoursInscrit(){
        return coursInscrit;
    }
    public void desinscrireCours(Cours cours){
        coursInscrit.remove(cours);
        cours.desinscrireEtudiant(this);
    }
    @Override
    public String toString(){
        return super.getNomPrenom() + coursInscrit;
    }


    public String getNiveauCompotences() {
        return niveauCompotences;
    }
}
