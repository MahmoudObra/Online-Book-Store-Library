

<%@page import="Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" rel="stylesheet" href="mystyle.css"/>
        <title>Update Profile</title>
    </head>
    <body background="Update Profile.png">
        
       
         <form  style=" background: transparent" action="updateUser">
                 
                 <p style="color:black" class="FormTitle">Update profile Info</p>
                <p class="FormSubtitle">  Name: </p> <input style="border-color: white" class="loginInput"  type="text" name="Name" />
                <br/>
                <p class="FormSubtitle">  Password: </p> <input style="border-color: white" class="loginInput"  type="password" name="password" />
                <br/>
                <p class="FormSubtitle">  E-mail: </p> <input style="border-color: white" class="loginInput"  type="text" name="E-mail" />
                <br/>
                <p class="FormSubtitle">  Mobile: </p> <input style="border-color: white" class="loginInput"  type="text" name="Mobile" />
                <br/>
                <p class="FormSubtitle">  Gender: </p> <select style="border-color: white"  name="Gender">
                                                       <option value="Male">Male</option>
                                                       <option value="Female">Female</option>
                                                        </select>
                
                <br/>
                <input style="Margin:60px;" id="submitButton" type="submit" value="Update" />
            </form>
        
    </body>
</html>
