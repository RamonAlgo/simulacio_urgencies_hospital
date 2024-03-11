package org.example;

public class TecnicSanitari {
    private String identificador;
    private String nom;
    private boolean disponibilitat;
    private int horesTreballades;

    public TecnicSanitari(String identificador, String nom) {
        this.identificador = identificador;
        this.nom = nom;
        this.disponibilitat = true; // Inicialment disponible
        this.horesTreballades = 0;
    }

    public void atendrePacient(Pacient pacient) {
        // Logica d'atenció al pacient
        this.disponibilitat = false;
    }

    public void finalitzarAtencio() {
        // Logica per acabar l'atenció
        this.disponibilitat = true;
    }

    public void començarNouTorn() {
        // Reiniciar comptador d'hores treballades
        this.horesTreballades = 0;
    }

    // Getters i setters segons sigui necessari
}
