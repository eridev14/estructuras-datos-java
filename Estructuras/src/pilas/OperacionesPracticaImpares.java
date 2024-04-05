/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilas;

import javax.swing.JOptionPane;

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
     * Dada una Pila P ordenada, insertar un elemento X en el lugar que le
     * corresponde.
     *
     * @param p
     * @param x
     */
    public void insertarX(Pila p, int x) {
        Pila aux = new Pila(p.max);
        while (!p.estaVacio()) {
            int val = p.pop();
            if (x >= val) {
                aux.push(x);
                aux.push(val);
                break;
            }
            aux.push(val);
        }

        p.reset(aux);
    }

    /**
     * Ejer 17
     *
     * Dada dos pila A,B, sumar sus elementos de ambas pilas, considere que las
     * pilas deben ser del mismo tamaño.
     *
     * @param A
     * @param B
     */
    public void sumarPilas(Pila A, Pila B, Pila C) {
        Pila auxA = new Pila(A.max);
        Pila auxB = new Pila(B.max);
        Pila auxC = new Pila(C.max);

        if (B.tope != A.tope) {
            JOptionPane.showMessageDialog(null, "la Pila A y B no son del mismo tama;o");
            return;
        }

        while (!A.estaVacio()) {
            int valA = A.pop();
            auxA.push(valA);
            int valB = B.pop();
            auxB.push(valB);
            int sum = valA + valB;
            auxC.push(sum);
        }

        A.reset(auxA);
        B.reset(auxB);
        C.reset(auxC);
    }

    /**
     * Ejer 19
     *
     * Dada dos Pilas A,B, realizar la Unión de elementos en una Pila C (la
     * unión debe ser como en teoría de conjuntos)
     *
     * @param A
     * @param B
     * @param C
     */
    public void union(Pila A, Pila B, Pila C) {
        Pila auxA = new Pila(A.max);
        Pila auxB = new Pila(B.max);
        //Pila auxC = new Pila(C.max);
        while (!A.estaVacio()) {
            int val = A.pop();
            auxA.push(val);
            C.push(val);
        }

        while (!B.estaVacio()) {
            int val = B.pop();
            auxB.push(val);
            C.push(val);
        }

        OperacionesPracticaPares op = new OperacionesPracticaPares();
        op.eliminarRepetidos(C);
        ordenar(C);
    }

    /**
     * Ejer 21
     *
     * Mediante Pilas realizar la suma y multiplicación de polinomios
     *
     */
    public void opPilinomiosPilas() {

    }

    /**
     * Ejer 23
     *
     * Dada una pila P, intercambiar el primer elemento de la pila y el último
     * elemento de la pila
     *
     * @param p
     */
    public void intercambio(Pila p) {
        Pila aux = new Pila(p.max);
        Pila aux2 = new Pila(p.max);

        int first = p.pop();
        while (!p.estaVacio()) {
            int val = p.pop();
            aux.push(val);
        }
        p.push(first);
        aux2.reset(aux);
        p.reset(aux2);
    }

    /**
     * Ejer 25
     *
     * Dada una Pila P, eliminar el primer Impar de la Pila.
     *
     * @param p
     */
    public void eliminarPrimerImpar(Pila p) {
        Pila aux = new Pila(p.max);

        while (!p.estaVacio()) {
            int val = p.pop();
            if (val % 2 == 1) {
                break;
            } else {
                aux.push(val);
            }
        }
        p.reset(aux);
    }

    /*
      * Ejer 27
     *
     * Dada una Pila P, eliminar el elemento mayor de la pila.
     *
     */
    public void eliminarMayor(Pila p) {
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
        while (!aux.estaVacio()) {
            int val = aux.pop();
            if (val != mayor) {
                p.push(val);
            }
        }
    }

    /**
     * Ejer 29
     *
     * Dada una Pila P eliminar el segundo elemento menor de la pila
     *
     * @param p
     */
    public void eliminarSegundoMenor(Pila p) {
        Pila aux = new Pila(p.max);
        int menor = p.pop();
        aux.push(menor);
        while (!p.estaVacio()) {
            int val = p.pop();
            if (val < menor) {
                menor = val;
            }
            aux.push(val);
        }

        p.reset(aux);

        int segundoMenor = p.pop();
        aux.push(segundoMenor);
        while (!p.estaVacio()) {
            int val = p.pop();
            if (val == menor) {
                aux.push(val);
                continue;
            }
            if (val < segundoMenor) {
                segundoMenor = val;
            }
            aux.push(val);
        }

        while (!aux.estaVacio()) {
            int val = aux.pop();
            if (val == segundoMenor) {
                continue;
            }
            p.push(val);
        }
    }

    /**
     * Ejer 31
     *
     * En una pila P, Generar n-elementos de la serie Fibonacci.
     *
     * @return 
     */
    public Pila serieFibonacci() {
        int n = Integer.parseInt(JOptionPane.showInputDialog("cantidad de elementos de Fibonacci"));
        Pila p = new Pila(n);
        int a = 0;
        int b = 1;
        for (int i = 0; i < n; i++) {
            p.push(a);
            int c = a + b;
            b = a;
            a = c;
        }
        return p;
    }

    /*
     * Ejer 33
     *
     * Dada una pila P, sumar todos los elementos múltiplos de X
     *
     */
    public int sumaMultiplosX(Pila p, int x) {
        Pila aux = new Pila(p.max);
        int sum = 0;
        while (!p.estaVacio()) {
            int val = p.pop();
            if (val % x == 0) {
                sum += val;
            }
            aux.push(val);
        }
        return sum;
    }

    /**
     * Ejer 35
     *
     * En una pila almacenar los datos de un libro con los siguientes atributos
     * (id, titulo, ,autor, editorial, precio) y luego realizar las siguientes
     * operaciones: a) Adicionar b) Listar c) Buscar un libro por el titulo
     *
     */
    
    public static void main(String[] args) {
        OperacionesPracticaImpares op = new OperacionesPracticaImpares();
        Pila p1;
        Pila p2 = new Pila(10);
        //Pila p3 = new Pila(p1.max + p2.max);
        /*
        p1.push(1);
        p1.push(2);
        p1.push(2);
        p1.push(6);
        p1.push(7);
         */
        p2.push(3);
        p2.push(4);
        p2.push(5);
        p2.push(6);

        p1 = op.serieFibonacci();
        System.out.println(" " + p1.listar() + "\n\n");
    }
}
