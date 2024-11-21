package simulador.pokemon;

public abstract class Pokemon {

    private String nombre; // El nombre del Pokémon
    private int salud; // Puntos de vida del Pokémon
    private int ataque; // Potencia base de los ataques del Pokémon
    private String estado; // Indica el estado del Pokémon
    private int nivel; // Nivel del Pokémon
    private final TipoPokemon tipo; // Tipo elemental del Pokémon

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

    // Método para atacar a un oponente
    public void atacar(Pokemon oponente) {
        double multiplicador = TipoPokemon.obtenerMultiplicadorDeDaño(tipo, tipo);
        int daño = (int) (this.ataque * multiplicador);
        oponente.recibirDaño(daño);
        System.out.println(this.nombre + " ataca a " + oponente.getNombre() + " causando " + daño + " de daño.");
    }

    // Método para recibir daño
    public void recibirDaño(int daño) {
        this.salud -= daño;
        if (this.salud < 0) {
            this.salud = 0;
        }
        System.out.println(this.nombre + " recibe " + daño + " de daño. Salud restante: " + this.salud);
    }

    // Método para entrenar y mejorar estadísticas
    public void entrenar() {
        setNivel(getNivel() + 1);
        setAtaque(getAtaque() + 1);
        setSalud(getSalud() + 1);
        System.out.println(""" 
            Entrenamiento completo. 
            Nivel actual: """ + nivel + "\n"
                + "Ataque actual: " + ataque + "\n"
                + "Salud actual: " + salud);
        if (nivel == 35) {
            evolucionar();
        }
    }

    // Método privado para evolucionar
    private void evolucionar() {
        if (nivel == 35) {
            switch (nombre) {
                case "Vulpix" -> {
                    setNombre("Ninetales");
                    setSalud(73);
                    setAtaque(75);
                    setEstado("Bueno");
                    setNivel(35);
                }
                case "Oddish" -> {
                    setNombre("Gloom");
                    setSalud(79);
                    setAtaque(84);
                    setEstado("Bueno");
                    setNivel(35);
                }
                case "Koffing" -> {
                    setNombre("Weezing");
                    setSalud(74);
                    setAtaque(99);
                    setEstado("Bueno");
                    setNivel(35);
                }
                case "Drowzee" -> {
                    setNombre("Hypno");
                    setSalud(94);
                    setAtaque(82);
                    setEstado("Bueno");
                    setNivel(35);
                }
                case "Magnemite" -> {
                    setNombre("Magneton");
                    setSalud(58);
                    setAtaque(69);
                    setEstado("Bueno");
                    setNivel(35);
                }
                case "Mankey" -> {
                    setNombre("Primeape");
                    setSalud(74);
                    setAtaque(114);
                    setEstado("Bueno");
                    setNivel(35);
                }
                case "Meowth" -> {
                    setNombre("Persian");
                    setSalud(74);
                    setAtaque(79);
                    setEstado("Bueno");
                    setNivel(35);
                }
                case "Poliwag" -> {
                    setNombre("Poliwhirl");
                    setSalud(74);
                    setAtaque(84);
                    setEstado("Bueno");
                    setNivel(35);
                }
                case "Rhyhorn" -> {
                    setNombre("Rhydon");
                    setSalud(114);
                    setAtaque(119);
                    setEstado("Bueno");
                    setNivel(35);
                }
                case "Spearow" -> {
                    setNombre("Fearow");
                    setSalud(74);
                    setAtaque(114);
                    setEstado("Bueno");
                    setNivel(35);
                }
            }
        }
    }
}
