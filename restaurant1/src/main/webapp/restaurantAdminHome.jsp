<%@ page import="service.restaurantAdmin.restaurantAdminServiceImpl" %>
<%@ page import="service.restaurantAdmin.restaurantAdminService" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>食堂管理员首页</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <style>
        body {
            font-family: 'Arial', sans-serif; /* 使用现代字体 */
            background-color: #f4f4f4; /* 轻松的背景色 */
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            padding: 20px;
        }
        #header {
            text-align: center;
            margin-bottom: 20px;
        }
        #buttons {
            display: flex;
            justify-content: center;
            flex-wrap: wrap;
        }
        input[type="submit"] {
            margin: 10px;
            padding: 20px 40px;
            font-size: 18px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        input[type="submit"]:hover {
            opacity: 0.9; /* hover效果 */
        }
        .button-restaurant {
            background-color: #3badc1;
        }
        .button-dish {
            background-color: #bd644e;
        }
        .button-evaluate {
            background-color: #99afc4;
        }
    </style>
</head>
<body>
<%
    restaurantAdminService resAdminSer=new restaurantAdminServiceImpl();
    String restaurantName= (String) session.getAttribute("restaurantName");
    int count=resAdminSer.notRead(restaurantName);
%>
<div id="header">
    <h1>食堂管理员首页</h1>
    <img src="./images/logo.jpg" alt="none" width="90%">
    <div onclick="redirectToEvaluateList()" style="position: absolute; top: 20px; right: 30px;">
        <img src="images/xinxiang.jpg" style="position: relative;">
        <span style="position: absolute; color: red;"><%=count%></span>
    </div>
</div>

<div id="buttons">
    <input type="submit" value="食堂信息维护" class="button-restaurant" onclick="window.location.href='restaurantList.jsp'">
    <input type="submit" value="菜品维护" class="button-dish" onclick="window.location.href='dishList.jsp'">
    <input type="submit" value="食堂评价处理" class="button-evaluate" onclick="window.location.href='evaluateList.jsp'">
    <!-- 其他按钮 -->
</div>

<script>
    function redirectToEvaluateList() {
        window.location.href = "evaluateList.jsp";
    }
</script>

</body>
</html>