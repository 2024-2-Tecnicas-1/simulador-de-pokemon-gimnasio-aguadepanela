package simulador.entrenador;

import java.util.LinkedList;
import java.util.Scanner;

public class Entrenador {
    final private String nombre;
    private static Scanner sc = new Scanner(System.in);  
    private static LinkedList<Entrenador> entrenadores = new LinkedList<>(); // Lista estática para almacenar entrenadores

    // Constructor
    public Entrenador(String nombre) {
        this.nombre = nombre;
    }

    // Método para obtener el nombre
    public String getNombre() {
        return nombre;
    }

    // Método toString para representar el nombre del entrenador en texto
    @Override
    public String toString() {
        return nombre;
    }

    // Método para agregar entrenadores a la lista
    public static void agregarEntrenador() {
        System.out.println("Ingrese el nombre del entrenador:");
        String nombreEntrenador = sc.nextLine().trim(); // Usar trim() para eliminar espacios extra
        
        if (nombreEntrenador.isEmpty()) {
            System.out.println("El nombre del entrenador no puede estar vacío.");
        } else {
            // Crear y agregar el nuevo entrenador a la lista
            Entrenador nuevoEntrenador = new Entrenador(nombreEntrenador);
            entrenadores.add(nuevoEntrenador);
            System.out.println("Entrenador '" + nombreEntrenador + "' agregado a la lista.");
        }
    }

    // Método para mostrar la lista de entrenadores
    public static void listaEntrenadores() {
        if (entrenadores.isEmpty()) {
            System.out.println("No hay entrenadores en la lista.");
        } else {
            System.out.println("Número de entrenadores: " + entrenadores.size());
            for (Entrenador entrenador : entrenadores) {
                System.out.println(entrenador);
            }
        }
    }
}
