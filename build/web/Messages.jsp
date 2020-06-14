<%@page import="Model.User"%>
<%@page import="Model.Message"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Book"%>
<!DOCTYPE html>
<html>
<head>
       <title>Messages</title>
        <meta charset="UTF-8" />
        <link rel="stylesheet" type="text/css" href="mystyle.css" />
</head>
<body background="Home.png">

    <%
           Message message = new Message();
           ArrayList<Message> list = new ArrayList<Message>();
           message.Connect_To_Database();
           User user = new User(  (User) session.getAttribute("userData") );        
           list = message.Get_allMessages( user.getID() );
           message.markSeen(user.getID());
           %>
    
<ul>
    <li><a class="normal" href="Logout"> <img src="Logout.png"> </a></li>
    <li><a class="normal" href="Borrowed_Books"><img src="Borrow Button Home.png"></a></li>
    <li><a class="normal" href="Messages.jsp"><img src="Message Button.png"></a></li>
    <li><a class="normal" href="Profile.jsp"><img src="Profile Button.png"></a></li>
     <%
          if (user.getType().equals("Admin") )
               {    
               %>
               
        <li><a class="normal" href="Home Page For Admin.jsp"><img src="Home Button.png"></a></li>           
               <%}
         else if (user.getType().equals("Student") )
               {    
               %>
               
        <li><a class="normal" href="Home Page.jsp"><img src="Home Button.png"></a></li>           
               <%}
          %>
    
     <li>    
        <form class="form-wrapper-2 cf" action="Search_Result.jsp">
        <input type="text" placeholder="Search here..." required name="SearchKey">
    <button type="submit">Search</button>
    </form>
    </li>
    
</ul>

    
    <div id="MessageContainer">
        
        
        
<%
           for(int i=0;i<list.size();i++)
           {
        %>
      
         <div id="message_viewer" >
                             
                <p id="messageContent">Message <%=i+1%> : <%=list.get(i).getContent() %> </p>
                      
               
               </div>
             
          <%}%>
    </div>
    

</body>
</html>
