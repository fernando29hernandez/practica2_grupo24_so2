/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Barbero;

/**
 *
 * @author Fernando
 */
public class NodoSilla {
    public String nombre;
    public NodoSilla siguiente;

    public NodoSilla(String nombre) {
        this.nombre = nombre;
    }

    public NodoSilla getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoSilla siguiente) {
        this.siguiente = siguiente;
    }
}
