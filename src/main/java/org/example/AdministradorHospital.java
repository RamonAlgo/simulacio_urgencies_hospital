package org.example;

public class AdministradorHospital {
    private Hospital hospital;

    public AdministradorHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public void iniciarSimulacio() {
        // Exemple: Genera un nombre inicial de pacients i els assigna a la sala d'espera
        for (int i = 0; i < 10; i++) { // Generem 10 pacients com a exemple
            Pacient pacient = new Pacient("Pacient_" + i, (int) (Math.random() * 5), System.currentTimeMillis());
            hospital.admetrePacient(pacient);
        }

        // Comença el procés de gestionar les arribades i assignar recursos
        gestionarArribadesPacients();
        assignarRecursos();
    }


    public void gestionarArribadesPacients() {
        // Aquí es podria implementar un mecanisme per generar pacients de manera periòdica
        // Per aquest exemple, simplement intentarem assignar pacients de la sala d'espera a qualsevol box disponible
        hospital.assignarPacientABox();
    }


    public void assignarRecursos() {
        // Recorrem tots els boxes per veure si hi ha pacients que necessiten atenció
        for (Box box : hospital.getBoxes()) {
            if (box.isOcupat()) {
                Pacient pacient = box.getPacientActual();
                // Determinem les necessitats del pacient basant-nos en la seva severitat
                int necessitats = calcularNecessitats(pacient);

                // Assignem els especialistes i tècnics necessaris
                for (int i = 0; i < necessitats; i++) {
                    if (hospital.hiHaEspecialistesDisponibles()) {
                        Especialista especialista = hospital.obtenirEspecialistaDisponible();
                        // Suposa que aquí es realitza alguna forma d'assignació
                        System.out.println("Assignat l'especialista " + especialista.getNom() + " al pacient " + pacient.getIdentificador());
                    }
                    if (hospital.hiHaTecnicsDisponibles()) {
                        TecnicSanitari tecnic = hospital.obtenirTecnicDisponible();
                        // Suposa que aquí es realitza alguna forma d'assignació
                        System.out.println("Assignat el tècnic " + tecnic.getNom() + " al pacient " + pacient.getIdentificador());
                    }
                }
                // Una vegada assignats els recursos, potser voldràs actualitzar l'estat de disponibilitat dels especialistes i tècnics
            }
        }
    }

    private int calcularNecessitats(Pacient pacient) {
        // Aquest mètode retorna el nombre d'especialistes/tècnics necessaris basant-se en la severitat del pacient
        // La implementació exacta dependrà de les regles de negoci específiques del teu sistema
        switch (pacient.getSeveritat()) {
            case 0: return 1; // Només necessita un tècnic
            case 1: return 2; // Necessita un especialista i un tècnic
            case 2: return 3; // Necessita dos especialistes i un tècnic
            case 3: return 4; // Necessita tres especialistes i un tècnic
            // Continua per a altres casos
            default: return 0;
        }
    }


    // Més lògica i mètodes segons sigui necessari
}
