package com.codegym.demo_thi.services;

import com.codegym.demo_thi.model.Borrow;

import java.util.List;

public interface IBorrowService {
    void insert(Borrow br);

    List<Borrow> selectAll();
}
