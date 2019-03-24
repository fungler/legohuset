<%-- 
    Document   : customerpage
    Created on : Aug 22, 2017, 2:33:37 PM
    Author     : kasper
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.Order"%>
<%@page import="FunctionLayer.User"%>
<%@page import="FunctionLayer.LogicFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
User user = (User)session.getAttribute("user");
if (user == null) {
    response.sendRedirect("./index.jsp");
}
ArrayList<Order> userOrders = LogicFacade.getUserOrders(user.getId());%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer home page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">  
        <h1>Welcome, <%=user.getEmail()%> </h1>
        <p>Logged in as: <%=session.getAttribute("role")%></p>
        <a href="./logout.jsp">Log out</a>
        <hr>
        <h3>Add a new order:</h3>
        <form action="FrontController" method="POST">
            <input type="hidden" name="command" value="addorder">
            <div class="form-group">
                <input type="text" name="height" placeholder="Height">
            </div>
            
            <div class="form-group">
                <input type="text" name="length" placeholder="Length">
            </div>
            
            <div class="form-group">
                <input type="text" name="width" placeholder="Width">
            </div>
            
            <input type="submit" value="Submit">
        </form>
        
            <br>
            <hr>
            <h2>Previous orders:</h2>    
            <br>
        <table class="table table-hover">
          <tr>
            <th>Order id</th>
            <!--<th>User id</th> -->
            <th>Height</th>
            <th>Length</th>
            <th>Width</th>
            <th>Shipped</th>
            <th>Options</th>
 
          </tr>
          <% for (Order o : userOrders) { %>
            <tr>
                <td><%=o.getOrderID()%></td>
                <!--<td><%=o.getUserID()%></td> -->
                <td><%=o.getH()%></td>
                <td><%=o.getL()%></td>
                <td><%=o.getW()%></td>
                <td><%=o.isShipped()%></td>
                <td>
                    <a href="./FrontController?command=calculatebricks&orderid=<%=o.getOrderID()%>&height=<%= o.getH() %>&width=<%= o.getW() %>&length=<%= o.getL() %>">Details</a>
                </td>
                
              <!--<td><button type="button" class="btn btn-primary" action="Shipped">Mark as shipped</button></td>-->
            </tr>
          <%}%>
        </table>
        </div>
    </body>
</html>
