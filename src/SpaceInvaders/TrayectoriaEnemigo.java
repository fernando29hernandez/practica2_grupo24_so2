/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpaceInvaders;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Fernando
 */
public class TrayectoriaEnemigo implements Runnable {

    Enemigo enemigo;
    Casilla tablero[][];
    int control;

    public TrayectoriaEnemigo(Enemigo enemigo, Casilla[][] tablero) {
        this.enemigo = enemigo;
        this.tablero = tablero;
        this.control = 0;

    }

    @Override
    public void run() {
        
        while (!enemigo.isUsado()) {

            if (!Tablero.pausa) {
                if (!enemigo.isUsado()) {
                    if (enemigo.getPosY() + 1 != 15) {

                        int verificacion = tablero[enemigo.posX][enemigo.posY].VerifyObject();

                        if (verificacion == 1) {
                            enemigo.setVida(enemigo.getVida() - 1);
                            if (enemigo.getVida() <= 0) {
                                enemigo.setUsado(true);
                                control = 1;
                                tablero[enemigo.posX][enemigo.posY].setEsEnemigo(false);
                                tablero[enemigo.posX][enemigo.posY].setBackground(Color.black);
                                tablero[enemigo.posX][enemigo.posY].setIcon(null);
                                Tablero.enemigosderrotados=Tablero.enemigosderrotados+1;
                                Tablero.txtenemigos.setText(Integer.toString(Tablero.enemigosderrotados));
                            }
                        }

                        if (enemigo.getVida() >= 1) {

                            tablero[enemigo.posX][enemigo.posY].setEsEnemigo(false);
                            tablero[enemigo.posX][enemigo.posY].setBackground(Color.black);
                            tablero[enemigo.posX][enemigo.posY].setIcon(null);
                            enemigo.setPosY(enemigo.getPosY() + 1);
                            tablero[enemigo.posX][enemigo.posY].setEsEnemigo(true);
                            tablero[enemigo.posX][enemigo.posY].setIcon(Tablero.getIcono(4));
                            
                            if(enemigo.posY==13&&Tablero.nuevanave.posicionNaveCentro==enemigo.posX){
                                Tablero.modificarvida(1);
                                tablero[enemigo.posX][enemigo.posY].setEsEnemigo(false);
                                enemigo.setUsado(true);
                            
                            }
                            if(enemigo.posY==13&&Tablero.nuevanave2.posicionNaveCentro==enemigo.posX){
                            Tablero.modificarvida(2);
                            tablero[enemigo.posX][enemigo.posY].setEsEnemigo(false);
                            enemigo.setUsado(true);
                            }
                            if(enemigo.posY>13){
                                Tablero.modificarvida(1);
                                Tablero.modificarvida(2);
                                enemigo.setUsado(true);
                            
                            }
                        }

                    }

                } else {
                    this.enemigo.setUsado(true);
                    tablero[enemigo.posX][enemigo.posY].setEsEnemigo(false);
                }
            }
            try {
                Thread.sleep(3500);
            } catch (InterruptedException ex) {
                //Logger.getLogger(TrayectoriaEnemigo.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
