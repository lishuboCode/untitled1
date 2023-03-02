package com.offcn.dao;

import com.offcn.bean.Book;

import java.util.List;

public class BookDao extends BaseDao<Book> {
    //查询所有图书
    public List<Book> findAllBook(){
        String sql = "SELECT * FROM book";
        return queryMany(sql,Book.class);
    }

    //添加图书
    public int addBook(Book book){
        String sql = "INSERT INTO book(bname,bprice,bauthor,bdesc)VALUES(?,?,?,?)";
        return update(sql,book.getBname(),book.getBprice(),book.getBauthor(),book.getBdesc());
    }
    //根据编号查询
    public Book findBookByBid(int bid){
        String sql ="SELECT * FROM book WHERE bid = ?";
        return queryOne(sql,Book.class,bid);
    }
    //修改图书信息
    public int updateBook(Book book){
        String sql = "UPDATE book SET bname=?,bprice=?,bauthor=?,bdesc=? WHERE bid =?";
        return  update(sql,book.getBname(),book.getBprice(),book.getBauthor(),book.getBdesc(),book.getBid());
    }

    //根据编号删除
    public int delBook(int bid) {
        String sql = "DELETE FROM book WHERE bid = ?";
        return update(sql,bid);
    }
}
