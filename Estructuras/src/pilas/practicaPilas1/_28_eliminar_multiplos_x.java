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
public class _28_eliminar_multiplos_x {
    
    public static void eliminarMultiplos(Pila p, int x) {
        Pila aux = new Pila(p.max);
        while (!p.estaVacio()) {
            int elem = p.pop();
            if (elem % x != 0) {
                aux.push(elem);
            }
        }
    }
}
