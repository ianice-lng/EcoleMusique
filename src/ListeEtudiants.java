import java.util.ArrayList;

public class ListeEtudiants {
    private static ArrayList<Etudiant> listeEtudiant= new ArrayList<Etudiant>();

    public static void ajouterEtudiant(Etudiant eleve){
        listeEtudiant.add(eleve);
    }
    public static void supprimerEtudiant(Etudiant eleve){
        listeEtudiant.remove(eleve);
    }

    public static String[] getListeEtudiant(){
        String[] listeNom = new String[listeEtudiant.size()];
        int i = 0;
        for(Etudiant eleve : listeEtudiant){
            listeNom[i] = eleve.getNom();
            i++;
        }
        return listeNom;
    }

    public static int getNombreEtudiant(){
        return listeEtudiant.size();
    }

    public static int getNombreEtudiantNiveau(String niveau){
        int nombreEleve = 0;
        if(niveau != "debutant" && niveau != "intermediaire" && niveau != "avance"){
            return -1;
        }
        for(Etudiant eleve : listeEtudiant){
            if(eleve.getNiveauCompotences() == niveau){
                nombreEleve++;
            }
        }
        return nombreEleve;
    }

    public static Etudiant rechercheEtudiant(String nom) {
        for (Etudiant eleve : listeEtudiant) {
            if (eleve.getNom().equals(nom)) {
                System.out.println(eleve);
                return eleve;
            }
        }
        return null;
    }

    public static void repartitionEtudiantParInstrument(){
        for(Instrument instrument : ListeInstrument.getListeInstrument()){
            int nombreEtudiant = 0;
            for(Etudiant etudiant : listeEtudiant){
                for(Cours cours : etudiant.getCoursInscrit()){
                    if(cours.getInstrument() == instrument){
                        nombreEtudiant++;
                        break;
                    }
                }
            }
            System.out.println("Nombre d'étudiant en " + instrument + " : " + nombreEtudiant);
        }
    }
}
