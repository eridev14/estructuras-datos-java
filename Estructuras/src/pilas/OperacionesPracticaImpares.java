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

    /**
     * Ejer 01
     *
     * Dada una pila P, Sumar los elementos pares de la pila
     *
     * @param p
     * @return
     */
    public int sumarPares(Pila p) {
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

    /**
     * Ejer 03
     *
     * Dada una Pila P sumar los elementos primos de la pila
     *
     */
    private static Boolean esPrimo(int val) {
        int c = 0;
        for (int i = 1; i <= val; i++) {
            if (val % i == 0) {
                c++;
            }
        }

        return c == 2;
    }

    public int sumarPrimos(Pila p) {
        Pila aux = new Pila(p.max);
        int sum = 0;
        while (!p.estaVacio()) {
            int elem = p.pop();
            if (esPrimo(sum)) {
                sum += elem;
            }
            aux.push(p.pop());
        }
        p.reset(aux);
        return sum;
    }

    /**
     * Ejer 05
     *
     * Dada una Pila p, eliminar los elementos divisores de x de la pila
     *
     * @param p
     * @param x
     */
    public void eliminarDiv_x(Pila p, int x) {
        Pila aux = new Pila(p.max);
        while (!p.estaVacio()) {
            int elem = p.pop();
            if (x % elem != 0) {
                aux.push(elem);
            }
        }
        p.reset(aux);
    }

    /**
     * Ejer 07
     *
     * Dada una P sumar los elementos primos de la pila
     *
     */
    /**
     * Ejer 09
     *
     * Dada una P sumar los elementos primos de la pila
     *
     */
    /**
     * Ejer 11
     *
     * Dada una P sumar los elementos primos de la pila
     *
     */
    /**
     * Ejer 13
     *
     * Dada una P sumar los elementos primos de la pila
     *
     */
    /**
     * Ejer 15
     *
     * Dada una P sumar los elementos primos de la pila
     *
     */
    /**
     * Ejer 17
     *
     * Dada una P sumar los elementos primos de la pila
     *
     */
    /**
     * Ejer 19
     *
     * Dada una P sumar los elementos primos de la pila
     *
     */
    /**
     * Ejer 21
     *
     * Dada una P sumar los elementos primos de la pila
     *
     */
    /**
     * Ejer 23
     *
     * Dada una P sumar los elementos primos de la pila
     *
     */
    /**
     * Ejer 25
     *
     * Dada una P sumar los elementos primos de la pila
     *
     */
    /*
      * Ejer 27
     *
     * Dada una P sumar los elementos primos de la pila
     *
     */
    /**
     * Ejer 29
     *
     * Dada una P sumar los elementos primos de la pila
     *
     */
    /**
     * Ejer 31
     *
     * Dada una P sumar los elementos primos de la pila
     *
     */
    /*
     * Ejer 33
     *
     * Dada una P sumar los elementos primos de la pila
     *
     */
    /**
     * Ejer 35
     *
     * Dada una P sumar los elementos primos de la pila
     *
     */
}
