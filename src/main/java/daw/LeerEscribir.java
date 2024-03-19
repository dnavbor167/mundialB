/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.io.File;
import java.io.FileNotFoundException;
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
public class LeerEscribir {
    public static void escribir() {
        String idFichero = "salida.txt";
        Scanner sc = new Scanner(System.in);
        String pregunta = "";
        //este bucle se va a repetir hasta que llegue a la letra fin
        do {
            //le preguntamos al usuario que introduzca algo que añadir al texto
            System.out.println("Introduce la línea que quieres añadir");
            pregunta = sc.nextLine();

            if (!pregunta.equalsIgnoreCase("fin")) {
                try {
                    Files.write(Paths.get(idFichero), (pregunta + "\n").getBytes(StandardCharsets.UTF_8),
                            StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
                } catch (IOException ex) {
                    System.out.println("Error creando el fichero");
                }
            }

        } while (!pregunta.equalsIgnoreCase("fin"));
        
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
}
