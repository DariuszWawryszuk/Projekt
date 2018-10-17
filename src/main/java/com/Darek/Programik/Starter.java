package com.Darek.Programik;

import com.Darek.Programik.model.Book;
import com.Darek.Programik.model.BookInBasket;
import com.Darek.Programik.repository.BasketRepository;
import com.Darek.Programik.repository.BookRepository;
import com.Darek.Programik.service.RunnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class Starter implements CommandLineRunner {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BasketRepository basketRepository;

    @Autowired
    RunnerService runnerService;

    @Transactional
    public void run(String... strings) throws Exception{

        bookRepository.createBook("Super książka", "Sienkiewicz","Komedia",400,888888);
        bookRepository.createBook("asdas książka", "tatat","Komertedia",66,88);
        bookRepository.createBook("Super sdas", "tyutyu","ert",66,888);

        runnerService.run();

    }
}
