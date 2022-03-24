package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Book implements Comparable<Book>, Serializable {
    private String isbn;
    private String title;
    private int edition;
    private double price;

    public Book() {
    }

    public Book(String isbn, String title, int edition, double price, String name) {
        this.isbn = isbn;
        this.title = title;
        this.edition = edition;
        this.price = price;
        this.addAuthor(name);
    }

    ArrayList<Author> authors = new ArrayList<>();

    void addAuthor(String name) {
        authors.add(new Author(name));
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ArrayList<Author> getArrayList1() {
        return authors;
    }

    public void setArrayList1(ArrayList<Author> arrayList1) {
        this.authors = arrayList1;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", edition=" + edition +
                ", price=" + price +
                ", Author=" + authors +
                '}';
    }

    @Override
    public int compareTo(Book o) {
        return title.compareTo(o.title);
    }
}
