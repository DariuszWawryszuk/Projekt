package com.Darek.Programik.utils;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component

    public class utilsScanner {
    public void printContinue() {
        System.out.println("Aby kontynuowac wcisnij dowolny przycisk");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public long getIdByScaner() {
        Scanner entry = new Scanner(System.in);
        return (long) entry.nextInt();
    }
    public String getString() {
        Scanner entry;
        entry = new Scanner(System.in);
        return entry.nextLine();
    }
}
