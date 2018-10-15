package com.Darek.Programik.model;

public class BookInBasket {

    private int id;

    private int idBook;

    private String title;

    private int quantity;

    public BookInBasket(int idBook, String book, int quantity) {
        this.idBook = idBook;
        this.title = book;
        this.quantity = quantity;
    }

    public BookInBasket(String book, int quantity) {
        this.title = book;
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
}
