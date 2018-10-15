package com.Darek.Programik.repository;

import com.Darek.Programik.model.BookInBasket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BasketRepository {

    @Autowired
    BookRepository bookRepository;

    private Map<Integer, BookInBasket> basket = new HashMap();

    public void addBookToBasket(int id, int ilosc){
        String book = bookRepository.getBook(id).getTitle();
        BookInBasket bookInBasket = new BookInBasket(id,book,ilosc);
        bookInBasket.setId(getNewId());

        basket.put(bookInBasket.getId(), bookInBasket);

    }

    public BookInBasket getBook(Integer id){
        return basket.get(id);
    }


    public void deleteFromBasket(int ind) { basket.remove(ind);}

    public int getNewId() {
        if(basket.isEmpty()) {
            return 0;
        }
        else {
            Integer integer = basket.keySet().stream().max((o1, o2) -> o1.compareTo(o2)).get();
            return integer+1;
        }
    }
    public HashMap<Integer, BookInBasket> findAllBooks() {
        return (HashMap<Integer, BookInBasket>) basket;
    }

}
