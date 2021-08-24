
package sqlRazn;
import java.io.Serializable;

public class Raznoe implements Serializable {
        private int id;
        private String surname;
        private String namedis;
        private String grupa;
        private int mark;

  
        
        public Raznoe(){ }
        public Raznoe(String namedis){
         
       
        this.namedis = namedis;
     
        
     
    }
        
        public Raznoe(int id, String surname, String namedis, String grupa, int mark){
         
        this.id = id;
        this.surname = surname;
        this.namedis = namedis;
        this.grupa = grupa;
        this.mark = mark;
        
     
    }
     
      public Raznoe(String surname, String namedis, String grupa, int mark){
         
        this.surname = surname;
        this.namedis = namedis;
        this.grupa = grupa;
        this.mark = mark;
        
        
    }
      
      public String getNamedis() {
        return namedis;
    }

    public void setNamedis(String namedis) {
        this.namedis = namedis;
    }  
}
    
