package com.Darek.Programik.repository;

import com.Darek.Programik.model.BookEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class BookRepository  {

    @PersistenceContext
    private EntityManager em;

// CODE REV za dużo enterów, konstruktor niepotrzebny, nie masz wszędzie transactional -> być może @Repository to zapewnia więc albo dajemy wszędzie albo nie dajemy w ogóle

    @Transactional
    public void createBook(String title, String author, String type, int quantity, float price){
        BookEntity bookEntity = new BookEntity(title, author, type, quantity, price);
        em.persist(bookEntity);
    }

    @Transactional
    public void deleteBook(BookEntity bookEntity){
        em.remove(bookEntity);
    }

    public List<BookEntity> findAllBooks() {
       return em.createQuery("from Book", BookEntity.class).getResultList();
    }

    public BookEntity getBookById(long id){
        return em.find(BookEntity.class,id);
    }
}
