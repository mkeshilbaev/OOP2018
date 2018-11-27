import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class TechSupportGuy extends Employee implements Serializable
{
    public TechSupportGuy(){}

    public TechSupportGuy(String name, String surname, String login, Type.UserType type, double salary)
    {
        super(name,surname,login,type,salary);
    }

    public void ViewOrders()
    {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> orders = Menu.database.getAllOrders();

        for(int i = 0; i < orders.size(); i++)
        {
            System.out.println(i+1 + orders.get(i));
        }

        System.out.println("Enter the number of order");
        int choise = scanner.nextInt();
        scanner.nextLine();

        switch (choise)
        {
            //todo
        }
    }

}