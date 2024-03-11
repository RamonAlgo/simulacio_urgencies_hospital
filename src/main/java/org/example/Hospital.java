package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Hospital {
    private String nom;
    private List<Box> boxes;
    private Queue<Pacient> salaEspera;

    public Hospital(String nom, int nombreDeBoxes) {
        this.nom = nom;
        this.boxes = new ArrayList<>();
        for (int i = 0; i < nombreDeBoxes; i++) {
            this.boxes.add(new Box("Box " + (i + 1)));
        }
        this.salaEspera = new LinkedList<>();
    }

    public void admetrePacient(Pacient pacient) {
        // Afegeix el pacient a la sala d'espera
        salaEspera.add(pacient);
    }

    public void assignarPacientABox() {
        if (!salaEspera.isEmpty()) {
            for (Box box : boxes) {
                if (!box.isOcupat()) {
                    Pacient pacient = salaEspera.poll(); // Obtenim i eliminem el pacient de la cua
                    box.assignarPacient(pacient); // Assignem el pacient al box
                    System.out.println("Pacient " + pacient.getIdentificador() + " assignat a " + box.getIdentificador());
                    break; // Sortim del bucle després d'assignar un pacient a un box
                }
            }
        }
    }


    public void alliberarBox(String identificadorBox) {
        for (Box box : boxes) {
            if (box.getIdentificador().equals(identificadorBox) && box.isOcupat()) {
                box.alliberarBox(); // Allibera el box
                System.out.println(identificadorBox + " ha estat alliberat.");
                assignarPacientABox(); // Intentem assignar un nou pacient si n'hi ha en espera
                break;
            }
        }
    }

    // Getters i setters segons sigui necessari
}
