/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.*;
import java.util.ArrayList;


public class Favourite_Book {
    
     private int User_ID;
     private int Book_ISBN;
     
     private Connection connect ;
    private Statement statement ;
    private ResultSet resultSet;

    public Favourite_Book() {
        User_ID = -1;
        Book_ISBN = -1;
    }
     
     public Favourite_Book(int User_ID, int Book_ISBN) {
        this.User_ID = User_ID;
        this.Book_ISBN = Book_ISBN;
    }
     
     public Favourite_Book(Favourite_Book b) {
        this.User_ID = b.User_ID;
        this.Book_ISBN = b.Book_ISBN;
        
    } 

    public int getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(int User_ID) {
        this.User_ID = User_ID;
    }

    public int getBook_ISBN() {
        return Book_ISBN;
    }

    public void setBook_ISBN(int Book_ISBN) {
        this.Book_ISBN = Book_ISBN;
    }
     
     public void Connect_To_Database() throws ClassNotFoundException, SQLException
	{
		   Class.forName("com.mysql.jdbc.Driver");
		      connect = DriverManager.getConnection(
		    		 "jdbc:mysql://localhost/University_Library?"
		             + "user=root&password=");
	}
     
     public void Add_New_Book_toFavouriteList() throws SQLException
    {
    	statement = connect.createStatement();
	    String sql = "INSERT INTO favourite_books (User_ID , Book_ISBN )  values ("+this.User_ID+","+this.Book_ISBN+" )";
        statement.executeUpdate(sql);
    }
    
    public ArrayList<Favourite_Book> Get_FavouriteList_forUser( int UserID ) throws SQLException
    {   
    	 statement = connect.createStatement();
         resultSet = statement.executeQuery("select * from favourite_books where User_ID = "+UserID+"");
         
         ArrayList<Favourite_Book> favourite_list = new ArrayList<Favourite_Book>();
         
         while (resultSet.next()) {

         User_ID = resultSet.getInt("User_ID");
        Book_ISBN = resultSet.getInt("Book_ISBN");
         
        favourite_list.add(new Favourite_Book(this) );
         }
         return favourite_list;
    }
     
}
