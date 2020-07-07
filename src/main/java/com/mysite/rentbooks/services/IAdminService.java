package com.mysite.rentbooks.services;

import com.mysite.rentbooks.models.Book;

import java.util.List;

public interface IAdminService {

        Book addBook(Book book);
        void delete(int id);
        List<Book> getAll();


}
