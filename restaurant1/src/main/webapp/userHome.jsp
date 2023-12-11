<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2023/12/10
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>师生用户界面</title>
    <link type="text/css" rel="stylesheet" href="css/userHomeStyle.css" />
    <link type="text/css" rel="stylesheet" href="css/listStyle.css">
</head>
<body>
<h1>欢迎来到上海理工大学食堂点评交流社区！</h1>
<div class="search-form">
    <form id="searchForm" action="${pageContext.request.contextPath}/SearchServlet" method="get">
        <input class="search-input" type="text" name="query" placeholder="搜索食堂名称...">
        <input class="search-button" type="submit"value="搜索">
    </form>
</div>
<div>
    <img src="./images/logo.jpg" alt="none" width="90%">
</div>
<div class="fav_list" style="background-color: rgba(204,204,204,0.23)">
    <div data-v-357a65ed="" class="fav_list_box">
        <div  class="fav_list_title">
            <h3 class="fav_list_title_h3">食堂列表</h3>
        </div>
        <div  class="my_fav_con">
            <div>
                <ul  class="my_fav_list">
                    <li class="my_fav_list_li" id="">
                        <a  class="my_fav_list_a" href="" target="_blank">
                            （电脑故障）2.电脑突然就找不到网络，上不了网 - qq_38959715的博客
                        </a>
                        <label class="my_fav_list_label">
                            <span >2019-04-08</span>
                            <a  class="cancel_fav"><em>取消</em></a>
                        </label>
                    </li>

                </ul> <!---->
            </div>
        </div>
    </div>
</div>

</body>
</html>
