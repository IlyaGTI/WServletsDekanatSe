
package sqladmin;
import java.io.Serializable;

public class Admin implements Serializable{
    private static final long serialVersionUID = 1L;
    private String login;
    private String pass;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
}
