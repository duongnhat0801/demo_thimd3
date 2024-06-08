package com.codegym.demo_thi.repositories;

import com.codegym.demo_thi.database.DBConnect;
import com.codegym.demo_thi.model.Student;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepo implements IStudentRepo{
    @Override
    public List<Student> selectAllStudent() throws SQLException {
        List<Student> students = new ArrayList<>();
        Connection connection = new DBConnect().getConnection();
        String sql = "select * from student";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            int id = rs.getInt("id");
            String code = rs.getString("code");
            String name = rs.getString("name");
            String class_room = rs.getString("class_room");
            Student student = new Student(id,code,name,class_room);
            students.add(student);
        }
        return students;
    }
}
