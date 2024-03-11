package org.example;

public class Especialista {
    private String identificador;
    private String nom;
    private String especialitat;
    private boolean disponibilitat;
    private int horesTreballades;

    public Especialista(String identificador, String nom, String especialitat) {
        this.identificador = identificador;
        this.nom = nom;
        this.especialitat = especialitat;
        this.disponibilitat = true; // Inicialment disponible
        this.horesTreballades = 0;
    }

    public void atendrePacient(Pacient pacient) {
        // Comprova que l'especialista estigui disponible abans d'atendre un pacient
        if (this.disponibilitat) {
            System.out.println(this.nom + " (" + this.especialitat + ") comença a atendre el pacient " + pacient.getIdentificador());
            this.disponibilitat = false; // Marca l'especialista com a ocupat
            // Aquí s'hauria d'afegir la lògica per ajustar el temps d'atenció basat en l'especialitat i la severitat del pacient
        } else {
            System.out.println(this.nom + " no està disponible en aquest moment.");
        }
    }

    public void finalitzarAtencio() {
        // Marca l'especialista com a disponible un cop ha finalitzat l'atenció
        this.disponibilitat = true;
        System.out.println(this.nom + " ha finalitzat l'atenció i ara està disponible.");
    }

    public void començarNouTorn() {
        // Reinicia les hores treballades a l'inici d'un nou torn
        this.horesTreballades = 0;
        this.disponibilitat = true; // Assegura que l'especialista estigui disponible al començament del torn
        System.out.println(this.nom + " comença un nou torn de treball.");
    }

    // Getters i setters necessaris
    public String getIdentificador() {
        return identificador;
    }

    public String getNom() {
        return nom;
    }

    public String getEspecialitat() {
        return especialitat;
    }

    public boolean isDisponibilitat() {
        return disponibilitat;
    }

    public int getHoresTreballades() {
        return horesTreballades;
    }

    public void setDisponibilitat(boolean disponibilitat) {
        this.disponibilitat = disponibilitat;
    }

    public void incrementarHoresTreballades(int hores) {
        this.horesTreballades += hores;
    }
}
