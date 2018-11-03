package com.company;

import java.util.LinkedList;
import java.util.List;

public class Main {
    private static List<Imagen> imagenes;

    public static void main(String[] args) {
        int a[][] = {{0,0,0,0,0,0,0,0,0,0,0},
                     {0,1,1,0,0,0,0,0,0,1,1},
                     {0,1,1,0,0,1,1,0,0,1,1},
                     {0,0,0,0,0,1,1,0,0,0,0},
                     {0,0,0,0,0,0,0,0,0,0,0},
                     {0,0,0,0,0,0,0,0,1,1,1},
                     {0,0,0,0,0,0,0,0,1,0,1},
                     {0,0,0,0,0,0,0,0,1,1,1}};
        imagenes = new LinkedList<>();

        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < a[i].length; j++){
                if (a[i][j] == 1 && !estaEnAlgunIntervalo(i,j,imagenes))
                    encontrarIntervalo(a, i, j);
            }
        }

        for (Imagen i: imagenes) {
            System.out.println(i.toString());
        }
    }

    private static void encontrarIntervalo(int a[][], int i, int j){
        int t1, t2;
        int s1 = i;
        int s2 = j;

        t1 = i;
        t2 = j;

        while (a[i][j] != 0){
            if ((i+1) == a.length)
                break;
            else if (a[i+1][j] == 0)
                break;
            else {
                i++;
                t1 = i;
            }
        }

        while (a[i][j] != 0){
            if ((j+1) == a[i].length)
                break;
            else if (a[i][j+1] == 0)
                break;
            else {
                j++;
                t2 = j;
            }
        }
        imagenes.add(new Imagen(s1, t1, s2, t2));
    }

    private static boolean estaEnAlgunIntervalo(int i, int j, List<Imagen> l){
        if (l.size() == 0)
            return false;
        else {
            boolean[] b = new boolean[l.size()];
            boolean e = false;
            for (int k = 0; k < l.size(); k++)
                b[k] = enIntervalo(i, j, l.get(k).getI1(), l.get(k).getJ1(),
                        l.get(k).getI2(), l.get(k).getJ2());
            for (int k = 0; k < b.length; k++){
                e = b[k];
                if (e)
                    break;
            }
            return e;
        }
    }

    private static boolean enIntervalo(int i, int j, int i1, int j1, int i2, int j2){
        return i >= i1 && i <= i2 && j >= j1 && j <= j2;
    }
}
