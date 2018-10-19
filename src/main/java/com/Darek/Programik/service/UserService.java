package com.Darek.Programik.service;

import com.Darek.Programik.model.BookEntity;
import com.Darek.Programik.model.BookInBasket;
import com.Darek.Programik.repository.BasketRepository;
import com.Darek.Programik.repository.BookRepository;
import com.Darek.Programik.utils.utilsScanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

@Service
public class UserService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BasketRepository basketRepository;

    @Autowired
    utilsScanner utilsScanner;

    public void addToBasket() {
        System.out.println("Podaj ID ksiązki którą chcesz dodać do koszyka");
        long id = utilsScanner.getIdByScaner();
        BookEntity book = bookRepository.getBookById(id);
        if (book == null) {
            System.out.println("Nie znaleziono książki o takim ID");
        } else {
            System.out.println("Podaj ilość książek jakie chcesz dodać");
            Scanner entry1 = new Scanner(System.in);
            int quantityBookInBasket = entry1.nextInt();

            if (book.getQuantity() <= quantityBookInBasket) {
                System.out.println("Za mało książek w magazynie");
            }
            else {
                basketRepository.addBookToBasket(id, quantityBookInBasket);
                int quantity = book.getQuantity() - quantityBookInBasket;
                book.setQuantity(quantity);
                bookRepository.updateBook(id,book);
                utilsScanner.printContinue();
            }
        }
    }

    public void deleteFromBasket() {
        System.out.println("Podaj ID ksiązki którą chcesz usunąć z  koszyka");
        long id = utilsScanner.getIdByScaner();
        BookInBasket bookInBasket = basketRepository.getBook(id);

        if (bookInBasket == null) {
            System.out.println("Nie znaleziono książki o takim ID");
        } else {
            long idBook = bookInBasket.getIdBook(id); // pobieram Id Książki z koszyka
            BookEntity book = bookRepository.getBookById(idBook); // tworzę instancję ksiązki

            int quantity = book.getQuantity() + bookInBasket.getQuantity();
            book.setQuantity(quantity);
            basketRepository.deleteFromBasket(bookInBasket);
            bookRepository.updateBook(id,book);
            utilsScanner.printContinue();
        }
    }

    public void showBookList() {
        List<BookInBasket> basket = basketRepository.findAllBooks();
        float totalPrice = totalPrice(basket);
        if (basket.size() < 1) {
            System.out.println("Narazie nie ma żadnej ksiazki");
        } else {
            System.out.println();
            for (BookInBasket bookInBasket : basket) {
                System.out.println(bookInBasket);
            }
        System.out.println("Cena za cały koszyk: " + totalPrice);
            System.out.println();
            utilsScanner.printContinue();
        }
    }

    public void specificInformation() {
        System.out.println("Podaj ID książki ktorej chcesz poznać dane:");
        long id = utilsScanner.getIdByScaner();
        BookInBasket bookInBasket = basketRepository.getBook(id);

        if (bookInBasket == null) {
            System.out.println("Nie znaleziono książki o takim ID");
        } else {
            long idBook = bookInBasket.getIdBook(id);//pobieram IDKsiążki po ID koszyka, aby potem stworzyć instancje książki po tym ID
            BookEntity book = bookRepository.getBookById(idBook);
            System.out.println("Tytuł: " + book.getTitle());
            System.out.println("Autor: " + book.getAuthor());
            System.out.println("Rodzaj: " + book.getType());
            System.out.println("Ilość: " + bookInBasket.getQuantity());
            System.out.println("Cena: " + book.getPrice());
            float totalPriceBook = (bookInBasket.getPrice()) * (bookInBasket.getQuantity());
            System.out.println("Łączna cena za książki: " + totalPriceBook);
            // CODEREv to można dać do metody np. printBookInformation ?
            utilsScanner.printContinue();
        }
    }

    public Float totalPrice(List<BookInBasket> basket){
        float totalPrice = 0;
        for (BookInBasket bookInBasket : basket) {
            totalPrice = bookInBasket.getPrice() * bookInBasket.getQuantity() + totalPrice ;
        }
      return totalPrice;
    }
}
