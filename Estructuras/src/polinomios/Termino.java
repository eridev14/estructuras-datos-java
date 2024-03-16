/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polinomios;

/**
 *
 * @author RedesPC
 */
public class Termino {

    private int coef;
    private int exp;

    public Termino(int coef, int exp) {
        this.coef = coef;
        this.exp = exp;
    }

    public Termino() {
    }
    
    public int getCoef() {
        return coef;
    }

    public void setCoef(int coef) {
        this.coef = coef;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public String getTodo() {
        String s;
        s = coef + " X^" + exp;
        return s;
    }
}
