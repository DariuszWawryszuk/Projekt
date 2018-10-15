package com.Darek.Programik;

import com.Darek.Programik.repository.BookRepository;
import com.Darek.Programik.service.RunnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Starter implements CommandLineRunner {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    RunnerService runnerService;

    public void run(String... strings) throws Exception{

        //bookRepository.createBook(1,"Tralala", "Super Autor", "Kryminał", 30);
        runnerService.run();

    }
}
