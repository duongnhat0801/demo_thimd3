package com.codegym.demo_thi.controllers;

import com.codegym.demo_thi.model.Book;
import com.codegym.demo_thi.model.Borrow;
import com.codegym.demo_thi.model.Student;
import com.codegym.demo_thi.services.BookService;
import com.codegym.demo_thi.services.BorrowService;
import com.codegym.demo_thi.services.IBorrowService;
import com.codegym.demo_thi.services.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "BorrowServlet", urlPatterns = "/borrows/*")
public class BorrowsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        switch (url) {
            case "/create":
                showFormCreateBorrow(req, resp);
                break;

            case "/list":
                showList(req, resp);
                break;
        }
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) {
        IBorrowService borrowService = new BorrowService();
        List<Borrow> borrows = borrowService.selectAll();
    }

    private void  showFormCreateBorrow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Book book = new BookService().findBookById(id);
        List<Student> students = new StudentService().selectAllStudent();
        req.setAttribute("students",students);
        req.setAttribute("book",book);
        req.getRequestDispatcher("/views/createBorrow.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        int book_id = Integer.parseInt(req.getParameter("book_id"));
        int student_id = Integer.parseInt(req.getParameter("student_id"));
        Date borrow_day = new Date(System.currentTimeMillis());
        Date pay_day = Date.valueOf(req.getParameter("pay_day"));
        boolean status = false;

        Borrow br = new Borrow(code, student_id, book_id, status, borrow_day, pay_day);
        IBorrowService borrowService = new BorrowService();
        borrowService.insert(br);

        resp.sendRedirect("/books/list");

    }
}
