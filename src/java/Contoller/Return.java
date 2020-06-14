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
import java.time.LocalDate;
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
@WebServlet(name = "Return", urlPatterns = {"/Return"})
public class Return extends HttpServlet {

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
            
             HttpSession session = request.getSession(true);
            Book book = new Book(  (Book) session.getAttribute("bookData") );
           int no_of_copies = book.getNo_Of_Copies();
           no_of_copies = no_of_copies+1;
           book.setNo_Of_Copies(no_of_copies);
         
            try {
                book.Connect_To_Database();
                 book.Update_book( book.getISBN() );
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(updateUser.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(updateUser.class.getName()).log(Level.SEVERE, null, ex);
            }
          
           
               
                session.removeAttribute("bookData");
               
                
           
                
              Borrowed_Book borrowed= new Borrowed_Book();
               User user = new User(  (User) session.getAttribute("userData") );
            try {
                borrowed.Connect_To_Database();
                  borrowed.deleteBook( user.getID(), book.getISBN() );
                  
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Borrow.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Borrow.class.getName()).log(Level.SEVERE, null, ex);
            }
            
              
                 if(user.getType().equals("Admin"))
                {
                    response.sendRedirect("Home Page For Admin.jsp");
                }
                else
                {
                    response.sendRedirect("Home Page.jsp");
                }

            
            
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
