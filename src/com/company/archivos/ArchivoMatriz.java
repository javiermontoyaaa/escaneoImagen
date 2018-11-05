package com.company.archivos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ArchivoMatriz {
    private static List<String> renglones;
    private static final String EOF = "";

    private static void leerArchivo(){
        try {
            FileReader file = new FileReader(
                    new File("src/com/company/archivos/matriz1.txt"));
            BufferedReader reader = new BufferedReader(file);
            renglones = new LinkedList<>();
            String line = EOF;
            while (line != null){
                line = reader.readLine();
                if (line != null)
                    renglones.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int[][] obtenerMatriz(){
        leerArchivo();
        int a[][] = new int[renglones.size()][renglones.get(renglones.size() - 1).length()/2 + 1];
        for (int i = 0; i < a.length; i++){
            String elementos[] = renglones.get(i).split(",");
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = Integer.parseInt(elementos[j]);
            }
        }

        return a;
    }

}
