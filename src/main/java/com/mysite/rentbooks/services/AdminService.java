package com.mysite.rentbooks.services;

import com.mysite.rentbooks.models.Book;
import com.mysite.rentbooks.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService implements IAdminService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ListBookService listBookService;


    @Override
    public Book addBook(Book book) {
        Book savedBook = bookRepository.saveAndFlush(book);

        return savedBook;
    }

    @Override
    public void delete(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> getAll() {

        return listBookService.getAll();
    }
}
