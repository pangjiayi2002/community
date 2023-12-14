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
<%--  <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>--%>
  <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
    .styled-link {
      color: #4A90E2; /* 链接颜色 */
      text-decoration: none; /* 移除下划线 */
      font-size: 18px; /* 字体大小 */
      font-weight: bold; /* 字体加粗 */
      padding: 10px 20px; /* 内边距 */
      border: 2px solid #4A90E2; /* 边框 */
      border-radius: 5px; /* 边框圆角 */
      transition: all 0.3s ease; /* 过渡效果 */
    }

    .styled-link:hover {
      background-color: #4A90E2; /* 悬停时的背景颜色 */
      color: white; /* 悬停时的文字颜色 */
      text-decoration: none; /* 确保悬停时没有下划线 */
    }

  </style>
</head>
<body>
<%
  restaurantAdminService resAdminSer=new restaurantAdminServiceImpl();
  List<Dish> dishes = resAdminSer.getAllDish();
%>
<div class="container">
  <h1>菜品信息维护</h1>
  <table class="table table-striped">
    <thead>
    <tr>
      <th>菜名</th>
      <th>菜系</th>
      <th>价格</th>
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
  <div class="container" style="text-align: center; padding: 20px;">
    <a href="dishAdd.jsp" class="styled-link">添加菜品</a>
  </div>
</div>
</body>
</html>
