<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2023/12/11
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>食堂信息详情</title>
    <link type="text/css" rel="stylesheet" href="css/userHomeStyle.css" />
</head>
<body>
<b>欢迎来到${sessionScope.restaurantInfo.name}!</b>
<input type="button" style="padding: 10px 20px;
    font-size: 16px;
    background-color: #C0C0C0;
    color: white;
    border: none;
    border-radius: 20px;
    margin-left: 10px;
    cursor: pointer;
    transition: background-color 0.3s ease;float: right" value="返回" onclick="window.location.href='userHome.jsp'">
<br>
<!--搜索该食堂内的菜-->
<div class="search-form">
    <form id="searchForm" action="${pageContext.request.contextPath}/SearchDishInResServlet" method="post">
        <input class="search-input" type="text" name="queryDish" placeholder="搜索菜品名称...">
        <input class="search-button" type="submit" value="搜索"><!--模糊搜索菜名-->
    </form>
</div>
<div id="image" style="float:left;">
    <img src="${sessionScope.restaurantInfo.cover}" alt="none" width="50%" height="50%">
</div>
<div id="info" style="float: left">
    <p>食堂名称：${sessionScope.restaurantInfo.name}</p>
    <p>食堂简介：${sessionScope.restaurantInfo.introduction}</p>
    <p>食堂地点：${sessionScope.restaurantInfo.location}</p>
    <p>营业时间：${sessionScope.restaurantInfo.time}</p>
</div>

</body>
</html>
