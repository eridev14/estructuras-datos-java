/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilas;

import javax.swing.JOptionPane;

/**
 *
 * @author RedesPC
 */
public class Pila {

    public int P[];
    public int tope;
    public int max;

    public Pila(int n) {
        this.tope = 0;
        max = n;
        P = new int[max];
    }

    public void push(int valor) {
        if (estaLLeno()) {
            JOptionPane.showMessageDialog(null, "pila llena");
            return;
        }
        P[tope] = valor;
        tope++;
    }

    public int pop() {
        int elem = -1;
        if (estaVacio()) {
            JOptionPane.showMessageDialog(null, "pila vacia");
            return -1;
        }
        elem = P[tope - 1];
        tope--;
        return elem;
    }

    public String listar() {
        String str = "";
        Pila aux = new Pila(max);
        if (estaVacio()) {
            JOptionPane.showMessageDialog(null, "Pila sin elementos");
        }
        while (!estaVacio()) {
            int elem = pop();
            str += elem + "\n";
            aux.push(elem);
        }

        reset(aux);

        return str;
    }

    public void reset(Pila p) {
        while (!p.estaVacio()) {
            push(p.pop());
        }
    }

    public Boolean estaLLeno() {
        return tope >= max;
    }

    public Boolean estaVacio() {
        return tope == 0;
    }

    public void copiar(Pila c) {
        Pila aux = new Pila(max);
        Pila auxc = new Pila(max);
        while (!this.estaVacio()) {
            int elem = this.pop();
            aux.push(elem);
            auxc.push(elem);
        }

        this.reset(aux);
        c.reset(auxc);
    }

}
