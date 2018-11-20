package Task2;
import java.io.*;
import java.util.Vector;

public class Instructor implements Serializable {
    private String firstName;
    private String lastName;
    private String department;
    private String email;

    Instructor(String firstName, String lastName, String department, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.email = email;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setDepartment(String department){
        this.department = department;
    }
    public String getDepartment(){
        return department;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }

    @Override
    public boolean equals(Object obj){
        if (this.getClass() != obj.getClass() || obj == null)
            return false;

        Instructor i = (Instructor) obj;
        if (!i.email.equals(email))
            return false;
        return true;
    }

    @Override
    public String toString(){
        return firstName + " " + lastName;
    }

    public void serialize(Vector<Instructor> v) {
        try {
            FileOutputStream foi = new FileOutputStream("instructors.out");
            ObjectOutputStream oos = new ObjectOutputStream(foi);
            oos.writeObject(v);
            oos.close();;
            foi.close();
        }
        catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
