/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polinomios;

import javax.swing.JOptionPane;

/**
 *
 * @author RedesPC
 */
public class Polinomio {

    public Termino P[];
    public int nt;

    public Polinomio(int n) {
        this.nt = n;
        P = new Termino[nt];
    }

    public void llenar() {
        int c, e;
        for (int i = 0; i < nt; i++) {
            c = Integer.parseInt(JOptionPane.showInputDialog("coef: "));
            e = Integer.parseInt(JOptionPane.showInputDialog("expo: "));
            Termino t = new Termino(c, e);
            P[i] = t;
        }
    }

    public String mostrar() {
        String m = "";
        for (int i = 0; i < nt - 1; i++) {
            m += P[i].getTodo() + " + ";
        }
        m += P[nt - 1].getTodo();
        return m;
    }

    public void ordenar() {
        for (int i = 0; i < nt - 1; i++) {
            int expi = P[i].getExp();
            for (int j = i + 1; j < nt; j++) {
                int expj = P[j].getExp();
                if (expi > expj) {
                    Termino aux = new Termino();
                    aux = P[i];
                    P[i] = P[j];
                    P[j] = aux;
                }
            }
        }
    }

    public void simplificar() {
        for (int i = 0; i < nt - 1; i++) {
            int expi = P[i].getExp();
            for (int j = i + 1; j < nt; j++) {
                int expj = P[j].getExp();
                if (expi == expj) {
                    P[i].setCoef(P[i].getCoef() + P[j].getCoef());
                    for (int k = j; k < nt - 1; k++) {
                        P[k] = P[k + 1];
                    }
                    j--;
                    nt--;
                } else {
                    break;
                }
            }
        }
    }

    public void sumar(Polinomio a, Polinomio b, Polinomio c) {
        int k = 0;
        for (int i = 0; i < a.nt; i++) {
            Termino t = new Termino(a.P[i].getCoef(), a.P[i].getExp());
            c.P[k] = t;
            k++;
        }

        for (int i = 0; i < b.nt; i++) {
            Termino t = new Termino(b.P[i].getCoef(), b.P[i].getExp());
            c.P[k] = t;
            k++;
        }
        c.ordenar();
        c.simplificar();
    }

}
