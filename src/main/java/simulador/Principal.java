package simulador;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    static ArrayList<String> entrenadores = new ArrayList<>();
    static String entrenadorSeleccionado = null;

    public static void main(String[] args) {
        // Menu principal//
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Simulador de batallas Pokemón");
            System.out.println("-------------------------------");
            System.out.println("""
                               1. Gestionar Entrenador
                               2. Gestionar Pokemones
                               3. Iniciar Batalla
                               4. Salir""");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.println("Gestionar Entrenador\n-------------------------------");
                    System.out.println("Que desea hacer?");
                    System.out.println("""
                                       1. Registrar nuevo entrenador
                                       2. Ver lista de entrenadores
                                       3. Seleccionar un entrenador
                                       4. Volver al menu principal""");
                    int opcionEntrenador = sc.nextInt();
                    switch (opcionEntrenador) {
                        case 1 -> {
                            // Registrar un nuevo entrenador
                            System.out.print("Ingrese el nombre del nuevo entrenador: ");
                            String nombreEntrenador = sc.next();
                            entrenadores.add(nombreEntrenador);
                            System.out.println("Entrenador " + nombreEntrenador + " registrado.");
                        }
                        case 2 -> {
                            // Ver la lista de entrenadores
                            if (entrenadores.isEmpty()) {
                                System.out.println("No hay entrenadores registrados.");
                            } else {
                                System.out.println("Lista de entrenadores:");
                                for (int i = 0; i < entrenadores.size(); i++) {
                                    System.out.println((i + 1) + ". " + entrenadores.get(i));
                                }
                            }
                        }
                        case 3 -> {
                            // Seleccionar un entrenador
                            if (entrenadores.isEmpty()) {
                                System.out.println("No hay entrenadores disponibles.");
                            } else {
                                System.out.println("Seleccione un entrenador:");
                                for (int i = 0; i < entrenadores.size(); i++) {
                                    System.out.println((i + 1) + ". " + entrenadores.get(i));
                                }
                                int seleccion = sc.nextInt();

                                if (seleccion > 0 && seleccion <= entrenadores.size()) {
                                    entrenadorSeleccionado = entrenadores.get(seleccion - 1);
                                    System.out.println("Entrenador seleccionado: " + entrenadorSeleccionado);
                                } else {
                                    System.out.println("Selección no válida.");
                                }
                            }
                        }
                        case 4 -> {
                        }
                        default -> System.out.println("Opción no válida.");
                    }
                    // Volver al menú principal
                }

                case 2 -> {
                    if (entrenadorSeleccionado == null) {
                        System.out.println("No hay entrenador seleccionado.");
                        return;
                    }

                    System.out.println("Gestionar Pokémones\n-------------------------------");
                    int opcionGestionPokemon;

                    do {
                        System.out.println("\nGestión de equipo del entrenador " + entrenadorSeleccionado);
                        System.out.println("1. Ver equipo de Pokémones");
                        System.out.println("2. Agregar Pokémon al equipo");
                        System.out.println("3. Entrenar Pokémon");
                        System.out.println("4. Volver a Gestionar Entrenadores");
                        System.out.print("Elige una opción: ");
                        opcionGestionPokemon = sc.nextInt();

                        switch (opcionGestionPokemon) {
                            case 1 -> System.out.println("Mostrando el equipo de Pokémon del entrenador...");
                            case 2 -> System.out.println("Agregando un Pokémon al equipo...");
                            case 3 -> System.out.println("Entrenando Pokémon...");
                            case 4 -> System.out.println("Volviendo a Gestión de Entrenadores...");
                            default -> System.out.println("Opción no válida.");
                        }
                    } while (opcionGestionPokemon != 4);
                }
                case 3 -> System.out.println("Iniciar Batalla\n-------------------------------");
                case 4 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida. Por favor, elija una opción del menú.");
            }
        } while (opcion != 4);
    }

}
