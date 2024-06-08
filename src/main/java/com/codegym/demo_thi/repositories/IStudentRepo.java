package com.codegym.demo_thi.repositories;

import com.codegym.demo_thi.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentRepo {
    List<Student> selectAllStudent() throws SQLException;
}
