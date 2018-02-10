package com.josearmas;

public class SensorMovimiento {

    private int umbral;

    //Conexión.
   private  Alarma alarma;

    public SensorMovimiento() {
    }

    public SensorMovimiento(int umbral) {
        this.umbral = umbral;
    }

    public boolean hayMovimiento(){

        return true;
    }

    public int getUmbral() {
        return umbral;
    }

    public void setUmbral(int umbral) {
        this.umbral = umbral;
    }

    public Alarma getAlarma() {
        return alarma;
    }

    public void setAlarma(Alarma alarma) {
        this.alarma = alarma;
    }
}
