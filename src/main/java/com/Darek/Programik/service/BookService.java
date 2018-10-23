package com.Darek.Programik.service;

import com.Darek.Programik.model.BookEntity;
import com.Darek.Programik.repository.BasketRepository;
import com.Darek.Programik.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BasketRepository basketRepository;

    public List<BookEntity>  findAllBooks() {
        return new ArrayList<>(bookRepository.findAllBooks());
    }

    public void saveBook(BookEntity bookEntity) {
        bookRepository.createBook(bookEntity);
    }

    public BookEntity getBook(Long id) {
        long idBook = basketRepository.getBook(id).getIdBook();
        return bookRepository.getBookById(idBook);
    }
}
