package supcom.projetdevmob.com.firebasetest123;

import java.io.Serializable;

/**
 * Created by pc on 06/11/2016.
 */

public class stats implements Serializable{
int num_users;
    int num_univ ;

    public stats(int num_users, int num_univ) {
        this.num_users = num_users;
        this.num_univ = num_univ;
    }

    public stats() {
    }

    public int getNum_users() {
        return num_users;
    }

    public void setNum_users(int num_users) {
        this.num_users = num_users;
    }

    public int getNum_univ() {

        return num_univ;
    }

    public void setNum_univ(int num_univ) {
        this.num_univ = num_univ;
    }
}
