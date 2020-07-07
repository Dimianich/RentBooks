package com.mysite.rentbooks.services;

import com.mysite.rentbooks.models.Book;

import java.util.List;

public interface ICheckOrderService {

    String getOrder(List<Book> order);
}
