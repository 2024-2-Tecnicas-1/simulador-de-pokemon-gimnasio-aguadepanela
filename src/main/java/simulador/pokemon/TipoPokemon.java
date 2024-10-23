package simulador.pokemon;

public class TipoPokemon extends Pokemon {

    private final Tipo tipo; // El tipo es final, no puede cambiar una vez asignado

    // Enumeración para los tipos de Pokémon
    public enum Tipo {
        FUEGO,
        AGUA,
        PLANTA,
        ELECTRICO,
        TIERRA,
        VOLADOR,
        PSICICO,
        HIELO,
        BICHO,
        ROCA,
        FANTASMA,
        DRAGON,
        HADA,
        LUCHADOR,
        NORMAL,
        ACERO
    }

    // Constructor
    public TipoPokemon(String nombre, int salud, int ataque, String estado, int nivel, Tipo tipo) {
        super(nombre, salud, ataque, estado, nivel); // Llama al constructor 
        this.tipo = tipo; 
    }

    // Método para obtener el tipo de Pokémon
    public Tipo getTipo() {
        return tipo;
    }

    // Método toString para mostrar la información del Pokémon junto con su tipo
    @Override
    public String toString() {
        return super.toString() + ", Tipo: " + tipo;
    }
}
