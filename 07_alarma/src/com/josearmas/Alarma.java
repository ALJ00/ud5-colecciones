package com.josearmas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Alarma {

    private int pin;
    private boolean activada;
    private int telefonoAviso;

    //Conexión
    private List<SensorMovimiento> sensores = new ArrayList<>();

    public Alarma(int telefonoAviso) {
        Random r = new Random();
        int aleatorio = r.nextInt(5)+1;

        for (int i = 0; i < aleatorio; i++) {
            int umbral = r.nextInt(100)+1;
            sensores.add(new SensorMovimiento(umbral));
            sensores.get(i).setAlarma(this);
        }
        //Asigno el tfno pásado por parametro que me da el usuario.
        this.telefonoAviso=telefonoAviso;

        //Creo un array para obtener el número pin aleatorio de 4 cifras.
        int []numeroPin = new int[4];
        for (int i = 0; i < 4; i++) {
            numeroPin[i]=r.nextInt(10);
        }

        //Creo un String para concatenar los números del array y así luego poder convertirlo a int.
        String unionInt = "";
        for (int i = 0; i < numeroPin.length; i++) {
            unionInt += numeroPin[i];
        }

        this.pin = Integer.parseInt(unionInt);
        this.activada = true;

    }

    /*public Alarma(int pin, boolean activada, int telefonoAviso) {
        this.pin = pin;
        this.activada = activada;
        this.telefonoAviso = telefonoAviso;
    }*/

    public void consultarSensores() {
        for (int i = 0; i <sensores.size(); i++) {
            if(sensores.get(i).hayMovimiento()){
                System.out.println("Sensor "+i+" detecta movimiento "+" llamar al teléfono "+this.telefonoAviso);
            }
        }
    }

    public void activar() {

    }

    public void desactivar(int pin) {

    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public boolean isActivada() {
        return activada;
    }

    public void setActivada(boolean activada) {
        this.activada = activada;
    }

    public int getTelefonoAviso() {
        return telefonoAviso;
    }

    public void setTelefonoAviso(int telefonoAviso) {
        this.telefonoAviso = telefonoAviso;
    }

    public List<SensorMovimiento> getSensoresMovientos() {
        return sensores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Alarma alarma = (Alarma) o;

        return pin == alarma.pin;
    }

    @Override
    public int hashCode() {
        return pin;
    }
}
