package com.Darek.Programik;

import com.Darek.Programik.model.Users;
import com.Darek.Programik.repository.BookRepository;
import com.Darek.Programik.repository.UsersRepository;
import com.Darek.Programik.service.RunnerService;
import com.Darek.Programik.utils.Role;
import com.Darek.Programik.utils.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Starter implements CommandLineRunner {

    @Autowired
    private RunnerService runnerService;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    RoleRepository roleRepository;

    public void run(String... strings) throws Exception{


        runnerService.run();

    }
}
