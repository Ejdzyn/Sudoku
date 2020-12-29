package com.Ejdzyn.Sudoku.service;

import java.util.List;

public interface SudokuService {

    void checkField();

    List<String> readCsv();

    int[][] getIntFromCsv();

}
