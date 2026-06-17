package br.com.aurealab.sudoku.ports.out;

import java.util.Optional;

import br.com.aurealab.sudoku.domain.model.SudokuBoard;

public interface SudokuRepositoryPort {
    SudokuBoard save(SudokuBoard board);

    Optional<SudokuBoard> findById(Long id);
}
