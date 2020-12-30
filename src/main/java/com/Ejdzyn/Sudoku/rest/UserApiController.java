package com.Ejdzyn.Sudoku.rest;

import com.Ejdzyn.Sudoku.service.SudokuChecker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
public class UserApiController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserApiController.class);

    private SudokuChecker sudokuChecker;

    public UserApiController() {
        this.sudokuChecker = new SudokuChecker("C:\\Users\\AdRiaN\\IdeaProjects\\c.csv");
    }

    @GetMapping("/api/sudoku/verify")
    public ResponseEntity<Map<String, Set<Integer>>> login() {
        LOGGER.info("--- check login data: {}",sudokuChecker.getErrors());

        if(sudokuChecker.getErrors().isEmpty()){
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().body(sudokuChecker.getErrors());
        }
    }
}
