package com.Darek.Programik.repository;

import com.Darek.Programik.model.BookInBasket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BasketRepository {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    BookRepository bookRepository;

    private Map<Integer, BookInBasket> basket = new HashMap();

    @Transactional
    public void addBookToBasket(int id, int ilosc){
        String title = bookRepository.getBook(id).getTitle();
        Float price = bookRepository.getBook(id).getPrice();
        BookInBasket bookInBasket = new BookInBasket(id,title,ilosc,price);

        em.persist(bookInBasket);

    }

    public BookInBasket getBook(Integer id){
        return em.find(BookInBasket.class,id);
    }

    @Transactional
    public void deleteFromBasket(int ind) { em.remove(ind);}


    public List<BookInBasket> findAllBooks() {

        return em.createQuery("from BOOK_IN_BASKET", BookInBasket.class).getResultList();
    }

}
