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
public class _24_eliminar_pares {
    
    public static void eliminarPares(Pila p) {
        Pila aux = new Pila(p.max);
        while (!p.estaVacio()) {
            int elem = p.pop();
            if (elem % 2 == 1) {
                aux.push(elem);
            }
        }
        
        p.reset(aux);
    }
}
