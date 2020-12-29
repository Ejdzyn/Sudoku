package com.Ejdzyn.Sudoku.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SudokuTableFromCsv implements SudokuService{

    private final String FILE;
    private final int SIZE = 9;
    private List<String> lines;

    public SudokuTableFromCsv(String fileName){
        this.FILE = fileName;
    }

    @Override
    public void checkField() {
        getIntFromCsv();
    }

    @Override
    public List<String> readCsv() {
        try{
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\AdRiaN\\IdeaProjects\\"+this.FILE));

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

        for(int[] i : gameTable){
            for(int y : i){
                System.out.print(y);
            }
            System.out.print("\n");
        }

        return gameTable;
    }
}
