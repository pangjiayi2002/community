<%@ page import="service.restaurantAdmin.restaurantAdminServiceImpl" %>
<%@ page import="service.restaurantAdmin.restaurantAdminService" %>
<%@ page import="Pojo.RestaurantInfo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>食堂详细信息界面</title>
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
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%
    String id = request.getParameter("id");
    if (id != null && !id.isEmpty()) {
        restaurantAdminService resAdminSer=new restaurantAdminServiceImpl();
        RestaurantInfo info=resAdminSer.getInfoById(id);
%>
<div class="container" style="display: flex; flex-direction: column; align-items: center; text-align: center; padding: 20px;">
    <h2 style="color: #4A90E2;"><%= info.getName() %></h2>
    <img src="<%= info.getCover() %>" style="max-width: 100%; border-radius: 10px; box-shadow: 0 4px 8px rgba(0,0,0,0.1);">
    <div style="margin-top: 20px;">
        <h3 style="color: #333;">简介</h3>
        <p style="color: #666;"><%= info.getIntroduction() %></p>
    </div>
    <div style="margin-top: 10px;">
        <h3 style="color: #333;">地点</h3>
        <p style="color: #666;"><%= info.getLocation() %></p>
    </div>
    <div style="margin-top: 10px;">
        <h3 style="color: #333;">营业时间</h3>
        <p style="color: #666;"><%= info.getTime() %></p>
    </div>
</div>

<%
} else {
%>
<div class="container">
    <p>Invalid</p>
</div>
<%
    }
%>
<div class="container" style="text-align: center; padding: 20px;">
    <a href="restaurantList.jsp" class="styled-link">返回食堂列表</a>
</div>
</body>
</html>