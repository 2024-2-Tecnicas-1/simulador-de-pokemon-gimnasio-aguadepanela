package simulador.batalla;

import java.util.LinkedList;
import java.util.Scanner;
import presentacion.Consola;
import logicaNegocio.ArchivosControlador;
import simulador.entrenador.Entrenador;
import simulador.pokemon.Pokemon;

public class Batalla {
    private static Scanner sc = new Scanner(System.in);
    private static final String NOMBRE_ARCHIVO = "entrenadores.pokemon";

    // Mensajes constantes
    private static final String MENSAJE_NO_ENTRENADORES = "No hay suficientes entrenadores para iniciar una batalla.";
    private static final String MENSAJE_SELECCION_INVALIDA = "Selección no válida, por favor elige un número de la lista.";
    private static final String MENSAJE_BATALLA_COMIENZA = "¡La batalla ha comenzado entre %s y %s!";
    private static final String MENSAJE_POKEMON_DERROTADO = "%s ha sido derrotado. ¡%s gana la batalla!";

    public static void iniciarBatalla(LinkedList<Entrenador> entrenadores) {
        if (entrenadores.isEmpty()) {
            entrenadores = cargarEntrenadores();
        }

        if (entrenadores.size() < 2) {
            System.out.println(MENSAJE_NO_ENTRENADORES);
            Consola consola = new Consola();
            consola.iniciar();
            return;
        }

        Entrenador entrenador1 = seleccionarEntrenador(entrenadores);
        Entrenador entrenador2 = seleccionarEntrenador(entrenadores);

        Pokemon pokemon1 = seleccionarPokemon(entrenador1);
        Pokemon pokemon2 = seleccionarPokemon(entrenador2);

        if (pokemon1 == null || pokemon2 == null) {
            System.out.println("No se puede iniciar la batalla debido a Pokémon no disponibles.");
            return;
        }

        System.out.println(String.format(MENSAJE_BATALLA_COMIENZA, pokemon1.getNombre(), pokemon2.getNombre()));
        while (pokemon1.getSalud() > 0 && pokemon2.getSalud() > 0) {
            if (realizarAtaque(pokemon1, pokemon2)) return;
            if (realizarAtaque(pokemon2, pokemon1)) return;
        }
    }

    private static boolean realizarAtaque(Pokemon atacante, Pokemon defensor) {
        System.out.println("Presiona Enter para que " + atacante.getNombre() + " ataque.");
        sc.nextLine();
        atacante.atacar(defensor);
        if (defensor.getSalud() <= 0) {
            System.out.println(String.format(MENSAJE_POKEMON_DERROTADO, defensor.getNombre(), atacante.getNombre()));
            guardarEntrenadores(cargarEntrenadores());
            return true;
        }
        return false;
    }

    private static Entrenador seleccionarEntrenador(LinkedList<Entrenador> entrenadores) {
        System.out.println("Entrenadores disponibles:");
        for (int i = 0; i < entrenadores.size(); i++) {
            System.out.println((i + 1) + ". " + entrenadores.get(i).getNombre());
        }

        int seleccion = -1;
        while (seleccion < 0 || seleccion >= entrenadores.size()) {
            System.out.println("Selecciona el número del Entrenador:");
            try {
                seleccion = sc.nextInt() - 1;
                sc.nextLine();
                if (seleccion < 0 || seleccion >= entrenadores.size()) {
                    System.out.println(MENSAJE_SELECCION_INVALIDA);
                }
            } catch (Exception e) {
                System.out.println("Entrada no válida. Por favor, ingresa un número.");
                sc.nextLine(); 
            }
        }
        return entrenadores.get(seleccion);
    }

    private static Pokemon seleccionarPokemon(Entrenador entrenador) {
        LinkedList<Pokemon> pokemones = (LinkedList<Pokemon>) entrenador.getPokemones();
        if (pokemones.isEmpty()) {
            System.out.println("Este entrenador no tiene Pokémon.");
            return null;
        }

        entrenador.mostrarPokemones();
        System.out.println("Seleccione el número del Pokémon para la batalla:");
        int seleccion = -1;
        while (seleccion < 0 || seleccion >= pokemones.size()) {
            try {
                seleccion = sc.nextInt() - 1;
                sc.nextLine();
                if (seleccion < 0 || seleccion >= pokemones.size()) {
                    System.out.println("Selección no válida. Por favor, elige un número de la lista.");
                }
            } catch (Exception e) {
                System.out.println("Entrada no válida. Por favor, ingresa un número.");
                sc.nextLine(); 
            }
        }
        return pokemones.get(seleccion);
    }

    private static LinkedList<Entrenador> cargarEntrenadores() {
        ArchivosControlador controlador = new ArchivosControlador();
        Object object = controlador.leer(NOMBRE_ARCHIVO);
        if (object != null) {
            return (LinkedList<Entrenador>) object;
        }
        return new LinkedList<>();
    }

    private static void guardarEntrenadores(LinkedList<Entrenador> entrenadores) {
        ArchivosControlador controlador = new ArchivosControlador();
        controlador.guardar(entrenadores, NOMBRE_ARCHIVO);
    }
}
