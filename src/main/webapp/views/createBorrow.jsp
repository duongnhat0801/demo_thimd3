<%@ page import="java.sql.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <h1>Mượn sách</h1>
    <div>
        <form action="/borrows/create" method="post" id="borrow-form">
            Mã mượn sách: <input type="text" name="code"  pattern="^MS\d{4}$" required>
            Tên sách: <input type="text" value="${book.name}" disabled>
            <input type="hidden" name="book_id" value="${book.id}">
            Tên hoc sinh:
            <select name="student_id">
                <c:forEach var="student" items="${students}">
                    <option value="${student.id}">${student.name}</option>
                </c:forEach>
            </select>
            <% Date date = new Date(System.currentTimeMillis()); %>


            Ngày mươn: <input type="date" name="borrow_day" value="<% out.print(date); %>" disabled>
            Ngày trả: <input type="date" name="pay_day" min="<% out.print(date); %>" value=""<% out.print(date); %>>

            <button>Mượn sách</button>
            <a href="/books/list">Huỷ</a>
        </form>


    </div>
</div>
</body>
</html>
