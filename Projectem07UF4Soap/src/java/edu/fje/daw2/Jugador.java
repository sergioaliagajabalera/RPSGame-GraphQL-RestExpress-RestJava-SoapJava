/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fje.daw2;

/**
 *
 * @author Sergio
 */
class Jugador {
    int codi;
    int njugador;
    String moviment;
    int torn;
    int puntuacio;

    //constructor
    public Jugador(int codi, int njugador, String moviment, int torn, int puntuacio) {
        this.codi = codi;
        this.njugador = njugador;
        this.moviment = moviment;
        this.torn = torn;
        this.puntuacio = puntuacio;
    }
   
    //getters i setters

    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    public int getNjugador() {
        return njugador;
    }

    public void setNjugador(int njugador) {
        this.njugador = njugador;
    }

    public String getMoviment() {
        return moviment;
    }

    public void setMoviment(String moviment) {
        this.moviment = moviment;
    }

    public int getTorn() {
        return torn;
    }

    public void setTorn(int torn) {
        this.torn = torn;
    }

    public int getPuntuacio() {
        return puntuacio;
    }

    public void setPuntuacio(int puntuacio) {
        this.puntuacio = puntuacio;
    }
    
    
    
    //metodes
    @Override
    public String toString() {
        return "Jugador{" + "codi=" + codi + ", njugador=" + njugador + ", moviment=" + moviment + ", torn=" + torn + ", puntuacio=" + puntuacio + '}';
    }
    
    
   
   
}
