package simulador.entrenador;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import logicaNegocio.Drowzee;
import logicaNegocio.Koffing;
import logicaNegocio.Magnemite;
import logicaNegocio.Mankey;
import logicaNegocio.Meowth;
import logicaNegocio.Oddish;
import logicaNegocio.Poliwag;
import logicaNegocio.Rhyhorn;
import logicaNegocio.Spearow;
import logicaNegocio.Vulpix;
import persistencia.ArchivosConexion;
import simulador.pokemon.Pokemon;

public class Entrenador {
    private final String nombre; // Nombre del entrenador
    private List<Pokemon> pokemones; // Lista de Pokémones que el entrenador ha capturado y entrenado
    private static Scanner sc = new Scanner(System.in);  
    private static LinkedList<Entrenador> entrenadores = new LinkedList<>(); // Lista estática para almacenar entrenadores

    // Constructor
    public Entrenador(String nombre) {
        this.nombre = nombre;
        this.pokemones = new LinkedList<>(); // Inicializa la lista de Pokémones
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
    public static void guardarEntrenadores(LinkedList<Entrenador> entrenadores1, String nombreArchivo) {
        ArchivosConexion.guardar(entrenadores, nombreArchivo);
        System.out.println("Entrenadores guardados en: " + nombreArchivo);
    }

    // Agregar un Pokémon al equipo del entrenador
    public void agregarPokemon() {
        System.out.println("Selecciona el Pokémon:");
        System.out.println("""
                           1. Drowzee
                           2. Koffing
                           3. Magnemite
                           4. Mankey
                           5. Meowth
                           6. Oddish
                           7. Poliwag
                           8. Rhyhorn
                           9. Spearow
                           10. Vulpix""");
        int tipoPokemon = sc.nextInt();
        Pokemon nuevoPokemon = null;
        switch (tipoPokemon) {
            case 1 -> nuevoPokemon = new Drowzee();
            case 2 -> nuevoPokemon = new Koffing();
            case 3 -> nuevoPokemon = new Magnemite();
            case 4 -> nuevoPokemon = new Mankey();
            case 5 -> nuevoPokemon = new Meowth();
            case 6 -> nuevoPokemon = new Oddish();
            case 7 -> nuevoPokemon = new Poliwag();
            case 8 -> nuevoPokemon = new Rhyhorn();
            case 9 -> nuevoPokemon = new Spearow();
            case 10 -> nuevoPokemon = new Vulpix();
            default -> System.out.println("Opción no válida. Selecciona un número del 1 al 10.");
        }

        if (nuevoPokemon != null) {
            pokemones.add(nuevoPokemon);
            System.out.println("Pokémon '" + nuevoPokemon.getNombre() + "' agregado al equipo de " + nombre);
        }
    }

    // Entrenar un Pokémon, mejorando sus estadísticas
    public void entrenarPokemon() {
        mostrarPokemones();
        System.out.println("Seleccione el número del Pokémon a entrenar:");
        int seleccion;
        try {
            seleccion = sc.nextInt();
            sc.nextLine(); 
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Debe ingresar un número.");
            return;
        }

        if (seleccion < 1 || seleccion > pokemones.size()) {
            System.out.println("Selección fuera de rango.");
            return;
        }

        Pokemon pokemonSeleccionado = pokemones.get(seleccion - 1);
        pokemonSeleccionado.entrenar();
        System.out.println("Pokémon '" + pokemonSeleccionado.getNombre() + "' ha sido entrenado.");
    }

    // Mostrar la lista de Pokémones actuales del entrenador
    public void mostrarPokemones() {
        if (pokemones.isEmpty()) {
            System.out.println("No hay Pokémones en el equipo de " + nombre);
        } else {
            System.out.println("Pokémones de " + nombre + ":");
            for (int i = 0; i < pokemones.size(); i++) {
                System.out.println((i + 1) + ". " + pokemones.get(i).getNombre());
            }
        }
    }

    // Seleccionar un Pokémon de su equipo para participar en una batalla
    public Pokemon prepararBatalla() {
        if (pokemones.isEmpty()) {
            System.out.println("No hay Pokémones disponibles para la batalla.");
            return null;
        }

        mostrarPokemones();
        System.out.println("Seleccione el número del Pokémon para la batalla:");
        int seleccion;
        try {
            seleccion = sc.nextInt();
            sc.nextLine(); 
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Debe ingresar un número.");
            return null;
        }

        if (seleccion < 1 || seleccion > pokemones.size()) {
            System.out.println("Selección fuera de rango.");
            return null;
        }

        Pokemon pokemonSeleccionado = pokemones.get(seleccion - 1);
        System.out.println("Pokémon seleccionado para la batalla: " + pokemonSeleccionado.getNombre());
        return pokemonSeleccionado;
    }

    // Método para gestionar el entrenador y sus Pokémones
    public static void gestionarEntrenador(LinkedList<Entrenador> entrenadores1, Scanner lector) {
        if (entrenadores.isEmpty()) {
            System.out.println("No hay entrenadores disponibles.");
            return;
        }

        System.out.println("Seleccione un entrenador:");
        for (int i = 0; i < entrenadores.size(); i++) {
            System.out.println((i + 1) + ". " + entrenadores.get(i).getNombre());
        }

        int seleccion;
        try {
            seleccion = sc.nextInt();
            sc.nextLine(); 
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Debe ingresar un número.");
            return;
        }

        if (seleccion < 1 || seleccion > entrenadores.size()) {
            System.out.println("Selección fuera de rango.");
            return;
        }

        Entrenador entrenadorSeleccionado = entrenadores.get(seleccion - 1);
        gestionarPokemones(entrenadorSeleccionado);
    }

    private static void gestionarPokemones(Entrenador entrenador) {
        boolean continuar = true;
        while (continuar) {
            System.out.println("Gestión de Pokémones para " + entrenador.getNombre());
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar Pokémon");
            System.out.println("2. Entrenar Pokémon");
            System.out.println("3. Mostrar Pokémones");
            System.out.println("4. Volver");

            int opcion;
            try {
                opcion = sc.nextInt();
                sc.nextLine(); 
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Debe ingresar un número.");
                continue;
            }

            switch (opcion) {
                case 1:
                    entrenador.agregarPokemon();
                    
                    break;
                case 2:
                    entrenador.entrenarPokemon();
                    break;
                case 3:
                    entrenador.mostrarPokemones();
                    break;
                case 4:
                continuar = false;
                default:
                    System.out.println("Opción no válida. Seleccione un número del 1 al 5.");
            }
        }
    }

    public Object getPokemones() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}