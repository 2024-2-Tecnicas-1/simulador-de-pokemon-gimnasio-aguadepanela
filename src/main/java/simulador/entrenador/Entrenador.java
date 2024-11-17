package simulador.entrenador;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import persistencia.ArchivosConexion;

public class Entrenador {
    final private String nombre;
    private static Scanner sc = new Scanner(System.in);  
    private static LinkedList<Entrenador> entrenadores = new LinkedList<>(); // Lista estática para almacenar entrenadores

    // Constructor
    public Entrenador(String nombre) {
        this.nombre = nombre;
    }

    // Obtener el nombre
    public String getNombre() {
        return nombre;
    }

    // Método toString para representar el nombre del entrenador en texto
    @Override
    public String toString() {
        return nombre;
    }

    // Agregar entrenadores a la lista
    public static void agregarEntrenador() {
        System.out.println("Ingrese el nombre del entrenador:");
        String nombreEntrenador = sc.nextLine(); 
        
        if (nombreEntrenador.isEmpty()) {
            System.out.println("El nombre del entrenador no puede estar vacío.");
        } else {
            // Crear y agregar el nuevo entrenador a la lista
            Entrenador nuevoEntrenador = new Entrenador(nombreEntrenador);
            entrenadores.add(nuevoEntrenador);
            System.out.println("Entrenador '" + nombreEntrenador + "' agregado a la lista.");
        }
    }

    // Mostrar la lista de entrenadores
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

    // Método para guardar la lista de entrenadores en un archivo
    public static void guardarEntrenadores(String nombreArchivo) {
        ArchivosConexion.guardar(entrenadores, nombreArchivo);
        System.out.println("Entrenadores guardados en: " + nombreArchivo);
    }

    // Seleccionar un entrenador de la lista
    public static Entrenador seleccionarEntrenador(List<Entrenador> entrenadores, Scanner sc) {
        if (entrenadores.isEmpty()) {
            System.out.println("No hay entrenadores disponibles para seleccionar.");
            return null; // Retorna null si no hay entrenadores
        }

        System.out.println("Seleccione el número del entrenador:");
        for (int i = 0; i < entrenadores.size(); i++) {
            System.out.println((i + 1) + ". " + entrenadores.get(i).getNombre());
        }

        int seleccion;
        try {
            String entrada = sc.nextLine();
            seleccion = Integer.parseInt(entrada); 
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Debe ingresar un número.");
            return null;
        }

        if (seleccion < 1 || seleccion > entrenadores.size()) {
            System.out.println("Selección fuera de rango.");
            return null;
        }

        Entrenador entrenadorSeleccionado = entrenadores.get(seleccion - 1);
        System.out.println("Entrenador seleccionado: " + entrenadorSeleccionado.getNombre());
        return entrenadorSeleccionado;
    }
}