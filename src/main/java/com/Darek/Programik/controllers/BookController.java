package com.Darek.Programik.controllers;

import com.Darek.Programik.model.BookEntity;
import com.Darek.Programik.repository.BookRepository;
import com.Darek.Programik.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
    @RequestMapping("/book")
    public String getBook(@RequestParam("id") Long id, Model model) {
        BookEntity bookEntity = bookService.getBook(id);
        model.addAttribute("book",bookEntity);
        return "book";
    }
    @RequestMapping("/book/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }

    @RequestMapping("/price/{id}")
    public String changePrice(@PathVariable("id") Long id, Model model) {
        BookEntity bookEntity = bookService.getBookById(id);
        model.addAttribute("book",bookEntity);
        return "price";
    }

    @RequestMapping(value = "/price/change", method = RequestMethod.POST)
    public String changePrice( BookEntity bookEntity){
        bookService.changePrice(bookEntity);
        return "redirect:/books";
    }


}
