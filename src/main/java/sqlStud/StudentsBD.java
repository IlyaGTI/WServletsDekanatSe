package sqlStud;
import java.sql.*;
import java.util.ArrayList;



public class StudentsBD {
    private static String url = "jdbc:mysql://localhost:3306/dekenat?useUnicode=yes&characterEncoding=UTF-8";
    private static String username = "root";
    private static String password = "212182";
    
    public static ArrayList<Students> select() {
         
        ArrayList<Students> students = new ArrayList<Students>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM students");
                while(rs.next()){
                      
                    int id = rs.getInt(1);  
                    String lastname = rs.getString(2);
                    String name = rs.getString(3);
                    String surname = rs.getString(4);
                    String pol = rs.getString(5);
                    String birthdate = rs.getString(6);
                    String addres = rs.getString(7);
                    String grupa = rs.getString(8);
                  
                    Students student = new Students(id, lastname, name, surname, pol, birthdate, addres, grupa);
                    students.add(student);
                    
                }
                 
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return students;
    }
    public static Students selectOne(int id) {
         
        Students student = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "SELECT * FROM students WHERE idStudents=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
 
                        int prodId = resultSet.getInt(1);
                        String lastname = resultSet.getString(2);
                        String name = resultSet.getString(3);
                        String surname = resultSet.getString(4);
                        String pol = resultSet.getString(5);
                        String birthdate = resultSet.getString(6);
                        String addres = resultSet.getString(7);
                        String grupa = resultSet.getString(8);
                        
                        student = new Students(prodId, lastname, name, surname, pol, birthdate, addres, grupa);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return student;
    }
    public static int insert(Students st) {
         
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "INSERT INTO students (LastName, Name, SurName, Pol, BirthDate, Addres, Grupa) Values (?, ?, ?, ?, ?, ?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, st.getlastname());
                    preparedStatement.setString(2, st.getname());
                    preparedStatement.setString(3, st.getsurname());
                    preparedStatement.setString(4, st.getpol());
                    preparedStatement.setString(5, st.getbirthdate());
                    preparedStatement.setString(6, st.getaddres());
                    preparedStatement.setString(7, st.getgrupa());
                      
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
     
    public static int update(Students st) {
         
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "UPDATE students SET LastName = ?, Name = ?, SurName = ?, Pol = ?, BirthDate = ?, Addres = ?, Grupa = ?  WHERE idStudents = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, st.getlastname());
                    preparedStatement.setString(2, st.getname());
                    preparedStatement.setString(3, st.getsurname());
                    preparedStatement.setString(4, st.getpol());
                    preparedStatement.setString(5, st.getbirthdate());
                    preparedStatement.setString(6, st.getaddres());
                    preparedStatement.setString(7, st.getgrupa());
                    
                    preparedStatement.setInt(8, st.getid());
                      
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
                  
                String sql = "DELETE FROM students WHERE idStudents = ?";
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

