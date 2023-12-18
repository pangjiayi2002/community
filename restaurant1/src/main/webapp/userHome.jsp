<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>师生用户界面</title>
    <link type="text/css" rel="stylesheet" href="css/userHomeStyle.css" />
    <link type="text/css" rel="stylesheet" href="css/listStyle.css">
    <style>
        #submit-button {
            background: url('images/xinxiang.jpg') no-repeat;
            background-size: cover;
            width: 100px;
            height: 100px;
            border: none;
            cursor: pointer;
        }
        .container {
            position: relative;
            display: inline-block; /* 确保容器尺寸适应内容 */
        }

        .unread-count {
            position: absolute;
            color: red;
            /* 调整距离图片右边的位置 */
            right: 0;
            top: 0; /* 调整距离图片顶部的位置 */
            /* 可以根据需要设置其他样式 */
        }

    </style>
</head>
<body>

<h1 style="float: left">欢迎来到上海理工大学食堂点评交流社区！</h1>
<div id="message" style="float: right" class="container">
    <a href="./unreadMessageServlet?userName=${sessionScope.userName}">
        <img src="images/xinxiang.jpg" alt="none"  height="10%">
    </a>
    <span class="unread-count" ><strong>${sessionScope.unreadCount}</strong></span>
</div>
<div >
    <img src="images/logo.jpg" alt="none" width="90%">

</div>

<div class="fav_list" style="background-color: rgba(204,204,204,0.23)">
    <div data-v-357a65ed="" class="fav_list_box">
        <div  class="fav_list_title">
            <h3 class="fav_list_title_h3">食堂列表</h3>
        </div>
        <div  class="my_fav_con">
            <div>
                <ul  class="my_fav_list">
                    <c:forEach var="restaurant" items="${sessionScope.RestaurantList}">
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
                <c:forEach var="foodtype" items="${sessionScope.foodTypeList}">
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
                <c:forEach var="restaurant" items="${sessionScope.RestaurantList}">
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
