package models;

public enum Size {
    S, M, L;

    public double getRate() {
        switch (this) {
            case S: return 0.25;
            case M: return 0.50;
            case L: return 0.75;
            default: throw new IllegalStateException();
        }
    }
}