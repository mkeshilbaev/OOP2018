import javax.print.DocFlavor;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public class Admin extends Employee implements Serializable
{
    public Admin()
    {
        login = "KARZHAS";
        name = "Karzhas";
        surname = "Tokbolatov";

        privilege.add("Add User");
        privilege.add("Remove User");
        privilege.add("Update info about the user");
        privilege.add("See log files about user's actions");

        password = "111";
    }

    public void AddUser()
    {
        Scanner scanner = new Scanner(System.in);
        String name,surname,login, faculty;
        Type.UserType type;
        System.out.println("Enter name:\n");
        name = scanner.nextLine();

        while(!ValidData.ValidName(name))
        {
            System.out.println("Not valid name, please input new name\n");
            name = scanner.nextLine();
        }

        System.out.println("\nEnter surname:");
        surname = scanner.nextLine();

        while(!ValidData.ValidName(surname))
        {
            System.out.println("Not valid surname, please input new surname\n");
            surname = scanner.nextLine();
        }
        System.out.println("Enter type (1. Teacher\t2. Student\t3.Manager\n");
        int typeINT = scanner.nextInt();
        scanner.nextLine();

        switch (typeINT)
        {
            case 1:
                type = Type.UserType.TEACHER;
                break;
            case 2:
                type = Type.UserType.STUDENT;
                break;
            case 3:
                type = Type.UserType.MANAGER;
                break;
            default:
                type = Type.UserType.STUDENT;
                break;
        }
        char symbolType = Type.GetSymbolByType(type);
        login = "" + name.charAt(0) + symbolType + surname;

        switch (type)
        {
            case STUDENT:
                System.out.println("Enter faculty: ");
                faculty = scanner.nextLine();
                System.out.println("Enter year of study");
                int year_of_study = scanner.nextInt();
                scanner.nextLine();
                Menu.database.addStudent(new Student(name,surname,login,faculty, year_of_study));
                break;

            case TEACHER:
                System.out.println("Enter faculty: ");
                faculty = scanner.nextLine();
                System.out.println("Enter degree of teacher");
                System.out.println("1.Tutor\n2.Lector\n3.Senior Lector\n4.Professor");
                int choise = scanner.nextInt();
                scanner.nextLine();
                Degree degree = Degree.LECTOR;

                switch (choise)
                {
                    case 1:
                        degree = Degree.TUTOR;
                        break;
                    case 2:
                        degree = Degree.LECTOR;
                        break;
                    case 3:
                        degree = Degree.SENIOR_LECTOR;
                        break;
                    case 4:
                        degree = Degree.PROFESSOR;
                        break;
                }
                //TUTOR, LECTOR, SENIOR_LECTOR, PROFESSOR;
                Menu.database.addTeacher(new Teacher(name,surname, login, Type.UserType.TEACHER, 0.0, faculty, degree));
                Menu.database.addTeacherFolder(new Teacher(faculty, name, surname));

                break;
            case MANAGER:
                Menu.database.addManager(new Manager(name, surname, login, Type.UserType.MANAGER, 0.0));
                break;
        }
        System.out.println("User " + name + " " + surname + " added succesfully!");

    }
    public void RemoveUser() throws IOException
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter login\n");
        String login = scanner.nextLine();
        boolean success = false;
        Type.UserType type = Type.GetTypeByLogin(login);

        if(type != null)
        {
            switch (type) {
                case STUDENT:
                    if(Menu.database.findStudentByLogin(login) != null)
                    {
                        if (Menu.database.removeStudent(login))
                            success = true;
                    }
                    break;
                case TEACHER:
                    if(Menu.database.findTeacherByLogin(login) != null)
                    {
                        if (Menu.database.removeTeacher(Menu.database.findTeacherByLogin(login)))
                            success = true;
                        break;
                    }
                case MANAGER:
                    if(Menu.database.findManagerByLogin(login) != null)
                    {
                        if (Menu.database.removeManager(Menu.database.findManagerByLogin(login)))
                            success = true;
                    }
                    break;
            }
        }
        if(success)
        {
            System.out.println("User with login: " + login + " successfully deleted from database");
        }
        else
        {
            System.out.println("No such login:" + login + " in database ");
        }
    }

    public void UpdateInfoUser()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter login\n");
        String login = scanner.nextLine();
        Type.UserType type = Type.GetTypeByLogin(login);
        if(type != null) {
            switch (type) {
                case STUDENT:
                    StudentInfoUpdate(login);
                    break;
                case TEACHER:
                    TeacherInfoUpdate();
                    // TODO
                    break;
                case MANAGER:
                    ManagerInfoUpdate();
                    // TODO
                    break;
            }
        }
        else
        {
            System.out.println("No such login: " + login + " in database");
        }
    }
    private void StudentInfoUpdate(String login)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1.Change name\n2.Change surname\n3.Change faculty"); // TODO
        int choise = scanner.nextInt();
        scanner.nextLine();
        Student student= Menu.database.findStudentByLogin(login);
        boolean success = false;
        if(student!= null)
        {
            switch (choise)
            {
                case 1:
                    System.out.println("Enter new name");
                    String newName = scanner.nextLine();
                    student.setName(newName);
                    student.setLogin(newName + "_" + student.surname);
                    break;
                case 2:
                    System.out.println("Enter new surname");
                    String newSurname = scanner.nextLine();
                    student.setSurname(newSurname);
                    student.setLogin(student.name + "_" + newSurname);
                    break;
                case 3:
                    System.out.println("Enter new faculty\n1.FIT\n2.ISE\n3.MKM\n4.BS\n5.FEOGI");
                    int newFaculty = scanner.nextInt();
                    scanner.nextLine();
                    switch (newFaculty)
                    {
                        case 1:
                            student.setFaculty("FIT");
                            break;
                        case 2:
                            student.setFaculty("ISE");
                            break;
                        case 3:
                            student.setFaculty("MKM");
                            break;
                        case 4:
                            student.setFaculty("BS");
                            break;
                        case 5:
                            student.setFaculty("FEOGI");
                            break;
                    }
            }
            success = true;
        }
        if(success)
        {
            System.out.println("Info about " + student.surname + " " + student.name + " successfully updated" );
        }
        else
        {
            System.out.println("No such student in Database");
        }
    }

    private void TeacherInfoUpdate()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1.Change name\n2.Change surname\n3.Change degree of teacher"); // TODO
        int choise = scanner.nextInt();
        scanner.nextLine();
        Teacher teacher = Menu.database.findTeacherByLogin(login);
        boolean success = false;
        if(teacher!= null)
        {
            switch (choise)
            {
                case 1:
                    System.out.println("Enter new name");
                    String newName = scanner.nextLine();
                    teacher.setName(newName);
                    teacher.setLogin(newName + "_" + teacher.surname);
                    break;
                case 2:
                    System.out.println("Enter new surname");
                    String newSurname = scanner.nextLine();
                    teacher.setSurname(newSurname);
                    teacher.setLogin(teacher.name + "_" + newSurname);
                    break;
                case 3:
                    // TUTOR, LECTOR, SENIOR_LECTOR, PROFESSOR;
                    System.out.println("Enter new degree\n1.TUTOR\n2.LECTOR\n3.SENIOR LECTOR\n4.PROFESSOR");
                    int newDegreeint = scanner.nextInt();
                    scanner.nextLine();
                    Degree newDegree = null;
                    scanner.nextLine();
                    switch (newDegreeint)
                    {
                        case 1:
                            newDegree = Degree.TUTOR;
                            break;
                        case 2:
                            newDegree = Degree.LECTOR;
                            break;
                        case 3:
                            newDegree = Degree.SENIOR_LECTOR;
                            break;
                        case 4:
                            newDegree = Degree.PROFESSOR;
                            break;
                    }
                    teacher.setDegree(newDegree);
            }
            success = true;
        }
        if(success)
        {
            System.out.println("Info about " + teacher.surname + " " + teacher.name + " successfully updated" );
        }
        else
        {
            System.out.println("No such teacher in Database");
        }

    } // TODO
    private void ManagerInfoUpdate()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1.Change name\n2.Change surname"); // TODO
        int choise = scanner.nextInt();
        scanner.nextLine();
        Manager manager = Menu.database.findManagerByLogin(login);
        boolean success = false;
        if(manager!= null)
        {
            switch (choise)
            {
                case 1:
                    System.out.println("Enter new name");
                    String newName = scanner.nextLine();
                    manager.setName(newName);
                    manager.setLogin(newName + "_" + manager.surname);
                    break;
                case 2:
                    System.out.println("Enter new surname");
                    String newSurname = scanner.nextLine();
                    manager.setSurname(newSurname);
                    manager.setLogin(manager.name + "_" + newSurname);
                    break;
            }
            success = true;
        }
        if(success)
        {
            System.out.println("Info about " + manager.surname + " " + manager.name + " successfully updated" );
        }
        else
        {
            System.out.println("No such manager in Database");
        }
    }
}