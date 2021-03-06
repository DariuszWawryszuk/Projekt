package com.Darek.Programik.repository;

import com.Darek.Programik.model.BookInBasket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class BasketRepository {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    BookRepository bookRepository;

    @Transactional
    public void addBookToBasket(long id, int quantity){
        Float price = bookRepository.getBookById(id).getPrice();
        BookInBasket bookInBasket = new BookInBasket(id,quantity,price);
        em.persist(bookInBasket);
    }

    public BookInBasket getBook(long id){
        return em.find(BookInBasket.class,id);
    }

    @Transactional
    public void deleteFromBasket(BookInBasket bookInBasket) {
        em.remove(em.contains(bookInBasket) ? bookInBasket : em.merge(bookInBasket));}


    public List<BookInBasket> findAllBooks() {
        return em.createQuery("from BookInBasket", BookInBasket.class).getResultList();
    }

    @Transactional
    public void addBookToBasket(BookInBasket bookInBasket){
        em.persist(bookInBasket);
    }

}
