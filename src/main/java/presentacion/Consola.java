package presentacion;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import logicaNegocio.ArchivosControlador;
import simulador.entrenador.Entrenador;
import simulador.pokemon.Pokemon;

public class Consola {

    public void iniciar() {
        final String NOMBRE_ARCHIVO = "miJuego.pokemon";
        List<Pokemon> pokemones = new LinkedList<>();
        LinkedList<Entrenador> entrenadores = new LinkedList<>();
        ArchivosControlador controlador = new ArchivosControlador();

        // Lectura de datos desde disco duro:
        Object object = controlador.leer(NOMBRE_ARCHIVO);
        if (object instanceof LinkedList) {
            pokemones = (LinkedList<Pokemon>) object;
            entrenadores = (LinkedList<Entrenador>) ((LinkedList) object).get(1);
        } else {
            System.out.println("No se pudo cargar la lista de Pokémones. Se creará una nueva.");
            pokemones = new LinkedList<>();
        }

        int opcionMenu;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Simulador de batallas Pokémon");
            System.out.println("-------------------------------");
            System.out.println("""
                    1. Gestionar Entrenador
                    2. Gestionar Pokémones
                    3. Iniciar Batalla
                    4. Salir""");
            System.out.print("Seleccione una opción: ");
            opcionMenu = sc.nextInt();

            switch (opcionMenu) {
                case 1 -> {
                    System.out.println("Gestionar Entrenadores");
                    System.out.println("""
                            1. Registrar nuevo entrenador
                            2. Ver lista de entrenadores
                            3. Seleccionar un entrenador
                            4. Volver al menú principal
                            """);
                    int opcionEntrenador;
                    opcionEntrenador = sc.nextInt();
                    do {
                        switch (opcionEntrenador) {
                            case 1 -> {
                                Entrenador.agregarEntrenador();
                                Entrenador.guardarEntrenadores(entrenadores, NOMBRE_ARCHIVO);
                                controlador.guardar(entrenadores, NOMBRE_ARCHIVO);
                                controlador.guardar(pokemones, NOMBRE_ARCHIVO);
                                opcionEntrenador = 4;
                            }
                            case 2 -> {
                                Entrenador.listaEntrenadores();
                                opcionEntrenador = 4;
                            }
                            case 3 -> {
                                Entrenador.gestionarEntrenador(entrenadores, sc);
                                opcionEntrenador = 4;
                            }
                            case 4 -> 
                                System.out.println("Volver al menú principal");
                        }
                    } while (opcionEntrenador != 4);
                }
                case 2 -> {
                    System.out.println("Gestionar Pokémones");
                    System.out.println("""
                            1. Ver todos los Pokémones disponibles
                            2. Registrar nuevo Pokémon
                            3. Volver al menú principal
                            """);
                    int opcionPokemon;
                    opcionPokemon = sc.nextInt();
                    do {
                        switch (opcionPokemon) {
                            case 1 -> {
                                System.out.println("""
                                    Drowzee
                                    Magnemite
                                    Mankey
                                    Meowth
                                    Oddish
                                    Poliwag
                                    Rhyhorn
                                    Spearow
                                    Vulpix
                                    """);
                            }
                            case 2 -> {
                                System.out.println("Debes tener seleccionado un entrenador para poder registrar un nuevo Pokémon. Por favor, selecciona un entrenador en la sección de gestión de entrenadores.");
                            }
                            case 3 -> {
                                System.out.println("Volver al menú principal");
                                opcionPokemon = 3;
                            }
                        }
                    } while (opcionPokemon != 3);

                    // Después de agregar un nuevo Pokémon, guardar ambas listas
                    controlador.guardar(entrenadores, NOMBRE_ARCHIVO);
                    controlador.guardar(pokemones, NOMBRE_ARCHIVO);
                }
                case 3 -> {
                    System.out.println("Iniciar Batalla");
                    System.out.println("""
                            1. Elegir entrenador 1
                            2. Elegir entrenador 2
                            3. Seleccionar Pokémon de entrenador 1
                            4. Seleccionar Pokémon de entrenador 2
                            5. Comenzar batalla
                            6. Volver al menú principal
                            """);
                    int opcionBatalla; 
                    opcionBatalla = sc.nextInt();       
                }
                case 4 -> {
                    System.out.println("Saliendo del simulador...");

                }
                default -> 
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcionMenu != 4);

    }
}
