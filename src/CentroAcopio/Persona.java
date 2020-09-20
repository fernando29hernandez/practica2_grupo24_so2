/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CentroAcopio;

import java.awt.Color;

/**
 *
 * @author Fernando
 */
public class Persona implements Runnable {

    public int accion;
    public boolean verificador;
    public Espacio cuadricula[][];
    public ListaEspacios lista;

    public Persona(int accion, Espacio cuadricula[][], ListaEspacios lista) {
        this.accion = accion;
        this.verificador = false;
        this.cuadricula = cuadricula;
        this.lista = lista;
    }

    public void hacer_accion() {
        if (accion == 0) {
            try {

                Thread.sleep(50);
            } catch (Exception e) {
            }
            boolean result = lista.can_append();
            if (result) {
                verificador = result;

                try {

                    Thread.sleep(50);
                } catch (Exception e) {
                }
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
            } else {
                verificador = result;
            }
        } else {
            try {

                Thread.sleep(50);
            } catch (Exception e) {
            }
            boolean result = lista.can_pop();
            if (result) {
                verificador = result;
                try {

                    Thread.sleep(50);
                } catch (Exception e) {
                }
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
            } else {
                verificador = result;
            }
        }
    }

    @Override
    public void run() {

        while (!verificador) {
            hacer_accion();
        }

    }

}
