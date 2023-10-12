<%--
  Created by IntelliJ IDEA.
  User: purin
  Date: 2023/10/11
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>index</title>
    <c:if test="${empty user}">
        <h1>游客,welcome to this guide^^</h1>
        <form action="login1">
            username:<input type="text" name="username"></input><br/>
            psw:<input type="password" name="psw"></input><br/>
            <button>login</button>
        </form>

    </c:if>

    <c:if test="${!empty user}">
        <h1>${user},welcome to this guide^^<a href="logout1">退出登录</a></h1>
        <h2>优质内容</h2>
        <li>
            <a href="/sy04/goodContent/a.jsp">水豚</a>
        </li>
    </c:if>

    <h2>普通内容</h2>
    <li>
        <a href="https://baike.baidu.com/item/%E5%BE%AE%E5%8D%9A/58302300?fromModule=lemma_search-box">微博百科</a>
        <a href="https://baike.baidu.com/item/%E8%B1%86%E7%93%A3%E7%BD%91/5549800?fromModule=lemma_search-box&fromtitle=%E8%B1%86%E7%93%A3&fromid=7803606">豆瓣百科</a>
    </li>
</head>
<body>

</body>
</html>
