package org.example;

public class Box {
    private String identificador;
    private boolean ocupat;
    private Pacient pacientActual;

    public Box(String identificador) {
        this.identificador = identificador;
        this.ocupat = false;
        this.pacientActual = null;
    }

    public void assignarPacient(Pacient pacient) {
        this.pacientActual = pacient;
        this.ocupat = true;
        // Logica per començar l'atenció
    }

    public void alliberarBox() {
        this.pacientActual = null;
        this.ocupat = false;
        // Netegem l'estat per un nou pacient
    }

    // Getters i setters segons sigui necessari
}
