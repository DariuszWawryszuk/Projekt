package com.Darek.Programik.service;

import com.Darek.Programik.model.BookEntity;

import com.Darek.Programik.model.BookInBasket;
import com.Darek.Programik.repository.BasketRepository;
import com.Darek.Programik.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Scanner;

@Service
public class UserService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BasketRepository basketRepository;

    public void dodanieKoszyk() {
        System.out.println("Podaj ID ksiązki którą chcesz dodać do koszyka tralala");
        Scanner entry = new Scanner(System.in);
        String wybor = entry.nextLine();
        int id = Integer.parseInt(wybor);

        BookEntity ksiazka = bookRepository.getBook(id);

        if (ksiazka == null) {
            System.out.println("Nie znaleziono książki o takim ID");
            return;
        }

        System.out.println("Podaj ilość książek jakie chcesz dodać");
        Scanner entry1 = new Scanner(System.in);
        String iloscKsiazek = entry1.nextLine();

        int ilosc = Integer.parseInt(iloscKsiazek);
        if (ksiazka.getQuantity() <= ilosc) {
            System.out.println("Za mało książek w magazynie");
            return;
        }

        basketRepository.addBookToBasket(id, ilosc);

        ksiazka.calculatingQuantity(ilosc);

        printContinue();
    }

    public void usuniecieKszyk() {
        System.out.println("Podaj ID ksiązki którą chcesz usunąć z  koszyka");
        Scanner entry = new Scanner(System.in);
        String idNew = entry.nextLine();
        int id = Integer.parseInt(idNew);

        BookInBasket bookInBasket = basketRepository.getBook(id);

        if (bookInBasket == null) {
            System.out.println("Nie znaleziono książki o takim ID");
            return;
        }


        Integer idBook = bookInBasket.getIdBook(id); // pobieram Id Książki z koszyka
        BookEntity ksiazka = bookRepository.getBook(idBook); // tworzę instancję ksiązki
        ksiazka.addingQuantity(bookInBasket.getQuantity()); // dodaję ilośc książek do magazynu

        basketRepository.deleteFromBasket(bookInBasket);


        printContinue();
    }


    public void showBookList() {
        List<BookInBasket> koszyk = basketRepository.findAllBooks();
        float totalPrice = totalPrice(koszyk);
        if (koszyk.size() < 1) {
            System.out.println("Narazie nie ma żadnej ksiazki");
        } else {
            System.out.println();
            for (BookInBasket wynik : koszyk) {
                System.out.println(wynik);
            }
        System.out.println("Cena za cały koszyk: " + totalPrice);
        }
    }

    public void daneSzczzegolowe() {
        System.out.println("Podaj ID książki ktorej chcesz poznać danettt:");
        Scanner tr = new Scanner(System.in);
        String idNew = tr.nextLine();
        int id = Integer.parseInt(idNew);

        BookInBasket bookInBasket = basketRepository.getBook(id);

        if (bookInBasket == null) {
            System.out.println("Nie znaleziono książki o takim ID");
            return;
        }

        Integer idBook = bookInBasket.getIdBook(id);//pobieram IDKsiążki po ID koszyka, aby ptem stworzyćinstancje książki po tym ID
        BookEntity ksiazka = bookRepository.getBook(idBook);

        System.out.println("Tytuł: " + bookInBasket.getTitle());
        System.out.println("Autor: " + ksiazka.getAuthor());
        System.out.println("Rodzaj: " + ksiazka.getType());
        System.out.println("Ilość: " + bookInBasket.getQuantity());
        System.out.println("Cena: " + ksiazka.getPrice());
        float totalPriceBook = (bookInBasket.getPrice()) * (bookInBasket.getQuantity());
        System.out.println("Łączna cena za książki: " + totalPriceBook);
        printContinue();
    }

    private void printContinue() {
        System.out.println("Aby kontynuowac wcisnij dowolny przycisk");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public Float totalPrice(List<BookInBasket> basket){
        float totalPrice = 0;
        for (BookInBasket wynik : basket) {
            totalPrice = wynik.getPrice() * wynik.getQuantity() + totalPrice ;
        }
      return totalPrice;
    }
}
