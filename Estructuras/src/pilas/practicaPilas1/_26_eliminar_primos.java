/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilas.practicaPilas1;

import pilas.Pila;

/**
 *
 * @author ERIK
 */
public class _26_eliminar_primos {
    
    private static Boolean esPrimo(int val) {
        int c = 0;
        for (int i = 1; i <= val; i++) {
            if (val % i == 0) {
                c++;
            }
        }
        
        return c == 2;
    }
    
    public static void eliminarPrimos(Pila p) {
        Pila aux = new Pila(p.max);
        while (!p.estaVacio()) {
            int elem = p.pop();
            if (!esPrimo(elem)) {
                aux.push(elem);
            }
        }
        
        p.reset(aux);
    }
}
