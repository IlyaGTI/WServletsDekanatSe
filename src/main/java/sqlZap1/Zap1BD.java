
package sqlZap1;
import java.sql.*;
import java.util.ArrayList;
import sqlStud.Students;

/**
 *
 * @author break
 */
public class Zap1BD {
    private static String url = "jdbc:mysql://localhost:3306/dekenat?useUnicode=yes&characterEncoding=UTF-8";
    private static String username = "root";
    private static String password = "212182";
    
    
     public static ArrayList<Zap1> selectZap(int id) {
         
        Zap1 zap1 = null;
        ArrayList<Zap1> za = new ArrayList(); 
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "SELECT discip.iddiscip, ocenki.discips, ocenki.SurName, ocenki.ocenka, grupastd.namegrp\n" +
                             "FROM (discip INNER JOIN ocenki ON discip.namediscip = ocenki.discips) INNER JOIN (grupastd INNER JOIN students ON grupastd.namegrp = students.Grupa) ON ocenki.SurName = students.LastName\n" +
                             "WHERE ((discip.iddiscip= ? ));";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()){
 
                        Zap1 z = new Zap1(); 
                        z.setDis(resultSet.getString("discips"));
                        z.setSurname(resultSet.getString("SurName"));
                        
                        z.setOcenka( resultSet.getString("ocenka"));
                        z.setNamegr(resultSet.getString("namegrp"));
                        
                        za.add(z);
                        
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return za;
     }
     
     
      public static ArrayList<Zap1> select() {
         
        ArrayList<Zap1> zap1 = new ArrayList<Zap1>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("SELECT discip.iddiscip, ocenki.discips, ocenki.SurName, ocenki.ocenka, grupastd.namegrp\n" +
                                               "FROM (discip INNER JOIN ocenki ON discip.namediscip = ocenki.discips) INNER JOIN (grupastd INNER JOIN students ON grupastd.namegrp = students.Grupa) ON ocenki.SurName = students.LastName\n" +
                                               "WHERE ((discip.iddiscip= ? ));");
                while(rs.next()){
                      
                    int iddis = rs.getInt(1);
                    String dis = rs.getString(2);
                    String surname = rs.getString(3);
                    String ocenka = rs.getString(4);
                    String namegr = rs.getString(5);
                   
                  
                    Zap1 zap = new Zap1(iddis, dis, surname, ocenka, namegr);
                    zap1.add(zap);
                    
                }
                 
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return zap1;
    }
}
