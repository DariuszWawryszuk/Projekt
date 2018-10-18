package com.Darek.Programik.model;

import javax.persistence.*;

@Entity
public class BookInBasket extends BaseEntity {

    private long idBook;
    private int quantity;
    private  float price;

    public BookInBasket(){

    }

    public BookInBasket(long idBook, int quantity, float price) {
        this.idBook = idBook;
        this.quantity = quantity;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public long getIdBook(long id) {
        return idBook;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return
                "id: " + getId() +
                ", idBook: " + idBook +
                ", quantity: " + quantity +
                ", price: " + price +
                '}';
    }
}
