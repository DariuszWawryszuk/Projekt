package com.Darek.Programik.model;

public class Book {

    private int id;

    private String title;
    private String author;
    private String type;
    private int quantity;

    public Book(int id,String title, String author, String type, int quantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.type = type;
        this.quantity = quantity;
    }

    public Book(String title, String author, String type, int quantity) {
        this.title = title;
        this.author = author;
        this.type = type;
        this.quantity = quantity;
    }

    //    public Book() {
//        this.id = id;
//        this.title = title;
//        this.author = author;
//        this.type = type;
//        this.quantity = quantity;
//    }
    public int calculatingQuantity(int x)
    {
        this.quantity = quantity - x;

        return quantity;
    }
    public int addingQuantity(int x)
    {
        this.quantity = quantity + x;

        return quantity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
