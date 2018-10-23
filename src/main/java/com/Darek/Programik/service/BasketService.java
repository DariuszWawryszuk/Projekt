package com.Darek.Programik.service;



import com.Darek.Programik.model.BookInBasket;
import com.Darek.Programik.repository.BasketRepository;
import com.Darek.Programik.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BasketService {

    @Autowired
    BasketRepository basketRepository;

    @Autowired
    BookRepository bookRepository;

    public List<BookInBasket> findAllBooks() {
        return new ArrayList<>(basketRepository.findAllBooks());
    }

    public void saveBook(BookInBasket bookInBasket) {

        long idBook = bookInBasket.getIdBook();
        Float price = bookRepository.getBookById(idBook).getPrice();
        bookInBasket.setPrice(price);

        basketRepository.addBookToBasket(bookInBasket);
    }


}
