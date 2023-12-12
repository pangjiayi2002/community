<%@ page import="service.restaurantAdmin.restaurantAdminService" %>
<%@ page import="service.restaurantAdmin.restaurantAdminServiceImpl" %>
<%@ page import="Pojo.RestaurantInfo" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>食堂信息维护</title>
  <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <style>
    .container {
      padding: 20px;
    }
    .form-group {
      margin-bottom: 15px;
    }
    label {
      margin-bottom: 5px;
    }
    .btn {
      margin-right: 10px;
    }
    img {
      max-width: 100%;
      height: auto;
      margin-bottom: 15px;
    }
  </style>
</head>
<body>
<div class="container">
  <% String id= request.getParameter("id");
    if (id != null && !id.isEmpty()) {
      restaurantAdminService resAdminSer=new restaurantAdminServiceImpl();
      RestaurantInfo info=resAdminSer.getInfoById(id); %>
  <h1>修改食堂信息</h1>
  <form role="form" action="${pageContext.request.contextPath}/RestaurantModifyServlet" method="post" class="form-horizontal">
    <input type="hidden" name="id" value="<%=info.getId()%>">
    <div class="form-group">
      <label for="name">食堂名称</label>
      <input type="text" class="form-control" id="name" name="name" value="<%=info.getName()%>">
    </div>
<%--      图片暂时改不了--%>
    <div class="form-group">
      <label for="cover">图片：</label>
<%--      <input type="file" class="form-control" id="newCover" name="newCover">--%>
      <input type="file" id="cover" name="cover" value="<%=info.getCover()%>">
      <img id="coverImage" src="<%=info.getCover()%>">
    </div>
    <div class="form-group">
      <label for="introduction">简介：</label>
      <textarea class="form-control" id="introduction" name="introduction"><%=info.getIntroduction()%></textarea>
    </div>
    <div class="form-group">
      <label for="location">地点：</label>
      <input type="text" class="form-control" id="location" name="location" value="<%=info.getLocation()%>">
    </div>
    <div class="form-group">
      <label for="time">营业时间：</label>
      <input type="text" class="form-control" id="time" name="time" value="<%=info.getTime()%>">
    </div>
    <button type="submit" class="btn btn-primary">更新</button>
    <a href="restaurantList.jsp" class="btn btn-default">取消</a>
  </form>
  <% } %>
</div>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>

