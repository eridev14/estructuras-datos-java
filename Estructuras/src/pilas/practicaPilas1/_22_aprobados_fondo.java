/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilas.practicaPilas1;

import pilas.Pila;

/**
 *
 * @author ERIK
 *
 * ejer 22 - dada una pila P, con datos de notas de esudiantes llevar los
 * aprobados al fondo de la pila y los reprobados despues de los aprobados.
 *
 */
public class _22_aprobados_fondo {
    
    public static void aprobadosFondo(Pila p) {
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
}
