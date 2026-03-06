package models;

import constants.Colors;

public enum Symbol {
    X, O, E;

    @Override
    public String toString() {
        return switch (this) {
            case X -> Colors.CYAN + "X" + Colors.RESET;
            case O -> Colors.YELLOW + "O" + Colors.RESET;
            case E -> " ";
        };
    }
}