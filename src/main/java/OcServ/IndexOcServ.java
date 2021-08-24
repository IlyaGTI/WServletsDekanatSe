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
import sqlOcenki.Ocenki;
import sqlOcenki.OcenkiBD;
import sqlRazn.Raznoe;
import sqlRazn.RaznoeBD;

/**
 *
 * @author break
 */
@WebServlet(name = "IndexOcServ", urlPatterns = {"/IndOc"})
public class IndexOcServ extends HttpServlet {

    

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
         ArrayList<Ocenki> ocenki = OcenkiBD.select();
        request.setAttribute("ocenki", ocenki);
       
        
        
        getServletContext().getRequestDispatcher("/indeoc.jsp").forward(request, response);
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
            String namedis = request.getParameter("discips");
            
            
            Raznoe rz = new Raznoe(namedis);
            RaznoeBD.selectW(rz);
            response.sendRedirect(request.getContextPath()+"/RazServ");
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
