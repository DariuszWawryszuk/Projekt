package com.Darek.Programik.utils;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Tools {
    // CODEREV nazwa klasy nic nie mówi, zbyt ogólnie
    public void printContinue() {
        System.out.println("Aby kontynuowac wcisnij dowolny przycisk");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}
