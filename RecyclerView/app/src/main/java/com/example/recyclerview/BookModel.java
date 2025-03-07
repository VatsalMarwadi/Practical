package com.example.recyclerview;

public class BookModel {

    public String book,bname,bprice,pauthor;

    public BookModel(String book, String bname, String bprice, String pauthor) {
        this.book = book;
        this.bname = bname;
        this.bprice = bprice;
        this.pauthor = pauthor;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBprice() {
        return bprice;
    }

    public void setBprice(String bprice) {
        this.bprice = bprice;
    }

    public String getPauthor() {
        return pauthor;
    }

    public void setPauthor(String pauthor) {
        this.pauthor = pauthor;
    }
}