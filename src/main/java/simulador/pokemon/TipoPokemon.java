package simulador.pokemon;

public enum TipoPokemon {
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
    HADA,
    LUCHADOR,
    NORMAL,
    ACERO

    public double calcularFactorMultiplicado(TipoPokemon atacante, TipoPokemon defensor) {
        switch (atacante) {
            case FUEGO:
                switch (defensor) {
                    case AGUA:
                    case ROCA:
                    case ACERO:
                        return 0.5;
                    case HIELO:
                    case PLANTA:
                    case BICHO:
                        return 2.0;
                    default:
                        return 1.0;
                }
            case AGUA:
                switch (defensor) {
                    case PLANTA:
                        return 0.5;
                    case FUEGO:
                    case ROCA:
                        return 2.0;
                    default:
                        return 1.0;

                }
            default:

        }
    }
}
