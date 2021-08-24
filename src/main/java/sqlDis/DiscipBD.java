
package sqlDis;
import java.sql.*;
import java.util.ArrayList;

public class DiscipBD {
    private static String url = "jdbc:mysql://localhost:3306/dekenat?useUnicode=yes&characterEncoding=UTF-8";
    private static String username = "root";
    private static String password = "212182";
    
    public static ArrayList<Discip> select() {
         
        ArrayList<Discip> discip = new ArrayList<Discip>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM discip");
                while(rs.next()){
                      
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    int hour = rs.getInt(3);
                   
                    
                  
                    Discip dis = new Discip(id, name, hour);
                    discip.add(dis);
                    
                }
                 
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return discip;
    }
    public static Discip selectOne(int id) {
         
        Discip discip  = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "SELECT * FROM discip WHERE iddiscip =?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
 
                        int prodId = resultSet.getInt(1);
                        String name = resultSet.getString(2);
                        int hour = resultSet.getInt(3);
                        
                        
                        
                        discip = new Discip (prodId, name, hour);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return discip;
    }
    public static int insert(Discip ds) {
         
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "INSERT INTO discip (namediscip, hour) Values (?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, ds.getName());
                    preparedStatement.setInt(2, ds.getHour());
                    
                   
                      
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
     
    public static int update(Discip ds) {
         
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "UPDATE discip SET namediscip = ?, hour = ? WHERE iddiscip = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, ds.getName());
                    preparedStatement.setInt(2, ds.getHour());
                    
                    
                    
                    preparedStatement.setInt(3, ds.getId());
                      
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
                  
                String sql = "DELETE FROM discip WHERE iddiscip = ?";
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
}
