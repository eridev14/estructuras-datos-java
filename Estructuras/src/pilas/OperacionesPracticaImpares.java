/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilas;

/**
 *
 * @author ERIK HUAYLLAS COAQUIRA PRG300
 */
public class OperacionesPracticaImpares {

    public static int sumarPares(Pila p) {
        Pila aux = new Pila(p.max);
        int sum = 0;
        while (!p.estaVacio()) {
            int elem = p.pop();
            if (elem % 2 == 0) {
                sum += elem;
            }
            aux.push(p.pop());
        }
        p.reset(aux);
        return sum;
    }
}
