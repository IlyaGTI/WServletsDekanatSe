package sqlStud;
import java.io.Serializable;

public class Students implements Serializable {
    private static final long serialVersionUID = 1L;
    
    
    private int id;
    private String lastname;
    private String name;
    private String surname;
    private String pol;
    private String birthdate;
    private String addres;
    private String grupa;
    
     public Students(){ }
     
     public Students(int id, String lastname, String name, String surname, String pol, String birthdate, String addres, String grupa){
         
        this.id = id;
        this.lastname = lastname;
        this.name = name;
        this.surname = surname;
        this.pol = pol;
        this.birthdate = birthdate;
        this.addres = addres;
        this.grupa = grupa;
        
        
    }
     
      public Students(String lastname, String name, String surname, String pol, String birthdate, String addres, String grupa){
         
        this.lastname = lastname;
        this.name = name;
        this.surname = surname;
        this.pol = pol;
        this.birthdate = birthdate;
        this.addres = addres;
        this.grupa = grupa;
        
        
    }
      
       
   

    public int getid() {
        return id;
    }

    public String getlastname() {
        return lastname;
    }

    public void setlastname(String lastname) {
        this.lastname = lastname;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getsurname() {
        return surname;
    }

    public void setsurname(String surname) {
        this.surname = surname;
    }

    public String getpol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    public String getbirthdate() {
        return birthdate;
    }

    public void setbirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getaddres() {
        return addres;
    }

    public void setaddres(String addres) {
        this.addres = addres;
    }

    public String getgrupa() {
        return grupa;
    }

    public void setgrupa(String grupa) {
        this.grupa = grupa;
    }
     
}
