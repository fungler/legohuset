<%-- 
    Document   : calcbricks
    Created on : 24-03-2019, 09:39:59
    Author     : Martin
--%>

<%@page import="FunctionLayer.HouseBuilder"%>
<%@page import="FunctionLayer.House"%>
<%@page import="FunctionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    House h = (House)request.getAttribute("house");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Details</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
        <h1>Order details for order #<%=request.getParameter("orderid")%>:</h1>
        <br>
        <a href="./customerpage.jsp">Go back</a>
        <hr>
        
        <h1>Order size: </h1>
        <table class="table table-hover">
          <tr>
            <th>Height</th>
            <th>Length</th>
            <th>Width</th>
          </tr>
            <tr>
                <td><%=request.getParameter("height")%></td>
                <td><%=request.getParameter("length")%></td>
                <td><%=request.getParameter("width")%></td>
            </tr>
        </table>
        <hr>
        <h1>Order calculation: </h1>
        <table class="table table-hover">
          <tr>
            <th>2x4</th>
            <th>2x2</th>
            <th>1x2</th>
            <th>Height</th>
            <th>total x height</th>
          </tr>
          
          <td><%=h.getLx8() + h.getWx8()%></td>
          <td><%=h.getLx4() + h.getWx4()%></td>
          <td><%=h.getLx1() + h.getWx1()%></td>
          <td><%=h.getHeight()%></td>
          <td><%=(h.getLx8() + h.getWx8() + h.getLx4() + h.getWx4() + h.getLx1() + h.getWx1()) * h.getHeight()%></td>
        </table>
        </div>
    </body>
</html>