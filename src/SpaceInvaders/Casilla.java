/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpaceInvaders;

import javax.swing.JLabel;

/**
 *
 * @author Fernando
 */
public class Casilla extends JLabel{
    
    Boolean esNave;
    Boolean esEnemigo;
    public Casilla() {
        this.esNave = false;
        this.esEnemigo = false;
    }

    public Boolean getEsNave() {
        return esNave;
    }

    public void setEsNave(Boolean esNave) {
        this.esNave = esNave;
    }

    public Boolean getEsEnemigo() {
        return esEnemigo;
    }

    public void setEsEnemigo(Boolean esEnemigo) {
        this.esEnemigo = esEnemigo;
    }
    
    /*
        Si hay colision regresa un 1 sino 0
    */
    public int VerifyObject()
    {
        if (this.getEsEnemigo()&&this.getEsNave()) {
            return 1;
        }
        return 0;
    }
}
