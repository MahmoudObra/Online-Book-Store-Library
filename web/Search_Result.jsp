<%@page import="java.util.ArrayList"%>
<%@page import="Model.Book"%>
<!DOCTYPE html>
<html>
<head>
       <title> Search Result</title>
        <meta charset="UTF-8" />
        <link rel="stylesheet" type="text/css" href="mystyle.css" />
</head>
<body background="Home.png">
  

<ul>
    <li><a class="normal" href="Logout"> <img src="Logout.png"> </a></li>
    <li><a class="normal" href="Borrowed_Books"><img src="Borrow Button Home.png"></a></li>
    <li><a class="normal" href="Messages.jsp"><img src="Message Button.png"></a></li>
    <li><a class="normal" href="Profile.jsp"><img src="Profile Button.png"></a></li>
  <li><a class="normal" href="Home Page.jsp"><img src="Home Button.png"></a></li>
    <li>    
        <form class="form-wrapper-2 cf" action="Search_Result.jsp">
        <input type="text" placeholder="Search here..." required name="SearchKey">
    <button type="submit">Search</button>
    </form>
    </li>
</ul>

      <div id="Container">
        
        
        <%
           String search = request.getParameter("SearchKey");
           Book book = new Book();
           ArrayList<Book> list = new ArrayList<Book>();
           book.Connect_To_Database();
           list = book.Get_Books_ByName(search);
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
          
              <%
           list = book.Get_Books_ByAuthor(search);
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
    
              <%
           list = book.Get_Books_ByCategory(search);
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
    
           <%
           list = book.Get_Books_ByYear(search);
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
