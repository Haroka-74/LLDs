package models;

import constants.Colors;

public class Board {
    private Symbol[][] grid;
    private int[][] winPath;

    public Board() {
        grid = new Symbol[3][3];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                grid[i][j] = Symbol.E;
            }
        }
    }

    public boolean validate(Position position) {
        int row = position.getRow();
        int column = position.getColumn();
        return row >= 0 && row < 3 && column >= 0 && column < 3 && grid[row][column] == Symbol.E;
    }

    public void place(Position position, Symbol symbol) {
        int row = position.getRow();
        int column = position.getColumn();
        grid[row][column] = symbol;
    }

    public boolean hasWinner() {
        for(int i = 0; i < 3; i++) {
            if(grid[i][0] != Symbol.E && grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2]) {
                winPath = new int[][] {{i, 0}, {i, 1}, {i, 2}};
                return true;
            }
        }

        for(int j = 0; j < 3; j++) {
            if (grid[0][j] != Symbol.E && grid[0][j] == grid[1][j] && grid[1][j] == grid[2][j]) {
                winPath = new int[][] {{0, j}, {1, j}, {2, j}};
                return true;
            }
        }

        if(grid[0][0] != Symbol.E && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) {
            winPath = new int[][] {{0, 0}, {1, 1}, {2, 2}};
            return true;
        }

        if(grid[0][2] != Symbol.E && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]) {
            winPath = new int[][] {{0, 2}, {1, 1}, {2, 0}};
            return true;
        }

        return false;
    }

    public boolean isFull() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if (grid[i][j] == Symbol.E) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\n");

        for (int i = 0; i < 3; i++) {
            sb.append("-".repeat(3 * 4 + 1)).append("\n");
            sb.append("|");
            for (int j = 0; j < 3; j++) {
                boolean isWinningCell = false;

                if(winPath != null) {
                    for(int k = 0; k < 3; k++) {
                        if(winPath[k][0] == i && winPath[k][1] == j) {
                            isWinningCell = true;
                            break;
                        }
                    }
                }

                if (isWinningCell) {
                    sb.append(" ").append(Colors.RED).append(grid[i][j].name()).append(Colors.RESET).append(" |");
                } else {
                    sb.append(" ").append(grid[i][j]).append(" |");
                }
            }
            sb.append("\n");
        }

        sb.append("-".repeat(3 * 4 + 1));
        return sb.toString();
    }
}