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
    <style>
        body {
            background-color: #f5f5f5;
        }

        .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-top: 20px; /* 调整容器与页面顶部的距离 */
        }

        .page-title {
            font-size: 24px;
            margin-bottom: 20px;
        }

        #fanhui {
            margin-top: 10px;
        }

        .table th, .table td {
            vertical-align: middle; /* 垂直居中 */
        }

        .table img {
            max-width: 100%;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
    </style>
</head>
<body>
<%
    restaurantAdminService resAdminSer=new restaurantAdminServiceImpl();
    String restaurantName= (String) session.getAttribute("restaurantName");
    List<Evaluate> evaluates=resAdminSer.getAllEvaluate(restaurantName);

%>
<div class="container">
    <div class="row">
        <div class="col-md-8">
            <h1 class="page-title">菜品信息维护</h1>
        </div>
        <div class="col-md-4 text-right">
            <a class="btn btn-primary" id="fanhui" href="restaurantAdminHome.jsp">返回首页</a>
        </div>
    </div>
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
