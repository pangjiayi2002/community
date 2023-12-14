<%@ page import="service.restaurantAdmin.restaurantAdminServiceImpl" %>
<%@ page import="Pojo.Dish" %>
<%@ page import="service.restaurantAdmin.restaurantAdminService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改菜品信息</title>
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
            Dish dish=resAdminSer.getDishById(id); %>
    <h1>修改食堂信息</h1>
    <form role="form" action="${pageContext.request.contextPath}/DishModifyServlet" method="post" class="form-horizontal">
        <input type="hidden" name="id" value="<%=dish.getId()%>">
        <div class="form-group">
            <label for="name">菜名</label>
            <input type="text" class="form-control" id="name" name="name" value="<%=dish.getName()%>">
        </div>
        <div class="form-group">
            <label for="foodtype">菜系：</label>
            <input type="text" class="form-control" id="foodtype" name="foodtype" value="<%=dish.getFoodtype()%>">
        </div>
        <div class="form-group">
            <label for="price">价格：</label>
            <input type="text" class="form-control" id="price" name="price" value="<%=dish.getPrice()%>">
        </div>
<%--        图片暂时改不了--%>
        <div class="form-group">
            <label for="cover">图片：</label>
            <input type="file" id="cover" name="cover" value="<%=dish.getCover()%>">
        </div>
        <div class="form-group">
            <label for="restaurantName">供应的食堂：</label>
            <input type="text" class="form-control" id="restaurantName" name="restaurantName" value="<%=dish.getRestaurantName()%>">
        </div>
        <button type="submit" id="updateButton" class="btn btn-primary">更新</button>
        <a href="dishList.jsp" class="btn btn-default">取消</a>
    </form>
    <% } %>
</div>
<script>
    // 获取按钮元素
    var updateButton = document.getElementById("updateButton");
    // 添加按钮点击事件监听器
    updateButton.addEventListener("click", function() {
        // 在按钮点击后显示弹窗
        window.alert("修改菜品信息成功");
    });
</script>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
