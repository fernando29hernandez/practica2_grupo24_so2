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
public class Cliente implements Runnable{
    public Silla cuadricula[][];
    public ListaSillas lista;

    public Cliente( Silla cuadricula[][], ListaSillas lista) {
        this.cuadricula = cuadricula;
        this.lista = lista;
    }

    public void hacer_accion() {
            try {

                Thread.sleep(50);
            } catch (Exception e) {
            }
            boolean result = lista.can_append();
            if (result) {
                Barberia.actualizarespera(0);
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
            }else{
                try {
                    Thread.sleep(50);
                } catch (Exception e) {
                }
                
                Barberia.actualizarretirados();
            
            }
        
    }

    @Override
    public void run() {

            hacer_accion();
        
    }
}
