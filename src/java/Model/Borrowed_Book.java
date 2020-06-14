/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Borrowed_Book {
    
    
    private int User_ID;
    private int Book_ISBN;
    private LocalDate Borrow_Date;
    private LocalDate Return_Due_Date;
    private String Notification_flag;
    
    private Connection connect ;
    private Statement statement ;
    private ResultSet resultSet;

    
    public Borrowed_Book() {
        User_ID = -1;
        Book_ISBN = -1;
        Borrow_Date = null;
        Return_Due_Date = null;
        Notification_flag = "false";
    }
    
    public Borrowed_Book(int User_ID, int Book_ISBN, LocalDate Borrow_Date, LocalDate Return_Due_Date, String Notification_flag) {
        this.User_ID = User_ID;
        this.Book_ISBN = Book_ISBN;
        this.Borrow_Date = Borrow_Date;
        this.Return_Due_Date = Return_Due_Date;
        this.Notification_flag = Notification_flag;
    }
    
    public Borrowed_Book(Borrowed_Book b) {
        this.User_ID = b.User_ID;
        this.Book_ISBN = b.Book_ISBN;
        this.Borrow_Date = b.Borrow_Date;
        this.Return_Due_Date = b.Return_Due_Date;
        this.Notification_flag = b.Notification_flag;
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

    public LocalDate getBorrow_Date() {
        return Borrow_Date;
    }

    public void setBorrow_Date(LocalDate Borrow_Date) {
        this.Borrow_Date = Borrow_Date;
    }

    public LocalDate getReturn_Due_Date() {
        return Return_Due_Date;
    }

    public void setReturn_Due_Date(LocalDate Return_Due_Date) {
        this.Return_Due_Date = Return_Due_Date;
    }

    public String isNotification_flag() {
        return Notification_flag;
    }

    public void setNotification_flag(String Notification_flag) {
        this.Notification_flag = Notification_flag;
    }
    
    public void Connect_To_Database() throws ClassNotFoundException, SQLException
	{
		   Class.forName("com.mysql.jdbc.Driver");
		      connect = DriverManager.getConnection(
		    		 "jdbc:mysql://localhost/University_Library?"
		             + "user=root&password=");
	}
    
    public void Add_New_Book_toBorrowList() throws SQLException
    {
    	statement = connect.createStatement();
	    String sql = "INSERT INTO borrowed_books (User_ID , Book_ISBN , Borrow_Date , Return_Due_Date , Notification_flag )  values ("+this.User_ID+","+this.Book_ISBN+" ,'"+this.Borrow_Date+"', '"+this.Return_Due_Date+"','"+this.Notification_flag+"' )";
        statement.executeUpdate(sql);
    }
    
    public ArrayList<Borrowed_Book> Get_BorrowList_forUser( int UserID ) throws SQLException
    {   
    	 statement = connect.createStatement();
         resultSet = statement.executeQuery("select * from borrowed_books where User_ID = "+UserID+"");
         
         ArrayList<Borrowed_Book> borrow_list = new ArrayList<Borrowed_Book>();
         
         while (resultSet.next()) {

         User_ID = resultSet.getInt("User_ID");
        Book_ISBN = resultSet.getInt("Book_ISBN");
        Notification_flag = resultSet.getString("Notification_flag");
        Borrow_Date =resultSet.getDate("Borrow_Date").toLocalDate();
        Return_Due_Date =resultSet.getDate("Return_Due_Date").toLocalDate();
         
        borrow_list.add(new Borrowed_Book(this) );
         }
         return borrow_list;
    }
    
    public ArrayList<Borrowed_Book> Get_AllBorrowedBooks() throws SQLException
    {   
    	 statement = connect.createStatement();
         resultSet = statement.executeQuery("select * from borrowed_books ");
         
         ArrayList<Borrowed_Book> borrow_list = new ArrayList<Borrowed_Book>();
         
         while (resultSet.next()) {

         User_ID = resultSet.getInt("User_ID");
        Book_ISBN = resultSet.getInt("Book_ISBN");
        Notification_flag = resultSet.getString("Notification_flag");
        Borrow_Date =resultSet.getDate("Borrow_Date").toLocalDate();
        Return_Due_Date =resultSet.getDate("Return_Due_Date").toLocalDate();
         
        borrow_list.add(new Borrowed_Book(this) );
         }
         return borrow_list;
    }
    
     public void deleteBook(int userid,int isbn) throws SQLException
    {
    	statement = connect.createStatement();
	    String sql = " DELETE FROM borrowed_books WHERE User_ID="+userid+" and Book_ISBN="+isbn+"  ";
        statement.executeUpdate(sql);
    }
    
}
