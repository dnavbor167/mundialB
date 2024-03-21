/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author daniel
 */
public class metodosMundialB {

    //método para escribir en el fichero "idfichero"
    public static void escribir(String escribir) {
        String idFichero = "salida.txt";
        try {
            Files.write(Paths.get(idFichero), (escribir + "\n").getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
        } catch (IOException ex) {
            System.out.println("Error creando el fichero");
        }

    }

    //método para leer un fichero de texto plano
    //usa la clase Files
    public static List<String> leerFichero() {
        String nombreFichero = "leer.txt";
        List<String> lista = new ArrayList<>();
        try {
            //un objeto path es un objeto que te permite poner la ruta de un archivo
            lista = Files.readAllLines(Paths.get(nombreFichero));
        } catch (IOException ex) {
            System.out.println("Error accediendo a " + nombreFichero);
        }
        lista.remove(0);
        return lista;
    }

    //método para pasarle una lista y escribe en el fichero de salida
    public static void salida() {
        //le paso la lista + leer fichero para que lo guarde en la lista
        List<String> lista = leerFichero();
        //bucle for para que vaya recorriendo cada línea de la lista
        for (int i = 0; i < lista.size(); i++) {
            //array de String y guarda la línea i de la lista y en cada hueco
            //del array se guarda hasta un espacio
            String[] array = lista.get(i).split("\\s");
            //sumaResta, esta variable suma las 6 votaciones y se lo resta
            //a las votaciones totales que han de haber
            int suma = 0;
            
            for (int j = 0; j < array.length; j++) {
                suma += Integer.parseInt(array[j]);
            }
            
//             suma = (Integer.parseInt(array[1]) + Integer.parseInt(array[2])
//                    + Integer.parseInt(array[3]) + Integer.parseInt(array[4])
//                    + Integer.parseInt(array[5]) + Integer.parseInt(array[6]));

            //si hay menos votaciones se ejecuta este código
            if (Integer.parseInt(array[0]) < suma) {
                escribir("hay más votaciones de lo permitido");
            } else {
                String guardar = String.valueOf(suma);
                escribir(guardar);
            }

        }
    }
}
