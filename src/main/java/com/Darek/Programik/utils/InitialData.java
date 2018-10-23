package com.Darek.Programik.utils;

import com.Darek.Programik.repository.BasketRepository;
import com.Darek.Programik.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitialData {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BasketRepository basketRepository;

    @PostConstruct
    public void initialBook (){

        bookRepository.createBook("Super książka", "Sienkiewicz","Komedia",400,888888);
        bookRepository.createBook("asdas książka", "tatat","Komertedia",66,88);
        bookRepository.createBook("Super sdas", "tyutyu","ert",66,888);

        basketRepository.addBookToBasket(1,1);
        basketRepository.addBookToBasket(1,1);
        basketRepository.addBookToBasket(3,1);
    }
}
