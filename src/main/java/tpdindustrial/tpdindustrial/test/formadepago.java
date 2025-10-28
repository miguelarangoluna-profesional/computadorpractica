/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tpdindustrial.tpdindustrial.test;

/**
 *
 * @author USUARIO
 */
public enum formadepago {
    TREINTA(30),
    SESENTA(60),
    NOVENTA(90);
    
    public final int formapago;
    
    formadepago(int p){
        this.formapago = p;
    }

    public int getFormapago() {
        return this.formapago;
    }
}
