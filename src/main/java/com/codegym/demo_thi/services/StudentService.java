package com.codegym.demo_thi.services;


import com.codegym.demo_thi.model.Student;
import com.codegym.demo_thi.repositories.IStudentRepo;
import com.codegym.demo_thi.repositories.StudentRepo;


import java.sql.SQLException;
import java.util.List;

public class StudentService implements IStudentService{
       IStudentRepo studentRepo = new StudentRepo();
    @Override
    public List<Student> selectAllStudent() {
        try {
             return studentRepo.selectAllStudent();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
