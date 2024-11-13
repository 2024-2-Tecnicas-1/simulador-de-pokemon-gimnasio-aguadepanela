package simulador.pokemon;

public abstract class Pokemon {

    private String nombre;
    private int salud;
    private int ataque;
    private String estado;
    private int nivel;
    private final TipoPokemon tipo;

    // Constructor
    public Pokemon(String nombre, int salud, int ataque, String estado, int nivel, TipoPokemon tipo) {
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

    public TipoPokemon getTipo() {
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
    public void entrenar() {
        nivel += 1; // Incrementa el nivel en 1
        System.out.println("Entrenamiento completo. Nivel actual: " + nivel);
        if (nivel == 35){
            evolucionar();
        }

    }
    public void evolucionar() {// Muestra la evolucion
        if (getNivel() == 35) {

            switch (getNombre()) {
                case "Vulpix" ->
                    setNombre("Ninetales");
                case "Oddish" ->
                    setNombre("Gloom");
                case "Drowzee" ->
                    setNombre("Hypno");
                case "Magnemite" ->
                    setNombre("Magneton");
                case "Mankey" ->
                    setNombre("Primeape");
                case "Meowth" ->
                    setNombre("Persian");
                case "Poliwag" ->
                    setNombre("Poliwhirl");
                case "Rhyhorn" ->
                    setNombre("Rhydon");
                case "Spearoe" ->
                    setNombre("Fearow");

            }
        }
    }
}
