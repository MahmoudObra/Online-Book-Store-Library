<%@page import="Model.User"%>
<%@page import="Model.Borrowed_Book"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Book"%>
<!DOCTYPE html>
<html>
<head>
       <title>Borrowed Books</title>
        <meta charset="UTF-8" />
        <link rel="stylesheet" type="text/css" href="mystyle.css" />
</head>
<body background="Home.png">

<ul>
    <li><a class="normal" href="Intro.jsp"> <img src="Logout.png"> </a></li>
    <li><a class="normal" href="Borrowed_Books"><img src="Borrow Button Home.png"></a></li>
    <li><a class="normal" href="Messages.jsp"><img src="Message Button.png"></a></li>
    <li><a class="normal" href="Profile.jsp"><img src="Profile Button.png"></a></li>
    <li><a class="normal" href="Home Page.jsp"><img src="Home Button.png"></a></li>

</ul>

     <h1 id="Page_title">Borrowed Books</h1>      
    <div id="Container">
        
        
        <%
        
           ArrayList<Book> list = (ArrayList<Book>)session.getAttribute("borrowedBooks");
         
           
           for(int i=0;i<list.size();i++)
           {
               
        %>
        
          <a href="showbookDetails_forReturn?ISBN=<%=list.get(i).getISBN()%>" >
          <div class="ch-item" >
                   
                 <div class="circleItem">
		 <img class="bookImage" src="<%=list.get(i).getName()%>.png" />               
                 </div>
                     
                <div class="circleItem2">  
                <h2 class="circleTitles"> <%=list.get(i).getName()%> </h2>
		<p class="circleParagraph"> Author: <%=list.get(i).getAuthor()%> </p>
                <p class="circleParagraph"> Category:<%=list.get(i).getCategory()%> </p>
                </div>
                      
               
               </div>
                </a>

          <%}
          
          session.removeAttribute("borrowedBooks");
          %>
    </div>

</body>
</html>
