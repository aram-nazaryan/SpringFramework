<%--
  Created by IntelliJ IDEA.
  User: aram
  Date: 12/26/22
  Time: 5:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <form action="register" method="post">
        <p>Current queue <%session.getAttribute("count");%></p>
        <input type="submit" value="Register">
    </form>
</body>
</html>
