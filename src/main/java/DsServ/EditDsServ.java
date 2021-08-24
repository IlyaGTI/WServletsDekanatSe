/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DsServ;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sqlDis.Discip;
import sqlDis.DiscipBD;

/**
 *
 * @author break
 */
@WebServlet(name = "EditDsServ", urlPatterns = {"/EditDs"})
public class EditDsServ extends HttpServlet {

 
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
            int id = Integer.parseInt(request.getParameter("iddiscip"));
            Discip discip = DiscipBD.selectOne(id);
            if(discip != null) {
                request.setAttribute("dis", discip);
                getServletContext().getRequestDispatcher("/editds.jsp").forward(request, response);
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
            int id = Integer.parseInt(request.getParameter("iddiscip"));
            String name = request.getParameter("namediscip");
            int hour  = Integer.parseInt(request.getParameter("hour"));

            
            Discip discip = new Discip(id, name, hour);
            DiscipBD.update(discip);
            response.sendRedirect(request.getContextPath() + "/IndDs");
        }
        catch(Exception ex) {
             
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);   
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
