package supcom.projetdevmob.com.firebasetest123;

/**
 * Created by pc on 06/11/2016.
 */

public class university {
    String name ;
    String speciality , place,budget;
int id;




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public university(int id , String name, String speciality, String place, String budget) {
        this.id=id;
        this.name = name;
        this.speciality = speciality;
        this.place = place;

        this.budget = budget;
    }
public university(){

}

}
