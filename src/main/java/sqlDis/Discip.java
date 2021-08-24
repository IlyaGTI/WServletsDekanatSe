
package sqlDis;
import java.io.Serializable;

public class Discip implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private int hour;
    
    public Discip(){ }

   
     
    public Discip(int id, String name, int hour){
         
        this.id = id;
        this.name = name;
        this.hour = hour;
        
        
    }
     
      public Discip(String name, int hour){
         
        this.name = name;
        this.hour = hour;
        
        
        
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

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }
    
}
