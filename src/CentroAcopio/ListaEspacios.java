/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CentroAcopio;

import java.awt.Color;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Fernando
 */
public class ListaEspacios {

    NodoEspacio inicio;
    int tamano;
    protected ReentrantLock candado;
    protected ReentrantLock candado2;

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public ListaEspacios() {
        this.inicio = null;
        this.tamano = 0;
        this.candado = new ReentrantLock();
        this.candado2 = new ReentrantLock();
    }

    public boolean can_append() {
        boolean resp = candado.tryLock();
        //System.out.println("vengo a insertar");
        if (resp) {
            Centro.puerta1.setBackground(Color.GREEN);
            try {

                Thread.sleep(50);
            } catch (Exception e) {
            }
            if (!full()) {
                append("nueva caja");
                candado.unlock();
                Centro.actualizardespacho();
                Centro.actualizarmeter(1);
                Centro.puerta1.setBackground(Color.magenta);

                return true;
            }
            Centro.puerta1.setBackground(Color.magenta);
            candado.unlock();
            return false;
        }
        return false;
    }

    public boolean can_pop() {
        boolean resp = candado2.tryLock();
        //System.out.println("vengo a sacar");
        if (resp) {
            Centro.puerta2.setBackground(Color.RED);
            try {

                Thread.sleep(50);
            } catch (Exception e) {
            }
            if (!empty()) {
                pop();
                Centro.actualizardespacho();
                Centro.actualizarsacar(1);
                Centro.puerta2.setBackground(Color.magenta);
                candado2.unlock();
                return true;
            }
            Centro.puerta1.setBackground(Color.magenta);
            candado2.unlock();
            return false;
        }
        return false;
    }

    public void append(String nombre) {

        if (inicio == null) {
            inicio = new NodoEspacio(nombre);
            inicio.siguiente = null;
            tamano += 1;
        } else {
            /*
             Si truena es aqui que tiene que ser tempora !=null y no asi como esta
            */
            NodoEspacio temporal = inicio;
            while (temporal.siguiente != null) {
                temporal = temporal.siguiente;
            }
            temporal.siguiente = new NodoEspacio(nombre);
            tamano += 1;
        }

        System.out.println("si pude insertar");
    }

    public void pop() {
        if (inicio != null) {
            inicio = inicio.siguiente;
            tamano -= 1;
        }
        //candado.unlock();
        System.out.println("si pude sacar");
    }

    public boolean full() {

        if (tamano == 20) {
            return true;
        }

        return false;
    }

    public boolean empty() {

        if (tamano == 0) {
            return true;
        }

        return false;
    }
}
