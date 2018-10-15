package com.Darek.Programik.service;

import com.Darek.Programik.model.Book;
import com.Darek.Programik.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


@Repository
public class RunnerService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AdminService adminService;

    @Autowired
    UserService userService;

    public void run() throws IOException {


        while (true) {
            handleMenu();
        }
    }

    private void handleMenu() throws IOException {
        System.out.println("Gdzie sie chcesz zalogować");
        System.out.println("1 - Administrator");
        System.out.println("2 - Użytkownik");
        Scanner klawiatura = new Scanner(System.in);
        int wyborMenu = klawiatura.nextInt();

        if (wyborMenu == 1) {
            handleAdmin();
        } else if (wyborMenu == 2) {
            handleUser();
        } else {
            System.exit(0);
        }
    }


    private void handleUser() {
        boolean wyjscie = true;
        while (wyjscie) {

            System.out.println("Witaj w Swoim koszyku");
            System.out.println("Wybież co chcesz zrobić");
            System.out.println("1 - Wyświetl ksiązki możliwe do kupienia");
            System.out.println("2 - Dodaj nową ksiązkę do koszyka");
            System.out.println("3 - Usuń książkę z koszyka");
            System.out.println("4 - Wyświetl swoje książki w koszyku");
            System.out.println("5 - Wyświetl szczegółowe dane wybranej książki");
            System.out.println("0 - Wyjście z programu");
            System.out.println("Wpisz opcję i wciśniej Enter");
            Scanner klawiaturaWybor = new Scanner(System.in);
            int wybor = klawiaturaWybor.nextInt();
            try {
                switch (wybor) {
                    case 1: {
                        adminService.showBookList();
                        break;
                    }
                    case 2: {
                        userService.dodanieKoszyk();
                        break;
                    }
                    case 3: {
                        userService.usuniecieKszyk();
                        break;
                    }
                    case 4: {
                        userService.showBookList();
                        break;
                    }
                    case 5:
                        userService.daneSzczzegolowe();
                        break;
                    case 0:
                        wyjscie = false;
                        break;
                }
            } catch (Exception e) {
                System.out.println("Jako wybór trzeba podać liczbę");
            }

        }
    }

    private void handleAdmin() throws IOException {
        boolean wyjscie = true;
        while (wyjscie) {

            System.out.println("Wybierz co chcesz zrobić");
            System.out.println("1 - Dodaj nową ksiązkę");
            System.out.println("2 - Usuń książkę");
            System.out.println("3 - Wyświetl swoje książki");
            //          System.out.println("4 - Zapis listy książek do pliku");
            System.out.println("0 - Wyjście z programu");
            System.out.println("Wpisz opcję i wciśniej Enter");

            Scanner klawiaturaWybor = new Scanner(System.in);

            int wybor = klawiaturaWybor.nextInt();

            switch (wybor) {
                case 1: {
                    adminService.addBook();
                    break;
                }
                case 2: {
                    adminService.deleteBook();
                    break;
                }
                case 3: {
                    adminService.showBookList();
                    break;
                }
//                case 4: {
//                    //plikService.zapisywaniePlik();
//                    adminService.zapisywaniePlik2();
//                    break;
//                }
                case 0:
                    wyjscie = false;
                    break;
            }
        }
    }


}
