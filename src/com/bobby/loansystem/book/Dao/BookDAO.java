package com.bobby.loansystem.book.Dao;

import com.bobby.loansystem.book.Domain.Book;
import java.sql.SQLException;

public class BookDAO implements IBookDAO{

    private static final String INSERT_SQL =  "insert into book(booknumber, bookname, author, translator, quantity, publishor, " +
            "language, price, onnumber, abstract) values(?,?,?,?,?,?,?,?,?,?)" ;
    //private static final String SELECT_SQL = "select " + FIELDS_INSERT + " from Administrator where username=?";
    private static final String UPDATE_SQL = "update Administrator set " + "password=? where username=?";
    private static final String DELETE_SQL = "delete from book where name=?";

    @Override
    public Book find(String nameOrNumber){

    }

    @Override
    public void update(Book book) {

    }

    @Override
    public void remove(Book book) {

    }

    @Override
    public void create(Book book) throws SQLException {

    }
}
