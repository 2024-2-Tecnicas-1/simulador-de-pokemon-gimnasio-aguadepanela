package simulador.pokemon;

public class Pokemon {

    private String nombre;
    private int salud;
    private int ataque;
    private String estado;
    private int nivel;
    private final TipoPokemon tipo;

    // Constructor
    public Pokemon(String nombre, int salud, int ataque, String estado, int nivel,TipoPokemon tipo) {
        this.nombre = nombre;
        this.salud = salud;
        this.ataque = ataque;
        this.estado = estado;
        this.nivel = nivel;
        this.tipo = tipo;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getEstado() {
        return estado;
    }

    public int getSalud() {
        return salud;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getNivel() {
        return nivel;
    }
    public TipoPokemon  getTipo() {
        return tipo;
        }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    
}
