package com.codegym.demo_thi.controllers;

import com.codegym.demo_thi.model.Book;
import com.codegym.demo_thi.services.BookService;
import com.codegym.demo_thi.services.IBookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BooksServlet", urlPatterns = "/books/*")
public class BooksServlet extends HttpServlet {
    private static IBookService bookService = new BookService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getPathInfo();
        if(url==null){
            url="";
        }
        switch (url) {
            case "/list":
                System.out.println("aaaaa");
                showListBook(req, resp);
                break;
        }
    }

    private void showListBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookService.selectAll();
        System.out.println("vbbbb");
        req.setAttribute("books", books);
        req.getRequestDispatcher("/views/list.jsp").forward(req,resp);
    }
}
