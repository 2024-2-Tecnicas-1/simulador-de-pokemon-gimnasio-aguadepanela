package simulador.pokemon;

public enum TipoPokemon {
    FUEGO,
    AGUA,
    PLANTA,
    VENENO,
    ELECTRICO,
    PSIQUICO,
    ROCA,
    TIERRA,
    NORMAL,
    VOLADOR,
    HADA,
    LUCHA,
    ACERO,
    BICHO,
    HIELO,
    FANTASMA;

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
            case PLANTA:
                switch (defensor) {
                    case FUEGO:
                    case VENENO:
                    case ACERO:
                    case BICHO:
                        return 0.5;
                    case AGUA:
                    case ROCA:
                    case TIERRA:
                        return 2.0;
                    default:
                        return 1.0;
                }
            case VENENO:
                switch (defensor) {
                    case ROCA:
                    case FANTASMA:
                        return 0.5;
                    case PLANTA:
                    case HADA:
                        return 2.0;
                    default:
                        return 1.0;
                }
                case ELECTRICO:
                switch (defensor) {
                    case PLANTA:
                        return 0.5;
                    case AGUA:
                    case VOLADOR:
                        return 2.0;
                    case TIERRA:
                        return 0.0;    
                    default:
                        return 1.0;
                }
                case PSIQUICO:
                switch (defensor) {
                    case ROCA:
                    case FANTASMA:
                        return 0.5;
                    case PLANTA:
                    case HADA:
                        return 2.0;
                    default:
                        return 1.0;
                }  
                case ROCA:
                switch (defensor) {
                    case LUCHA:
                        return 0.5;
                    case FUEGO:
                    case VOLADOR:
                    case ACERO:
                    case BICHO:
                    case HIELO:
                        return 2.0;
                    default:
                        return 1.0;
                }
                case TIERRA:
                switch (defensor) {
                    case ELECTRICO:
                        return 0.0;
                    case VOLADOR:
                        return 0.5;
                    case FUEGO:
                    case VENENO:
                    case ROCA:
                    case ACERO:
                        return 2.0;
                    default:
                        return 1.0;
                }
                case NORMAL:
                switch (defensor) {
                    case FANTASMA:
                        return 0.0;
                    default:
                        return 1.0;
                }
                case VOLADOR:
                switch (defensor) {
                    case ROCA:
                        return 0.5;
                    case PLANTA:
                    case ELECTRICO:
                    case BICHO:
                        return 2.0;
                    default:
                        return 1.0;
                }
                case HADA:
                switch (defensor) {
                    case PSIQUICO:
                        return 2.0;
                    default:
                        return 1.0;
                }
                case LUCHA:
                switch (defensor) {
                    case PSIQUICO:
                    case HADA:
                    case FANTASMA:
                        return 0.5;
                    case ROCA:
                    case NORMAL:
                    case HIELO:
                        return 2.0;
                    default:
                        return 1.0;
                }
                case ACERO:
                switch (defensor) {
                    case PSIQUICO:
                        return 0.5;
                    case FUEGO:
                    case ROCA:
                    case HADA:
                    case LUCHA:
                        return 2.0;
                    default:
                        return 1.0;
                }
                case BICHO:
                switch (defensor) {
                    case ACERO:
                    case FANTASMA:
                        return 0.5;
                    case PLANTA:
                    case VOLADOR:
                        return 2.0;
                    default:
                        return 1.0;
                }
                case HIELO:
                switch (defensor) {
                    case PLANTA:
                    case TIERRA:

                        return 2.0;
                    default:
                        return 1.0;
                }
                case FANTASMA:
                switch (defensor) {
                    case VENENO:
                        return 0.5;
                    case NORMAL:
                        return 0.0;
                    case FANTASMA:
                        return 2.0;
                    default:
                        return 1.0;
                }   
            default:

        }
    }
}
