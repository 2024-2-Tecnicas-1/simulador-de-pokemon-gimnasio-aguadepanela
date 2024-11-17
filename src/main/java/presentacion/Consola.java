package presentacion;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import logicaNegocio.ArchivosControlador;
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
import simulador.entrenador.Entrenador;
import simulador.pokemon.Pokemon;

public class Consola {

    public void iniciar() {
        final String NOMBRE_ARCHIVO = "miJuego.pokemon";
        List<Pokemon> pokemones = new LinkedList<>();
        LinkedList<Entrenador> entrenadores = new LinkedList<>(); // Lista de entrenadores
        ArchivosControlador controlador = new ArchivosControlador();

        // Lectura de datos desde disco duro:
        Object object = controlador.leer(NOMBRE_ARCHIVO);
        if (object instanceof LinkedList) {
            pokemones = (LinkedList<Pokemon>) object;
        } else {
            System.out.println("No se pudo cargar la lista de Pokémones. Se creará una nueva.");
            pokemones = new LinkedList<>();
        }

        Scanner lector = new Scanner(System.in);
        System.out.println("Simulador de batallas Pokémon");
        System.out.println("-------------------------------");

        int opcionMenu;
        do {
            System.out.println("""
                               1. Gestionar Entrenador
                               2. Gestionar Pokémones
                               3. Iniciar Batalla
                               4. Salir""");
            opcionMenu = lector.nextInt();

            switch (opcionMenu) {
                case 1 -> {
                    int opcionEntrenador;
                    do {
                        System.out.println("Gestionar Entrenador");
                        System.out.println("""
                        1. Registrar nuevo entrenador
                        2. Ver lista de entrenadores
                        3. Seleccionar un entrenador
                        4. Volver al menú principal""");
                        opcionEntrenador = lector.nextInt();
                        

                        switch (opcionEntrenador) {
                            case 1 -> {Entrenador.agregarEntrenador();
                            Entrenador.guardarEntrenadores(NOMBRE_ARCHIVO);
                            }
                            case 2 -> Entrenador.listaEntrenadores();

                            case 3 -> Entrenador.seleccionarEntrenador(entrenadores, lector);

                            case 4 -> System.out.println("Volviendo al menú principal...");

                            default -> System.out.println("Opción no válida.");
                        }
                    } while (opcionEntrenador != 4);
                }

                case 2 -> {
                    int opcionPokemon;
                    do {
                        System.out.println("""
                                           1. Agregar un nuevo Pokémon
                                           2. Ver lista de Pokémones
                                           0. Volver al menú principal""");
                        opcionPokemon = lector.nextInt();

                        switch (opcionPokemon) {
                            case 1 -> {
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

                                int tipoPokemon = lector.nextInt();
                                switch (tipoPokemon) {
                                    case 1 -> pokemones.add(new Drowzee());
                                    case 2 -> pokemones.add(new Koffing());
                                    case 3 -> pokemones.add(new Magnemite());
                                    case 4 -> pokemones.add(new Mankey());
                                    case 5 -> pokemones.add(new Meowth());
                                    case 6 -> pokemones.add(new Oddish());
                                    case 7 -> pokemones.add(new Poliwag());
                                    case 8 -> pokemones.add(new Rhyhorn());
                                    case 9 -> pokemones.add(new Spearow());
                                    case 10 -> pokemones.add(new Vulpix());
                                    default -> System.out.println("Opción no válida. Selecciona un número del 1 al 10.");
                                }
                                controlador.guardar(pokemones, NOMBRE_ARCHIVO);
                                System.out.println("Pokémon añadido a la lista.");
                            }

                            case 2 -> {
                                System.out.println("Existen " + pokemones.size() + " Pokémones en la lista:");
                                for (Pokemon pokemon : pokemones) {
                                    System.out.println(pokemon.getNombre());
                                }
                            }

                            case 0 -> System.out.println("Volviendo al menú principal...");

                            default -> System.out.println("Opción no válida.");
                        }
                    } while (opcionPokemon != 0);
                }

                case 3 -> {
                    
                }

                case 4 -> System.out.println("Saliendo del simulador. ¡Hasta luego!");

                default -> System.out.println("Opción no válida. Selecciona un número del 1 al 4.");
            }
        } while (opcionMenu != 4);
    }
}
