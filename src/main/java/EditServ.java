/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import sqlStud.Students;
import sqlStud.StudentsBD;

/**
 *
 * @author break
 */
@WebServlet(urlPatterns = {"/edit"})
public class EditServ extends HttpServlet {

    
    

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
              ArrayList<Group> group = GroupBD.select();
              request.setAttribute("group", group);
            int id = Integer.parseInt(request.getParameter("idStudents"));
            Students student = StudentsBD.selectOne(id);
            if(student != null) {
                request.setAttribute("student", student);
                getServletContext().getRequestDispatcher("/edit.jsp").forward(request, response);
            }
            else {
                getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
            }
        }
        catch(Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
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
            int id = Integer.parseInt(request.getParameter("idStudents"));
            String lastname = request.getParameter("LastName");
            String name = request.getParameter("Name");
            String surname = request.getParameter("SurName");
            String pol = request.getParameter("Pol");
            String birthdate = request.getParameter("BirthDate");
            String addres = request.getParameter("Addres");
            String grupa = request.getParameter("Grupa");
           
            Students student = new Students(id, lastname, name, surname, pol, birthdate, addres, grupa);
            StudentsBD.update(student);
            response.sendRedirect(request.getContextPath() + "/Ind");
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

