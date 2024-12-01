public class Instrument {
    private String nom;
    private String type;
    private static String[] typesIntruments = new String[]{ "cordes", "vent", "percussion"}; //permet de creer un tableau de 3instruments

    public Instrument(String nom, String type) {
        this.nom = nom;

        for(String typeInstrument : typesIntruments){
            if(typeInstrument == type){
                this.type = type;
                ListeInstrument.ajouterInstrument(this);
                return;
            }
        }
    }

    public static String[] getListeTypeInstrument() {
        return typesIntruments;
    }

    @Override
    public String toString(){
        return nom + " types: " + type;
    }

}
