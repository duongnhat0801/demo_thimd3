package com.codegym.demo_thi.services;

import com.codegym.demo_thi.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> selectAllStudent();
}
