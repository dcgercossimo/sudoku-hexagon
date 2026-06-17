package br.com.aurealab.sudoku.ports.in;

import br.com.aurealab.sudoku.domain.model.SudokuBoard;

public interface CriarJogoUseCase {
    SudokuBoard criarJogo();
}
