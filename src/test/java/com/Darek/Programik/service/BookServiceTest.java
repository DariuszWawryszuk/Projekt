package com.Darek.Programik.service;

import com.Darek.Programik.model.BookEntity;
import com.Darek.Programik.repository.BookRepository;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.BDDMockito;
import org.mockito.Mockito;


import java.util.ArrayList;
import java.util.List;

public class BookServiceTest {

    @InjectMocks
    BookService bookServvice;

    @Mock
    private BookRepository bookRepository;

    private ArrayList<BookEntity> Lista;

    @Test
    public void testFindAllBooks() {

        BDDMockito.given(bookRepository.findAllBooks()).willReturn(Lista);

       List<BookEntity> books = bookServvice.findAllBooks();

        Mockito.verify(bookRepository).findAllBooks();
    }
}
