package com.mysite.rentbooks.controllers;

import com.mysite.rentbooks.models.Book;
import com.mysite.rentbooks.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class AdminController {


    @Autowired
    private AdminService adminService;

    @GetMapping(value = "/api/admin/books")
    public ResponseEntity<List<Book>> read() {
        final List<Book> books = adminService.getAll();

        return books != null &&  !books.isEmpty()
                ? new ResponseEntity<>(books, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/api/admin/books")
    public ResponseEntity<?> create(@RequestBody Book book) {
        adminService.addBook(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/api/admin/books/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        adminService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}





