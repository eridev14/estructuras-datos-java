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
public class Operaciones {

    public int contarElemLong3(Pila p) {
        Pila aux = new Pila(p.max);
        int cant = 0;
        while (!p.estaVacio()) {
            int elem = p.pop();
            aux.push(elem);

            int count = 0;

            while (elem > 0) {
                elem /= 10;
                count++;
            }

            if (count == 3) {
                cant++;
            }
        }

        p.reset(aux);

        return cant;
    }

    public int sumar(Pila p) {
        Pila aux = new Pila(p.max);
        int sum = 0;
        while (!p.estaVacio()) {
            int elem = p.pop();
            aux.push(elem);

            if (elem % 2 == 0) {
                sum += elem;
            }
        }

        p.reset(aux);

        return sum;
    }

    public int multiplos3(Pila p) {
        Pila aux = new Pila(p.max);
        int sum = 0;
        while (!p.estaVacio()) {
            int elem = p.pop();
            aux.push(elem);
            if (elem % 3 == 0) {
                sum += elem;
            }
        }
        p.reset(aux);

        return sum;
    }

    public int elemMenor(Pila p) {
        Pila aux = new Pila(p.max);
        int men = p.pop();
        while (!p.estaVacio()) {
            int elem = p.pop();
            aux.push(elem);

            if (elem < men) {
                men = elem;
            }

        }
        p.reset(aux);

        return men;
    }

    public int elemMeyor(Pila p) {
        Pila aux = new Pila(p.max);
        int may = p.pop();
        while (!p.estaVacio()) {
            int elem = p.pop();
            aux.push(elem);

            if (elem > may) {
                may = elem;
            }

        }
        p.reset(aux);

        return may;
    }

    public void eliminarElem(Pila p, int x) {
        Pila aux = new Pila(p.max);
        while (!p.estaVacio()) {
            int elem = p.pop();
            if (elem == x) {
                break;
            }
            aux.push(elem);

        }
        p.reset(aux);
    }

    public void eliminarTodoElem(Pila p, int x) {
        Pila aux = new Pila(p.max);
        while (!p.estaVacio()) {
            int elem = p.pop();
            if (elem != x) {
                aux.push(elem);
            }
        }
        p.reset(aux);
    }

    /*ejer 02*/
    public void llenarRandom(Pila p, int n) {
        int i = 0;
        while (i < n) {
            int e = (int) (Math.random() * 100);
            p.push(e);
            i++;
        }
    }

    /*ejer 04*/
    public void insertarFondo(Pila p, int x) {
        Pila aux = new Pila(p.max);
        while (!p.estaVacio()) {
            aux.push(p.pop());
        }
        p.push(x);
        p.reset(aux);
    }

    /*ejer 06*/
    public void eliminarFondo(Pila p) {
        Pila aux = new Pila(p.max);
        while (!p.estaVacio()) {
            aux.push(p.pop());
        }
        aux.pop();
        p.reset(aux);
    }

    /*ejer 08*/
    public String mostrarCentrales(Pila p) {
        double mid = (double) (p.tope - 1) / 2;
        int midFirst = (int) Math.floor(mid);
        int midSecond = (int) Math.ceil(mid);
        Pila aux = new Pila(p.max);
        int n = p.tope - 1;
        String s = "";
        while (!p.estaVacio()) {
            int e = p.pop();
            aux.push(e);
            if (n == midFirst || n == midSecond) {
                s += e + " ";
            }
            n--;
        }
        p.reset(aux);
        return s;
    }

    /*ejer 10*/
    public void eliminarRepetidos(Pila p) {
        Pila aux = new Pila(p.tope);
        int n;
        while (!p.estaVacio()) {
            int e = p.pop();
            eliminarTodoElem(p, e);
            aux.push(e);
        }

        p.reset(aux);
    }

    /*ejer 12*/
    public void intercambiarAdyacente(Pila p) {
        Pila aux = new Pila(p.tope);
        while (!p.estaVacio()) {
            int first = p.pop();
            int second = p.pop();
            if (second == -1) {
                break;
            }
            aux.push(second);
            aux.push(first);
        }

        p.reset(aux);
    }

    /*ejer 14*/
    public void llevarParesFondo(Pila p) {
        Pila aux = new Pila(p.tope);
        Pila pares = new Pila(p.tope);
        while (!p.estaVacio()) {
            int e = p.pop();
            if (e % 2 == 0) {
                pares.push(e);
            } else {
                aux.push(e);
            }
        }
        p.reset(pares);
        p.reset(aux);
    }

    /*ejer 16*/
    public void rotacion(Pila p, int r) {
        int i = 0;
        Pila aux = new Pila(p.tope);
        while (i < r) {
            int e = p.pop();
            while (!p.estaVacio()) {
                aux.push(p.pop());
            }
            aux.push(e);
            p.reset(aux);

            i++;
        }
    }

    /*ejer 18*/
    public Pila mezclaPilas(Pila a, Pila b) {
        Pila c = new Pila(a.tope + b.tope);
        Pila aux = new Pila(c.max);
        while (!a.estaVacio()) {
            aux.push(a.pop());
        }

        while (!b.estaVacio()) {
            aux.push(b.pop());
        }

        c.reset(aux);

        return c;
    }

}
