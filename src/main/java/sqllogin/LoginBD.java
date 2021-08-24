package sqllogin;
import java.util.*;
import java.sql.*;
public class LoginBD {
    
    private static String url = "jdbc:mysql://localhost:3306/dekenat?useUnicode=yes&characterEncoding=UTF-8";
    private static String username = "root";
    private static String password = "212182";
    
      public static ArrayList<LogB> select() {
         
        ArrayList<LogB> users = new ArrayList<LogB>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM users");
                while(rs.next()){
                      
                    int id = rs.getInt(1);
                    String username = rs.getString(2);
                    String password = rs.getString(3);
                    
                    LogB user = new LogB(id, username, password);
                    users.add(user);
                    
                }
                 
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return users;
    }
    public static LogB selectOne(int id) {
         
        LogB user = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "SELECT * FROM users WHERE idusers=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
 
                        int prodId = resultSet.getInt(1);
                        String userName = resultSet.getString(2);
                        String password = resultSet.getString(3);
                        
                        user = new LogB(prodId, userName, password);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return user;
    }
    public static int insert (LogB log) {
         
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "INSERT INTO users (userName, password) Values (?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, log.getUsername());
                    preparedStatement.setString(2, log.getPassword());
                    
                      
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
     
    public static int update(LogB log) {
         
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "UPDATE users SET userName = ?, password = ?  WHERE idusers = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, log.getUsername());
                    preparedStatement.setString(2, log.getPassword());
                    
                    preparedStatement.setInt(3, log.getId());
                      
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
    public static int delete(int id) {
         
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "DELETE FROM users WHERE idusers = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                      
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
    
     public String authenticateUser(LogB log) {
         String userName = log.getUsername();
         String pasword = log.getPassword();
         String userNameDB = "";
         String passwordDB = "";
         
         try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "SELECT userName, password FROM users";
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()) {
                     userNameDB = rs.getString("userName");
                     passwordDB = rs.getString("password");
                     
                     if(userName.equals(userNameDB) && pasword.equals(passwordDB)) {
                         return "SUCCESS";
                     }
                }
            }
                } catch(Exception ex) {
                       System.out.println(ex);
                        }
                return "Повторите попытку. Данные не верные";
            }
     }

