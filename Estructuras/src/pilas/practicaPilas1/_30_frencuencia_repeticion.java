/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilas.practicaPilas1;

import pilas.Operaciones;
import pilas.Pila;

/**
 *
 * @author ERIK
 *
 * hallar la frecuencia (cantidad) de repeticion de cada elemento de la pila
 *
 */
public class _30_frencuencia_repeticion {

    public static String frecuencia(Pila p) {
        Pila pcopy = new Pila(p.max);
        Pila aux = new Pila(pcopy.max);

        p.copiar(pcopy);
        Operaciones op = new Operaciones();
        op.eliminarRepetidos(p);
        String s = "";

        while (!p.estaVacio()) {
            int elem = p.pop();
            int count = 0;
            while (!pcopy.estaVacio()) {
                int val = pcopy.pop();
                aux.push(val);
                if (elem == val) {
                    count++;
                }
            }
            pcopy.reset(aux);

            s = s + elem + " se repite: " + count + " veces \n";
        }
        p.reset(pcopy);
        return s;
    }
}
