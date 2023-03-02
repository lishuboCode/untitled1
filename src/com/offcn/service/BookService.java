package com.offcn.service;

import com.offcn.bean.Book;
import com.offcn.dao.BookDao;

import java.util.List;

public class BookService {
    private BookDao bd = new BookDao();

    //查询所有图书
    public List<Book> findAllBook(){
        return  bd.findAllBook();
    }

    //添加图书
    public int addBook(Book book){
        return bd.addBook(book);
    }

    //根据编号查询
    public Book findBookByBid(int bid){
        return  bd.findBookByBid(bid);
    }

    //修改图书信息
    public int updateBook(Book book){
        return bd.updateBook(book);
    }

    //删除图书
    public int delBook(int bid) {
        return bd.delBook(bid);
    }
}
