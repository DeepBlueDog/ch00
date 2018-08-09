package com.bobby.loansystem.book.Dao;

import com.bobby.loansystem.book.Domain.Book;

public interface IBookDAO {
    Book find(String nameOrNumber); //查询图书
    void update(Book book); //修改图书信息
    void remove(Book book); //删除图书信息
    void create(Book book) throws Exception;  //图书入库
}
