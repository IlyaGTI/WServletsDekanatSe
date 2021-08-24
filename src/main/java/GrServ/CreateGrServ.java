/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GrServ;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sqlGrup.Group;
import sqlGrup.GroupBD;

/**
 *
 * @author break
 */
@WebServlet(name = "CreateGrServ", urlPatterns = {"/CreateGr"})
public class CreateGrServ extends HttpServlet {

    

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
        getServletContext().getRequestDispatcher("/creategr.jsp").forward(request, response);
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        try {
            String name = request.getParameter("namegrp");
            int kurs =  Integer.parseInt(request.getParameter("kurs"));
            int semestr = Integer.parseInt(request.getParameter("semestr"));
            
            Group gr = new Group(name, kurs, semestr);
            GroupBD.insert(gr);
            response.sendRedirect(request.getContextPath()+"/IndGr");
        }
        catch(Exception ex) {
             
            getServletContext().getRequestDispatcher("/creategr.jsp").forward(request, response); 
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
