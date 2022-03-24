package com.company;

import java.util.ArrayList;

public class CollectionOfBooks extends Book{

    ArrayList<Book> arrayList2 = new ArrayList<Book>();

    public CollectionOfBooks() {
    }

    void addBook(Book book) {
        arrayList2.add(book);
    }

    void removeBook(int index) {
        arrayList2.remove(index);
    }

    Book getBook(int index) {
        return arrayList2.get(index);
    }

    int size() {
        return arrayList2.size();
    }

    public ArrayList<Book> getList() {
        return arrayList2;
    }

    public ArrayList<Book> searchTitle(String title) {
        ArrayList<Book> title2 = new ArrayList<>();
        for (int i = 0; i < arrayList2.size(); i++) {
            if (title.compareTo(arrayList2.get(i).getTitle()) == 0) {
                title2.add(arrayList2.get(i));
            }
        }
        return title2;
    }

    public ArrayList<Book> searchIsbn(String index) {
        ArrayList<Book> index2 = new ArrayList<>();
        for (int i = 0; i < arrayList2.size(); i++) {
            if (index.compareTo(arrayList2.get(i).getIsbn()) == 0) {
                index2.add(arrayList2.get(i));
            }
        }
            return index2;
    }

    public ArrayList<Book> searchAuthor(String author) {
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Author> authors = new ArrayList<>();
        for (int i = 0; i < arrayList2.size(); i++) {
            authors = arrayList2.get(i).getArrayList1();
            for (int j = 0; j < authors.size(); j++) {
                if (author.compareTo(authors.get(i).getName()) == 0) {
                    books.add(arrayList2.get(i));
                }
            }
        }
        return books;
    }

    @Override
    public String toString() {
        String author = "";
        for (int i = 0; i < arrayList2.size(); i++) {
            author += arrayList2.get(i).toString() + "\n";
        }
        return author;
    }
}
