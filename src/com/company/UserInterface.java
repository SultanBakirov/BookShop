package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {


    Scanner scanner = new Scanner(System.in);

    CollectionOfBooks collectionOfBooks = new CollectionOfBooks();

    void addBook() {
        String title;
        String isbn;
        String author;
        double price;
        int edition;
        System.out.println("\n===>*** ADD THE BOOK  ***<===");
        System.out.print("=====   ENTER ISBN     =====> ");
        isbn = scanner.next();
        System.out.print("=====   ENTER TITLE    =====> ");
        title = scanner.nextLine();
        title = scanner.nextLine();
        System.out.print("====   ENTER EDITION   =====> ");
        edition = scanner.nextInt();
        System.out.print("===== HOW MUCH IT COST =====> ");
        price = scanner.nextDouble();
        System.out.print("=====   ENTER AUTHOR   =====> ");
        author = scanner.next();
        collectionOfBooks.addBook(new Book(isbn, title, edition, price, author));
        System.out.print("DO YOU WANT ADD ADDITIONAL AUTHOR: 1/0 ==> ");
        while (scanner.nextInt() == 0) {
            System.out.print("WRITE AUTHOR NAME: ");
            collectionOfBooks.getBook(collectionOfBooks.size() - 1).addAuthor(scanner.next());
            System.out.print("DO YOU WANT ADD THE OTHER ONE: ");
        }
        System.out.println("\nTHE BOOK ADDED !!!\n");
    }

    void listBook() {
        System.out.println("\nTHE LIST ALL THE BOOKS:");
        for (int i = 0; i < collectionOfBooks.size(); i++) {
            System.out.println(i + " " + collectionOfBooks.getBook(i).toString());
        }
    }
//
    void removeBook() {
        listBook();
        System.out.print("CONFIRM YOUR REMOVING: 1/0 ==> ");
        int number = scanner.nextInt();
        if (number < collectionOfBooks.size()) {
            System.out.println(collectionOfBooks.getBook(number).toString());
            if (scanner.nextInt() == 0) {
                collectionOfBooks.removeBook(number);
                System.out.println("THE BOOK REMOVED !!!\n");
            } else {
                System.out.println("THE BOOK NOT DELETED !!!");
            }
        } else {
            System.out.println("THERE IS NO BOOK WITH THAT NUMBER...\n");
        }
    }

    void printSearch(ArrayList<Book> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i).toString());
        }
    }

    void getBookByTitle(String title) {
        printSearch(collectionOfBooks.searchTitle(title));
    }

    void getBookByIsbn(String isbn) {
        printSearch(collectionOfBooks.searchIsbn(isbn));
    }

    void getBookByAuthor(String author) {
        printSearch(collectionOfBooks.searchAuthor(author));
    }

    void searchMenu() {
        while (true) {
            System.out.println(
                    "\n===============> 1. SEARCH BY TITLE  <===============\n" +
                    "===============>  2. SEARCH BY ISBN  <===============\n" +
                    "===============> 3. SEARCH BY AUTHOR <===============\n" +
                    "===============>    4. MAIN MENU     <===============");
            System.out.print("\n========== TYPE YOUR CHOICE ==========> ");
            int numberOfSearch = scanner.nextInt();
            switch (numberOfSearch) {
                case 1:
                    System.out.print("=====   ENTER TITLE    =====> ");
                    getBookByTitle(scanner.next());
                    break;
                case 2:
                    System.out.print("=====   ENTER ISBN     =====> ");
                    getBookByIsbn(scanner.next());
                    break;
                case 3:
                    System.out.print("=====   ENTER AUTHOR   =====> ");
                    getBookByAuthor(scanner.next());
                    break;
                case 4:
                    mainMenu();
            }
        }
    }

    void mainMenu() {
        System.out.println("\n===============> *** BOOK SHOP *** <=============== ");
        while (true) {
        System.out.println(
                "===============>    1.ADD A BOOK   <===============\n" +
                "===============>   2.DELETE BOOK   <===============\n" +
                "===============>   3.FIND A BOOK   <===============\n" +
                "===============>  4.SHOW ALL BOOKS <===============\n" +
                "===============>       5.EXIT      <===============");
            System.out.println(
                    "\n===================================================");
            System.out.print(
                    "\n========== TYPE YOUR CHOICE ==========> ");
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    searchMenu();
                    break;
                case 4:
                    listBook();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }
}
