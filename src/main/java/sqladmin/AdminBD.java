
package sqladmin;
import java.util.*;
import java.sql.*;
public class AdminBD {
     
    private static String url = "jdbc:mysql://localhost:3306/dekenat?useUnicode=yes&characterEncoding=UTF-8";
    private static String username = "root";
    private static String password = "212182";
    
     public String authenticateAdmin(Admin a) {
         String login = a.getLogin();
         String pass = a.getPass();
         String loginDB = "";
         String passDB = "";
         
         try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "SELECT userName, password FROM admins";
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()) {
                     loginDB = rs.getString("login");
                     passDB = rs.getString("passwods");
                     
                     if(login.equals(loginDB) && pass.equals(passDB)) {
                         return "ADMIN";
                     }
                }
            }
                } catch(Exception ex) {
                       System.out.println(ex);
                        }
                return "Данные не верные";
            }
}
