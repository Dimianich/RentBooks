package com.mysite.rentbooks.services;

import com.mysite.rentbooks.models.Book;

import java.util.List;

public interface ICheckOrderService {

    boolean getOrder(List<Book> order);
}
