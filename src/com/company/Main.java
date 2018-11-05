package com.company;

import com.company.archivos.ArchivoMatriz;
import com.company.imagen.Intervalo;

public class Main {

    public static void main(String[] args) {
        Intervalo.encontrarIntervalos(ArchivoMatriz.obtenerMatriz());
        Intervalo.imprimirIntervalos();
    }
}
