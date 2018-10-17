package com.Darek.Programik.model;


import javax.persistence.Entity;

@Entity(name = "Book")
public class BookEntity
        extends NewId
{

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long id;

    private String title;
    private String author;
    private String type;
    private int quantity;
    private  float price;

    public BookEntity() {
    }

    public BookEntity(String title, String author, String type, int quantity, float price) {
        this.title = title;
        this.author = author;
        this.type = type;
        this.quantity = quantity;
        this.price = price;
    }

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


    public String getAuthor() {
        return author;
    }


    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return
               // "ID " + getId() +
                        " Tytuł: " + title + " Autor: " + author + " Rodzaj: "
                + type + " Ilość: " + quantity + " Cena: " + price;
    }
}
