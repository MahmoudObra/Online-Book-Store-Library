<%@page import="java.util.ArrayList"%>
<%@page import="Model.Book"%>
<!DOCTYPE html>
<html>
<head>
       <title> Home Page</title>
        <meta charset="UTF-8" />
        <link rel="stylesheet" type="text/css" href="mystyle.css" />
</head>
<body background="Home.png">

<ul>
    <li><a class="normal" href="Intro.jsp"> <img src="Logout.png"> </a></li>
    <li><a class="normal" href="Borrowed_Books"><img src="Borrow Button Home.png"></a></li>
    <li><a class="normal" href="Add Book.jsp"><img src="Add Book Button.png"></a></li>
    <li><a class="normal" href="Messages.jsp"><img src="Message Button.png"></a></li>
    <li><a class="normal" href="Profile.jsp"><img src="Profile Button.png"></a></li>
    
     <li>    
        <form class="form-wrapper-2 cf" action="Search_Result.jsp">
        <input type="text" placeholder="Search here..." required name="SearchKey">
    <button type="submit">Search</button>
    </form>
    </li>

    
</ul>

    
    <div id="Container">
        
        
        <%
           Book book = new Book();
           ArrayList<Book> list = new ArrayList<Book>();
           book.Connect_To_Database();
           list = book.Get_AllBooks();
           for(int i=0;i<list.size();i++)
           {
        %>
        <a href="showBookDetails?ISBN=<%=list.get(i).getISBN()%>" >
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
          <%}%>
    </div>

</body>
</html>
