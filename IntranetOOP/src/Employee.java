import java.io.Serializable;

public class Employee extends User implements Serializable
{
    protected double salary;

    public Employee(){}

    public Employee(String name, String surname, String login, Type.UserType type, double salary)
    {
        super(name,surname,login,type);
        this.salary = salary;
    }
}