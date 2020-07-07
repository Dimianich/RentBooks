package com.mysite.rentbooks.services;

import com.mysite.rentbooks.models.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckOrderService implements ICheckOrderService {

    //Проверка на формирование заказа
    @Override
    public boolean getOrder(List<Book> order){
        return (isManyHorrors(order));
    }

    //Проверка на наличие более трех книг жанра ужасов
    private boolean isManyHorrors(List<Book> order){
        int count = 0;
        String checkGenre = "Ужасы";

        for (Book book : order){
            if(book.getGenre().equals(checkGenre)){
                count++;
            }
        }

        if (count > 3){
            return false;
        }
        return true;
    }
}
