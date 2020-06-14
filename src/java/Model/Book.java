/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;


public class Book {
    
    
     private int ISBN;
    private String Name;
    private String Author;
    private String Category;
    private int No_Of_Copies;
    private int Publication_Year;
    private String Description;
    
    private Connection connect ;
    private Statement statement ;
    private ResultSet resultSet;

    public Book() {
        ISBN = -1;
        Name = "";
        Author = "";
        Category = "";
        No_Of_Copies = 0;
        Publication_Year = 0;
        Description = "";
    }
    
    public Book(int ISBN, String Name, String Author, String Category, int No_Of_Copies, int Publication_Year , String Description) {
        this.ISBN = ISBN;
        this.Name = Name;
        this.Author = Author;
        this.Category = Category;
        this.No_Of_Copies = No_Of_Copies;
        this.Publication_Year = Publication_Year;
        this.Description = Description;
    }
    
     public Book( Book b) {
        this.ISBN = b.ISBN;
        this.Name = b.Name;
        this.Author = b.Author;
        this.Category = b.Category;
        this.No_Of_Copies = b.No_Of_Copies;
        this.Publication_Year = b.Publication_Year;
        this.Description = b.Description;
    }

  
    public String getDesc() {
        return Description;
    }

    public void setISBN(String Description) {
        this.Description = Description;
    }

     
     
    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public int getNo_Of_Copies() {
        return No_Of_Copies;
    }

    public void setNo_Of_Copies(int No_Of_Copies) {
        this.No_Of_Copies = No_Of_Copies;
    }

    public int getPublication_Year() {
        return Publication_Year;
    }

    public void setPublication_Year(int Publication_Year) {
        this.Publication_Year = Publication_Year;
    }

    public Connection getConnect() {
        return connect;
    }

    public void setConnect(Connection connect) {
        this.connect = connect;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }
    
    
    public void Connect_To_Database() throws ClassNotFoundException, SQLException
	{
		   Class.forName("com.mysql.jdbc.Driver");
		      connect = DriverManager.getConnection(
		    		 "jdbc:mysql://localhost/University_Library?"
		             + "user=root&password=");
	}
    
    public void Add_New_Book() throws SQLException
    {
    	statement = connect.createStatement();
	    String sql = "INSERT INTO Book (ISBN , Name , Author , Publication_Year , Category , No_Of_Copies)  values ("+this.ISBN+",'"+this.Name+"','"+this.Author+"', '"+this.Publication_Year+"','"+this.Category+"' , "+this.No_Of_Copies+" ,'"+this.Description+"' )";
        statement.executeUpdate(sql);
    }
    
    public Book Get_Book( int BookISBN ) throws SQLException
    {   
    	 statement = connect.createStatement();
         resultSet = statement.executeQuery("select * from Book where ISBN = "+BookISBN+"");
         
         while (resultSet.next()) {

         ISBN = resultSet.getInt("ISBN");
        Name = resultSet.getString("Name");
        Author = resultSet.getString("Author");;
        Category = resultSet.getString("Category");;
        No_Of_Copies = resultSet.getInt("No_Of_Copies");;
        Publication_Year =resultSet.getInt("Publication_Year");
        Description = resultSet.getString("Description");
         }
         return this;
    }
    
     public ArrayList<Book> Get_AllBooks() throws SQLException
    {   
    	 statement = connect.createStatement();
         resultSet = statement.executeQuery("select * from Book ");
         
         ArrayList<Book> b = new ArrayList<Book>();
         while (resultSet.next()) {

         ISBN = resultSet.getInt("ISBN");
        Name = resultSet.getString("Name");
        Author = resultSet.getString("Author");;
        Category = resultSet.getString("Category");;
        No_Of_Copies = resultSet.getInt("No_Of_Copies");;
        Publication_Year =resultSet.getInt("Publication_Year");
        Description = resultSet.getString("Description");
 
        b.add(new Book(this));
         }
         return b;
    }
     
     public void Update_book(int isbn) throws SQLException
    {
         statement = connect.createStatement();
          String sql = "UPDATE Book " +
	                   "SET ISBN = "+ISBN+",Name='"+Name+"',Author='"+Author+"',Category='"+Category+"',No_Of_Copies="+No_Of_Copies+",Publication_Year="+Publication_Year+" , '"+Description+" WHERE ISBN = "+isbn+" ";
 
        statement.executeUpdate(sql);
    }
         
    public ArrayList<Book> Get_Books_ByAuthor(String Author) throws SQLException
    {   
    	 statement = connect.createStatement();
         resultSet = statement.executeQuery("select * from Book where Book.Author Like '%"+Author+"%' ");
         
         ArrayList<Book> b = new ArrayList<Book>();
         while (resultSet.next()) {

        ISBN = resultSet.getInt("ISBN");
        Name = resultSet.getString("Name");
        Author = resultSet.getString("Author");;
        Category = resultSet.getString("Category");;
        No_Of_Copies = resultSet.getInt("No_Of_Copies");;
        Publication_Year =resultSet.getInt("Publication_Year");
        Description = resultSet.getString("Description");
        b.add(new Book(this));
         }
         return b;
    }
    
    public ArrayList<Book> Get_Books_ByName(String name) throws SQLException
    {   
    	 statement = connect.createStatement();
         resultSet = statement.executeQuery("select * from Book where Book.Name Like '%"+name+"%' ");
         
         ArrayList<Book> b = new ArrayList<Book>();
         while (resultSet.next()) {

        ISBN = resultSet.getInt("ISBN");
        Name = resultSet.getString("Name");
        Author = resultSet.getString("Author");;
        Category = resultSet.getString("Category");;
        No_Of_Copies = resultSet.getInt("No_Of_Copies");;
        Publication_Year =resultSet.getInt("Publication_Year");
        Description = resultSet.getString("Description");        
        b.add(new Book(this));
         }
         return b;
    }
     public ArrayList<Book> Get_Books_ByCategory(String Category) throws SQLException
    {   
    	 statement = connect.createStatement();
         resultSet = statement.executeQuery("select * from Book where Book.Category='"+Category+"' ");
         
         ArrayList<Book> b = new ArrayList<Book>();
         while (resultSet.next()) {

        ISBN = resultSet.getInt("ISBN");
        Name = resultSet.getString("Name");
        Author = resultSet.getString("Author");;
        Category = resultSet.getString("Category");;
        No_Of_Copies = resultSet.getInt("No_Of_Copies");;
        Publication_Year =resultSet.getInt("Publication_Year");
        Description = resultSet.getString("Description");        
        b.add(new Book(this));
         }
         return b;
    }
     
     public ArrayList<Book> Get_Books_ByYear(String Year) throws SQLException
    {   
    	 statement = connect.createStatement();
         resultSet = statement.executeQuery("select * from Book where Book.Publication_Year='"+Year+"' ");
         
         ArrayList<Book> b = new ArrayList<Book>();
         while (resultSet.next()) {

        ISBN = resultSet.getInt("ISBN");
        Name = resultSet.getString("Name");
        Author = resultSet.getString("Author");;
        Category = resultSet.getString("Category");;
        No_Of_Copies = resultSet.getInt("No_Of_Copies");;
        Publication_Year =resultSet.getInt("Publication_Year");
        Description = resultSet.getString("Description");        
        b.add(new Book(this));
         }
         return b;
    }
  
}