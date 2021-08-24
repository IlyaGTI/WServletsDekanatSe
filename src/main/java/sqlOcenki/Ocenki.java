package sqlOcenki;
import java.io.Serializable;

public class Ocenki implements Serializable {
     private static final long serialVersionUID = 1L;
    
    private int id;
    private String surname;
    private String namegr;
    private String namedis;
    private int mark;
    
     public Ocenki(){ }
     
     public Ocenki(int id, String surname, String namegr, String namedis, int mark){
         
        this.id = id;
        this.surname = surname;
        this.namegr = namegr;
        this.namedis = namedis;
        this.mark = mark;
        
        
    }
     
      public Ocenki(String surname, String namegr , String namedis, int mark){
         
        this.surname = surname;
        this.namegr = namegr;
        this.namedis = namedis;
        this.mark = mark;
        
        
    }   

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNamegr() {
        return namegr;
    }

    public void setNamegr(String namegr) {
        this.namegr = namegr;
    }

    public String getNamedis() {
        return namedis;
    }

    public void setNamedis(String namedis) {
        this.namedis = namedis;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
    
      
}
 