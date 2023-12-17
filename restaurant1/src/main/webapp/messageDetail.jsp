<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2023/12/17
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>回复信息详情</title>
</head>
<body>
<p>回复者 :${applicationScope.evaluate.sender}</p>
<p>食堂   :${applicationScope.evaluate.restaurant}</p>
<p>菜品   :${applicationScope.evaluate.food}</p>
<p>回复标题:${applicationScope.evaluate.title}</p>
<p>回复内容:${applicationScope.evaluate.content}</p>
</body>
</html>
