<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2023/12/13
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>菜品综合查询页面</title>
</head>
<body>
<div class="fav_list" style="background-color: rgba(204,204,204,0.23)">
    <div data-v-357a65ed="" class="fav_list_box">
        <div  class="fav_list_title">
            <h3 class="fav_list_title_h3">查询结果</h3>
            <input type="button" style="padding: 10px 20px;
            font-size: 16px;
            background-color: #C0C0C0;
            color: white;
            border: none;
            border-radius: 20px;
            margin-left: 10px;
            cursor: pointer;
            transition: background-color 0.3s ease;float: right" value="返回" onclick="window.location.href='userHome.jsp'">
        </div>
        <div  class="my_fav_con">
            <div>
                <ul  class="my_fav_list">
                    <p>${requestScope.message}</p>
                    <c:forEach var="dish" items="${sessionScope.dishList}">
                        <li class="my_fav_list_li" id="">
                            <a  class="my_fav_list_a" href="./dishDetailServlet?dishName=${dish.name}" target="_blank">
                                    ${dish.name}
                            </a>
                        </li>

                    </c:forEach>

                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>
