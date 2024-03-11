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
        if (!ocupat) {
            this.pacientActual = pacient;
            this.ocupat = true;
            // Logica per començar l'atenció
            System.out.println("Pacient amb identificador " + pacient.getIdentificador() + " assignat al box " + identificador + ".");
        } else {
            System.out.println("Box " + identificador + " ja està ocupat.");
        }
    }

    public void alliberarBox() {
        if (ocupat) {
            System.out.println("Pacient amb identificador " + pacientActual.getIdentificador() + " ha estat alliberat del box " + identificador + ".");
            this.pacientActual = null;
            this.ocupat = false;
            // Netegem l'estat per un nou pacient
        } else {
            System.out.println("Box " + identificador + " ja està buit.");
        }
    }

    // Getters
    public String getIdentificador() {
        return identificador;
    }

    public boolean isOcupat() {
        return ocupat;
    }

    public Pacient getPacientActual() {
        return pacientActual;
    }

    // Setters
    public void setOcupat(boolean ocupat) {
        this.ocupat = ocupat;
    }

    public void setPacientActual(Pacient pacientActual) {
        this.pacientActual = pacientActual;
    }
}
