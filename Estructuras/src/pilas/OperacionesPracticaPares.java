/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilas;

/**
 *
 * @author ERIK
 */
public class OperacionesPracticaPares {

    /**
     * ejer 02
     *
     * En una Pila P llenar n datos de forma aleatoria en la pila
     *
     * @param p
     * @param n
     */
    public void llenarRandom(Pila p, int n) {
        int i = 0;
        while (i < n) {
            int e = (int) (Math.random() * 100);
            p.push(e);
            i++;
        }
    }

    /**
     * ejer 04
     *
     * Dada una pila P, insertar un x al fondo de la Pila
     *
     * @param p
     * @param x
     */
    public void insertarFondo(Pila p, int x) {
        Pila aux = new Pila(p.max);
        while (!p.estaVacio()) {
            aux.push(p.pop());
        }
        p.push(x);
        p.reset(aux);
    }

    /**
     * ejer 06
     *
     * Dada una Pila P, Eliminar el primer elemento (el del fondo) de la pila p
     *
     * @param p
     */
    public void eliminarFondo(Pila p) {
        Pila aux = new Pila(p.max);
        while (!p.estaVacio()) {
            aux.push(p.pop());
        }
        aux.pop();
        p.reset(aux);
    }

    /**
     * ejer 08
     *
     * Dada una pila P, Mostrar el o los elementos centrales de la pila
     * (considerando que el tamaño de la pila puede ser par o impar)
     *
     * @param p
     * @return
     */
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

    /**
     * ejer 10
     *
     * Dada una Pila P, eliminar los elementos repetidos Ej.P(1,2,8,2,3,8,8) →
     * resultado: p(1,2,8,3)
     *
     * @param p
     */
    public void eliminarRepetidos(Pila p) {
        Pila aux = new Pila(p.tope);
        while (!p.estaVacio()) {
            int e = p.pop();
            Operaciones op = new Operaciones();
            op.eliminarTodoElem(p, e);
            aux.push(e);
        }
        
        p.reset(aux);
    }

    /**
     * ejer 12
     *
     * Dada una pila P, Intercambiar cada elemento de la pila con su adyacente
     *
     * @param p
     */
    public void intercambiarAdyacente(Pila p) {
        Pila aux = new Pila(p.max);
        while (!p.estaVacio()) {
            int first = p.pop();
            if (p.estaVacio()) {
                aux.push(first);
                break;
            }
            int second = p.pop();
            aux.push(second);
            aux.push(first);
        }
        
        p.reset(aux);
    }

    /**
     * ejer 14
     *
     * Dada una Pila P, llevar los pares al fondo de la pila y luego los
     * impares.
     *
     * @param p
     */
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

    /**
     * ejer 16
     *
     * Dada una Pila P, realizar la rotación de datos r-veces
     *
     * @param p
     * @param r
     */
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

    /**
     * ejer 18
     *
     * Dada dos pilas A,B, realizar la mescla en una tercera pila C
     *
     * @param a
     * @param b
     * @return
     */
    public Pila mezclaPilas(Pila a, Pila b) {
        Pila c = new Pila(a.tope + b.tope);
        Pila aux = new Pila(c.max);
        while (!a.estaVacio() || !b.estaVacio()) {
            if (!a.estaVacio()) {
                aux.push(a.pop());
            }
            if (!b.estaVacio()) {
                aux.push(b.pop());
            }
        }
        
        c.reset(aux);
        
        return c;
    }

    /**
     * ejer 20
     *
     * Dada dos Pilas A,B, realizar la Intersección de elementos de una Pila
     * C(la intersección debe ser con en teoría de conjuntos)
     *
     * @param a
     * @param b
     * @return String
     */
    public String interseccion(Pila a, Pila b) {
        eliminarRepetidos(a);
        eliminarRepetidos(b);
        String str = "";
        Pila baux = new Pila(b.max);
        while (!a.estaVacio()) {
            int val = a.pop();
            while (!b.estaVacio()) {
                int elem = b.pop();
                if (val == elem) {
                    str += val + " ";
                } else {
                    baux.push(elem);
                }
            }
            b.reset(baux);
        }
        
        return "{ " + str + "}";
    }

    /**
     * ejer 22
     *
     * Dada una Pila P, con datos de notas de estudiantes llevar los aprobados
     * al fondo de la pila y los reprobados después de los aprobados.
     *
     * @param p
     */
    public void aprobadosFondo(Pila p) {
        Pila aprobados = new Pila(p.max);
        Pila reprobados = new Pila(p.max);
        
        while (!p.estaVacio()) {
            int nota = p.pop();
            if (nota > 60) {
                aprobados.push(nota);
            } else {
                reprobados.push(nota);
            }
        }
        p.reset(aprobados);
        p.reset(reprobados);
    }

    /**
     * Ejer 24
     *
     * Dada una Pila P, eliminar todos los elementos pares.
     *
     * @param p
     */
    public void eliminarPares(Pila p) {
        Pila aux = new Pila(p.max);
        while (!p.estaVacio()) {
            int elem = p.pop();
            if (elem % 2 == 1) {
                aux.push(elem);
            }
        }
        
        p.reset(aux);
    }

    /**
     * Ejer 26
     *
     * Dada una pila P, eliminar todos los primos de la pila
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
    
    public void eliminarPrimos(Pila p) {
        Pila aux = new Pila(p.max);
        while (!p.estaVacio()) {
            int elem = p.pop();
            if (!esPrimo(elem)) {
                aux.push(elem);
            }
        }
        
        p.reset(aux);
    }

    /**
     * Ejer 28
     *
     * Dada una pila P, eliminar todos los elementos múltiplos de X
     *
     * @param p
     * @param x
     */
    public void eliminarMultiplos(Pila p, int x) {
        Pila aux = new Pila(p.max);
        while (!p.estaVacio()) {
            int elem = p.pop();
            if (elem % x != 0) {
                aux.push(elem);
            }
        }
        p.reset(aux);
    }

    /**
     * Ejer 30
     *
     * Hallar la frecuencia(cantidad) de repetición de cada elemento de la pila
     *
     * @param p
     * @return s string
     */
    public String frecuencia(Pila p) {
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

    /**
     * Ejer 32
     *
     * En una pila P, generar la siguiente serie S=1,2,4,7,11,16,….
     *
     * @param p
     * @param n
     */
    public void generarSerie(Pila p, int n) {
        //1 2 4 7 11 16...
        int val = 1;
        for (int i = 1; i <= n; i++) {
            p.push(val);
            val = val + i;// 1+1=2, 2+2=4, 4+3=7, 7+4=11, 11+5=16....
        }
    }
}
