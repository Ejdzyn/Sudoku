package com.Ejdzyn.Sudoku.service;

import com.Ejdzyn.Sudoku.rest.UserApiController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class SudokuChecker implements SolverService{

    private static final Logger LOGGER = LoggerFactory.getLogger(UserApiController.class);

    private final int[][] GAME_TABLE;

    private final SudokuTableFromCsv gameTable;

    public SudokuChecker(String fileName){
        this.gameTable = new SudokuTableFromCsv(fileName);
        this.GAME_TABLE = this.gameTable.getIntFromCsv();

        checkRow();
        checkColumn();

    }

    private Set<Integer> rowErrors = new TreeSet<>();
    private Set<Integer> columnErrors = new TreeSet<>();
    private Set<Integer> gridErrors = new TreeSet<>();

    public Map<String, Set<Integer>> getErrors() {
        if(!rowErrors.isEmpty()){
            errors.put("lineIds",rowErrors);
        }

        if(!columnErrors.isEmpty()){
            errors.put("columnIds",columnErrors);
        }

        if(!gridErrors.isEmpty()){
            errors.put("gridIds",gridErrors);
        }

        return errors;
    }

    private Map<String,Set<Integer>> errors = new HashMap<>();



    @Override
    public void checkRow() {
        for(int i = 0 ; i < 9;++i){
            Set<Integer> uniques = new HashSet<>();
            for(int y = 0 ; y < 9;++y){
                if(!uniques.contains(GAME_TABLE[i][y])){
                   uniques.add(GAME_TABLE[i][y]);
                }else {
                    rowErrors.add(i);
                }
            }
        }
    }

    @Override
    public void checkColumn() {
        for(int i = 0 ; i < 9;++i){
            Set<Integer> uniques = new HashSet<>();
            for(int y = 0 ; y < 9;++y){
                if(!uniques.contains(GAME_TABLE[y][i])){
                    uniques.add(GAME_TABLE[y][i]);
                }else columnErrors.add(i);
            }
        }
    }

    @Override
    public void checkGrid() {

    }
}
