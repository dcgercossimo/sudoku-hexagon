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
        int[][] tabuleiroInicial = {
                { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
                { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
                { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
                { 8, 0, 0, 0, 6, 0, 0, 0, 3 },
                { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
                { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
                { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
                { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
                { 0, 0, 0, 0, 8, 0, 0, 7, 9 }
        };
        return sudokuRepositoryPort.save(new SudokuBoard(tabuleiroInicial));
    }
}
