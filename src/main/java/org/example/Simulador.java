package org.example;

public class Simulador {
    private AdministradorHospital administradorHospital;

    public Simulador(AdministradorHospital administradorHospital) {
        this.administradorHospital = administradorHospital;
    }

    public void executarSimulacio() {
        // Comença la simulació
        administradorHospital.iniciarSimulacio();
        // Aquí es poden afegir bucles de temps o events que triguen la lògica de simulació
    }

    public static void main(String[] args) {
        Hospital hospital = new Hospital("Hospital General", 5); // 5 boxes
        AdministradorHospital admin = new AdministradorHospital(hospital);
        Simulador simulador = new Simulador(admin);

        simulador.executarSimulacio();
    }
}
