package sqlOcenki;

import java.sql.*;
import java.util.ArrayList;

public class OcenkiBD {
    private static String url = "jdbc:mysql://localhost:3306/dekenat?useUnicode=yes&characterEncoding=UTF-8";
    private static String username = "root";
    private static String password = "212182";
    
    public static ArrayList<Ocenki> select() {
         
        ArrayList<Ocenki> ocenki = new ArrayList<Ocenki>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM ocenki");
                while(rs.next()){
                      
                    int id = rs.getInt(1);
                    String surname = rs.getString(2);
                    String namegr = rs.getString(3);
                    String namedis = rs.getString(4);
                    int mark = rs.getInt(5);
                    
                    
                  
                    Ocenki oc = new Ocenki(id, surname, namegr, namedis, mark);
                    ocenki.add(oc);
                    
                }
                 
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return ocenki;
    }
    public static Ocenki selectOne(int id) {
         
        Ocenki ocenki  = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "SELECT * FROM ocenki WHERE idocenki=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
 
                        int prodId = resultSet.getInt(1);
                        String surname = resultSet.getString(2);
                        String namegr = resultSet.getString(3);
                        String namedis = resultSet.getString(4);
                        int mark = resultSet.getInt(5);
                        
                        
                        
                        ocenki = new Ocenki (prodId, surname, namegr, namedis, mark);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return ocenki;
    }
    public static int insert(Ocenki oc) {
         
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "INSERT INTO ocenki (SurName, NameGr, discips, ocenka) Values (?, ?, ?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, oc.getSurname());
                    preparedStatement.setString(2, oc.getNamegr());
                    preparedStatement.setString(3, oc.getNamedis());
                    preparedStatement.setInt(4, oc.getMark());
                   
                      
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
     
    public static int update(Ocenki oc) {
         
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "UPDATE ocenki SET SurName = ?, NameGr = ?, discips = ?, ocenka = ? WHERE idocenki = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, oc.getSurname());
                    preparedStatement.setString(2, oc.getNamegr());
                    preparedStatement.setString(3, oc.getNamedis());
                    preparedStatement.setInt(4, oc.getMark());
                   
                    
                    
                    preparedStatement.setInt(5, oc.getId());
                      
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
                  
                String sql = "DELETE FROM ocenki WHERE idocenki = ?";
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

