/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserServ;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sqllogin.LogB;
import sqllogin.LoginBD;

/**
 *
 * @author break
 */
@WebServlet(name = "CreateUse", urlPatterns = {"/CreateUse"})
public class CreateUse extends HttpServlet {

    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         getServletContext().getRequestDispatcher("/createuse.jsp").forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
          
        try {
            String username = request.getParameter("userName");
            String password = request.getParameter("password");
            
            
            LogB user = new LogB(username, password);
            LoginBD.insert(user);
            response.sendRedirect(request.getContextPath()+"/IndeUse");
        }
        catch(Exception ex) {
             
            getServletContext().getRequestDispatcher("/createuse.jsp").forward(request, response); 
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
