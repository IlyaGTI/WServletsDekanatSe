/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlZap1;
import java.io.Serializable;
/**
 *
 * @author break
 */
public class Zap1 implements Serializable {
    private static final long serialVersionUID = 1L;
    
    
    private int iddis;
    private String dis;
    private String surname;
    private String ocenka;
    private String namegr;

    
     public Zap1(){ }
     
     public Zap1(int iddis, String dis, String surname, String ocenka, String namegr){
         
        this.iddis = iddis;
        this.dis = dis;
        this.surname = surname;
        this.ocenka = ocenka;
        this.namegr = namegr;
        
        
        
    }
     
      public Zap1(String dis, String surname, String ocenka, String namegr){
         
   
        this.dis = dis;
        this.surname = surname;
        this.ocenka = ocenka;
        this.namegr = namegr;
        
        
        
    }

    public int getIddis() {
        return iddis;
    }

    public void setIddis(int iddis) {
        this.iddis = iddis;
    }
    

    public String getDis() {
        return dis;
    }

    public void setDis(String dis) {
        this.dis = dis;
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

    public String getNamegr() {
        return namegr;
    }

    public void setNamegr(String namegr) {
        this.namegr = namegr;
    }
      
}
