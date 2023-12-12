<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2023/12/12
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>管理员界面</title>
    <link rel="stylesheet" href="../css/manageHomePagecss.css">
    <script src="../js/manageHomePagejs.js"></script>
</head>
<body>
<div id="topdiv">
    <label id="topdivlab">管理员后台</label>
    <form action="LogoutServlet" method="post">
        <button id="topdivbutton" type="submit">退出</button>
    </form>

</div>
<div id="centerdiv">
    <button id="centerdivbutton1" onclick="onclickbutton(1)">食堂管理员账号管理</button>
    <button id="centerdivbutton2" onclick="onclickbutton(2)">食堂信息管理</button>
    <button id="centerdivbutton3" onclick="onclickbutton(3)">评价信息管理</button>
</div>
<div id="center1div">
    <label class="centerdivlab">食堂管理员账号列表</label><br>
    <button class="centerdivbutton">添加食堂管理员</button>
    <div id="center1divtop">
        <label id="center1divtoplab1">id</label>
        <label id="center1divtoplab2">username</label>
        <label id="center1divtoplab3">password</label>
        <label id="center1divtoplab4">restaurant</label>
        <label id="center1divtoplab5">操作</label>
    </div>
    <c:set var="i" value="0" />
<c:forEach var="rm" items="${requestScope.rms}" varStatus="status">
    <div class="center1divc">
        <label class="center1divclab1">${rm.id}</label>
        <label class="center1divclab2">${rm.username}</label>
        <label class="center1divclab3">${rm.password}</label>
        <label class="center1divclab4">${rm.restaurant}</label>
        <button class="center1divcbutton1" onclick="">编辑</button>
        <button class="center1divcbutton2" onclick="">删除</button>
    </div>
    <div class="center1_2div">
        <button class="center1_2divbutton1" onclick="">X</button><br>
        <label class="center1_2divlab1">修改食堂管理员信息</label><br><br>
        <label class="center1_2divlab2">食堂管理员id:</label>
        <input type="number" value="${rm.id}" class="center1_2divinput1"><br><br>
        <label class="center1_2divlab3">食堂管理员用户名:</label>
        <input type="text" value="${rm.username}" class="center1_2divinput2"><br><br>
        <label class="center1_2divlab4">食堂管理员密码:</label>
        <input type="text" value="${rm.password}" class="center1_2divinput3"><br><br>
        <label class="center1_2divlab5">食堂管理员所属餐厅:</label>
        <input type="text" value="${rm.restaurant}" class="center1_2divinput4"><br><br><br>
        <button class="center1_2divbutton2" onclick="">确认修改</button>
    </div>
    <div class="center1_3div">
        <button class="center1_3divbutton1">X</button><br>
        <label class="center1_3divlab1">删除食堂管理员信息</label><br><br><br>
        <label class="center1_3divlab2">此操作不可逆，是否确认删除该食堂管理员？</label><br><br><br>
        <button class="center1_3divbutton2">确认删除</button>
    </div>
    <c: @i=@i+1 />
</c:forEach>
</div>
<div id="center2div">
    <label class="centerdivlab">食堂信息列表</label><br>
    <button class="centerdivbutton">添加食堂信息</button><br>
    <div id="center2divtop">
        <label id="center2divtoplab1">id</label>
        <label id="center2divtoplab2">name</label>
        <label id="center2divtoplab3">introduction</label>
        <label id="center2divtoplab4">cover</label>
        <label id="center2divtoplab5">location</label>
        <label id="center2divtoplab6">time</label>
        <label id="center2divtoplab7">操作</label>
    </div>
<c:set var="j" value="0" />
<c:forEach var="r" items="${requestScope.rs}" varStatus="status">
    <div class="center2divc">
        <label class="center2divclab1">${r.id}</label>
        <label class="center2divclab2">${r.name}</label>
        <label class="center2divclab3">${r.introduction}</label>
        <label class="center2divclab4">${r.cover}</label>
        <label class="center2divclab5">${r.location}</label>
        <label class="center2divclab6">${r.time}</label>
        <button class="center2divcbutton1">编辑</button>
        <button class="center2divcbutton2">删除</button>
    </div>
    <div class="center2_2div">
        <button class="center2_2divbutton1">X</button><br>
        <label class="center2_2divlab1">修改食堂信息</label><br><br>
        <label class="center2_2divlab2">食堂id:</label>
        <input type="number" value="${r.id}" class="center2_2divinput1"><br><br>
        <label class="center2_2divlab3">食堂名:</label>
        <input type="text" value="${r.name}" class="center2_2divinput2"><br><br>
        <label class="center2_2divlab4">食堂地点:</label>
        <input type="text" value="${r.location}" class="center2_2divinput3"><br><br>
        <label class="center2_2divlab5">食堂经营时间:</label>
        <input type="text" value="${r.time}" class="center2_2divinput4"><br><br><br>
        <button class="center2_2divbutton2">确认修改</button>
    </div>
    <div class="center2_3div">
        <button class="center2_3divbutton1">X</button><br>
        <label class="center2_3divlab1">删除食堂信息</label><br><br><br>
        <label class="center2_3divlab2">此操作不可逆，是否确认删除该食堂？</label><br><br><br>
        <button class="center2_3divbutton2">确认删除</button>
    </div>
    <c: @j=@j+1 />
