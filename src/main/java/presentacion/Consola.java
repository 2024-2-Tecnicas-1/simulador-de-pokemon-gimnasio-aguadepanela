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
        List<Entrenador> entrenadores = new LinkedList<>();
        ArchivosControlador controlador = new ArchivosControlador();

        // Lectura de datos desde disco duro:
        Object object = controlador.leer(NOMBRE_ARCHIVO);
        pokemones = (LinkedList<Pokemon>) object; // Supongamos que el objeto leído es una lista de Pokémon
        // entrenadores = (LinkedList<Entrenador>) object; // Esto se debe manejar de forma separada.

        Scanner lector = new Scanner(System.in);
        System.out.println("Simulador de batallas Pokemón");
        System.out.println("-------------------------------");

        int opcionMenu;
        do {
            System.out.println("""
                               1. Gestionar Entrenador
                               2. Gestionar Pokemones
                               3. Iniciar Batalla
                               4. Salir""");
            opcionMenu = lector.nextInt();
            int opcionPokemon = 0;
            int opcionEntrenador = 0;

            switch (opcionMenu) {
                case 1 -> {
                    do {
                        System.out.println("Ingresa la operación");
                        System.out.println("1. Adicionar Pokemon a la lista");
                        System.out.println("2. Mostrar Pokemones");
                        System.out.println("0. Salir");

                        opcionPokemon = lector.nextInt();

                        switch (opcionPokemon) {
                            case 1 -> {
                                System.out.println("Selecciona el pokémon");
                                System.out.println("1.Drowzee");
                                System.out.println("2.Koffing");
                                System.out.println("3.Magnemite");
                                System.out.println("4.Mankey");
                                System.out.println("5.Meowth");
                                System.out.println("6.Oddish");
                                System.out.println("7.Poliwag");
                                System.out.println("8.Rhyhorn");
                                System.out.println("9.Spearow");
                                System.out.println("10.Vulpix");

                                int tipoPokemon = lector.nextInt();
                                switch (tipoPokemon) {
                                    case 1 ->
                                        pokemones.add(new Drowzee());
                                    case 2 ->
                                        pokemones.add(new Koffing());
                                    case 3 ->
                                        pokemones.add(new Magnemite());
                                    case 4 ->
                                        pokemones.add(new Mankey());
                                    case 5 ->
                                        pokemones.add(new Meowth());
                                    case 6 ->
                                        pokemones.add(new Oddish());
                                    case 7 ->
                                        pokemones.add(new Poliwag());
                                    case 8 ->
                                        pokemones.add(new Rhyhorn());
                                    case 9 ->
                                        pokemones.add(new Spearow());
                                    case 10 ->
                                        pokemones.add(new Vulpix());
                                    default ->
                                        System.out.println("Opción no válida. Por favor selecciona un número del 1 al 10.");
                                }
                                controlador.guardar(pokemones, NOMBRE_ARCHIVO);
                            }

                            case 2 -> {
                                System.out.println("Existen " + pokemones.size() + " pokemones en la lista:");
                                for (Pokemon pokemon : pokemones) {
                                    System.out.println(pokemon.getNombre());
                                }
                            }
                            case 0 -> {
                                // Salir del submenú de Pokémon
                            }
                            default ->
                                System.out.println("Opción no válida.");
                        }
                    } while (opcionPokemon != 0);
                }

                case 2 -> {
                    do {
                        System.out.println("Gestionar Entrenador");
                        System.out.println("""
                                                                   1. Registrar nuevo entrenador
                                                                   2. Ver lista de entrenadores
                                                                   3. Seleccionar un entrenador
                                                                   4. Volver al menu principal""");
                        opcionEntrenador = lector.nextInt();
                        // Implementar lógica para gestionar entrenadores
                    } while (opcionEntrenador != 4);
                }

                case 3 -> {
                }

                case 4 -> System.out.println("Saliendo del simulador. ¡Hasta luego!");

                default -> System.out.println("Opción no válida. Por favor selecciona un número del 1 al 4.");
            }
            // Implementar lógica para iniciar batalla
                    } while (opcionMenu != 4);

    }
}
