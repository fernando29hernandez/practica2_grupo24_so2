/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Barbero;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Fernando
 */
public class LlegadaClientes implements Runnable{
     public Silla cuadricula[][];
    public ListaSillas lista;
    public ExecutorService personas;
    public int cantidad;
    public LlegadaClientes(Silla[][] cuadricula, ListaSillas lista,int cantidad) {
        this.cuadricula = cuadricula;
        this.lista = lista;
        this.personas = Executors.newCachedThreadPool();
        this.cantidad = cantidad;
    }
    
    
    @Override
    public void run() {
         
        for (int i = 0; i < cantidad; i++) {
             try {

                    Thread.sleep(50);
                } catch (Exception e) {
                }
            personas.execute(new Cliente( cuadricula, lista));
            
            System.out.println("llega cliente");

        }
    }
    
}
