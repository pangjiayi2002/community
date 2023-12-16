<%@ page import="service.restaurantAdmin.restaurantAdminServiceImpl" %>
<%@ page import="service.restaurantAdmin.restaurantAdminService" %>
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
<%
    restaurantAdminService resAdminSer=new restaurantAdminServiceImpl();
    int count=resAdminSer.notRead();
%>
<div id="header">
    <h1>食堂管理员首页</h1>
    <img src="./images/logo.jpg" alt="none" width="90%">
    <div onclick="redirectToEvaluateList()"
         style="position: absolute; top: 20px; right: 30px;"
    >
        <img src="images/xinxiang.jpg" style="position: relative;">
        <span style="position: absolute; color: red;"><%=count%></span>
    </div>
</div>

<div id="buttons">
    <input type="submit" value="食堂信息维护" style="background-color: #3badc1;width:150px;height:100px;font-size: 20px;border: none" onclick="window.location.href='restaurantList.jsp'">
    <input type="submit" value="菜品维护" style="background-color: #bd644e;width:150px;height:100px;font-size: 20px;border: none" onclick="window.location.href='dishList.jsp'">
    <input type="submit" value="食堂评价处理" style="background-color: #99afc4;width:150px;height:100px;font-size: 20px;border: none" onclick="window.location.href='evaluateList.jsp'">
<%--    <input type="submit" value="活动公告" style="background-color: #faca0d;width:150px;height:100px;font-size: 20px;border: none" onclick="window.location.href=''">--%>
<%--    <input type="submit" value="发布投票调查" style="background-color: #faca0d;width:150px;height:100px;font-size: 20px;border: none" onclick="window.location.href=''">--%>
<%--    <input type="submit" value="投诉信息处理" style="background-color: #faca0d;width:150px;height:100px;font-size: 20px;border: none" onclick="window.location.href=''">--%>
<%--    <input type="submit" value="最新推荐菜品" style="background-color: #faca0d;width:150px;height:100px;font-size: 20px;border: none" onclick="window.location.href=''">--%>
</div>

<script>
    function redirectToEvaluateList() {
        window.location.href = "evaluateList.jsp";
    }
</script>

</body>
</html>
