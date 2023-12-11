<%@ page import="service.restaurantAdmin.restaurantAdminService" %>
<%@ page import="service.restaurantAdmin.restaurantAdminServiceImpl" %>
<%@ page import="Pojo.RestaurantInfo" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>食堂管理员管理的食堂列表</title>
</head>
<body>
<%
    restaurantAdminService resAdminSer=new restaurantAdminServiceImpl();
    List<RestaurantInfo> infos = resAdminSer.getAll();
%>
<div class="container">
    <h1>通知公告</h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>标题</th>
            <th>创建时间</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="info" items="<%=infos%>">
            <tr>
                <td>${notice.title}</td>
                <td>
                    <a href="noticeDetail.jsp?noticeTime=${notice.createTime}">
                            ${notice.createTime}
                    </a>
                </td>
                <td>
                    <span><a class="viewNotice" href="noticeDetail.jsp?noticeTime=${notice.createTime}"><img src="${pageContext.request.contextPath }/images/read.png" alt="查看" title="查看"/></a></span>
                    <span><a class="modifyNotice" href="noticeModify.jsp?noticeTime=${notice.createTime}" ><img src="${pageContext.request.contextPath }/images/xiugai.png" alt="修改" title="修改"/></a></span>
                    <span><a class="deleteNotice" href="javascript:void(0);" createTime=${notice.createTime } title=${notice.title }><img src="${pageContext.request.contextPath }/images/schu.png" alt="删除" title="删除"/></a></span>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="noticeAdd.jsp">添加公告</a>
</div>
</body>
</html>
