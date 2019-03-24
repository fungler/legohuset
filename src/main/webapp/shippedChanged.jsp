<%-- 
    Document   : shippedChanged
    Created on : 20-03-2019, 19:15:23
    Author     : Martin
--%>

<%@page import="FunctionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%User user = (User)session.getAttribute("user");
if (user == null) {
    response.sendRedirect("./index.jsp");
}%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shipping</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <h1>Shipping status was successfully changed for order #<%=request.getParameter("order")%></h1>
        <br>
        <a href="./employeepage.jsp">Go back</a>
    </body>
</html>
