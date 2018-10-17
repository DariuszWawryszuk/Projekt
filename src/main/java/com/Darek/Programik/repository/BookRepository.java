package com.Darek.Programik.repository;

import com.Darek.Programik.model.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookRepository {

    @PersistenceContext
    private EntityManager em;

    public BookRepository(){

    }

    @Transactional
    public void createBook(String title, String author, String type, int quantity, float price){
        Book book = new Book(title, author, type, quantity, price);

        em.persist(book);
    }
    @Transactional
    public void deleteBook(Book book){

        em.remove(book);
    }

    public List<Book> findAllBooks() {

       return em.createQuery("from Book", Book.class).getResultList();
    }

    public Book getBook(Integer id){

        return em.find(Book.class,id);
    }
}
