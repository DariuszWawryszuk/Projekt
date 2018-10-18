package com.Darek.Programik.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Scanner;


@Service
public class RunnerService {

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
        Scanner enter = new Scanner(System.in);
        int choiceMenu = enter.nextInt();

        if (choiceMenu == 1) {
            handleAdmin();
        } else if (choiceMenu == 2) {
            handleUser();
        } else {
            System.exit(0);
        }
    }


    private void handleUser() throws IOException {
        boolean exit = true;
        while (exit) {

            System.out.println("Witaj w Swoim koszyku");
            System.out.println("Wybież co chcesz zrobić");
            System.out.println("1 - Wyświetl ksiązki możliwe do kupienia");
            System.out.println("2 - Dodaj nową ksiązkę do koszyka");
            System.out.println("3 - Usuń książkę z koszyka");
            System.out.println("4 - Wyświetl swoje książki w koszyku");
            System.out.println("5 - Wyświetl szczegółowe dane wybranej książki");
            System.out.println("0 - Wyjście z programu");
            System.out.println("Wpisz opcję i wciśniej Enter");
            Scanner enter = new Scanner(System.in);
            int choice = enter.nextInt();
            try {
                switch (choice) {
                    case 1: {
                        adminService.showBookList();
                        break;
                    }
                    case 2: {
                        userService.addToBasket();
                        break;
                    }
                    case 3: {
                        userService.deleteFromBasket();
                        break;
                    }
                    case 4: {
                        userService.showBookList();
                        break;
                    }
                    case 5:
                        userService.specificInformation();
                        break;
                    case 0:
                        exit = false;
                        break;
                }
            } catch (Exception e) {
                System.out.println("Jako wybór trzeba podać liczbę tralala");
            }

        }
    }

    private void handleAdmin() throws IOException {
        boolean exit = true;
        while (exit) {

            System.out.println("Wybierz co chcesz zrobić");
            System.out.println("1 - Dodaj nową ksiązkę");
            System.out.println("2 - Usuń książkę");
            System.out.println("3 - Wyświetl swoje książki");
            System.out.println("4 - Praca z danymi książki");
            System.out.println("0 - Wyjście z programu");
            System.out.println("Wpisz opcję i wciśniej Enter");

            Scanner enter = new Scanner(System.in);
            int choice = enter.nextInt();

            switch (choice) {
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
                case 4: {
                    handleBook();
                    break;
                }
                case 0:
                    exit = false;
                    break;
            }
        }
    }

    private void handleBook() throws IOException {
        boolean exit = true;
        while (exit) {

            System.out.println("Wybierz co chcesz zrobić");
            System.out.println("1 - Zmień cenę książki");
            System.out.println("2 - Zmień ilość książek");
            System.out.println("0 - Wyjście z programu");
            System.out.println("Wpisz opcję i wciśniej Enter");

            Scanner enter = new Scanner(System.in);
            int choice = enter.nextInt();

            switch (choice) {
                case 1: {
                    adminService.changePrice();
                    break;
                }
                case 2: {
                    adminService.changeQuantity();
                    break;
                }
                case 0:
                    exit = false;
                    break;
            }
        }
    }


}
