
package sqlRazn;
import java.sql.*;
import java.util.*;
import sqlStud.Students;
import sqlStud.StudentsBD;
import sqlDis.Discip;
import sqlDis.DiscipBD;
import sqlGrup.GroupBD;
import sqlGrup.Group;
import sqlOcenki.Ocenki;
public class RaznoeBD {
    
    private static String url = "jdbc:mysql://localhost:3306/dekenat?useUnicode=yes&characterEncoding=UTF-8";
    private static String username = "root";
    private static String password = "212182";
   
    
    
    
   public static ArrayList<Raznoe> select(){
        ArrayList<Raznoe> raz = new ArrayList<Raznoe>();
          try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                
                Statement st = conn.createStatement();
                String sql = ("SELECT ocenki.SurName, ocenki.discips, students.Grupa, ocenki.ocenka\n" +
                              "FROM (discip INNER JOIN ocenki ON discip.namediscip = ocenki.discips) INNER JOIN (grupastd INNER JOIN students ON grupastd.namegrp = students.Grupa) ON ocenki.SurName = students.LastName\n" +
                              "WHERE (((ocenki.discips)= ? ))");
                
                ResultSet rs = st.executeQuery(sql); 
                while(rs.next()){
                      
                    
                    String surname = rs.getString(1);
                    String namedis = rs.getString(2);
                    String grupa = rs.getString(3);
                    int mark = rs.getInt(4);
                    Raznoe rz = new Raznoe(surname, namedis, grupa, mark);
                    raz.add(rz);
                    
                    
                    
                    
                }
                 
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return raz;
                         
   }
   
   public static int selectW(Raznoe rz) {
         
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "SELECT ocenki.SurName, ocenki.discips, students.Grupa, ocenki.ocenka\n" +
                              "FROM (discip INNER JOIN ocenki ON discip.namediscip = ocenki.discips) INNER JOIN (grupastd INNER JOIN students ON grupastd.namegrp = students.Grupa) ON ocenki.SurName = students.LastName\n" +
                              "WHERE (((ocenki.discips)= ? ))";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    
                    
                    preparedStatement.setString(1, rz.getNamedis());
                    
                   
                      
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
   
   
    public static ArrayList<Raznoe> selectwse() {
         
        ArrayList<Raznoe> raznoe = new ArrayList<Raznoe>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM ocenki");
                while(rs.next()){
                      
                    
                    String surname = rs.getString(1);
                    String namegr = rs.getString(2);
                    String namedis = rs.getString(3);
                    int mark = rs.getInt(4);
                    
                    
                  
                    Raznoe rz = new Raznoe(surname, namedis, namegr, mark);
                    raznoe.add(rz);
                    
                }
                 
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return raznoe;
   
   
   
   
}
}
