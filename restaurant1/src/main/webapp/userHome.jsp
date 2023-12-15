<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2023/12/10
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>师生用户界面</title>
    <link type="text/css" rel="stylesheet" href="css/userHomeStyle.css" />
    <link type="text/css" rel="stylesheet" href="css/listStyle.css">
</head>
<body>
<h1>欢迎来到上海理工大学食堂点评交流社区！</h1>
<div>
    <img src="./images/logo.jpg" alt="none" width="90%">
</div>
<div class="fav_list" style="background-color: rgba(204,204,204,0.23)">
    <div data-v-357a65ed="" class="fav_list_box">
        <div  class="fav_list_title">
            <h3 class="fav_list_title_h3">食堂列表</h3>
        </div>
        <div  class="my_fav_con">
            <div>
                <ul  class="my_fav_list">
                    <c:forEach var="restaurant" items="${applicationScope.RestaurantList}">
                        <li class="my_fav_list_li" id="">
                            <a  class="my_fav_list_a" href="./restaurantSearchServlet?restaurantName=${restaurant.name}" target="_blank">
                                ${restaurant.name}
                            </a>
                        </li>

                    </c:forEach>

                </ul>
            </div>
        </div>
    </div>
</div>
<div class="fav_list" style="background-color: rgba(204,204,204,0.23)">
    <div data-v-357a65ed="" class="fav_list_box">
        <div  class="fav_list_title">
            <h3 class="fav_list_title_h3">菜品综合检索</h3>
        </div>
        <form action="./SearchDishServlet" method="post">
        <div style="float: left;padding: 20px">
            <p style="color: #c5063f">${requestScope.priceError}</p>
            <p>菜系：</p>
            <select name="foodtype">
                <option value="全部">全部</option>
                <c:forEach var="foodtype" items="${applicationScope.foodTypeList}">
                    <option value="${foodtype}">${foodtype}</option>
                </c:forEach>
            </select>
        </div>
        <div style="float: left;padding: 20px">
            <p>价格：</p>
            <input type="number" name="min"> -
            <input type="number" name="max">
        </div>
        <div style="float: left;padding: 20px">
            <p>食堂</p>
            <select name="restaurant">
                <option value="全部">全部</option>
                <c:forEach var="restaurant" items="${applicationScope.RestaurantList}">
                    <option value="${restaurant.name}">${restaurant.name}</option>
                </c:forEach>
            </select>
        </div>
        <div style="float: left;padding: 20px">
            <input class="search-button" type="submit"value="搜索">
        </div>
            <p style="color: red">${requestScope.dishMessage}</p>
        </form>
    </div>
</div>
</body>
</html>
