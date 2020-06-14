

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="mystyle.css"/>
        <title>Enter Book Data</title>
    </head>
    <body background="Add Book.png">
        
         <form  style=" background: transparent" action="UpdateBook">
                 
                 <p style="color:black" class="FormTitle">Enter Book Data</p>
                <p class="FormSubtitle">  ISBN: </p> <input style="border-color: white" class="loginInput"  type="text" name="ISBN" />
                <br/>
                <p class="FormSubtitle">  Name: </p> <input style="border-color: white" class="loginInput"  type="text" name="Name" />
                <br/>
                <p class="FormSubtitle">  Category: </p> <input style="border-color: white" class="loginInput"  type="text" name="Category" />
                <br/>
                <p class="FormSubtitle">  Author Name: </p> <input style="border-color: white" class="loginInput"  type="text" name="Author" />
                <br/>
                <p class="FormSubtitle">  Publication Year: </p> <input style="border-color: white" class="loginInput"  type="text" name="PublicationYear" />
                <br/> 
                <p class="FormSubtitle">  Number of Copies: </p> <input style="border-color: white" class="loginInput"  type="text" name="NoCopies" />
                <br/> 
            <p class="FormSubtitle">  Description: </p> <input style="border-color: white" class="DescriptionInput"  type="text" name="Desc" />
                <br/> 

                
                <input style="Margin:60px;" id="submitButton" type="submit" value="Update Book" />
            </form>
        
    </body>
</html>
