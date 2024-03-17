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
public class _32_generar_serie {

    public static void generarSerie(Pila p, int n) {
        //1 2 4 7 11 16...
        int val = 1;
        for (int i = 1; i <= n; i++) {
            p.push(val);
            val = val + i;// 1+1=2, 2+2=4, 4+3=7, 7+4=11, 11+5=16....
        }
    }
}
