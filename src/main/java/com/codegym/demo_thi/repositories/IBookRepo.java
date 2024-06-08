package com.codegym.demo_thi.repositories;

import com.codegym.demo_thi.model.Book;

import java.sql.SQLException;
import java.util.List;

public interface IBookRepo {
    List<Book> selectAll() throws SQLException;

    Book findBookById(int id) throws SQLException;
}
