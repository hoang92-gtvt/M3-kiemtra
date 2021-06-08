<%--
  Created by IntelliJ IDEA.
  User: YEN
  Date: 6/8/2021
  Time: 1:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Create Product</title>
</head>
<body>

<div>
    <h1>Form tạo mới một sản phẩm</h1>
    <a href="/product?action=home">Quay về trang chủ</a>

    <form method="post">
        <table>
            <tr>
                <td>Tên</td>
                <td>Giá</td>
                <td>Số lượng</td>

                <td>Màu sắc</td>
                <td>Mô tả</td>

                <td>Loại sản phẩm</td>
            </tr>
            <tr>
                <%--            <span>STT: <input name="id" type="text" size="15"/></span> <br>--%>
                <td><input name="name" type="text" size="15"/></td>
                <td><input name="price" type="text" size="15"/></td>
                <td><input name="quanlity" type="text" size="15"/></td>

                <td> <input name="color" type="text" size="15"/></td>

                <td> <input name="description" type="text" size="15"/></td>



                <td>
                    <c:forEach items="${categories}" var="c">
                        <input  type="radio" name="category_id" value="${c.id}">
                        <label>${c.name}</label>
                    </c:forEach>
                </td>
            </tr>
        </table>
        <button type="submit">Tạo mới</button>
    </form>

</div>
</body>
</html>
