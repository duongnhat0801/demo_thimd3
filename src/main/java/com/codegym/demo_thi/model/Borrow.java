package com.codegym.demo_thi.model;


import java.sql.Date;

public class Borrow {
    private int id;
    private String code ;
    private int student_id;
    private int book_id;
    private boolean status;
    private Date borrow_day;
    private Date pay_day;
    private Student student;
    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Borrow() {
    }

    public Borrow(String code, int student_id, int book_id, boolean status, Date borrow_day, Date pay_day) {
        this.code = code;
        this.student_id = student_id;
        this.book_id = book_id;
        this.status = status;
        this.borrow_day = borrow_day;
        this.pay_day = pay_day;
    }

    public Borrow(int id, String code, int student_id, int book_id, boolean status, Date borrow_day, Date pay_day) {
        this.id = id;
        this.code = code;
        this.student_id = student_id;
        this.book_id = book_id;
        this.status = status;
        this.borrow_day = borrow_day;
        this.pay_day = pay_day;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getBorrow_day() {
        return borrow_day;
    }

    public void setBorrow_day(Date borrow_day) {
        this.borrow_day = borrow_day;
    }

    public Date getPay_day() {
        return pay_day;
    }

    public void setPay_day(Date pay_day) {
        this.pay_day = pay_day;
    }
}
