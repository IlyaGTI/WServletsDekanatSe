package sqlGrup;
import java.io.Serializable;

public class Group implements Serializable{
    private static final long serialVersionUID = 1L;
    
    
    private int id;
    private String name;
    private int kurs;
    private int semestr;
    
     public Group(){ }
     
     public Group(int id, String name, int kurs, int semestr){
         
        this.id = id;
        this.name = name;
        this.kurs = kurs;
        this.semestr = semestr;
        
        
    }
     
      public Group(String name, int kurs, int semestr){
         
        this.name = name;
        this.kurs = kurs;
        this.semestr = semestr;
        
        
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKurs() {
        return kurs;
    }

    public void setKurs(int kurs) {
        this.kurs = kurs;
    }

    public int getSemestr() {
        return semestr;
    }

    public void setSemestr(int semestr) {
        this.semestr = semestr;
    }
      
      
   
    
}
