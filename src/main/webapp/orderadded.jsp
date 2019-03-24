<%-- 
    Document   : orderadded
    Created on : 21-03-2019, 20:37:19
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
        <title>Order Added</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <h1>Your order has been added to the database.</h1>
        <br>
        <a href="./customerpage.jsp">Go back</a>
    </body>
</html>
