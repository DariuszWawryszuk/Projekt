package com.Darek.Programik;


import com.Darek.Programik.model.BookEntity;
import com.Darek.Programik.repository.BookRepository;
import com.Darek.Programik.service.RunnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Starter implements CommandLineRunner {

    @Autowired
    RunnerService runnerService;
    // CODEREV private? obier zmienne
    @Autowired
    BookRepository bookRepository;

    public void run(String... strings) throws Exception{
        // CODEREV a po co w argumencie stringi?
        runnerService.run();


    }
}
