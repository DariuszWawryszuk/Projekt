package com.Darek.Programik.service;

import com.Darek.Programik.model.BookEntity;
import com.Darek.Programik.repository.BookRepository;
import com.Darek.Programik.utils.utilsScanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class AdminService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private utilsScanner utilsScanner;

    public void addBook() {
        System.out.println("Podaj tytuł ksiązki");
        String title = utilsScanner.getString();
        System.out.println("Podaj autora ksiązki");
        String author = utilsScanner.getString();
        System.out.println("Podaj rodzaj ksiązki");
        String type = utilsScanner.getString();
        System.out.println("Podaj ilość książek");
        String quantity = utilsScanner.getString();
        System.out.println("Podaj cenę książki");
        String strPrice = utilsScanner.getString();
        addBookToCollection(title, author, type, quantity, strPrice);
        utilsScanner.printContinue();
    }

    private void addBookToCollection(String title, String author, String type,
                                     String quantity, String strPrice) {
        try {
            int quantityInt = Integer.parseInt(quantity);
            float price = Float.parseFloat(strPrice);
            bookRepository.createBook(title, author, type,quantityInt,price);

            System.out.println("Książka została dodana");
        } catch (Exception e) {
            System.out.println("Jako ilość trzeba podać liczbę");
        }
    }

    public void deleteBook() {
        System.out.println("Podaj ID ksiązki którą chcesz usunąć");
        long id = utilsScanner.getIdByScaner();
        BookEntity book = bookRepository.getBookById(id);

        if (book == null) {
            System.out.println("Nie znaleziono książki o takim tytule");
            utilsScanner.printContinue();
        } else {
            bookRepository.deleteBook(book);
            System.out.println("Usunięto książkę");
            utilsScanner.printContinue();
        }
    }

    public void showBookList() {
        List<BookEntity> books = bookRepository.findAllBooks();
        if (books.size() < 1) {
            System.out.println("Narazie nie ma żadnej ksiazki");
        }
        else {
            System.out.println();
            for (BookEntity result : books)
                System.out.println(result);
            }
        utilsScanner.printContinue();
    }

    public void changePrice() {
        System.out.println("Podaj ID ksiązki dla której chcesz zmeinić cenę");
        long id = utilsScanner.getIdByScaner();
        BookEntity bookEntity = bookRepository.getBookById(id);

        if (bookEntity == null) {
            System.out.println("Nie znaleziono książki o takim tytule");
            utilsScanner.printContinue();
        } else {

            System.out.println("Aktualna cena książki to: " + bookEntity.getPrice() + " Podaj nową cenę książki: ");
            Scanner newPrice = new Scanner(System.in);
            float price = newPrice.nextFloat();
            bookEntity.setPrice(price);
            System.out.println("Zmianiono cenę książki");
            bookRepository.updateBook(id,bookEntity);
            utilsScanner.printContinue();
        }
    }

    public void changeQuantity() {
        System.out.println("Podaj ID ksiązki dla której chcesz zmeinić ilość");
        long id = utilsScanner.getIdByScaner();
        BookEntity bookEntity = bookRepository.getBookById(id);

        if (bookEntity == null) {
            System.out.println("Nie znaleziono książki o takim tytule");
            utilsScanner.printContinue();
        } else {
            System.out.println("Aktualna ilość książek to: " + bookEntity.getQuantity() + " Podaj nową ilość książek: ");
            Scanner newQuantity = new Scanner(System.in);
            int quantity = newQuantity.nextInt();
            bookEntity.setQuantity(quantity);
            System.out.println("Zmianiono ilość książek");
            bookRepository.updateBook(id,bookEntity);
            utilsScanner.printContinue();
        }
    }

}
