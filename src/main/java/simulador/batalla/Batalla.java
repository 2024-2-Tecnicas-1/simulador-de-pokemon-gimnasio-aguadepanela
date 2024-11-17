package simulador.batalla;

import simulador.pokemon.Pokemon;

public class Batalla {

    public static  void iniciarBatalla(Pokemon pokemon1, Pokemon pokemon2) {
        System.out.println("¡La batalla ha comenzado entre " + pokemon1.getNombre() + " y " + pokemon2.getNombre() + "!");
        
        while (pokemon1.getSalud() > 0 && pokemon2.getSalud() > 0) {
            // Pokémon 1 ataca a Pokémon 2
            pokemon1.atacar(pokemon2);
            if (pokemon2.getSalud() <= 0) {
                System.out.println(pokemon2.getNombre() + " ha sido derrotado. ¡" + pokemon1.getNombre() + " gana la batalla!");
                return;
            }

            // Pokémon 2 ataca a Pokémon 1
            pokemon2.atacar(pokemon1);
            if (pokemon1.getSalud() <= 0) {
                System.out.println(pokemon1.getNombre() + " ha sido derrotado. ¡" + pokemon2.getNombre() + " gana la batalla!");
                return;
            }
        }
    }
}
