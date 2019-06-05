/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Jorge Alejandro Herrera Ramos 1863060
 */
public class AciertaModelo {
    private int random;
    public int getRandom(){
        return random;
    }
    public void generarAleatorio(){
        random = (int)(Math.random()*5+1);
    }
    public boolean comparar(int numeroDelJugador1){
        return numeroDelJugador1 == random;
    }
}
