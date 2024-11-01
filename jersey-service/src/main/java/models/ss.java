package models;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import controller.tda.list.LinkedList;
import java.lang.reflect.Type;
import controller.tda.list.Node;

public class ss {  // Renombré la clase a Main
    public static void main(String[] args) {
        // Crear una lista enlazada de personas
        LinkedList<Persona> listaPersonas = new LinkedList<>();

        // Crear objetos de la clase Persona y agregarlos a la lista
        listaPersonas.add(new Persona(1, "Juan", "Pérez", "12345678", "987654321"));
        listaPersonas.add(new Persona(2, "Ana", "García", "87654321", "123456789"));
        listaPersonas.add(new Persona(3, "Luis", "Martínez", "11223344", "998877665"));

        // Crear un objeto Gson
        Gson gson = new Gson();

        // Convertir la lista de personas a formato JSON
        String listaPersonasJson = gson.toJson(listaPersonas);

        // Imprimir el JSON generado en la consola
        System.out.println(listaPersonasJson);

        // Guardar el JSON en un archivo dentro de src/main/java/Data
        String filePath = "src/main/java/Data/personas.json"; // Ruta del archivo
        
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(listaPersonasJson);
            System.out.println("JSON guardado en: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Leer el archivo 
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            Type listType = new TypeToken<LinkedList<Persona>>() {}.getType();
            LinkedList<Persona> loadedList = gson.fromJson(reader, listType);

            // Imprimir las personas 
            Node<Persona> current = loadedList.getHeader(); // Asume que hay un método getHeader() en LinkedList
            while (current != null) {
                Persona p = current.getInfo(); // Asegúrate de que getInfo() exista
                System.out.println("ID: " + p.getIdPersona() + ", Nombre: " + p.getNombre() + ", Apellido: " + p.getApellido() + ", DNI: " + p.getDNI());
                current = current.getNext(); // Asegúrate de que getNext() exista
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
