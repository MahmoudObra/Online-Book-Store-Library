package Contoller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Wagdy
 */
@WebServlet(urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           String User_Name = request.getParameter("User_name");
           String Password = request.getParameter("password");
           User newUser = new User();
           newUser.Connect_To_Database();
           newUser.Get_User(User_Name);
           int verfiy = 0;
           if (newUser.getPassword().equals(Password) )
           {
                HttpSession session = request.getSession(true);
                session.setAttribute("userData", newUser);
               if (newUser.getType().equals("Admin") )
               {
                     Borrowed_Book book = new Borrowed_Book();
                     ArrayList<Borrowed_Book> list = new ArrayList<Borrowed_Book>();
            
                     try {
                          book.Connect_To_Database();               
                         list = book.Get_AllBorrowedBooks();
                           LocalDate d = LocalDate.now();
                           Book book2 = new Book();
                           
                         for(int i=0;i<list.size();i++)
                         {
                             if( d.compareTo( list.get(i).getReturn_Due_Date() ) > 0 )
                               {
                                   book2.Connect_To_Database();
                                    book2.Get_Book(list.get(i).getBook_ISBN());
                                    Message message = new Message(list.get(i).getUser_ID() , "You are LATE to return book "+ book2.getName() + " borrowed in: "+ list.get(i).getBorrow_Date(), "false" );
                                    message.Connect_To_Database();
                                    message.Send_Message();
                               }
                            
                         }
                
                    } catch (ClassNotFoundException ex) {
                     Logger.getLogger(Borrowed_Books.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                     Logger.getLogger(Borrowed_Books.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
               response.sendRedirect("Home Page For Admin.jsp");
               }
               else if (newUser.getType().equals("Student") )
               {
                   response.sendRedirect("Home Page.jsp");
               }
            }
           else
           {
               response.sendRedirect("Intro.jsp");
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
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
