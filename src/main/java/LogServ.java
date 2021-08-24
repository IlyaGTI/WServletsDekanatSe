
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sqllogin.LogB;
import sqllogin.LoginBD;
import sqladmin.*;

@WebServlet(urlPatterns = {"/LogServ"})
public class LogServ extends HttpServlet {

  
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
       getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
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
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        
        LogB log = new LogB();
        log.setUsername(userName);
        log.setPassword(password);
        
        LoginBD log2 = new LoginBD();
        String userV = log2.authenticateUser(log);
        
        String login = request.getParameter("userName");
        String pass = request.getParameter("password");
        
        Admin a = new Admin();
        a.setLogin(login);
        a.setPass(pass);
        
        AdminBD adm = new AdminBD();
        String adminV = adm.authenticateAdmin(a);
        
        if(userV.equals("SUCCESS")){
            request.setAttribute("userName", userName);
            request.getRequestDispatcher("/indexGlav.jsp").forward(request, response);
        } 
          if(adminV.equals("ADMIN")) {
        request.setAttribute("userName", userName);
        request.getRequestDispatcher("/IndexAdmin.jsp").forward(request, response);
        } 
        
        else {
            request.setAttribute("errMessage", userV);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
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
