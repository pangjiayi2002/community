<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2023/12/14
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>菜品详情</title>
    <style>
        #detail::after {
            content: "";
            display: table;
            clear: both; /* 清除浮动 */
        }
    </style>
</head>
<body>
<h1>菜品详情</h1>
<div id="detail">
    <div id="image" style="float:left;">
        <img src="${sessionScope.dish.cover}" alt="none" width="80%" height="50%">
    </div>
    <div id="info" style="float: left">
        <p>菜名   ：${sessionScope.dish.name}</p>
        <p>菜系   ：${sessionScope.dish.foodtype}</p>
        <p>价格   ：${sessionScope.dish.price}</p>
        <p>食堂名称：${sessionScope.dish.restaurantName}</p>
    </div>
</div>
<div id="comment" style="">
    <h2>评价：</h2>
</div>
</body>
</html>
