

<%@page import="Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="mystyle.css"/>
        <title>My Profile</title>
    </head>
    <body background="Profile.png">
 
               
        <%
        
           User user = new User(  (User) session.getAttribute("userData") );
        %>
 
        <ul>
    <li><a class="normal" href="Logout"> <img src="logout button details.png"> </a></li>
    <li><a class="normal" href="Borrowed_Books"><img src="Borrowed Books details.png"></a></li>
    <li><a class="normal" href="Messages.jsp"><img src="Message Button details.png"></a></li>
   
     <%
          if (user.getType().equals("Admin") )
               {    
               %>
               
        <li><a class="normal" href="Home Page For Admin.jsp"><img src="Home Button for details.png"></a></li>           
               <%}
         else if (user.getType().equals("Student") )
               {    
               %>
               
        <li><a class="normal" href="Home Page.jsp"><img src="Home Button for details.png"></a></li>           
               <%}
          %>
    
</ul>
        
        
        <img id="profilePic" src="Profile Picture.png" />
        <p  class="profileTitle"> <%= user.getName() %> </p>
        <p class="profileParagraph"> E-mail:<%= user.getEmail() %> </p>
        <p class="profileParagraph"> Mobile:<%= user.getMobile() %> </p>
        
         <form  style=" background: transparent" action="Update Profile.jsp">
                
                
                <input style="Margin:60px;" id="loginButton" type="submit" value="Update Profile" />
         </form>
                <br/>
          
        
    </body>
</html>
