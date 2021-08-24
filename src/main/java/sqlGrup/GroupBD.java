package sqlGrup;
import java.sql.*;
import java.util.ArrayList;

public class GroupBD {
    private static String url = "jdbc:mysql://localhost:3306/dekenat?useUnicode=yes&characterEncoding=UTF-8";
    private static String username = "root";
    private static String password = "212182";
    
    public static ArrayList<Group> select() {
         
        ArrayList<Group> grupa = new ArrayList<Group>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM grupastd");
                while(rs.next()){
                      
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    int kurs = rs.getInt(3);
                    int semestr = rs.getInt(4);
                    
                  
                    Group gr = new Group(id, name, kurs, semestr);
                    grupa.add(gr);
                    
                }
                 
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return grupa;
    }
    public static Group selectOne(int id) {
         
        Group grupa  = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "SELECT * FROM grupastd WHERE idgrupastd=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
 
                        int prodId = resultSet.getInt(1);
                        String name = resultSet.getString(2);
                        int kurs = resultSet.getInt(3);
                        int semestr = resultSet.getInt(4);
                        
                        
                        grupa = new Group (prodId, name, kurs, semestr);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return grupa;
    }
    public static int insert(Group gr) {
         
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "INSERT INTO grupastd (namegrp, kurs, semestr) Values (?, ?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, gr.getName());
                    preparedStatement.setInt(2, gr.getKurs());
                    preparedStatement.setInt(3, gr.getSemestr());
                   
                      
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
     
    public static int update(Group gr) {
         
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "UPDATE grupastd SET namegrp = ?, kurs = ?, semestr = ? WHERE idgrupastd = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, gr.getName());
                    preparedStatement.setInt(2, gr.getKurs());
                    preparedStatement.setInt(3, gr.getSemestr());
                    
                    
                    preparedStatement.setInt(4, gr.getId());
                      
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
                  
                String sql = "DELETE FROM grupastd WHERE idgrupastd = ?";
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
