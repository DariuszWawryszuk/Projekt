package com.Darek.Programik.repository;

import com.Darek.Programik.model.Book;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BookRepository {

    private Map<Integer, Book> books = new HashMap<Integer, Book>();

    public BookRepository(){

    }

    public void createBook(String title, String author, String type, int quantity, float price){
        Book book = new Book(title, author, type, quantity, price);
        book.setId(getNewId());
        books.put(book.getId(), book);
    }

    public void deleteBook(int id){
        books.remove(id);
    }

    public HashMap<Integer, Book> findAllBooks() {
        return (HashMap<Integer, Book>) books;
    }

    public Book getBook(Integer id){
        return books.get(id);
    }

    public Book getBookTitle(String title){
        return books.get(title);
    }

    public int getNewId() {
        if(books.isEmpty()) {
            return 0;
        }
        else {
            Integer integer = books.keySet().stream().max((o1, o2) -> o1.compareTo(o2)).get();
            return integer+1;
        }
    }

}
