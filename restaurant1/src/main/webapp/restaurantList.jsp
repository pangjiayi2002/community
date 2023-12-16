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
    <style>
        body {
            background-color: #f5f5f5; /* 设置页面背景颜色 */
        }
        .container {
            background-color: #fff; /* 设置容器背景颜色 */
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .page-title {
            font-size: 24px;
            margin-bottom: 20px;
        }
        #fanhui {
            margin-top: 10px; /* 调整按钮与标题的垂直间距 */
        }
    </style>
</head>
<body>
<%
    restaurantAdminService resAdminSer=new restaurantAdminServiceImpl();
    List<RestaurantInfo> infos = resAdminSer.getAll();
%>
<div class="container">
    <div class="row">
        <div class="col-md-8">
            <h1 class="page-title">食堂信息维护</h1>
        </div>
        <div class="col-md-4 text-right">
            <a class="btn btn-primary" id="fanhui" href="restaurantAdminHome.jsp">返回首页</a>
        </div>
    </div>
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
</div>
</body>
</html>
