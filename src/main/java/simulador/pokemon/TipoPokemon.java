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

    public double calcularFactorMultiplicador(TipoPokemon atacante, TipoPokemon defensor) {
        switch (atacante) {
            case FUEGO -> {
                return switch (defensor) {
                    case AGUA, ROCA, ACERO -> 0.5;
                    case HIELO, PLANTA, BICHO -> 2.0;
                    default -> 1.0;
                };
            }

            case AGUA -> {
                return switch (defensor) {
                    case PLANTA -> 0.5;
                    case FUEGO, ROCA -> 2.0;
                    default -> 1.0;
                };
            }

            case PLANTA -> {
                return switch (defensor) {
                    case FUEGO, VENENO, ACERO, BICHO -> 0.5;
                    case AGUA, ROCA, TIERRA -> 2.0;
                    default -> 1.0;
                };
            }

            case VENENO -> {
            return switch (defensor) {
                case ROCA, FANTASMA -> 0.5;
                case PLANTA, HADA -> 2.0;
                default -> 1.0;
            };
            }
            case ELECTRICO -> {
            return switch (defensor) {
                case PLANTA -> 0.5;
                case AGUA, VOLADOR -> 2.0;
                case TIERRA -> 0.0;
                default -> 1.0;
            };
            }
            case PSIQUICO -> {
            return switch (defensor) {
                case ROCA, FANTASMA -> 0.5;
                case PLANTA, HADA -> 2.0;
                default -> 1.0;
            };
            }
            case ROCA -> {
            return switch (defensor) {
                case LUCHA -> 0.5;
                case FUEGO, VOLADOR, ACERO, BICHO, HIELO -> 2.0;
                default -> 1.0;
            };
            }
            case TIERRA -> {
            return switch (defensor) {
                case ELECTRICO -> 0.0;
                case VOLADOR -> 0.5;
                case FUEGO, VENENO, ROCA, ACERO -> 2.0;
                default -> 1.0;
            };
            }
            case NORMAL -> {
            return switch (defensor) {
                case FANTASMA -> 0.0;
                default -> 1.0;
            };
            }
            case VOLADOR -> {
            return switch (defensor) {
                case ROCA -> 0.5;
                case PLANTA, ELECTRICO, BICHO -> 2.0;
                default -> 1.0;
            };
            }
            case HADA -> {
            return switch (defensor) {
                case PSIQUICO -> 2.0;
                default -> 1.0;
            };
            }
            case LUCHA -> {
            return switch (defensor) {
                case PSIQUICO, HADA, FANTASMA -> 0.5;
                case ROCA, NORMAL, HIELO -> 2.0;
                default -> 1.0;
            };
            }
            case ACERO -> {
            return switch (defensor) {
                case PSIQUICO -> 0.5;
                case FUEGO, ROCA, HADA, LUCHA -> 2.0;
                default -> 1.0;
            };
            }
            case BICHO -> {
            return switch (defensor) {
                case ACERO, FANTASMA -> 0.5;
                case PLANTA, VOLADOR -> 2.0;
                default -> 1.0;
            };
            }
            case HIELO -> {
            return switch (defensor) {
                case PSIQUICO -> 0.5;
                case FUEGO, LUCHA, ROCA, ACERO -> 2.0;
                default -> 1.0;
            };
            }
            case FANTASMA -> {
            return switch (defensor) {
                case PSIQUICO, HADA -> 2.0;
                case LUCHA, NORMAL -> 0.0;
                default -> 1.0;
            };
            }
            default -> {
                return 1.0;
            }
        }
    }
}
