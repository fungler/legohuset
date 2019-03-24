<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
session.invalidate();
response.sendRedirect("./index.jsp");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><logout</title>
    </head>
    <body>
        Bye!
    </body>
</html>
