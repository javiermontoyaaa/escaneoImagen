package com.company;

import com.company.archivos.controladores.Archivo;
import com.company.archivos.controladores.Imagen;
import com.company.imagen.Intervalo;

public class Main {

    public static void main(String[] args) {
        //Archivo
        System.out.println("Archivo: ");
        Intervalo.encontrarIntervalos(Archivo.obtenerMatriz(), 1,0);
        Intervalo.imprimirIntervalos();

        //Imagen
        System.out.println("Imagen: ");
        Intervalo.encontrarIntervalos(Imagen.obtenerMatriz(), -20791, -1);
        Intervalo.imprimirIntervalos();
        Imagen.crearImagen(Imagen.actualizarImagen(Imagen.obtenerMatriz(), Intervalo.getIntervalos()));
    }
}
