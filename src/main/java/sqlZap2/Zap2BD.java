
package sqlZap2;
import java.sql.*;
import java.util.ArrayList;

public class Zap2BD {
    private static String url = "jdbc:mysql://localhost:3306/dekenat?useUnicode=yes&characterEncoding=UTF-8";
    private static String username = "root";
    private static String password = "212182";
    
    public static ArrayList<Zap2> selectZap(int id) {
         
        Zap2 zap2 = null;
        ArrayList<Zap2> za = new ArrayList(); 
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "SELECT grupastd.idgrupastd, grupastd.namegrp, ocenki.SurName, ocenki.ocenka, ocenki.discips\n" +
                             "FROM (discip  JOIN ocenki ON discip.namediscip = ocenki.discips) INNER JOIN (grupastd INNER JOIN students ON grupastd.namegrp = students.Grupa) ON ocenki.SurName = students.LastName\n" +
                             "WHERE ((grupastd.idgrupastd= ? ));";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()){
 
                        Zap2 z = new Zap2(); 
                        z.setNamegr(resultSet.getString("namegrp"));
                        z.setSurname(resultSet.getString("SurName"));
                        
                        z.setOcenka( resultSet.getString("ocenka"));
                        z.setDis(resultSet.getString("discips"));
                        
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
     
}
