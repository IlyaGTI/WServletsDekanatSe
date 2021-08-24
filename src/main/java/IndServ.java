
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sqlRazn.Raznoe;
import sqlRazn.RaznoeBD;
import sqlGrup.GroupBD;
import sqlStud.Students;
import sqlStud.StudentsBD;

/**
 *
 * @author break
 */
@WebServlet("/Ind")
public class IndServ extends HttpServlet {

   

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
        
        ArrayList<Raznoe> razn = RaznoeBD.selectwse();
        request.setAttribute("raz", razn);
       
        
        
        getServletContext().getRequestDispatcher("/inde.jsp").forward(request, response);
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
