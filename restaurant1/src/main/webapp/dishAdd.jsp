<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加菜品</title>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
    <h2>添加菜品</h2>
    <form role="form" action="${pageContext.request.contextPath}/DishAddServlet" method="post">
        <div class="form-group">
            <label for="name">菜名</label>
            <input type="text" class="form-control" id="name" name="name">
        </div>
        <div class="form-group">
            <label for="foodtype">菜系</label>
            <input class="form-control" id="foodtype" name="foodtype">
        </div>
        <div class="form-group">
            <label for="price">价格</label>
            <input class="form-control" id="price" name="price">
        </div>
        <div class="form-group">
            <label for="cover">图片</label>
            <input type="file" class="form-control" name="cover" id="cover">
        </div>
        <div class="form-group">
            <label for="restaurantName">供应的食堂</label>
            <input class="form-control" id="restaurantName" name="restaurantName">
        </div>
        <button type="submit" id="addButton" class="btn btn-primary">提交</button>
        <a href="dishList.jsp" class="btn btn-default">取消</a>
    </form>
</div>
<script>
    // 获取按钮元素
    var updateButton = document.getElementById("addButton");

    // 添加按钮点击事件监听器
    updateButton.addEventListener("click", function() {
        // 在按钮点击后显示弹窗
        window.alert("菜品添加成功");
    });
</script>
</body>
</html>
