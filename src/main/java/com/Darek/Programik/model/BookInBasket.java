package com.Darek.Programik.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class BookInBasket {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int idBook;
    private String title;
    private int quantity;
    private  float price;

    public BookInBasket(int idBook, String title, int quantity, float price) {
        this.idBook = idBook;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }

    public BookInBasket(String title, int quantity) {
        this.title = title;
        this.quantity = quantity;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getIdBook() {
        return idBook;
    }

    public int getIdBook(Integer id) {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
