package com.company.imagen;

import java.util.LinkedList;
import java.util.List;

public class Intervalo {
    private static List<Intervalo> intervalos;
    private int i1;
    private int i2;
    private int j1;
    private int j2;

    private Intervalo(int i1, int i2, int j1, int j2) {
        this.i1 = i1;
        this.i2 = i2;
        this.j1 = j1;
        this.j2 = j2;
    }

    public static void encontrarIntervalos(int a[][], int colorImagen, int colorFondo){
        intervalos = new LinkedList<>();
        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < a[i].length; j++){
                if (a[i][j] == colorImagen && !estaEnAlgunIntervalo(i,j,intervalos))
                    encontrarIntervalo(a, i, j, colorFondo);
            }
        }
    }

    private static void encontrarIntervalo(int a[][], int i, int j, int colorFondo){
        int t1, t2;
        int s1 = i;
        int s2 = j;

        t1 = i;
        t2 = j;

        while (a[i][j] != colorFondo){
            if ((i+1) == a.length)
                break;
            else if (a[i+1][j] == colorFondo)
                break;
            else {
                i++;
                t1 = i;
            }
        }

        while (a[i][j] != colorFondo){
            if ((j+1) == a[i].length)
                break;
            else if (a[i][j+1] == colorFondo)
                break;
            else {
                j++;
                t2 = j;
            }
        }
        intervalos.add(new Intervalo(s1, t1, s2, t2));
    }

    private static boolean estaEnAlgunIntervalo(int i, int j, List<Intervalo> l){
        if (l.size() == 0)
            return false;
        else {
            boolean[] b = new boolean[l.size()];
            boolean e = false;
            for (int k = 0; k < l.size(); k++)
                b[k] = enIntervalo(i, j, l.get(k).getI1(), l.get(k).getJ1(),
                        l.get(k).getI2(), l.get(k).getJ2());
            for (boolean t: b) {
                e = t;
                if (e)
                    break;
            }
            return e;
        }
    }

    private static boolean enIntervalo(int i, int j, int i1, int j1, int i2, int j2){
        return i >= i1 && i <= i2 && j >= j1 && j <= j2;
    }

    public static void imprimirIntervalos(){
        for (Intervalo i: intervalos) {
            System.out.println(i.toString());
        }
    }

    public int getI1() {
        return i1;
    }

    public int getI2() {
        return i2;
    }

    public int getJ1() {
        return j1;
    }

    public int getJ2() {
        return j2;
    }

    public static List<Intervalo> getIntervalos() {
        return intervalos;
    }

    @Override
    public String toString() {
        return "(" + i1 + ", " + i2 + ") " + " (" + j1 + ", " + j2 + ")";
    }
}
