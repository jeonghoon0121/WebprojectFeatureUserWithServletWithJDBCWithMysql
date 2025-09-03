<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>UserTest1</h1>
<!--
user
Web-> java
Create -> redirect
READ -> forward 방식
Update -> redirect
DELETE -> redirect
-->
<ul>
<li><a href="create">Create</a></li>
<%--<li><a href="read">Read</a></li>--%>
<li><a href="update">Update</a></li>
<li><a href="delete">Delete</a></li>
</ul>
<form action ="read" method="post">
    <input type="text" name="userId">
    <input type="password" name="password">
    <button type="submit">로그인</button>
</form>

</body>
</html>