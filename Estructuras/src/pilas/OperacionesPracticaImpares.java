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
     * Dada una Pila P, Invertir la Pila
     *
     * @param p
     */
    public void invertir(Pila p) {
        Pila aux = new Pila(p.max);
        p.copiar(aux);
        while (!p.estaVacio()) {
            p.pop();
        }
        p.reset(aux);
    }

    /**
     * Ejer 09
     *
     * Dada una Pila P, sumar el primer elemento y último elemento.
     *
     * @param p
     * @return
     */
    public int sumarPrimeroUltimo(Pila p) {
        Pila aux = new Pila(p.max);
        int first = p.pop();
        aux.push(first);
        int last = 0;
        while (!p.estaVacio()) {
            last = p.pop();
            aux.push(last);
        }

        p.reset(aux);
        return first + last;
    }

    /**
     * Ejer 11
     *
     * Dada una Pila P, encontrar el primer elemento par e impar de la Pila
     *
     * @param p
     * @return
     */
    /*
    public static primerPar(p) {
        
    }
     */
    public String encontrarParImpar(Pila p) {
        Pila aux = new Pila(p.max);
        String par = "";
        String impar = "";
        while (!p.estaVacio()) {
            int val = p.pop();
            if (val % 2 == 0) {
                par += val;
            } else {
                impar += val;
            }
            aux.push(val);
        }

        p.reset(aux);
        String parImpar = "Primer par: " + par.charAt(0) + "\n Primer Impar" + impar.charAt(0);
        return parImpar;
    }

    /**
     * Ejer 13
     *
     * Dada una Pila P ordenar los elementos de la Pila.
     *
     * @param p
     */
    public void ordenar(Pila p) {
        Pila aux = new Pila(p.max);
        Pila aux1 = new Pila(p.max);
        while (!p.estaVacio()) {
            int mayor = mayor(p);
            while (!p.estaVacio()) {
                int val = p.pop();
                if (val == mayor) {
                    aux.push(val);
                } else {
                    aux1.push(val);
                }
            }

            p.reset(aux1);
        }

        p.reset(aux);
    }

    /*encotrar elemento menor de la pila*/
    public int menor(Pila p) {
        Pila aux = new Pila(p.max);
        int menor = p.pop();
        while (!p.estaVacio()) {
            int val = p.pop();
            if (val < menor) {
                menor = val;
            }
            aux.push(val);
        }
        p.reset(aux);
        return menor;
    }

    /*encotrar elemento mayor de la pila*/
    public int mayor(Pila p) {
        Pila aux = new Pila(p.max);
        int mayor = p.pop();
        aux.push(mayor);
        while (!p.estaVacio()) {
            int val = p.pop();
            aux.push(val);
            if (val > mayor) {
                mayor = val;
            }
        }
        p.reset(aux);
        return mayor;
    }

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
    public static void main(String[] args) {
        OperacionesPracticaImpares op = new OperacionesPracticaImpares();
        Pila p = new Pila(5);
        p.push(1);
        p.push(8);
        p.push(3);
        p.push(4);
        System.out.println(" " + p.listar() + "\n\n");
        op.ordenar(p);
        System.out.println(" " + p.listar() + "\n\n");
        System.out.println("mayor" + op.mayor(p) + "\n\n");
        System.out.println(" " + p.listar() + "\n\n");

    }
}
