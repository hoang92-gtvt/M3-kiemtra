<%--
  Created by IntelliJ IDEA.
  User: YEN
  Date: 6/8/2021
  Time: 11:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Form View</title>
</head>
<body>

<h1>Danh sách sản phẩm</h1>

<div><a href="/product?action=create">Thêm sản phẩm</a></div>
<table border="1" cellspacing="0px" cellpadding="0.5px">
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Giá</th>
        <th>Số Lượng</th>
        <th>Màu sắc</th>

        <th>Loại Sản phẩm</th>

        <th>Action1</th>
        <th>Action2</th>

    </tr>
    <c:forEach items="${dssp}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.quanlity}</td>
            <td>${product.color}</td>

            <td>${product.category.name}</td>

            <td><a href="product?action=edit&id=${product.id}">edit</a></td>
            <td><a href="product?action=delete&id=${product.id}">delele</a></td>

        </tr>

    </c:forEach>

</table>

</body>
</html>
