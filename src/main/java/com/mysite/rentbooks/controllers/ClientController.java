package com.mysite.rentbooks.controllers;

import com.mysite.rentbooks.services.CheckCardServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class ClientController {

    @Autowired
    private CheckCardServices cardService;

    private final Logger logger = LoggerFactory.getLogger(ClientController.class);


    @GetMapping(value = "api/clients/{card}")
    public ResponseEntity<Integer> read(@PathVariable(name = "card") String card) {
        final int discount = cardService.getDiscount(card);

        logger.info("Скидка: {} %", discount);
        return new ResponseEntity<>(discount, HttpStatus.OK);
    }
}
