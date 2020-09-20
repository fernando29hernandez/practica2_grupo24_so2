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
public class Nave {
    int posicionNaveCentro;
    int vida;

    public Nave() {
        this.vida=3;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
    
    public int getPosicionNaveCentro() {
        return posicionNaveCentro;
    }

    public void setPosicionNaveCentro(int posicionNaveCentro) {
        this.posicionNaveCentro = posicionNaveCentro;
    }
    
}
