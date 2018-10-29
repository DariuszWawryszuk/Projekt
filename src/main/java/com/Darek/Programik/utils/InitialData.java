package com.Darek.Programik.utils;

import com.Darek.Programik.model.Users;
import com.Darek.Programik.repository.BasketRepository;
import com.Darek.Programik.repository.BookRepository;
import com.Darek.Programik.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitialData {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BasketRepository basketRepository;

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    RoleRepository roleRepository;

    @PostConstruct
    public void initialBook (){

        bookRepository.createBook("Super książka", "Sienkiewicz","Komedia",400,888888);
        bookRepository.createBook("asdas książka", "tatat","Komertedia",66,88);
        bookRepository.createBook("Super sdas", "tyutyu","ert",66,888);

        basketRepository.addBookToBasket(1,1);
        basketRepository.addBookToBasket(1,1);
        basketRepository.addBookToBasket(3,1);

        Users users1 = new Users("user1", "user1");
        usersRepository.createUser(users1);
        Users users2 = new Users("user2", "user2");
        usersRepository.createUser(users2);


        Role user1RoleUSER = new Role("user1","USER");
        //Role user2RoleUSER = new Role("user2","USER");
        Role user2RoleADMIN = new Role("user2","ADMIN");

        roleRepository.persistRole(user1RoleUSER);
        //roleRepository.persistRole(user2RoleUSER);
        roleRepository.persistRole(user2RoleADMIN);
    }
}
