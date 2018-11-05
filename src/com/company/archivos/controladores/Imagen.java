package com.company.archivos.controladores;

import com.company.imagen.Intervalo;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Imagen {
    private static BufferedImage imagenOriginal;

    public static int[][] obtenerMatriz(){
        File file = new File("src/com/company/archivos/image.png");
        try {
            BufferedImage imagen = ImageIO.read(file);
            imagenOriginal = imagen;
            int a[][] = new int[imagen.getWidth()][imagen.getHeight()];
            for (int i = 0; i < imagen.getWidth(); i++){
                for (int j = 0; j < imagen.getHeight(); j++) {
                    a[i][j] = imagen.getRGB(i, j);
                }
            }

            return a;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static int[][] actualizarImagen(int a[][], List<Intervalo> l){
        for (Intervalo in: l) {
            for (int j = in.getJ1(); j <= in.getJ2(); j++) {
                a[in.getI1()][j] = -16777216;
                a[in.getI1()+1][j] = -16777216;

                a[in.getI2()][j] = -16777216;
                a[in.getI2()-1][j] = -16777216;
            }

            for (int i = in.getI1(); i <= in.getI2(); i++){
                a[i][in.getJ1()] = -16777216;
                a[i][in.getJ1()+1] = -16777216;

                a[i][in.getJ2()] = -16777216;
                a[i][in.getJ2()-1] = -16777216;
            }
        }

        return a;
    }

    public static void crearImagen(int a[][]){
        File file = new File("src/com/company/archivos/imagen1.png");
        BufferedImage imagenActualizada = new BufferedImage(imagenOriginal.getWidth(),
                imagenOriginal.getHeight(), BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                imagenActualizada.setRGB(i, j, a[i][j]);
            }
        }

        try {
            ImageIO.write(imagenActualizada, "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
