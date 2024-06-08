package com.codegym.demo_thi.repositories;

import com.codegym.demo_thi.database.DBConnect;
import com.codegym.demo_thi.model.Book;
import com.codegym.demo_thi.model.Borrow;
import com.codegym.demo_thi.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BorrowRepo implements IBorrowRepo{
    @Override
    public void insert(Borrow br) {
        Connection connection = new DBConnect().getConnection();

        String sql = "insert into borrow(code, student_id, book_id, status, borrow_day, pay_day) value(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, br.getCode());
            ps.setInt(2, br.getStudent_id());
            ps.setInt(3, br.getBook_id());
            ps.setBoolean(4, br.isStatus());
            ps.setDate(5, br.getBorrow_day());
            ps.setDate(6, br.getPay_day());
            ps.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Borrow> selectAll() throws SQLException {
        List<Borrow> borrows = new ArrayList<>();
        Connection connection = new DBConnect().getConnection();
        String sql = "select br.code,b.name as nameBook,b.author,s.name as nameStudent,s.class_room,br.borrow_day,br.pay_day " +
                "from book b join borrow br on b.id = br.book_id join student s on br.student_id = s.id; ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Student student = new Student();
            student.setName(rs.getString("nameStudent"));
            student.setClass_room(rs.getString("class_room"));
            Book book = new Book();
            book.setName(rs.getString("nameBook"));
            book.setAuthor(rs.getString("author"));
            Borrow borrow = new Borrow();
            borrow.setStudent(student);
            borrow.setBook(book);
            borrow.setCode(rs.getString("code"));
            borrow.setBorrow_day(rs.getDate("borrow_day"));
            borrow.setPay_day(rs.getDate("pay_day"));
            borrows.add(borrow);
        }
        return borrows;
    }
}
