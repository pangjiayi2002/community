<%@ page import="service.restaurantAdmin.restaurantAdminService" %>
<%@ page import="service.restaurantAdmin.restaurantAdminServiceImpl" %>
<%@ page import="Pojo.RestaurantInfo" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>食堂管理员管理的食堂列表</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%
    restaurantAdminService resAdminSer=new restaurantAdminServiceImpl();
    List<RestaurantInfo> infos = resAdminSer.getAll();
%>
<div class="container">
    <h1>食堂信息维护</h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>食堂名称</th>
            <th>营业时间</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="info" items="<%=infos%>">
            <tr>
                <td>${info.name}</td>
                <td>${info.time}</td>
                <td>
                    <span><a class="view" href="restaurantDetail.jsp?id=${info.id}"><img src="${pageContext.request.contextPath }/images/read.png" alt="查看" title="查看"/></a></span>
                    <span><a class="modify" href="restaurantModify.jsp?id=${info.id}" ><img src="${pageContext.request.contextPath }/images/xiugai.png" alt="修改" title="修改"/></a></span>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
<%--    <a href="noticeAdd.jsp">添加食堂</a>--%>
</div>
</body>
</html>
