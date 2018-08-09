package com.bobby.loansystem.book.Domain;

public class Book {


    private String booknumber;
    private String bookname;
    private String author;
    private String translator;
    private int quantity;
    private String publishor;
    private String lanuage;
    private String abstractText;
    private double price;
    private int onnumber;

    public Book() {}

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getLanuage() {
        return lanuage;
    }

    public void setLanuage(String lanuage) {
        this.lanuage = lanuage;
    }

    public String getPublishor() {
        return publishor;
    }

    public void setPublishor(String publishor) {
        this.publishor = publishor;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBooknumber() {
        return booknumber;
    }

    public void setBooknumber(String booknumber) {
        this.booknumber = booknumber;
    }

    public int getOnnumber() {
        return onnumber;
    }

    public void setOnnumber(int onnumber) {
        this.onnumber = onnumber;
    }

    public String getAbstractText() {
        return abstractText;
    }

    public void setAbstractText(String abstractText) {
        this.abstractText = abstractText;
    }

}
