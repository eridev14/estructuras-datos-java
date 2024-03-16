/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vectores;

import javax.swing.JOptionPane;

/**
 *
 * @author RedesPC
 */
public class Vectores {

    public void leerVector(int v[], int n) {
        for (int i = 0; i < n; i++) {
            v[i] = Integer.parseInt(JOptionPane.showInputDialog("ingrese num"));
        }
    }

    public String imprimirVector(int v[], int n) {
        String s = "[ ";
        for (int i = 0; i < n; i++) {
            s += " " + v[i];
        }
        return s + " ]";
    }

    public void ordenarBurbuja(int v[]) {
        for (int i = 0; i < v.length - 1; i++) {
            for (int j = i + 1; j < v.length; j++) {
                if (v[j] < v[i]) {
                    int aux = v[j];
                    v[j] = v[i];
                    v[i] = aux;
                }
            }
        }
    }

    public int busquedaBinaria(int v[], int x) {
        int izq = 0;
        int der = v.length;
        while (izq <= der) {
            int mid = (int) (izq + der) / 2;

            if (v[mid] == x) {
                return mid;
            }

            if (x > v[mid]) {
                izq = mid + 1;
            } else {
                der = mid - 1;
            }
        }

        return -1;
    }

    public void buscarElemento(int v[], int x) {
        ordenarBurbuja(v);
        int bin = busquedaBinaria(v, x);
        if (bin == -1) {
            JOptionPane.showMessageDialog(null, "no existe el valor");
        } else {
            JOptionPane.showMessageDialog(null, "valor esta en v[" + bin + "]");
        }
    }

    public int sumarVector(int v[]) {
        int sum = 0;
        for (int i = 0; i < v.length; i++) {
            sum += v[i];
        }
        return sum;
    }

    

}
