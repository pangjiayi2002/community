<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2023/12/16
  Time: 23:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="./css/dishDetail1.css">
</head>
<body>
<label id="lab1">食堂管理员的回复:</label><br><br><br>
<div class="centerdiv">
    <label class="centerdivlab1">${e.sender}:</label>
    <label class="centerdivlab2">${e.title}</label><br><br>
    <label class="centerdivlab2">${e.content}</label><br>
</div>
</body>
</html>
