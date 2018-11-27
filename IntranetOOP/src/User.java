import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class User implements Serializable
{
    protected String name;
    protected String surname;
    protected String login;
    protected String password;
    protected ArrayList<String> privilege;
    protected Type.UserType type;

    public User()
    {
        privilege = new ArrayList<String>();
        privilege.add("Quit");
        privilege.add("Change Password");
        password = "123456";
    }

    public User(String name, String surname, String login, Type.UserType type)
    {
        this();
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.type = type;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void ShowPrivilege()
    {
        for(int i = 0; i < privilege.size(); i++)
        {
            System.out.println(i  + " " + privilege.get(i));
        }
    }

    public boolean ChangePassword()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter old password:");
        String oldPassword = scanner.nextLine();
        if(oldPassword.equals(password))
        {
            System.out.println("Enter new password:");
            String newPassword = scanner.nextLine();
            setPassword(newPassword);
            return true;
        }
        System.out.println("No correct old password\n");
        return false;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
