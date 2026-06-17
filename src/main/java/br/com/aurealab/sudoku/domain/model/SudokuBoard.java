package br.com.aurealab.sudoku.domain.model;

public class SudokuBoard {
    private final int[][] grid;

    /**
     * Construtor que recebe uma matriz 9x9 representando o tabuleiro de Sudoku.
     *
     * @param grid
     */
    public SudokuBoard(int[][] grid) {
        if (grid.length != 9 || grid[0].length != 9) {
            throw new IllegalArgumentException("O tabuleiro de Sudoku deve ser 9x9.");
        }
        this.grid = copyGrid(grid);
    }

    public int[][] getGrid() {
        return copyGrid(this.grid);
    }

    /**
     * Valida se a jogada é válida, ou seja, se o número não existe na mesma linha,
     * coluna e caixa 3x3.
     *
     * @param row
     * @param col
     * @param number
     * @return
     */
    public boolean isValidMove(int row, int col, int number) {
        boolean validMove = Boolean.TRUE;

        if (number < 1 || number > 9) {
            validMove = Boolean.FALSE;
        }

        if (isNotValidRowAndCol(row, col, number)) {
            validMove = Boolean.FALSE;
        }

        if (isNotValidBox(row, col, number)) {
            validMove = Boolean.FALSE;
        }

        return validMove;
    }

    /**
     * Verifica se o número já existe na mesma linha ou coluna.
     *
     * @param row
     * @param col
     * @param number
     * @return
     */
    private boolean isNotValidRowAndCol(int row, int col, int number) {
        for (int i = 0; i < 9; i++) {
            if (grid[row][i] == number || grid[i][col] == number) {
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica se o número já existe na mesma caixa 3x3.
     *
     * @param row
     * @param col
     * @param number
     * @return
     */
    private boolean isNotValidBox(int row, int col, int number) {
        int boxRowStart = row - row % 3;
        int boxColStart = col - col % 3;

        for (int r = boxRowStart; r < boxRowStart + 3; r++) {
            for (int c = boxColStart; c < boxColStart + 3; c++) {
                if (grid[r][c] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Cria uma cópia da matriz para evitar que a matriz original seja modificada
     * externamente.
     *
     * @param source
     * @return
     */
    private int[][] copyGrid(int[][] source) {
        int[][] target = new int[9][9];
        for (int i = 0; i < 9; i++) {
            System.arraycopy(source[i], 0, target[i], 0, 9);
        }
        return target;
    }
}
