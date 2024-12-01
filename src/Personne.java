abstract public class Personne {
        private String nom;
        private String prenom;
        private int age;

        public Personne(String nom, String prenom, int age){
            this.nom = nom;
            this.prenom = prenom;
            this.age = age;
        }

        public String getNom(){
            return this.nom;
        }

        public String getPrenom(){
            return this.prenom;
        }

        public String getNomPrenom(){
            return nom + " " + prenom;
        }

    public int getAge() {
        return age;
    }
}
