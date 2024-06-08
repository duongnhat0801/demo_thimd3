<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>sadasfdf</title>
</head>
</head>
<body>
<div>
    <h1>List Book</h1>
    <a href="/borrows/list">List Borrow</a>
</div>
<div class="container">
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List Book</h2></caption>
            <tr>
                <th>Mã sách</th>
                <th>Tên sách</th>
                <th>Tác giả</th>
                <th>Mô tả</th>
                <th>Số lượng</th>
                <th>Action</th>
            </tr>
            <c:forEach var="book" items="${books}" >
                <tr>
                    <td>${book.code}</td>
                    <td>${book.name}</td>
                    <td>${book.author}</td>
                    <td>${book.description}</td>
                    <td>${book.quantity}</td>
                    <td><a href="/borrows/create?id=${book.id}">Mượn</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

</body>
</html>