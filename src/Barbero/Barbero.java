/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Barbero;

import java.awt.Color;

/**
 *
 * @author Fernando
 */
public class Barbero  implements Runnable {

    public int accion;
    public boolean verificador;
    public Silla cuadricula[][];
    public ListaSillas lista;
    public boolean estado;
    public Barbero(Silla cuadricula[][], ListaSillas lista) {
        this.verificador = false;
        this.cuadricula = cuadricula;
        this.lista = lista;
        this.estado=false;
    }

    public void hacer_accion() {
        if (estado == false) {
            //viendo si hay alguien en la cola o el cliente llegue a la barberia
            try {

                    Thread.sleep(500);
                } catch (Exception e) {
                }
            boolean result = lista.can_pop();
            if (result) {
                Barberia.actualizarespera(1);
                Barberia.barbero.setBackground(Color.GREEN);
                
                int cantidad = 0;
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 2; j++) {
                        if (cantidad < lista.getTamano()) {
                            cuadricula[i][j].setBackground(Color.GREEN);
                            //cuadricula[i][j].setIcon(Centro.getIcono(1));
                        } else {
                            cuadricula[i][j].setBackground(Color.black);
                            cuadricula[i][j].setIcon(null);
                        }
                        cantidad++;

                    }
                }
                estado=true;
            }
        } else {
            //cortando pelo
            try {

                Thread.sleep(100);
            } catch (Exception e) {
            }
            estado=false;
            Barberia.actualizaratendidos();
            Barberia.barbero.setBackground(Color.BLUE);
        }
    }

    @Override
    public void run() {

        while (!verificador) {
            try {

                    Thread.sleep(50);
                } catch (Exception e) {
                }
            hacer_accion();
        }

    }

}
