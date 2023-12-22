<%@ page import="service.restaurantAdmin.restaurantAdminServiceImpl" %>
<%@ page import="Pojo.Dish" %>
<%@ page import="java.util.List" %>
<%@ page import="service.restaurantAdmin.restaurantAdminService" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
  <title>菜品界面</title>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
    .styled-link {
      color: #4A90E2;
      text-decoration: none;
      font-size: 18px;
      font-weight: bold;
      padding: 10px 20px;
      border: 2px solid #4A90E2;
      border-radius: 5px;
      transition: all 0.3s ease;
    }

    .styled-link:hover {
      background-color: #4A90E2;
      color: white;
      text-decoration: none;
    }

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

    .container-link {
      text-align: center;
      padding: 20px;
    }
  </style>
</head>
<body>
<%
  restaurantAdminService resAdminSer=new restaurantAdminServiceImpl();
  String restaurantName= (String) session.getAttribute("restaurantName");
  List<Dish> dishes = resAdminSer.getAllDish(restaurantName);
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
      <th>菜名</th>
      <th>菜系</th>
      <th>价格 /元</th>
      <th>图片</th>
      <th>供应的食堂</th>
      <th>对菜品操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="dish" items="<%=dishes%>">
      <tr>
        <td>${dish.name}</td>
        <td>${dish.foodtype}</td>
        <td>${dish.price}</td>
        <td><img src="${dish.cover}" style="max-width: 100%; border-radius: 10px; box-shadow: 0 4px 8px rgba(0,0,0,0.1);"></td>
        <td>${dish.restaurantName}</td>
        <td>
          <span><a class="modify" href="dishModify.jsp?id=${dish.id}" ><img src="${pageContext.request.contextPath}/images/xiugai.png" alt="修改" title="修改"/></a></span>
          <span><a class="delete" href="${pageContext.request.contextPath}/DishDeleteServlet?id=${dish.id}" id=${dish.id} name=${dish.name }><img src="${pageContext.request.contextPath }/images/schu.png" alt="删除" title="删除"/></a></span>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
  <div class="container-link">
    <a href="dishAdd.jsp" class="styled-link">添加菜品</a>
  </div>
</div>
</body>
</html>
