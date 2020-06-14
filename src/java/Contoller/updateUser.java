/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contoller;

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
 * @author el mostafa
 */
@WebServlet(name = "updateUser", urlPatterns = {"/updateUser"})
public class updateUser extends HttpServlet {

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
           
             String User_Name = request.getParameter("Name");
           String Password = request.getParameter("password");
           String Email = request.getParameter("E-mail");
           String mobile = request.getParameter("Mobile");
           String Gender = request.getParameter("Gender");
           
           HttpSession session = request.getSession(true);
            User user = new User(  (User) session.getAttribute("userData") );
           
           User newUser = new User(User_Name, Password, "", Email, null, Gender, mobile);
            try {
                newUser.Connect_To_Database();
                 newUser.Update_user(user.getName());
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(updateUser.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(updateUser.class.getName()).log(Level.SEVERE, null, ex);
            }
          
            try {
                user.Connect_To_Database();
                user.Get_User(User_Name);
                session.removeAttribute("userData");
                session.setAttribute("userData", user);
                
                response.sendRedirect("Profile.jsp");
                
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
