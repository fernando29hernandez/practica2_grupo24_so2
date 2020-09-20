/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpaceInvaders;

import java.awt.Color;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Fernando
 */
public class TrayectoriaMisil implements Runnable {

    Misil misil;
    Casilla tablero[][];
    int control;
    int posX;
    private ReentrantLock candado;

    public TrayectoriaMisil(Misil misil, Casilla[][] tablero) {
        this.misil = misil;
        this.tablero = tablero;
        this.control = 0;
        this.candado = new ReentrantLock();
    }

    @Override
    public void run() {

        while (control == 0) {
            if (!Tablero.pausa) {
                if (!misil.isUsado()) {
                    if (misil.getPosY() - 1 != 0) {
                        if (misil.posY != 13) {
                            tablero[misil.posX][misil.posY].setBackground(Color.black);
                            tablero[misil.posX][misil.posY].setIcon(null);
                            //tablero[misil.posX][misil.posY].setEsNave(false);
                        }
                        int verificacion = 0;

                        verificacion = tablero[misil.posX][misil.posY].VerifyObject();

                        if (verificacion == 1) {

                            tablero[misil.posX][misil.posY].setBackground(Color.black);
                            tablero[misil.posX][misil.posY].setIcon(null);
                            this.misil.setUsado(true);
                            control = 1;
                            tablero[misil.posX][misil.posY].setEsNave(false);
                        } else {
                            if (!misil.isUsado()) {
                                misil.setPosY(misil.getPosY() - 1);
                                tablero[misil.posX][misil.posY].setEsNave(true);
                                tablero[misil.posX][misil.posY].setIcon(Tablero.getIcono(3));
                            }
                        }
                    } else {
                        tablero[misil.posX][misil.posY].setEsNave(false);
                        tablero[misil.posX][misil.posY].setBackground(Color.black);
                        tablero[misil.posX][misil.posY].setIcon(null);
                        control = 1;
                        this.misil.setUsado(true);
                    }
                } else {
                    this.misil.setUsado(true);

                }

            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
                //Logger.getLogger(TrayectoriaEnemigo.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
