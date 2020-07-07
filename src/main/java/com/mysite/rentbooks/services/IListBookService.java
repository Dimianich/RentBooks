package com.mysite.rentbooks.services;

import com.mysite.rentbooks.models.Book;

import java.util.List;

public interface IListBookService {

    List<Book> getAll();
}
