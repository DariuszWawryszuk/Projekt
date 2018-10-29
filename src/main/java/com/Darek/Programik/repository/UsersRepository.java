package com.Darek.Programik.repository;

import com.Darek.Programik.model.Users;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UsersRepository {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public void createUser(Users users) {
        em.persist(users);

    }

}
