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
        if (this.disponibilitat) {
            System.out.println(nom + " comença a atendre el pacient " + pacient.getIdentificador());
            // El tècnic ara està ocupat
            this.disponibilitat = false;
            // Aquí es podria ajustar la lògica per incloure el temps d'atenció necessari segons el cas
        } else {
            System.out.println(nom + " no està disponible actualment.");
        }
    }

    public void finalitzarAtencio() {
        System.out.println(nom + " ha finalitzat l'atenció i ara està disponible.");
        // Torna a estar disponible després d'atendre un pacient
        this.disponibilitat = true;
        // Potencialment, incrementar hores treballades aquí
        this.horesTreballades += 1; // Exemple: Incrementa en 1 les hores treballades
    }

    public void començarNouTorn() {
        System.out.println(nom + " comença un nou torn de treball.");
        // Reinicia les hores treballades per al nou torn
        this.horesTreballades = 0;
        // Assegura que està disponible al començament del torn
        this.disponibilitat = true;
    }

    // Getters
    public String getIdentificador() {
        return identificador;
    }

    public String getNom() {
        return nom;
    }

    public boolean isDisponibilitat() {
        return disponibilitat;
    }

    public int getHoresTreballades() {
        return horesTreballades;
    }

    // Setters
    public void setDisponibilitat(boolean disponibilitat) {
        this.disponibilitat = disponibilitat;
    }

    public void setHoresTreballades(int horesTreballades) {
        this.horesTreballades = horesTreballades;
    }
}
