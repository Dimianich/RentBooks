package com.mysite.rentbooks.controllers;

import com.mysite.rentbooks.models.Book;
import com.mysite.rentbooks.services.ListBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class BookController {

    @Autowired
    private ListBookService listBookService;

    @GetMapping(value = "/api/books")
    public ResponseEntity<List<Book>> read() {
        final List<Book> books = listBookService.getAll();

        return (books != null && !books.isEmpty())
                ? new ResponseEntity<>(books, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
