package org.example;

public class Pacient {
    private String identificador;
    private int severitat;
    private long tempsArribada;
    private long tempsSortida;
    private int tempsAtencio;
    private int prioritat;
    private boolean viu;

    public Pacient(String identificador, int severitat, long tempsArribada) {
        this.identificador = identificador;
        this.severitat = severitat;
        this.tempsArribada = tempsArribada;
        this.viu = true;

        // Determinar el temps d'atenció i la prioritat basat en la severitat
        switch (severitat) {
            case 0:
                this.tempsAtencio = 1; // 0.5 segons, ajustat per facilitat de implementació
                this.prioritat = 1;
                break;
            case 1:
                this.tempsAtencio = 2; // 1 segon per pacient amb malaltia poc greu
                this.prioritat = 2;
                break;
            case 2:
                this.tempsAtencio = 2; // 1 segon per especialitat, necessita 2 especialistes
                this.prioritat = 3;
                break;
            case 3:
                this.tempsAtencio = 3; // 1 segon per especialitat, necessita 3 especialistes
                this.prioritat = 4;
                break;
            case 4:
                this.tempsAtencio = 4; // Ajustar segons l'empitjorament potencial
                this.prioritat = 5;
                break;
            case 5:
                this.tempsAtencio = 5; // Severitat màxima, pot morir
                this.prioritat = 6;
                break;
            default:
                this.tempsAtencio = 1; // Valor per defecte
                this.prioritat = severitat;
        }
    }
    public String getIdentificador() {
        return identificador;
    }

    public int getSeveritat() {
        return severitat;
    }

    public long getTempsArribada() {
        return tempsArribada;
    }

    public Long getTempsSortida() {
        return tempsSortida;
    }

    public int getTempsAtencio() {
        return tempsAtencio;
    }

    public int getPrioritat() {
        return prioritat;
    }

    // Mètodes set
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public void setSeveritat(int severitat) {
        this.severitat = severitat;
    }

    public void setTempsArribada(long tempsArribada) {
        this.tempsArribada = tempsArribada;
    }

    public void setTempsSortida(Long tempsSortida) {
        this.tempsSortida = tempsSortida;
    }

    public void setTempsAtencio(int tempsAtencio) {
        this.tempsAtencio = tempsAtencio;
    }

    public void setPrioritat(int prioritat) {
        this.prioritat = prioritat;
    }

    public void rebreAtencio(long tempsInici) {
        // Marca l'inici de l'atenció
        // Potencialment aquí podríem ajustar la prioritat o fer altres actualitzacions
    }


    public void finalitzarAtencio(long tempsFi) {
        this.tempsSortida = tempsFi;
    }


    public void esperar() {
        // Suponiendo que aumentas la prioridad basado en el tiempo de espera
        long tempsEspera = System.currentTimeMillis() - this.tempsArribada; // Este es un ejemplo, ajusta según cómo manejas el tiempo
        if (tempsEspera > 10) { // Ejemplo: Si ha esperado más de 10 unidades de tiempo
            this.prioritat += 1; // Aumenta la prioridad
        }
    }

    public void actualitzarEstat() {
        long tempsEspera = System.currentTimeMillis() - this.tempsArribada;
        if (this.severitat == 4 && tempsEspera > 24000) { // Empitjora després de 24 segons
            this.severitat = 5;
            this.tempsAtencio = 5; // Ajusta el temps d'atenció per reflectir l'empitjorament
            this.prioritat = 6; // La prioritat més alta per la severitat crítica
        } else if (this.severitat == 5 && tempsEspera > 24000) {
            this.viu = false; // Marca el pacient com a mort
        }
    }




    // Getters i setters segons sigui necessari
}
