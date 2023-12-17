<%@ page import="service.restaurantAdmin.restaurantAdminServiceImpl" %>
<%@ page import="service.restaurantAdmin.restaurantAdminService" %>
<%@ page import="Pojo.Evaluate" %>
<%@ page import="Pojo.Reply" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>查看评论详情界面</title>
  <!-- 引入Bootstrap样式 -->
  <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <style>
    /* Add custom styles here */
    body {
      background-color: #f8f9fa;
    }
    .container {
      margin-top: 20px;
    }
    .card {
      border: 1px solid #e5e5e5;
    }
    .card-title {
      font-size: 24px;
      margin-bottom: 10px;
    }
    .card-subtitle {
      font-size: 18px;
      margin-bottom: 5px;
    }
    .mb-4 {
      margin-bottom: 20px;
    }
    .btn-primary {
      margin-top: 10px;
    }
    .mt-4 {
      margin-top: 20px;
    }
    .form-group {
      margin-bottom: 20px;
    }
  </style>
</head>
<body>
<%
  String id = request.getParameter("id");
  HttpSession session1=request.getSession();
  session1.setAttribute("id",id);
  if (id != null && !id.isEmpty()) {
    restaurantAdminService resAdminSer = new restaurantAdminServiceImpl();
    Evaluate evaluate = resAdminSer.getEvaluateById(id);
    resAdminSer.modifyIsRead(id);
    List<Reply> replies = resAdminSer.getReply(id);
    String food= evaluate.getFood();
    session1.setAttribute("food",food);
    String sender= evaluate.getSender();
    session1.setAttribute("receiver",sender);
%>
<div class="container">
  <div class="card">
    <div class="card-body">
      <h2 class="card-title"><%= evaluate.getTitle() %></h2>
      <hr>
      <div class="mb-4">
        <h4 class="card-subtitle text-muted">评论内容</h4>
        <p><%= evaluate.getContent() %></p>
      </div>
      <div class="mb-4">
        <h4 class="card-subtitle text-muted">发送方</h4>
        <p><%= evaluate.getSender()%></p>
      </div>
<%--      <div class="mb-4">--%>
<%--        <h4 class="card-subtitle text-muted">发送方的身份：</h4>--%>
<%--        <p><%= evaluate.getSendertype()%></p>--%>
<%--      </div>--%>
      <div class="mb-4">
        <h4 class="card-subtitle text-muted">评论的食堂</h4>
        <p><%= evaluate.getRestaurant() %></p>
      </div>
      <div class="mb-4">
        <h4 class="card-subtitle text-muted">评论的菜品</h4>
        <p><%= evaluate.getFood() %></p>
      </div>
<%--      <div class="mb-4">--%>
<%--        <h4 class="card-subtitle text-muted">评论接收方</h4>--%>
<%--        <p><%= evaluate.getReceiver() %></p>--%>
<%--      </div>--%>
    </div>
  </div>
</div>

<div class="container mt-4">
  <div class="card">
    <div class="card-body">
      <h4 class="card-subtitle text-muted">回复的评论</h4>
      <ul>
        <% for (Reply reply : replies) { %>
        <li><%= reply.getContent() %></li>
        <li class="card-subtitle text-muted">回复者: <%= reply.getSender() %></li>
        <% } %>
      </ul>
    </div>
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
<div class="container mt-4">
  <a href="evaluateList.jsp" class="btn btn-primary">返回评论列表</a>
  <h3 class="mt-4">回复评论</h3>

  <form action="${pageContext.request.contextPath}/ReplyServlet" method="post">
<%--    <input type="hidden" name="evaluateId" value="<%= /* comment.getId() */ 1 %>">--%>
    标题：<input  type="text" name="replyTitle">
    <div class="form-group">
      内容：<textarea name="replyContent" class="form-control"></textarea>
    </div>
    <button type="submit" class="btn btn-success">提交回复</button>
  </form>
</div>

<script src="https://cdn.bootcss.com/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

