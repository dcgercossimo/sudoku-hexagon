package br.com.aurealab.sudoku.domain.service;

import br.com.aurealab.sudoku.domain.model.SudokuBoard;
import br.com.aurealab.sudoku.ports.in.CriarJogoUseCase;
import br.com.aurealab.sudoku.ports.out.SudokuRepositoryPort;

public class SudokuService implements CriarJogoUseCase {
    private final SudokuRepositoryPort sudokuRepositoryPort;

    public SudokuService(SudokuRepositoryPort sudokuRepositoryPort) {
        this.sudokuRepositoryPort = sudokuRepositoryPort;
    }

    @Override
    public SudokuBoard criarJogo() {
        // TODO: implementar a lógica para gerar um tabuleiro de Sudoku válido.
        int[][] grid = new int[9][9];
        return sudokuRepositoryPort.save(new SudokuBoard(grid));
    }
}
