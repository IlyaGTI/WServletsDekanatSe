/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OcServ;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sqlGrup.Group;
import sqlGrup.GroupBD;
import sqlDis.Discip;
import sqlDis.DiscipBD;
import sqlStud.Students;
import sqlStud.StudentsBD;
import sqlOcenki.Ocenki;
import sqlOcenki.OcenkiBD;


/**
 *
 * @author break
 */
@WebServlet(name = "CreateOcServ", urlPatterns = {"/CreateOc"})
public class CreateOcServ extends HttpServlet {

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
        ArrayList<Students> student = StudentsBD.select();
        request.setAttribute("student", student);
        
        ArrayList<Discip> discip = DiscipBD.select();
        request.setAttribute("discip", discip);
        
         ArrayList<Group> group = GroupBD.select();
        request.setAttribute("group", group);
        
        getServletContext().getRequestDispatcher("/createoc.jsp").forward(request, response);
        
        
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
            String surname = request.getParameter("SurName");
            String namegr = request.getParameter("NameGr");
            String namedis = request.getParameter("discips");
            int mark = Integer.parseInt(request.getParameter("ocenka"));
            
            
            Ocenki ocenki = new Ocenki(surname, namegr, namedis, mark);
            OcenkiBD.insert(ocenki);
            response.sendRedirect(request.getContextPath()+"/IndOc");
        }
        catch(Exception ex) {
             
            getServletContext().getRequestDispatcher("/createoc.jsp").forward(request, response); 
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
