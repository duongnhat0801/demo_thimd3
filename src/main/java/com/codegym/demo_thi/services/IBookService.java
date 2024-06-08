package com.codegym.demo_thi.services;

import com.codegym.demo_thi.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> selectAll();

    Book findBookById(int id);
}
