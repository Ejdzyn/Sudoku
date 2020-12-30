package com.Ejdzyn.Sudoku.service;

import com.Ejdzyn.Sudoku.rest.UserApiController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class SudokuTableFromCsv implements SudokuService{

    private final String FILE;
    private final int SIZE = 9;

    public SudokuTableFromCsv(String fileName){
        this.FILE = fileName;
    }

    @Override
    public void checkField() {
        getIntFromCsv();
    }

    @Override
    public List<String> readCsv() {
        List<String> lines = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader(this.FILE));

            String line;
            while ((line=reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return lines;
    }

    @Override
    public int[][] getIntFromCsv(){

        List<String> strings = readCsv();

        int[][] gameTable = new int[SIZE][SIZE];

        for(int i = 0 ; i < strings.size();i++){

            String[] str = strings.get(i).split(";");
            for(int y = 0 ; y < str.length;y++){
                gameTable[i][y] = Integer.parseInt(str[y]);
            }
        }

        /*for(int[] i : gameTable){
            for(int y : i){
                System.out.print(y);
            }
            System.out.print("\n");
        }*/

        return gameTable;
    }
}
