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
@WebServlet(name = "editServ", urlPatterns = {"/editUse"})
public class editServ extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
             
            int id = Integer.parseInt(request.getParameter("idusers"));
            LogB user = LoginBD.selectOne(id);
            if(user != null) {
                request.setAttribute("us", user);
                getServletContext().getRequestDispatcher("/edituse.jsp").forward(request, response);
            }
            else {
                getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
            }
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
         
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("idusers"));
            String username = request.getParameter("userName");
            String password = request.getParameter("password");
            
           
            LogB user = new LogB(id, username, password);
            LoginBD.update(user);
            response.sendRedirect(request.getContextPath() + "/IndeUse");
        }
        catch(Exception ex) {
             
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);   
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
