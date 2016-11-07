package supcom.projetdevmob.com.firebasetest123;

import java.io.Serializable;

/**
 * Created by pc on 04/11/2016.
 */

public class Informations implements Serializable{

    String password ;
    String name , dateofbirth ;

    public Informations(String password, String name, String dateofbirth) {
        this.password = password;
        this.name = name;
        this.dateofbirth = dateofbirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
