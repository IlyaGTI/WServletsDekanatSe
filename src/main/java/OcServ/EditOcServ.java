/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OcServ;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sqlOcenki.Ocenki;
import sqlOcenki.OcenkiBD;

/**
 *
 * @author break
 */
@WebServlet(name = "EditOcServ", urlPatterns = {"/EditOcServ"})
public class EditOcServ extends HttpServlet {


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
            int id = Integer.parseInt(request.getParameter("idocenki"));
            Ocenki oc = OcenkiBD.selectOne(id);
            if(oc != null) {
                request.setAttribute("oc", oc);
                getServletContext().getRequestDispatcher("/editoc.jsp").forward(request, response);
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
            int id = Integer.parseInt(request.getParameter("idocenki"));
            String surname = request.getParameter("SurName");
            String namegr = request.getParameter("NameGr");
            String namedis = request.getParameter("Discips");
            int mark = Integer.parseInt(request.getParameter("ocenka"));
            
            
            Ocenki grupa = new Ocenki(id, surname, namegr, namedis, mark);
            OcenkiBD.update(grupa);
            response.sendRedirect(request.getContextPath() + "/IndOc");
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
