<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>食堂管理员首页</title>
    <link rel="stylesheet" type="text/css" href="style.css">
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
    <h1>食堂管理员首页</h1>
    <img src="./images/logo.jpg" alt="none" width="90%">
</div>
<div id="buttons">
    <input type="submit" value="食堂信息维护" style="background-color: #3a8dc1;width:150px;height:100px;font-size: 20px;border: none" onclick="window.location.href='restaurantList.jsp'">
    <input type="submit" value="菜品维护" style="background-color: #8bc93a;width:150px;height:100px;font-size: 20px;border: none" onclick="window.location.href='dishList.jsp'">
    <input type="submit" value="食堂评价处理" style="background-color: #faca0d;width:150px;height:100px;font-size: 20px;border: none" onclick="window.location.href=''">
<%--    <input type="submit" value="活动公告" style="background-color: #faca0d;width:150px;height:100px;font-size: 20px;border: none" onclick="window.location.href=''">--%>
<%--    <input type="submit" value="发布投票调查" style="background-color: #faca0d;width:150px;height:100px;font-size: 20px;border: none" onclick="window.location.href=''">--%>
<%--    <input type="submit" value="投诉信息处理" style="background-color: #faca0d;width:150px;height:100px;font-size: 20px;border: none" onclick="window.location.href=''">--%>
<%--    <input type="submit" value="最新推荐菜品" style="background-color: #faca0d;width:150px;height:100px;font-size: 20px;border: none" onclick="window.location.href=''">--%>
</div>
</body>
</html>
