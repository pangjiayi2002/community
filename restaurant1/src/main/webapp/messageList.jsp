<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2023/12/17
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信箱</title>
    <link type="text/css" rel="stylesheet" href="css/listStyle.css">
</head>
<body>
<div class="fav_list" style="background-color: rgba(204,204,204,0.23)">
    <div data-v-357a65ed="" class="fav_list_box">
        <div  class="fav_list_title">
            <h3 class="fav_list_title_h3">未读消息</h3>
        </div>
        <div  class="my_fav_con">
            <div>
                <ul  class="my_fav_list">
                    <p>${sessionScope.listMessage1}</p>
                    <c:if test="${sessionScope.unreadMessageList.size()!=0}" var="result" scope="session">
                        <c:forEach var="message" items="${sessionScope.unreadMessageList}">
                            <li class="my_fav_list_li" id="">
                                <a  class="my_fav_list_a" href="./messageServlet?messageId=${message.id}" target="_blank">
                                    来自${message.getSender()}的回复
                                </a>
                            </li>

                        </c:forEach>
                    </c:if>

                </ul>
            </div>
        </div>
    </div>
</div>

<div class="fav_list" style="background-color: rgba(204,204,204,0.23)">
    <div data-v-357a65ed="" class="fav_list_box">
        <div  class="fav_list_title">
            <h3 class="fav_list_title_h3">已读消息</h3>
        </div>
        <div  class="my_fav_con">
            <div>
                <ul  class="my_fav_list">
                    <p>${sessionScope.listMessage2}</p>
                    <c:forEach var="message" items="${sessionScope.readMessageList}">
                        <li class="my_fav_list_li" id="">
                            <a  class="my_fav_list_a" href="./messageServlet?messageId=${message.id}" target="_blank">
                                来自${message.sender}的回复
                            </a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</div>
</body>
</html>
