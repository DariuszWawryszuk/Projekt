package com.Darek.Programik.service;

import com.Darek.Programik.model.BookEntity;
import com.Darek.Programik.repository.BookRepository;
import com.Darek.Programik.utils.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class AdminService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    Tools tools;

    public void addBook() {
        System.out.println("Podaj tytuł ksiązki");
        Scanner entry = new Scanner(System.in);
        String title = entry.nextLine();
        System.out.println("Podaj autora ksiązki");
        entry = new Scanner(System.in);
        String author = entry.nextLine();
        System.out.println("Podaj rodzaj ksiązki");
        entry = new Scanner(System.in);
        String type = entry.nextLine();
        System.out.println("Podaj ilość książek");
        entry = new Scanner(System.in);
        String quantity = entry.nextLine();
        System.out.println("Podaj cenę książki");
        entry = new Scanner(System.in);
        String strPrice = entry.nextLine();

        addBookToCollection(title, author, type, quantity, strPrice);

        tools.printContinue();
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

        Scanner entry = new Scanner(System.in);
        long id = entry.nextInt();

        BookEntity book = bookRepository.getBookById(id);

        if (book == null) {
            System.out.println("Nie znaleziono książki o takim tytule");
            tools.printContinue();
            return;
        }
        bookRepository.deleteBook(book);
        System.out.println("Usunięto książkę");

        tools.printContinue();
    }


    public void showBookList() {
        List<BookEntity> books = bookRepository.findAllBooks();
        if (books.size() < 1) {
            System.out.println("Narazie nie ma żadnej ksiazki");
        } else {
            System.out.println();
            for (BookEntity result : books)
                System.out.println(result);
            }
        tools.printContinue();
    }

    public void changePrice(){
        System.out.println("Podaj ID ksiązki dla której chcesz zmeinić cenę");

        Scanner entry = new Scanner(System.in);
        long id = entry.nextInt();

        BookEntity bookEntity = bookRepository.getBookById(id);

        if (bookEntity == null) {
            System.out.println("Nie znaleziono książki o takim tytule");
            tools.printContinue();
            return;
        }

        System.out.println("Aktualna cena książki to: " + bookEntity.getPrice() + " Podaj nową cenę książki: ");

        Scanner newPrice = new Scanner(System.in);
        float price = newPrice.nextFloat();

        bookEntity.setPrice(price);

        System.out.println("Zmianiono cenę książki");
        tools.printContinue();
    }

    public void changeQuantity(){
        System.out.println("Podaj ID ksiązki dla której chcesz zmeinić ilość");

        Scanner entry = new Scanner(System.in);
        long id = entry.nextInt();

        BookEntity bookEntity = bookRepository.getBookById(id);

        if (bookEntity == null) {
            System.out.println("Nie znaleziono książki o takim tytule");
            tools.printContinue();
            return;
        }

        System.out.println("Aktualna ilość książek to: " + bookEntity.getQuantity() + " Podaj nową ilość książek: ");

        Scanner newQuantity = new Scanner(System.in);
        int quantity = newQuantity.nextInt();

        bookEntity.setQuantity(quantity);

        System.out.println("Zmianiono ilość książek");
        tools.printContinue();
    }

}
