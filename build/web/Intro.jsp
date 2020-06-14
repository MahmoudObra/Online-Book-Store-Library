

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="mystyle.css"/>
        <title>Intro</title>
    </head>
    <body background="Welcome Screen.png">
        
        <div id="Left">

            <h1 id="Welcome_title">Welcome to Library System</h1>            
            <form action="Sign UP.jsp">
                
                <input id="submitButton" type="submit" value="Sign up" />
            </form>   
        </div>
        
        
        
        <div id="Right">
            <form id="loginForm" action="Login">
                 
                 <p class="loginTitle">Log In</p>
                <p class="loginSubtitle">  User Name: </p> <input class="loginInput"  type="text" name="User_name" />
                <br/>
                <p class="loginSubtitle">  Password: </p> <input class="loginInput"  type="password" name="password" />
                
                <input id="loginButton" type="submit" value="Log In"  />
            </form>
            
        </div>
        
    </body>
</html>
