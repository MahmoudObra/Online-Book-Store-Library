/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contoller;

import Model.Book;
import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
 * @author Wagdy
 */
@WebServlet(name = "UpdateBook", urlPatterns = {"/UpdateBook"})
public class UpdateBook extends HttpServlet {

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
           
            
            int ISBN = Integer.parseInt( request.getParameter("ISBN") );
            String Book_Name = request.getParameter("Name");
           String Category = request.getParameter("Category");
           String Author = request.getParameter("Author");
           int PublicationYear = Integer.parseInt( request.getParameter("PublicationYear") );
           int NoCopies = Integer.parseInt( request.getParameter("NoCopies") );
           String Description = request.getParameter("Desc");
            HttpSession session = request.getSession(true);
            Book book = new Book(  (Book) session.getAttribute("bookData") );
           
           Book newBook = new Book(ISBN,Book_Name, Author, Category, NoCopies,PublicationYear , Description );
            try {
                newBook.Connect_To_Database();
                 newBook.Update_book( ISBN );
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(updateUser.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(updateUser.class.getName()).log(Level.SEVERE, null, ex);
            }
          
            try {
                book.Connect_To_Database();
                book.Get_Book(ISBN );
                session.removeAttribute("bookData");
               session.setAttribute("bookData", book);
                
              User user = new User(  (User) session.getAttribute("userData") );
                
                if(user.getType().equals("Admin"))
                {
                    response.sendRedirect("Book Details Admin.jsp");
                }
                else
                {
                    response.sendRedirect("Book Details Student.jsp");
                }

                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(updateUser.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(updateUser.class.getName()).log(Level.SEVERE, null, ex);
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
