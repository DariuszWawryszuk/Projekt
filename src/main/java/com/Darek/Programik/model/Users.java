package com.Darek.Programik.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String username;

    private String password;

    private boolean enabled;

    public Users(){

    }

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
        this.enabled = true;
    }
}
