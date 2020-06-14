/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class User {
    
    private int ID;
    private String Name;
    private String Password;
    private String Type;
    private String Email;
    private String Gender;
    private LocalDate Date_Of_Birth;
    private String Mobile;
    
    private Connection connect ;
    private Statement statement ;
    private ResultSet resultSet;


    
     public User() {
        ID = -1;
        Name = "";
        Password = "";
        Type = "";
        Email = "";
        Date_Of_Birth = null;
        Gender = "";
        Mobile="";
    }
     public User(String Name, String Password, String Type, String Email, LocalDate Date_Of_Birth , String Gender , String Mobile) {
       // this.ID = ID;
        this.Name = Name;
        this.Password = Password;
        this.Type = Type;
        this.Email = Email;
        this.Date_Of_Birth = Date_Of_Birth;
        this.Gender = Gender;
        this.Mobile = Mobile;
    }
    
       public User(User u) {
        this.ID = u.ID;
        this.Name = u.Name;
        this.Password = u.Password;
        this.Type = u.Type;
        this.Email = u.Email;
        this.Date_Of_Birth = u.Date_Of_Birth;
        this.Gender = u.Gender;
        this.Mobile = u.Mobile;
    }
     
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
     
    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
public String getMobile() {
        return Mobile;
    }

    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    
    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public LocalDate getDate_Of_Birth() {
        return Date_Of_Birth;
    }

    public void setDate_Of_Birth(LocalDate Date_Of_Birth) {
        this.Date_Of_Birth = Date_Of_Birth;
    }
    
    
    public void Connect_To_Database() throws ClassNotFoundException, SQLException
	{
		   Class.forName("com.mysql.jdbc.Driver");
		      connect = DriverManager.getConnection(
		    		 "jdbc:mysql://localhost/University_Library?"
		             + "user=root&password=");
	}

    public void Add_New_User() throws SQLException
    {
    	statement = connect.createStatement();
	    String sql = "INSERT INTO users (Name , Password , Email , Type, Date_Of_Birth , Gender , Mobile)  values "
                    + "('"+this.Name+"','"+this.Password+"', '"+this.Email+"','"+this.Type+"' , '"+this.Date_Of_Birth+"' , '"+Gender+"' , '"+Mobile+"')";
        statement.executeUpdate(sql);
    }
    
    public User Get_User( String UserName ) throws SQLException
    {   
    	 statement = connect.createStatement();
         resultSet = statement.executeQuery("select * from Users where Name = '"+UserName+"'");
         
         while (resultSet.next()) {

         ID = resultSet.getInt("ID");
        Name = resultSet.getString("Name");
        Password = resultSet.getString("Password");;
        Type = resultSet.getString("Type");;
        Email = resultSet.getString("Email");;
        Date_Of_Birth =resultSet.getDate("Date_Of_Birth").toLocalDate();
        Gender = resultSet.getString("Gender");
        Mobile = resultSet.getString("Mobile");
         }
         return this;
    }
    
    public void Update_user(String name) throws SQLException
    {
         statement = connect.createStatement();
          String sql = "UPDATE Users " +
	                   "SET Name = '"+Name+"',Password='"+Password+"',Email='"+Email+"',Gender='"+Gender+"',Mobile='"+Mobile+"' WHERE Name = '"+name+"' ";
 
        statement.executeUpdate(sql);
    }

    
    
  /*
    public static void main(String arg[]){
       
       LocalDate d = LocalDate.now();
       LocalDate d2 = LocalDate.of(1995,11,13);
       System.out.println(d);
       if( d.compareTo(d2) > 0 )
       {
         System.out.println("late to return book");  
       }
       User u = new User();
       
       u.setDate_Of_Birth(d2);
       u.setName("Wagdy");
       u.setEmail("wa");
       u.setGender("Male");
       u.setMobile("12345");
       u.setPassword("528");
       u.setType("Admin");              
       try {
            u.Connect_To_Database();
            u.Add_New_User();
           //u.Get_User(4);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
       System.out.println(u.getName() + " " +u.getDate_Of_Birth());
     
    
    /*  Message m = new Message();
        try {
          try {
              m.Connect_To_Database();
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
          }
            m.markSeen(4);
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }*/
}
