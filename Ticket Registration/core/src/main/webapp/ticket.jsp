<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ticket</title>
</head>
<body>
<form method="post" action="consume">
  <p> Your ticket: <input name="ticketId" type="text" value="<%session.getAttribute("ticketId");%>" readonly></p><br>
    <p><% session.getAttribute("count"); %> are waiting in a queue.</p>
    <input type="submit" value="Consume">
</form>
</body>
</html>
