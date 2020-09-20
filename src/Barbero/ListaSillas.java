/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Barbero;

import java.awt.Color;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Fernando
 */
public class ListaSillas {
    NodoSilla inicio;
    int tamano;
    protected ReentrantLock candado;
    protected ReentrantLock candado2;

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public ListaSillas() {
        this.inicio = null;
        this.tamano = 0;
        this.candado = new ReentrantLock();
        this.candado2 = new ReentrantLock();
    }

    public boolean can_append() {
        boolean resp = candado.tryLock();
        //System.out.println("vengo a insertar");
        if (resp) {
            try {

                Thread.sleep(50);
            } catch (Exception e) {
            }
            if (!full()) {
                append("nuevo cliente");
                candado.unlock();
            
                return true;
            }
            candado.unlock();
            return false;
        }
        return false;
    }

    public boolean can_pop() {
        boolean resp = candado2.tryLock();
        if (resp) {
        //System.out.println("vengo a sacar");
        
            try {

                Thread.sleep(50);
            } catch (Exception e) {
            }
            
            if (!empty()) {
                System.out.println("2");
                pop();
                candado2.unlock();
                return true;
            }
            candado2.unlock();
            return false;
        }
        return false;
    }

    public void append(String nombre) {

        if (inicio == null) {
            inicio = new NodoSilla(nombre);
            inicio.siguiente = null;
            tamano += 1;
        } else {
            NodoSilla temporal = inicio;
            while (temporal.siguiente != null) {
                temporal = temporal.siguiente;
            }
            temporal.siguiente = new NodoSilla(nombre);
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

    public synchronized boolean  empty() {

        if (tamano <= 0) {
            return true;
        }

        return false;
    }
}


