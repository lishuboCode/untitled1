package com.offcn.bean;

public class Book {
    public Book() {
    }

    public Book(String bname, double bprice, String bauthor, String bdesc) {
        this.bname = bname;
        this.bprice = bprice;
        this.bauthor = bauthor;
        this.bdesc = bdesc;
    }

    public Book(int bid, String bname, double bprice, String bauthor, String bdesc) {
        this.bid = bid;
        this.bname = bname;
        this.bprice = bprice;
        this.bauthor = bauthor;
        this.bdesc = bdesc;
    }

    private int bid;
    private String bname;
    private double bprice;
    private String bauthor;
    private String bdesc;

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public double getBprice() {
        return bprice;
    }

    public void setBprice(double bprice) {
        this.bprice = bprice;
    }

    public String getBauthor() {
        return bauthor;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }

    public String getBdesc() {
        return bdesc;
    }

    public void setBdesc(String bdesc) {
        this.bdesc = bdesc;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid=" + bid +
                ", bname='" + bname + '\'' +
                ", bprice=" + bprice +
                ", bauthor='" + bauthor + '\'' +
                ", bdesc='" + bdesc + '\'' +
                '}';
    }
}
