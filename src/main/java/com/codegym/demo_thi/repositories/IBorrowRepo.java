package com.codegym.demo_thi.repositories;

import com.codegym.demo_thi.model.Borrow;

import java.sql.SQLException;
import java.util.List;

public interface IBorrowRepo {
    void insert(Borrow br);

    List<Borrow> selectAll() throws SQLException;
}
