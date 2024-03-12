package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Hospital {
    private String nom;
    private List<Box> boxes;
    private Queue<Pacient> salaEspera;
    private List<TecnicSanitari> tecnicsSanitaris;
    private List<Especialista> especialistes;

    public Hospital(String nom, int nombreDeBoxes) {
        this.nom = nom;
        this.boxes = new ArrayList<>();
        this.tecnicsSanitaris = new ArrayList<>();
        this.especialistes = new ArrayList<>();
        this.salaEspera = new LinkedList<>();
        for (int i = 0; i < nombreDeBoxes; i++) {
            this.boxes.add(new Box("Box " + (i + 1)));
        }

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

    public boolean hiHaTecnicsDisponibles() {
        // Comprova si hi ha algun tècnic disponible
        return tecnicsSanitaris.stream().anyMatch(TecnicSanitari::isDisponibilitat);
    }

    public TecnicSanitari obtenirTecnicDisponible() {
        for (TecnicSanitari tecnic : tecnicsSanitaris) {
            if (tecnic.isDisponibilitat()) {
                tecnic.setDisponibilitat(false); // Actualitza l'estat a no disponible
                return tecnic;
            }
        }
        return null; // Si no hi ha tècnics disponibles, retorna null
    }
    public void afegirEspecialista(Especialista especialista) {
        especialistes.add(especialista);
    }
    public Especialista obtenirEspecialistaDisponible() {
        for (Especialista especialista : especialistes) {
            if (especialista.isDisponibilitat()) {
                especialista.setDisponibilitat(false); // Actualitza l'estat a no disponible
                return especialista;
            }
        }
        return null;
    }
    public boolean hiHaEspecialistesDisponibles() {
        return especialistes.stream().anyMatch(Especialista::isDisponibilitat);
    }

    // Getters i setters segons sigui necessari
    public String getNom() {
        return nom;
    }

    public List<Box> getBoxes() {
        return boxes;
    }

    public Queue<Pacient> getSalaEspera() {
        return salaEspera;
    }

    public List<TecnicSanitari> getTecnicsSanitaris() {
        return tecnicsSanitaris;
    }

    public List<Especialista> getEspecialistes() {
        return especialistes;
    }
// Getters i setters segons sigui necessari
}
