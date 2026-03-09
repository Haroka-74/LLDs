package models;

import strategies.MoveStrategy;

public class Player {
    private String name;
    private Symbol symbol;
    private MoveStrategy strategy;

    public Player(String name, Symbol symbol, MoveStrategy strategy) {
        this.name = name;
        this.symbol = symbol;
        this.strategy = strategy;
    }

    public String getName() {
        return name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public Position move(Board board) {
        return strategy.move(board, name);
    }
}