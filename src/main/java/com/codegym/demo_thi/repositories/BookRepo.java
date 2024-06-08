package com.codegym.demo_thi.repositories;

import com.codegym.demo_thi.database.DBConnect;
import com.codegym.demo_thi.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

public class BookRepo implements IBookRepo{
    @Override
    public List<Book> selectAll() throws SQLException {
        List<Book> books = new ArrayList<>();
        Connection connection = new DBConnect().getConnection();
        String sql = "select * from book";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            int id = rs.getInt("id");
            String code = rs.getString("code");
            String name = rs.getString("name");
            String author = rs.getString("author");
            String description = rs.getString("description");
            int quantity = rs.getInt("quantity");
            Book book = new Book(id,code,name,author,description,quantity);
            books.add(book);
        }
        return books;
    }

    @Override
    public Book findBookById(int id) throws SQLException {
        Book book = null;
        Connection connection = new DBConnect().getConnection();
        String sql = " select * from book where id = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            String code = rs.getString("code");
            String name = rs.getString("name");
            String author = rs.getString("author");
            String description = rs.getString("description");
            int quantity = rs.getInt("quantity");
             book = new Book(id,code,name,author,description,quantity);
        }
        return book;
    }
}
