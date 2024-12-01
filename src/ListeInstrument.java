import java.util.ArrayList;

public class ListeInstrument {
    private static ArrayList<Instrument> listeInstrument = new ArrayList<Instrument>();

    public static void ajouterInstrument(Instrument instrument){
        listeInstrument.add(instrument);
    }
    public static void supprimerInstrument(Instrument instrument){
        listeInstrument.remove(instrument);
    }

    public static ArrayList<Instrument> getListeInstrument(){
        return listeInstrument;
    }

    public static String[] getListeInstrumentNom(){
        String[] listeNom = new String[listeInstrument.size()];
        int i = 0;
        for(Instrument instru : listeInstrument){
            listeNom[i] = instru.toString();
            i++;
        }
        return listeNom;
    }

    public static Instrument rechercheInstrument(String instrument) {
        for (Instrument instru : listeInstrument) {
            if (instru.toString().equals(instrument)) {
                return instru;
            }
        }
        return null;
    }
}
