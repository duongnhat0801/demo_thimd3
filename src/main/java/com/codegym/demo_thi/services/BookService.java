package com.codegym.demo_thi.services;

import com.codegym.demo_thi.model.Book;
import com.codegym.demo_thi.repositories.BookRepo;
import com.codegym.demo_thi.repositories.IBookRepo;

import java.sql.SQLException;
import java.util.List;

public class BookService implements IBookService{
    private static IBookRepo bookRepo = new BookRepo();
    @Override
    public List<Book> selectAll() {
        try {
           return bookRepo.selectAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Book findBookById(int id) {
        try {
            return bookRepo.findBookById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
