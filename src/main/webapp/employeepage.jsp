<%-- 
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
    Author     : kasper
--%>

<%@page import="FunctionLayer.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.Order"%>
<%@page import="FunctionLayer.LogicFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%ArrayList<Order> allOrders = LogicFacade.getAllOrders();
User user = (User)session.getAttribute("user");
if (user == null) {
    response.sendRedirect("./index.jsp");
}%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee home page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
    <div class="container">  
        <h1>Hello <%=user.getEmail()%> </h1>
        <br>
        <p>Logged in as: <%=session.getAttribute("role")%>
        <br>
        <br>
        <table class="table table-hover">
          <tr>
            <th>Order id</th>
            <th>User id</th> 
            <th>Height</th>
            <th>Length</th>
            <th>Width</th>
            <th>Shipped</th>
            <th>Options</th>
 
          </tr>
          <% for (Order o : allOrders) { %>
            <tr>
                <td><%=o.getOrderID()%></td>
                <td><%=o.getUserID()%></td> 
                <td><%=o.getH()%></td>
                <td><%=o.getL()%></td>
                <td><%=o.getW()%></td>
                <td><%=o.isShipped()%></td>
                <td style="text-align: center;">
                    <!--<form action="FrontController" method="POST">
                    <input type="hidden" name="command" value="shipped">
                    <input type="hidden" name="order" value="<%=o.getOrderID()%>">
                    <input type="submit" class="btn btn-primary" name="shipstatus" value="Change shipped status" style="width:100%" />
                    </form>-->
                    <a href="./FrontController?command=shipped&order=<%= o.getOrderID() %>">Change Shipped Status</a>
                    <a href="./FrontController?command=deleteorder&order=<%= o.getOrderID() %>">Delete order</a>
                </td>
                
              <!--<td><button type="button" class="btn btn-primary" action="Shipped">Mark as shipped</button></td>-->
            </tr>
          <%}%>
        </table>
    </div>
    </body>
</html>
