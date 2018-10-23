package com.Darek.Programik.controllers;

import com.Darek.Programik.model.BookEntity;
import com.Darek.Programik.repository.BookRepository;
import com.Darek.Programik.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping("/newbook")
    public String crateBook (Model model){
        model.addAttribute("book", new BookEntity());
        return "bookform";

    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public String saveBooks(BookEntity bookEntity){
        bookService.saveBook(bookEntity);
        return "redirect:/books";
    }

}
