/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.*;
import java.util.ArrayList;

public class Message {
    
    private int ID;
    private int User_ID;
    private String Content;
    private String Seen_flag;
    
    private Connection connect ;
    private Statement statement ;
    private ResultSet resultSet;

    public Message() {
        this.ID = -1;
        this.User_ID = -1;
        this.Content = "";
        this.Seen_flag = "false";
    }
    
    public Message( int User_ID, String Content, String Seen_flag) {
      //  this.ID = ID;
        this.User_ID = User_ID;
        this.Content = Content;
        this.Seen_flag = Seen_flag;
    }
    
    public Message(Message m) {
    //    this.ID = m.ID;
        this.User_ID = m.User_ID;
        this.Content = m.Content;
        this.Seen_flag = m.Seen_flag;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(int User_ID) {
        this.User_ID = User_ID;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    public String isSeen_flag() {
        return Seen_flag;
    }

    public void setSeen_flag(String Seen_flag) {
        this.Seen_flag = Seen_flag;
    }
    
    public void Connect_To_Database() throws ClassNotFoundException, SQLException
	{
		   Class.forName("com.mysql.jdbc.Driver");
		      connect = DriverManager.getConnection(
		    		 "jdbc:mysql://localhost/University_Library?"
		             + "user=root&password=");
	}
    
    public void Send_Message() throws SQLException
    {
    	statement = connect.createStatement();
	    String sql = "INSERT INTO messages ( User_ID , Content , Seen_Flag )  values ("+this.User_ID+" ,'"+this.Content+"', '"+this.Seen_flag+"' )";
        statement.executeUpdate(sql);
    }
    
    public ArrayList<Message> Get_allMessages( int UserID ) throws SQLException
    {   
    	 statement = connect.createStatement();
         resultSet = statement.executeQuery("select * from messages where User_ID = "+UserID+"");
         
         ArrayList<Message> messages = new ArrayList<Message>();
         
         while (resultSet.next()) {

         User_ID = resultSet.getInt("User_ID");
         ID = resultSet.getInt("ID");
        Content = resultSet.getString("Content");
        Seen_flag = resultSet.getString("Seen_Flag");
         
        messages.add(new Message(this) );
         }
         return messages;
    }
    
    public void markSeen(int UserID) throws SQLException
    {
    	statement = connect.createStatement();
            String Value="true";
	    String sql = "update messages set Seen_Flag='"+Value+"' where User_ID = "+UserID+" ";
        statement.executeUpdate(sql);
    }

    
}
