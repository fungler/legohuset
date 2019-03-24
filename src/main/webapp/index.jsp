<%-- 
    Document   : index
    Created on : Aug 22, 2017, 2:01:06 PM
    Author     : kasper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
        <h1>Welcome</h1>
                    <form name="login" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="login">
                        <div class="form-group">
                            <input type="text" name="email" placeholder="Email">
                        </div>
                        <div class="form-group">
                            <input type="password" name="password" placeholder="Password">
                        </div>
                        <input type="submit" value="Submit">
                    </form>
        
        <% String error = (String) request.getAttribute( "error");
           if ( error != null) { 
               out.println("<H2>Error!!</h2>");
               out.println(error);
           }
        %>
        <br>
        <br>
        <button class="btn btn-primary" onclick="showRegister()">Or create and account</button>
        <div style="display:none" id="registerDiv">
                    <form name="register" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="register">
                        Email:<br>
                        <input type="text" name="email" placeholder="someone@nowhere.com">
                        <br>
                        Password:<br>
                        <input type="password" name="password1" placeholder="Password">
                        <br>
                        Retype Password:<br>
                        <input type="password" name="password2" placeholder="Password">
                        <br>
                        <input type="submit" value="Submit">
                    </form>
        
        <script>
            function showRegister() {
                var display = document.getElementById("registerDiv");
                if (display.style.display == "none") {
                    display.style.display = "block";
                } else {
                    display.style.display = "none";
                }
            }
        </script>
    </body>
</html>
