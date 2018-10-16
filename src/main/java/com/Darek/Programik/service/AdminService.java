package com.Darek.Programik.service;

import com.Darek.Programik.model.Book;
import com.Darek.Programik.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Scanner;

@Repository
public class AdminService {

    @Autowired
    BookRepository bookRepository;

    public void addBook() {
        System.out.println("Podaj tytuł ksiązki");
        Scanner entry = new Scanner(System.in);
        String tytul = entry.nextLine();
        System.out.println("Podaj autora ksiązki");
        entry = new Scanner(System.in);
        String autor = entry.nextLine();
        System.out.println("Podaj rodzaj ksiązki");
        entry = new Scanner(System.in);
        String rodzaj = entry.nextLine();
        System.out.println("Podaj ilość książek");
        entry = new Scanner(System.in);
        String ilosc = entry.nextLine();
        System.out.println("Podaj cenę książki");
        entry = new Scanner(System.in);
        String strPrice = entry.nextLine();

        addBookToCollection(tytul, autor, rodzaj, ilosc, strPrice);

        printContinue();
    }

    private void addBookToCollection(String tytul, String autor, String rodzaj,
                                     String ilosc, String strPrice) {
        try {
            int iloscInt = Integer.parseInt(ilosc);
            float price = Float.parseFloat(strPrice);
            bookRepository.createBook(tytul, autor, rodzaj,iloscInt,price);

            System.out.println("Książka została dodana");
        } catch (Exception e) {
            System.out.println("Jako ilość trzeba podać liczbę");
        }
    }


    public void deleteBook() {
        System.out.println("Podaj ID ksiązki którą chcesz usunąć");
        Scanner entry = new Scanner(System.in);
        String idNew = entry.nextLine();
        int id = Integer.parseInt(idNew);

        Book ksiazka = bookRepository.getBook(id);

        if (ksiazka == null) {
            System.out.println("Nie znaleziono książki o takim tytule");
            printContinue();
            return;
        }
        bookRepository.deleteBook(id);
        System.out.println("Usunięto książkę");

        printContinue();
    }


//    public void showBookList() {
//        HashMap<Integer, Book> zbior = bookRepository.findAllBooks();
//        if (zbior.size() < 1) {
//            System.out.println("Narazie nie ma żadnej ksiazki");
//        } else {
//            System.out.println();
//            for (Book wynik : zbior.values()) {
//                System.out.println("ID " + wynik.getId() + " Tytuł: " + wynik.getTitle() + " Autor: " + wynik.getAuthor() + " Rodzaj: "
//                        + wynik.getType() + " Ilość: " + wynik.getQuantity() + " Cena: " + wynik.getPrice());
//            } }
//        printContinue();
//    }

    public void changePrice(){
        System.out.println("Podaj ID ksiązki dla której chcesz zmeinić cenę");
        Scanner entry = new Scanner(System.in);
        String idNew = entry.nextLine();
        int id = Integer.parseInt(idNew);

        Book book = bookRepository.getBook(id);

        if (book == null) {
            System.out.println("Nie znaleziono książki o takim tytule");
            printContinue();
            return;
        }

        System.out.println("Aktualna cena książki to: " + book.getPrice() + " Podaj nową cenę książki: ");
        entry = new Scanner(System.in);
        String newPrice = entry.nextLine();
        float price = Float.parseFloat(newPrice);

        book.setPrice(price);

        System.out.println("Zmianiono cenę książki");
        printContinue();
    }

    public void changeQuantity(){
        System.out.println("Podaj ID ksiązki dla której chcesz zmeinić ilość");
        Scanner entry = new Scanner(System.in);
        String idNew = entry.nextLine();
        int id = Integer.parseInt(idNew);

        Book book = bookRepository.getBook(id);

        if (book == null) {
            System.out.println("Nie znaleziono książki o takim tytule");
            printContinue();
            return;
        }

        System.out.println("Aktualna ilość książek to: " + book.getQuantity() + " Podaj nową ilość książek: ");
        entry = new Scanner(System.in);
        String newQuantity = entry.nextLine();
        int quantity = Integer.parseInt(newQuantity);

        book.setQuantity(quantity);

        System.out.println("Zmianiono ilość książek");
        printContinue();
    }
    private void printContinue() {
        System.out.println("Aby kontynuowac wcisnij dowolny przycisk");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

}
