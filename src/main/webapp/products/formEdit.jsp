<%--
  Created by IntelliJ IDEA.
  User: YEN
  Date: 6/8/2021
  Time: 4:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Form Edit Product</title>


</head>
<body>
<div>
    <h1>Form Edit Product</h1>
    <a href="product?action=home">Quay trở về trang chủ</a>
    <form method ="post">
        <%--        <span>STT<input type="text" name="id" value="${product.id}"/></span><br>--%>
        <span>Tên<input type="text" name="name" value="${product.name}"/></span><br>
        <span>Giá<input type="text" name="price" value="${product.price}"/></span><br>
        <span>Số lượng<input type="text" name="quanlity" value="${product.quanlity}"/></span><br>
        <span>Màu sắc<input type="text" name="color" value="${product.color}"/></span><br>

        <span>Mô Tả<input type="text" name="description" value="${product.description}"/></span><br>




        <span>Category </span>
        <c:forEach items="${categories}" var="category">
            <input type="radio" id="${category.id}" name="category_id" value="${category.id}">
            <%--                 <label for="other">"${category.name}"</label>--%>
            <label >"${category.name}"</label>

        </c:forEach>
<%--        <input type="radio" id="other" name="catagory_id" value="other">--%>
<%--        <label for="other">Other</label>--%>


        <br>

        <button type="submit">Update</button>
    </form>
</div>

</body>
</html>
