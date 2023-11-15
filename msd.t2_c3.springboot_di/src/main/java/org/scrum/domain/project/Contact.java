package org.scrum.domain.project;

public class Contact {
        private String nume;
        private String prenume;
        private String numarTelefon;
        private String adresaEmail;
    private int id;

    public Contact(String nume, String prenume, String numarTelefon, String adresaEmail)
    {
            this.nume = nume;
            this.prenume = prenume;
            this.numarTelefon = numarTelefon;
            this.adresaEmail = adresaEmail;
        }

        public String getNume() {
            return nume;
        }

        public void setNume(String nume) {
            this.nume = nume;
        }

        public String getPrenume() {
            return prenume;
        }

        public void setPrenume(String prenume) {
            this.prenume = prenume;
        }

        public String getNumarTelefon() {
            return numarTelefon;
        }

        public void setNumarTelefon(String numarTelefon) {
            this.numarTelefon = numarTelefon;
        }

        public String getAdresaEmail() {
            return adresaEmail;
        }

        public void setAdresaEmail(String adresaEmail) {
            this.adresaEmail = adresaEmail;
        }

        public void afiseazaInformatiiContact() {
            System.out.println("Nume: " + nume);
            System.out.println("Prenume: " + prenume);
            System.out.println("Numar de telefon: " + numarTelefon);
            System.out.println("Adresa de email: " + adresaEmail);
        }

        public static void main(String[] args) {
            Contact contactExemplu = new Contact("Gh", "Andreea", "123456789", "and.gh@example.com");
            contactExemplu.afiseazaInformatiiContact();
        }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
}

