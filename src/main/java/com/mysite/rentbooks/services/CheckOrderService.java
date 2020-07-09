package com.mysite.rentbooks.services;

import com.mysite.rentbooks.models.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckOrderService implements ICheckOrderService {

    //Проверка на формирование заказа
    @Override
    public String getOrder(List<Book> order){

        boolean manyHorrors = isManyGenres(order, "Ужасы", 3);
        boolean incompatibilityGenres = isIncompatibilityGenres(order, "Книги для детей", "Манга");
        boolean dict = isNecessaryGenres(order, "На английском языке", "Словари");

        if (manyHorrors && incompatibilityGenres && dict){
            return "Ваш заказ успешно принят";
        }else if (!manyHorrors){
            return "Нельзя взять более трех книг жанра ужасов, возьмите, пожалуйста меньше";
        }else if(!incompatibilityGenres){
            return "Нельзя вместе взять детскую литературу и мангу";
        }else{
            return "Вы взяли иностранную литературу, возьмите обязательно словарь!";
        }
    }

    //Проверка на наличие более трех книг жанра ужасов
    private boolean isManyGenres(List<Book> order, String genre, int count){
        int i = 0;

        for (Book book : order){
            if(book.getGenre().equals(genre)){
                i++;
            }
        }

        if (i > count){
            return false;
        }
        return true;
    }

    //Проверка на несоместимость жанров детской литературы и манги
    private boolean isIncompatibilityGenres(List<Book> order, String genre1, String genre2){
        boolean isGenre1 = false;
        boolean isGenre2 = false;

        for (Book book : order){
            if(book.getGenre().equals(genre1)){
                isGenre1 = true;
            }
            if(book.getGenre().equals(genre2)){
                isGenre2 = true;
            }
        }

        if (isGenre1 && isGenre2){
            return false;
        }

        return true;
    }

    //Проверка на совместное присутствие словаря с иностранной литературой
    private boolean isNecessaryGenres(List<Book> order, String baseGenre, String necessaryGenre){
        String dictionaryGenre = "Словари";
        String foreignGenre = "На английском языке";
        boolean isNecessaryGenre = false;
        boolean isBaseGenre = false;

        for (Book book : order){
            if(book.getGenre().equals(foreignGenre)){
                isBaseGenre = true;
            }
            if(book.getGenre().equals(dictionaryGenre)){
                isNecessaryGenre = true;
            }
        }

        if (isBaseGenre && !isNecessaryGenre){
            return false;
        }

        return true;
    }
}
