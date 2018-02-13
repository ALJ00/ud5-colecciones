package com.josearmas;

import java.util.Random;

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

        boolean movimiento = false;

        Random r = new Random();
        int aleatorio = r.nextInt(100)+1;

        if( aleatorio>this.umbral){
            movimiento = true;
        }

        return movimiento;
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
