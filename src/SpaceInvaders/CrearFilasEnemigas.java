/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpaceInvaders;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JLabel;

/**
 *
 * @author Fernando
 */
public class CrearFilasEnemigas implements Runnable {
    Enemigo enemigos[];
    Casilla tablero[][];
    ExecutorService ejecutorInsertar;
    public CrearFilasEnemigas(Enemigo[] enemigos, Casilla[][] tablero,ExecutorService ejecutorInsertar) {
        this.enemigos = enemigos;
        this.tablero = tablero;
        this.ejecutorInsertar=ejecutorInsertar;
    }
    
    @Override
    public void run() {
         ejecutorInsertar = Executors.newCachedThreadPool();
        int randomNum = 0;
        enemigos = new Enemigo[50];
        LinkedList numeros = new LinkedList();
        for (int i = 0; i < 8; i++) {
            randomNum = ThreadLocalRandom.current().nextInt(0, 23 + 1);
            if(!numeros.contains(randomNum)){
                numeros.add(randomNum);
                enemigos[i] = new Enemigo(randomNum, 0);
                
            }else{
            i--;
            }
            
        }
        for (int i = 0; i < 8; i++) {
            ejecutorInsertar.execute(new TrayectoriaEnemigo(enemigos[i], tablero));

        }
         try {
                Thread.sleep(25000);
            } catch (InterruptedException ex) {
                //Logger.getLogger(TrayectoriaEnemigo.class.getName()).log(Level.SEVERE, null, ex);
            }
        for (int i = 15; i < 30; i++) {
            randomNum = ThreadLocalRandom.current().nextInt(0, 23 + 1);
            enemigos[i] = new Enemigo(randomNum, 0);

        }
        for (int i = 15; i < 30; i++) {

            ejecutorInsertar.execute(new TrayectoriaEnemigo(enemigos[i], tablero));

        }
         try {
                Thread.sleep(25000);
            } catch (InterruptedException ex) {
                //Logger.getLogger(TrayectoriaEnemigo.class.getName()).log(Level.SEVERE, null, ex);
            }
        for (int i = 30; i < 45; i++) {
            randomNum = ThreadLocalRandom.current().nextInt(0, 23 + 1);
            enemigos[i] = new Enemigo(randomNum, 0);

        }
        for (int i = 30; i < 45; i++) {

            ejecutorInsertar.execute(new TrayectoriaEnemigo(enemigos[i], tablero));

        }
    }
    
}
