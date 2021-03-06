package com.mysite.rentbooks.controllers;

import com.mysite.rentbooks.models.Book;
import com.mysite.rentbooks.services.AdminService;
import com.mysite.rentbooks.services.CheckOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class OrderController {

    @Autowired
    private CheckOrderService orderService;

    private final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @PostMapping(value = "/api/order")
    public ResponseEntity<String> getOrder(@RequestBody List<Book> order) {
        String response = orderService.getOrder(order);

        logger.info("Проверка заказа: {}", response);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
