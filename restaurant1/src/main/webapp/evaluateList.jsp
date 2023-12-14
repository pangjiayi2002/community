<%@ page import="service.restaurantAdmin.restaurantAdminService" %>
<%@ page import="service.restaurantAdmin.restaurantAdminServiceImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="Pojo.Evaluate" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>评论列表</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%
    restaurantAdminService resAdminSer=new restaurantAdminServiceImpl();
    List<Evaluate> evaluates=resAdminSer.getAllEvaluate();
%>
<div class="container">
    <h1>食堂评价处理</h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>评论标题</th>
            <th>发送方</th>
            <th>所评论的食堂</th>
            <th>所评论的菜品</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="evaluate" items="<%=evaluates%>">
            <tr>
                <td>${evaluate.title}</td>
                <td>${evaluate.sender}</td>
                <td>${evaluate.restaurant}</td>
                <td>${evaluate.food}</td>
                <td>
                    <span><a class="view" href="evaluateDetail.jsp?id=${evaluate.id}">查看详情</a></span>
<%--                    <span><a class="modify" href="restaurantModify.jsp?id=${evaluate.id}" ><img src="${pageContext.request.contextPath }/images/xiugai.png" alt="修改" title="修改"/></a></span>--%>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
