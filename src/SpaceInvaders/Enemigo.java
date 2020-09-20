/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpaceInvaders;

/**
 *
 * @author Fernando
 */
public class Enemigo {
    int posX;
    int posY;
    boolean usado;
    int vida;
    public Enemigo() {
       
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public boolean isUsado() {
        return usado;
    }

    public void setUsado(boolean usado) {
        this.usado = usado;
    }

    public Enemigo(int posX, int posY, boolean usado) {
        this.posX = posX;
        this.posY = posY;
        this.usado = usado;
    }
    
    public Enemigo(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
         this.vida=2;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
    
}
