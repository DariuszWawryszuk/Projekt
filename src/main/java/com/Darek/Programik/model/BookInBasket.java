package com.Darek.Programik.model;

import javax.persistence.*;

@Entity
public class BookInBasket
        extends NewId
{


//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long id;

    private int idBook;
    private String title;
    private int quantity;
    private  float price;

    public BookInBasket(){

    }

    public BookInBasket(int idBook, String title, int quantity, float price) {
        this.idBook = idBook;
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getIdBook(Integer id) {
        return idBook;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return
                //"id: " + getId() +
                ", idBook: " + idBook +
                ", title: '" + title + '\'' +
                ", quantity: " + quantity +
                ", price: " + price +
                '}';
    }
}
