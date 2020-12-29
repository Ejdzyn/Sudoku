package com.Ejdzyn.Sudoku.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApiController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserApiController.class);

    public UserApiController() {

    }

    @GetMapping("/api/sudoku/verify")
    public ResponseEntity<Void> login() {
        LOGGER.info("--- check login data: {}");

        /*if(userService.checkLogin(loginDto.getLogin(), loginDto.getPassword())) {
            return new ResponseEntity<>(HttpStatus.OK);
        }*/

        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
