import java.util.ArrayList;

public class ListeProfesseurs {
    private static ArrayList<Professeur> listeProfesseurs = new ArrayList<Professeur>();

    public static void ajouterProfesseur(Professeur professeur){
        listeProfesseurs.add(professeur);
    }
    public static void supprimerProfesseur(Professeur professeur){
        listeProfesseurs.remove(professeur);
    }

    public static ArrayList<Professeur> getListeProfesseurs(){
        return listeProfesseurs;
    }

    public static Professeur rechercheProfesseur(String nom){
        for(Professeur prof : listeProfesseurs){
            if(prof.getNom().equals(nom)){
                return prof;
            }
        }
        return null;
    }


    public static ArrayList<Professeur> rechercheProfesseurParCours(Cours cours){
        ArrayList<Professeur> listeProfesseurs2 = new ArrayList<Professeur>();
        for(Professeur professeur : listeProfesseurs){
            for(Cours coursProf : professeur.getCoursDonnes()){
                if(coursProf == cours){
                    listeProfesseurs2.add(professeur);
                }
            }
        }

        return listeProfesseurs2;
    }

    public static String[] getListeProfesseurNom() {
        String[] listeNom = new String[listeProfesseurs.size()];
        int i = 0;
        for (Professeur prof : listeProfesseurs) {
            listeNom[i] = prof.getNom();
            i++;
        }
        return listeNom;
    }
}