</c:forEach>
</div>
<div id="center3div">
    <label class="centerdivlab">评价信息列表</label><br>
    <div id="center3divtop">
        <label id="center3divtoplab1">id</label>
        <label id="center3divtoplab2">title</label>
        <label id="center3divtoplab3">content</label>
        <label id="center3divtoplab4">sender</label>
        <label id="center3divtoplab5">restuarant</label>
        <label id="center3divtoplab6">food</label>
        <label id="center3divtoplab7">receiver</label>
        <label id="center3divtoplab8">操作</label>
    </div>
<c:set var="k" value="0" />
<c:forEach var="e" items="${requestScope.es}" varStatus="status">
    <div class="center3divc">
        <label class="center3divclab1">${e.id}</label>
        <label class="center3divclab2">${e.title}</label>
        <label class="center3divclab3">${e.content}</label>
        <label class="center3divclab4">${e.sender}</label>
        <label class="center3divclab5">${e.restuarant}</label>
        <label class="center3divclab6">${e.food}</label>
        <label class="center3divclab7">${e.receiver}</label>
        <button class="center3divcbutton1">编辑</button>
        <button class="center3divcbutton2">删除</button>
    </div>
    <div class="center3_2div">
        <button class="center3_2divbutton1">X</button><br>
        <label class="center3_2divlab1">修改评价信息</label><br><br>
        <label class="center3_2divlab2">评价id:</label>
        <input type="number" value="${e.id}" class="center3_2divinput1"><br><br>
        <label class="center3_2divlab3">评价标题:</label>
        <input type="text" value="${e.title}" class="center3_2divinput2"><br><br>
        <label class="center3_2divlab4">评价内容:</label>
        <input type="text" value="${e.content}" class="center3_2divinput3"><br><br>
        <label class="center3_2divlab5">发送者:</label>
        <input type="text" value="${e.sender}" class="center3_2divinput4"><br><br>
        <label class="center3_2divlab6">评价食堂:</label>
        <input type="text" value="${e.restuarant}" class="center3_2divinput5"><br><br>
        <label class="center3_2divlab7">评价食物:</label>
        <input type="text" value="${e.food}" class="center3_2divinput6"><br><br>
        <label class="center3_2divlab8">接收者:</label>
        <input type="text" value="${e.receiver}" class="center3_2divinput7"><br><br>
        <button class="center3_2divbutton2">确认修改</button>
    </div>
    <div class="center3_3div">
        <button class="center3_3divbutton1">X</button><br>
        <label class="center3_3divlab1">删除评价信息</label><br><br><br>
        <label class="center3_3divlab2">此操作不可逆，是否确认删除该食堂？</label><br><br><br>
        <button class="center3_3divbutton2">确认删除</button>
    </div>
    <c: @k=@k+1 />
</c:forEach>
</div>
<div id="center1_1div">
    <button id="center1_1divbutton1">X</button><br>
    <label id="center1_1divlab1">添加食堂管理员</label><br><br>
    <label id="center1_1divlab2">食堂管理员id:</label>
    <input type="number" id="center1_1divinput1"><br><br>
    <label id="center1_1divlab3">食堂管理员用户名:</label>
    <input type="text" id="center1_1divinput2"><br><br>
    <label id="center1_1divlab4">食堂管理员密码:</label>
    <input type="text" id="center1_1divinput3"><br><br>
    <label id="center1_1divlab5">食堂管理员所属餐厅:</label>
    <input type="text" id="center1_1divinput4"><br><br><br>
    <button id="center1_1divbutton2">确认添加</button>
</div>
<div id="center2_1div">
    <button id="center2_1divbutton1">X</button><br>
    <label id="center2_1divlab1">添加食堂信息</label><br><br>
    <label id="center2_1divlab2">食堂id:</label>
    <input type="number" id="center2_1divinput1"><br><br>
    <label id="center2_1divlab3">食堂名:</label>
    <input type="text" id="center2_1divinput2"><br><br>
    <label id="center2_1divlab4">食堂地点:</label>
    <input type="text" id="center2_1divinput3"><br><br>
    <label id="center2_1divlab5">食堂经营时间:</label>
    <input type="text" id="center2_1divinput4"><br><br><br>
    <button id="center2_1divbutton2">确认添加</button>
</div>
</body>
</html>
