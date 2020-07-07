package com.mysite.rentbooks.services;

import com.mysite.rentbooks.models.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckOrderService implements ICheckOrderService {

    //Проверка на формирование заказа
    @Override
    public String getOrder(List<Book> order){
        boolean manyHorrors = isManyHorrors(order);
        boolean incompatibilityGenres = isIncompatibilityGenres(order);
        boolean dict = isDictionary(order);

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

    //Проверка на несоместимость жанров детской литературы и манги
    private boolean isIncompatibilityGenres(List<Book> order){
        String babyGenre = "Книги для детей";
        String mangaGenre = "Манга";
        boolean isBabyGenre = false;
        boolean isMangaGenre = false;

        for (Book book : order){
            if(book.getGenre().equals(babyGenre)){
                isBabyGenre = true;
            }
            if(book.getGenre().equals(mangaGenre)){
                isMangaGenre = true;
            }
        }

        if (isBabyGenre && isMangaGenre){
            return false;
        }

        return true;
    }

    //Проверка на совместное присутствие словаря с иностранной литературой
    private boolean isDictionary(List<Book> order){
        String dictionaryGenre = "Словари";
        String foreignGenre = "На английском языке";
        boolean isdictionaryGenre = false;
        boolean isforeignGenre = false;

        for (Book book : order){
            if(book.getGenre().equals(foreignGenre)){
                isforeignGenre = true;
            }
            if(book.getGenre().equals(dictionaryGenre)){
                isdictionaryGenre = true;
            }
        }

        if (isforeignGenre && !isdictionaryGenre){
            return false;
        }

        return true;
    }
}
