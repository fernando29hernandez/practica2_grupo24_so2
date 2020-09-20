/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CentroAcopio;

/**
 *
 * @author Fernando
 */
public class NodoEspacio {
    public String nombre;
    public NodoEspacio siguiente;

    public NodoEspacio(String nombre) {
        this.nombre = nombre;
    }

    public NodoEspacio getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoEspacio siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
}
