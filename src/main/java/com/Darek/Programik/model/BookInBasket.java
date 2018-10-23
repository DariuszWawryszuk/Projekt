package com.Darek.Programik.model;

import javax.persistence.Entity;

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

    public void setIdBook(long idBook) {
        this.idBook = idBook;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public long getIdBook() {
        return idBook;
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
