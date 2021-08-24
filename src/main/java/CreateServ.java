/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sqlGrup.Group;
import sqlStud.Students;
import sqlStud.StudentsBD;
import sqlGrup.GroupBD;

/**
 *
 * @author break
 */
@WebServlet(urlPatterns = {"/Create"})
public class CreateServ extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Group> group = GroupBD.select();
        request.setAttribute("group", group);
        
        getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
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
            String lastname = request.getParameter("LastName");
            String name = request.getParameter("Name");
            String surname = request.getParameter("SurName");
            String pol = request.getParameter("Pol");
            String birthdate = request.getParameter("BirthDate");
            String addres = request.getParameter("Addres");
            String grupa = request.getParameter("Grupa");
            
            Students student = new Students(lastname, name, surname, pol, birthdate, addres, grupa);
            StudentsBD.insert(student);
            response.sendRedirect(request.getContextPath()+"/Ind");
        }
        catch(Exception ex) {
             
            getServletContext().getRequestDispatcher("/create.jsp").forward(request, response); 
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
