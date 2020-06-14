

<%@page import="Model.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="mystyle.css"/>
        <title>Return Book</title>
    </head>
    <body background="Book Details.png">
     
           <%
          Book book = new Book( (Book)session.getAttribute("bookData") );
          
        %>

        
        <div id="Left" style="width: 30%">
         
            <img class="bookImage2" src="<%=book.getName()%>.png" />
		<p class="circleParagraph"> Author: <%=book.getAuthor()%> </p>
                <p class="circleParagraph"> Category:<%=book.getCategory()%> </p>
                        <p class="circleParagraph"> Copies:<%=book.getNo_Of_Copies()%> </p>
        </div>
        
        
        
        <div id="Right" style="width: 70%">
            
            
            <ul>
    <li><a class="normal" href="Logout"> <img src="logout button details.png"> </a></li>
    <li><a class="normal" href="Borrowed_Books"><img src="Borrowed Books details.png"></a></li>
    <li><a class="normal" href="Messages.jsp"><img src="Message Button details.png"></a></li>
    <li><a class="normal" href="Profile.jsp"><img src="profile Button details.png"></a></li>
    <li><a class="normal" href="Home Page For Admin.jsp"><img src="Home Button for details.png"></a></li>
</ul>
            
              <h2 id="Page_title"> <%=book.getName()%> </h2>
                          <p class="circleParagraph"> <%=book.getDesc() %> </p>

             <form action="Return">   
                <input style="margin: 30% 30% 0px 30%;" id="submitButton" type="submit" value="Return" />
                
            </form>
            
        </div>
        
    </body>
</html>
