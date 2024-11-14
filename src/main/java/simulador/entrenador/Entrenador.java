package simulador.entrenador;

import java.util.LinkedList;
import java.util.Scanner;

public class Entrenador {
    private String nombre;
    private static Scanner sc = new Scanner(System.in);  

    // Constructor
    public Entrenador(String nombre) {
        this.nombre = nombre;
    }

    // Método  obtener el nombre
    public String getNombre() {
        return nombre;
    }

    // Método toString para representar el nombre del entrenador en texto
    @Override
    public String toString() {
        return nombre;
    }

    // Método para agregar entrenadores
    public static void agregarEntrenador(LinkedList<Entrenador> entrenadores) {
        System.out.println("Ingrese el nombre del entrenador:");
        String nombreEntrenador = sc.nextLine();
        
        // Crear y agregar el nuevo entrenador a la lista
        Entrenador nuevoEntrenador = new Entrenador(nombreEntrenador);
        entrenadores.add(nuevoEntrenador);
        
        System.out.println("Entrenador '" + nombreEntrenador + "' agregado a la lista.");
    }
}