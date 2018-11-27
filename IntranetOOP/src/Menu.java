import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu implements Serializable
{
    static public Database database = new Database();

    public void Start() throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);

        try(ObjectInputStream in =  new ObjectInputStream (new FileInputStream
                ("C:\\Users\\mkesh\\Desktop\\OOP2018\\IntranetOOP\\objects.dat")))
        {
            database = (Database)in.readObject();
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }

        for(int i = 0; i < database.getAllTeachers().size(); i++)
        {
            System.out.println(database.getAllTeachers().get(i).getLogin() + " " + database.getAllTeachers().get(i).getPassword());
        }
        int choise = -1;

       menu:while(choise != 0)
        {
            System.out.println("0. Quit");
            System.out.println("1. Authorization");
            choise = scanner.nextInt();
            scanner.nextLine();
            if(choise == 1)
            {
                Authorization();
            }
        }
    }

    public void Authorization() throws IOException {
        Scanner scanner = new Scanner(System.in);

        int choise = -1;
        while (true)
        {
            System.out.println("Login:");
            String login = scanner.nextLine();
            System.out.println("Password:");
            String password = scanner.nextLine();

            Type.UserType type = Type.GetTypeByLogin(login);

            if (type != null && database.Authentication(type, login, password))
            {
                run(login, type);
            }
            else
            {
                System.out.println("No correct password/login\n0. Quit\n1. Re-enter");
                choise = scanner.nextInt();
                scanner.nextLine();
                if(choise == 1)
                    Authorization();

            }
        }
    }

    public void run(String login, Type.UserType type) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int choise = -1;
        User user = database.GetUserByLogin(login);
        while (choise != 0)
        {
            System.out.println("Hello " + user.surname + " " + user.name + ", please select functions by enter a number from list of functions");
            switch (type)
            {
                case ADMIN:
                    user.ShowPrivilege();
                    break;
                case STUDENT:
                    user.ShowPrivilege();
                    break;
                case TEACHER:
                    user.ShowPrivilege();
                    break;
                case MANAGER:
                    user.ShowPrivilege();
                    break;
            }
            choise = scanner.nextInt();

            scanner.nextLine();
            switch (type)
            {
                case ADMIN:
                    runAdmin(user, choise);
                    break;
                case STUDENT:
                    runStudent(user, choise);
                    break;
                case TEACHER:
                    runTeacher(user, choise);
                    break;
                case MANAGER:
                    runManager(user, choise);
                    break;
            }
        }
        if(choise == 0)
        {
            //database.save();
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("C:\\Users\\mkesh\\Desktop\\OOP2018\\IntranetOOP\\objects.dat"));
            ){
                out.writeObject(database);
            }
            catch(Exception ex){

                System.out.println(ex.getMessage());
            }
            System.exit(0);
            // TODO save();
        }
    }

    private void runManager(User user, int choise) throws IOException {
        Scanner scanner = new Scanner(System.in);

        user = (Manager)user;
        while (choise != 0)
        {
            switch (choise)
            {
                case 1:
                    while (choise != 0)
                    {
                        if(!user.ChangePassword())
                        {
                            System.out.println("0. Quit\n1. Re-Change password");
                            choise = scanner.nextInt();
                            scanner.nextLine();
                        }
                    }
                    break;

                case 2:
                    ((Manager) user).AddCourseForRegistration();
                    choise = 0;
                    break;
                case 3:
                    ((Manager) user).InfoAboutTeachers();
                    choise = 0;
                    break;
                case 4:
                    ((Manager) user).InfoAboutStudents();
                    choise = 0;
                    break;
            }
        }
    }

    private void runTeacher(User user, int choise) throws IOException {
        Scanner scanner = new Scanner(System.in);

        user = (Teacher)user;
        while (choise != 0)
        {
            switch (choise)
            {
                case 1:
                    while (choise != 0)
                    {
                        if(!user.ChangePassword())
                        {
                            System.out.println("0. Quit\n1. Re-Change password");
                            choise = scanner.nextInt();
                            scanner.nextLine();
                        }
                    }
                    break;

                case 2:
                    ((Teacher) user).AddCourse();
                    choise = 0;
                    break;
                case 3:
                    ((Teacher) user).AddCourseFile();
                    choise = 0;
                    break;
                case 4:
                    ((Teacher) user).DeleteCourseFile();
                    choise = 0;
                    break;
                case 5:
                    ((Teacher) user).PutMarks();
                    choise = 0;
                    break;
            }
        }
    }

    private void runStudent(User user, int choise)
    {
        Scanner scanner = new Scanner(System.in);

        user = (Student)user;
        while (choise != 0)
        {
            switch (choise)
            {
                case 1:
                    while (choise != 0)
                    {
                        if(!user.ChangePassword())
                        {
                            System.out.println("0. Quit\n1. Re-Change password");
                            choise = scanner.nextInt();
                            scanner.nextLine();
                        }
                    }
                    break;

                case 2:
                    ((Student) user).registerForCourse();
                    choise = 0;
                    break;
                case 3:
                    ((Student) user).ViewInfoAboutTeacherOfSpecificCourse();
                    choise = 0;
                    break;
                case 4:
                    ((Student) user).viewAttestation();
                    choise = 0;
                    break;
                case 5:
                    ((Student) user).viewTranscript();
                    choise = 0;
                    break;
            }
        }
    }

    private void runAdmin(User user, int choise) throws IOException {
        Scanner scanner = new Scanner(System.in);

        user = (Admin)user;
        while (choise != 0)
        {
            switch (choise)
            {
                case 1:
                    while (choise != 0)
                    {
                        if(!user.ChangePassword())
                        {
                            System.out.println("0. Quit\n1. Re-Change password");
                            choise = scanner.nextInt();
                            scanner.nextLine();
                        }
                        else
                            choise = 0;
                    }
                    break;

                case 2:
                    ((Admin) user).AddUser();
                    choise = 0;
                    break;
                case 3:
                    ((Admin) user).RemoveUser();
                    choise = 0;
                    break;
                case 4:
                    ((Admin) user).UpdateInfoUser();
                    choise = 0;
                    break;
                case 5:
                    // TODO LOG FILES
                    break;
            }
        }
    }
}