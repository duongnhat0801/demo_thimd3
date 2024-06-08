package com.codegym.demo_thi.services;

import com.codegym.demo_thi.model.Book;
import com.codegym.demo_thi.model.Borrow;
import com.codegym.demo_thi.repositories.BorrowRepo;
import com.codegym.demo_thi.repositories.IBorrowRepo;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class BorrowService implements IBorrowService{
    private static IBorrowRepo borrowRepo = new BorrowRepo();
    @Override
    public void insert(Borrow br) {
        borrowRepo.insert(br);
        Book book = new BookService().findBookById(br.getBook_id());
                book.setQuantity(book.getQuantity() - 1);
                update
    }

    @Override
    public List<Borrow> selectAll() {
        try {
            return borrowRepo.selectAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
