package com.mysite.rentbooks.services;

import com.mysite.rentbooks.models.Book;
import com.mysite.rentbooks.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListBookService implements IListBookService{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAll() {

        return bookRepository.findAll();
    }

}
