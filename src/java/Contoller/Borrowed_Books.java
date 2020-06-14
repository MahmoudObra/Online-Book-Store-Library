/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contoller;

import Model.Book;
import Model.Borrowed_Book;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author el mostafa
 */
@WebServlet(name = "Borrowed_Books", urlPatterns = {"/Borrowed_Books"})
public class Borrowed_Books extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            
              Borrowed_Book book2 = new Borrowed_Book();
           ArrayList<Borrowed_Book> list2 = new ArrayList<Borrowed_Book>();
            HttpSession session = request.getSession(true); 
           try {
                book2.Connect_To_Database();
                User user = new User(  (User) session.getAttribute("userData") );          
           list2 = book2.Get_BorrowList_forUser(user.getID());
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Borrowed_Books.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Borrowed_Books.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
           Book book = new Book();
           ArrayList<Book> list = new ArrayList<Book>();
           for(int i=0;i<list2.size();i++)
           {
                try {
                    book.Connect_To_Database();
                    list.add(  new Book(book.Get_Book(list2.get(i).getBook_ISBN()) ) ) ;
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Borrowed_Books.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(Borrowed_Books.class.getName()).log(Level.SEVERE, null, ex);
                }
              
           }
           
           session.setAttribute("borrowedBooks", list);
           response.sendRedirect("Borrowed_books.jsp");
            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
