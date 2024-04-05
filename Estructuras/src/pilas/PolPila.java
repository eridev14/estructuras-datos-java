/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilas;

import javax.swing.JOptionPane;
import polinomios.Termino;

/**
 *
 * @author ERIK
 */
public class PolPila {

    public int tope;
    public Termino p[];
    int max;

    public PolPila(int max) {
        this.tope = 0;
        this.max = max;
        this.p = new Termino[max];
    }

    public Boolean esVacio() {
        return this.tope == 0;
    }

    public Boolean esLleno() {
        return this.tope >= this.max;
    }

    public void push(Termino val) {
        if (this.esLleno()) {
            JOptionPane.showMessageDialog(null, "pila llena");
            return;
        }
        this.p[this.tope] = val;
        this.tope++;
    }

    public Termino pop() {
        if (this.esVacio()) {
            JOptionPane.showMessageDialog(null, "pila llena");
            return null;
        }
        Termino val = this.p[this.tope - 1];
        this.tope--;
        return val;
    }

    public String mostrar() {
        String str = "" + '\n';
        PolPila aux = new PolPila(max);
        if (this.esVacio()) {
            JOptionPane.showMessageDialog(null, "Pila sin elementos");
        }

        while (!this.esVacio()) {
            Termino elem = this.pop();
            int elemTer = elem.getCoef();
            if (elemTer > 0) {
                str += " +" + elem.getTodo() + '\n';
            } else {
                str += " " + elem.getTodo() + '\n';
            }

            aux.push(elem);
        }

        reset(aux);

        return str;
    }

    public void reset(PolPila p) {
        while (!p.esVacio()) {
            push(p.pop());
        }
    }

    /*operaciones Polinomios Pilas*/
    public void ordenar(PolPila A) {
        PolPila ord = new PolPila(A.max);
        while (!A.esVacio()) {
            Termino val = A.pop();
            int valTer = val.getExp();
            while (!ord.esVacio()) {
                Termino aux = ord.pop();
                int auxTer = aux.getExp();
                if (auxTer < valTer) {
                    A.push(aux);
                } else {
                    ord.push(aux);
                    break;
                }
            }
            ord.push(val);
        }
        while (!ord.esVacio()) {
            A.push(ord.pop());
        }
    }

    public void simplificar() {
        int numeroTérminos = this.tope;
        for (int i = 0; i < numeroTérminos - 1; i++) {
            int expi = this.p[i].getExp();
            for (int j = i + 1; j < numeroTérminos; j++) {
                int expj = this.p[j].getExp();
                if (expi == expj) {
                    this.p[i].setCoef(this.p[i].getCoef() + this.p[j].getCoef());
                    for (int k = j; k < numeroTérminos - 1; k++) {
                        this.p[k] = this.p[k + 1];
                    }
                    j--;
                    numeroTérminos--;
                } else {
                    break;
                }
            }
        }
        this.tope = numeroTérminos;
    }

    public void llenar() {
        for (int i = 0; i < this.max; i++) {
            int c = Integer.parseInt(JOptionPane.showInputDialog("coef: "));
            int e = Integer.parseInt(JOptionPane.showInputDialog("expo: "));
            Termino t = new Termino(c, e);
            this.push(t);
        }
    }

    public PolPila copiar() {
        PolPila copia = new PolPila(this.max);
        PolPila aux = new PolPila(this.max);
        while (!this.esVacio()) {
            Termino termino = this.pop();
            copia.push(termino);
            aux.push(termino);
        }
        while (!aux.esVacio()) {
            this.push(aux.pop());
        }
        return copia;
    }

    public static PolPila sumarPolinomios(PolPila polinomio1, PolPila polinomio2) {
        PolPila resultado = new PolPila(Math.max(polinomio1.max, polinomio2.max));

        PolPila copiaPolinomio1 = polinomio1.copiar();
        PolPila copiaPolinomio2 = polinomio2.copiar();

        while (!copiaPolinomio1.esVacio() || !copiaPolinomio2.esVacio()) {
            Termino termino1 = copiaPolinomio1.esVacio() ? null : copiaPolinomio1.pop();
            Termino termino2 = copiaPolinomio2.esVacio() ? null : copiaPolinomio2.pop();

            if (termino1 == null) {
                resultado.push(termino2);
            } else if (termino2 == null) {
                resultado.push(termino1);
            } else {
                int coefSuma = termino1.getCoef() + termino2.getCoef();
                int expSuma = termino1.getExp();

                if (termino1.getExp() != termino2.getExp()) {
                    resultado.push(termino1);
                    resultado.push(termino2);
                } else {
                    Termino terminoSuma = new Termino(coefSuma, expSuma);
                    resultado.push(terminoSuma);
                }
            }
        }

        resultado.simplificar();

        return resultado;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(JOptionPane.showInputDialog("tama;o de Pila"));
        PolPila p = new PolPila(n);
        p.llenar();
        System.out.println(" " + p.mostrar());
        p.simplificar();
        System.out.println(" " + p.mostrar());

        int n2 = Integer.parseInt(JOptionPane.showInputDialog("tama;o de Pila"));
        PolPila p1 = new PolPila(n2);
        p1.llenar();
        System.out.println(" " + p1.mostrar());
        p1.simplificar();
        System.out.println(" " + p1.mostrar());
        System.out.println("suma: " + sumarPolinomios(p, p1));
    }

}
