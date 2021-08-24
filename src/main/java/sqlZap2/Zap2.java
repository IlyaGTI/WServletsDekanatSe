
package sqlZap2;
import java.io.Serializable;

public class Zap2 implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private int idgr;
    private String namegr;
    private String surname;
    private String ocenka;
    private String dis;
    
     public Zap2(){ }
     
     public Zap2(int idgr, String namegr, String surname, String ocenka, String dis){
         
        this.idgr = idgr;
        this.namegr = namegr;
        this.dis = dis;
        this.surname = surname;
        this.ocenka = ocenka;
        this.dis = dis;
        
        
        
    }
     
      public Zap2(String namegr, String surname, String ocenka, String dis){
         
   
        this.namegr = namegr;
        this.surname = surname;
        this.ocenka = ocenka;
        this.dis = dis;
        
        
        
        
    }

    public void setIdgr(int idgr) {
        this.idgr = idgr;
    }

    public String getNamegr() {
        return namegr;
    }

    public void setNamegr(String namegr) {
        this.namegr = namegr;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getOcenka() {
        return ocenka;
    }

    public void setOcenka(String ocenka) {
        this.ocenka = ocenka;
    }

    public String getDis() {
        return dis;
    }

    public void setDis(String dis) {
        this.dis = dis;
    }
    
    
}
