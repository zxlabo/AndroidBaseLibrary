package com.demo.reflect;

public class Book {
    private final static String TAG = "BookTag";
    public int age;
    private String name;
    private String author;

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public Book() {
    }

    public Book(String name) {
        this.name = name;
    }

    private Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    private String declaredMethod(int index) {
        String string = null;
        switch (index) {
            case 0:
                string = "I am declaredMethod 0 !";
                break;
            case 1:
                string = "I am declaredMethod 1 !";
                break;
            default:
                string = "I am declaredMethod default!";
        }

        return string;
    }
    public void testAbcFun(){

    }
}