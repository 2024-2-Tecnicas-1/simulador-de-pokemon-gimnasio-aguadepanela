package simulador.batalla;

import java.util.LinkedList;
import java.util.Scanner;

import presentacion.Consola;
import simulador.entrenador.Entrenador;
import simulador.pokemon.Pokemon;


public class Batalla {
    private static Scanner sc = new Scanner(System.in);

    public static void iniciarBatalla(LinkedList<Entrenador> entrenadores) {
        if (entrenadores.size() < 2) {
            System.out.println("No hay suficientes entrenadores para iniciar una batalla.");
            System.out.println("Se volvera a la pantalla principal.");
            Consola consola = new Consola();
            consola.iniciar();
    
        }else{

        // Seleccionar entrenadores
        System.out.println("Selecciona el Entrenador 1:");
        Entrenador entrenador1 = seleccionarEntrenador(entrenadores);
        System.out.println("Selecciona el Entrenador 2:");
        Entrenador entrenador2 = seleccionarEntrenador(entrenadores);

        // Seleccionar Pokémon de cada entrenador
        Pokemon pokemon1 = seleccionarPokemon(entrenador1);
        Pokemon pokemon2 = seleccionarPokemon(entrenador2);

        // Iniciar la batalla
        System.out.println("¡La batalla ha comenzado entre " + pokemon1.getNombre() + " y " + pokemon2.getNombre() + "!");
        while (pokemon1.getSalud() > 0 && pokemon2.getSalud() > 0) {
            System.out.println("Presiona Enter para que " + pokemon1.getNombre() + " ataque.");
            sc.nextLine(); 
            pokemon1.atacar(pokemon2);
            if (pokemon2.getSalud() <= 0) {
                System.out.println(pokemon2.getNombre() + " ha sido derrotado. ¡" + pokemon1.getNombre() + " gana la batalla!");
                return;
            }

            System.out.println("Presiona Enter para que " + pokemon2.getNombre() + " ataque.");
            sc.nextLine(); 
            pokemon2.atacar(pokemon1);
            if (pokemon1.getSalud() <= 0) {
                System.out.println(pokemon1.getNombre() + " ha sido derrotado. ¡" + pokemon2.getNombre() + " gana la batalla!");
                return;
            }
        }
    }}


    private static Entrenador seleccionarEntrenador(LinkedList<Entrenador> entrenadores) {
        System.out.println("Entrenadores disponibles:");
        for (int i = 0; i < entrenadores.size(); i++) {
            System.out.println((i + 1) + ". " + entrenadores.get(i).getNombre());
        }
        
        System.out.println("Selecciona el número del Entrenador:");
        int seleccion = sc.nextInt() - 1;
        sc.nextLine();
        return entrenadores.get(seleccion);
    }

    private static Pokemon seleccionarPokemon(Entrenador entrenador) {
        entrenador.mostrarPokemones();
        System.out.println("Seleccione el número del Pokémon para la batalla:");
        int seleccion = sc.nextInt() - 1;
        sc.nextLine();
        return entrenador.prepararBatalla(); // Este método debe devolver el Pokémon seleccionado
    }
}