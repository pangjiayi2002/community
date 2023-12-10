<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2023/12/9
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <style>
        body{
            justify-content: center;
            align-items: center;
        }
        #header{
            justify-content: center;
            text-align: center;
        }
        #buttons{
            justify-content: center;
            text-align: center;
        }
        input[type="submit"]{
            margin: 20px;
        }
    </style>
</head>
<body>
<div id="header">
    <h1>欢迎来到上海理工大学食堂点评交流社区！</h1>
    <img src="./images/logo.jpg" alt="none" width="90%">
</div>
<div id="buttons">
    <input type="submit" value="系统管理员端" style="background-color: #3a8dc1;width:150px;height:100px;font-size: 20px;border: none" onclick="window.location.href='adminLogin.jsp'">
    <input type="submit" value="食堂管理员端" style="background-color: #8bc93a;width:150px;height:100px;font-size: 20px;border: none" onclick="window.location.href='adminLogin.jsp'">
    <input type="submit" value="师生端" style="background-color: #faca0d;width:150px;height:100px;font-size: 20px;border: none" onclick="window.location.href='userLogin.jsp'">
</div>
</body>
</html>
