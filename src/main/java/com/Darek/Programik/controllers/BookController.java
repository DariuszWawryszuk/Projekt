package com.Darek.Programik.controllers;

import com.Darek.Programik.model.BookEntity;
import com.Darek.Programik.repository.BookRepository;
import com.Darek.Programik.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping("/books")
    public String getBooks(Model model){
        List<BookEntity> allBooks = bookService.findAllBooks();
        model.addAttribute("books",allBooks);
        return "books";
    }
}
