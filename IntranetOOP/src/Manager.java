import java.io.Serializable;
import java.sql.DataTruncation;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager extends Employee implements Serializable
{
    public Manager(){}

    public Manager(String name, String surname, String login, Type.UserType type, double salary)
    {
        super(name,surname,login,type,salary);
        privilege.add("Add course for registration");
        privilege.add("View info about teachers");
        privilege.add("View info about students");
    }

    public void AddCourseForRegistration()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose faculty\n1.FIT\n2.FEOGI\n3.ISE\n4.MKM\n5.BS");
        int choise = scanner.nextInt();
        scanner.nextLine();
        String faculty = "";
        switch (choise)
        {
            case 1:
                faculty = "FIT";
                break;
            case 2:
                faculty = "FEOGI";
                break;
            case 3:
                faculty = "ISE";
                break;
            case 4:
                faculty = "MKM";
                break;
            case 5:
                faculty = "BS";
                break;
        }
        System.out.println("Enter year of study:");
        int year_of_study = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Course> courses = Menu.database.getAllCourses();
        for(int i = 0; i < courses.size(); i++)
        {
            if(courses.get(i).getFaculty().equals(faculty) && courses.get(i).getYear_of_study() == year_of_study)
            {
                System.out.println(i+1  + " " + courses.get(i).getName());

            }
        }
        System.out.println("Choose course name to open for register");
        choise = scanner.nextInt();
        scanner.nextLine();
        courses.get(choise-1).setRegistrationOpen(true);
    }

    public void InfoAboutTeachers()
    {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Teacher> teachers = Menu.database.getAllTeachers();
        System.out.println("1. Sort by alphabetical order\n2.Teachers of specific faculty\n3.Teachers of specific course");
        int choise = scanner.nextInt();
        scanner.nextLine();
        switch (choise)
        {
            case 1:
                Menu.database.ShowTeachersByAlphOrder();
                break;
            case 2:
                String faculty = getFaculty();
                Menu.database.ShowFacultyTeacher(faculty);
                break;
            case 3:
                System.out.println("For which course you want see teachers?");
                for(int i = 0; i < Menu.database.getAllCourses().size(); i++)
                {
                    System.out.println(Menu.database.getAllCourses().get(i).getName());
                }
                choise = scanner.nextInt();
                scanner.nextLine();
                Menu.database.ShowTeachersByCourse(Menu.database.getAllCourses().get(choise-1));
                break;
        }
    }

    public void InfoAboutStudents()
    {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Student> students = Menu.database.getAllStudents();
        System.out.println("1. Sort by alphabetical order\n2.Sort by GPA");
        int choise = scanner.nextInt();
        scanner.nextLine();
        switch (choise)
        {
            case 1:
                Menu.database.ShowStudentsByAlphOrder();
                break;
            case 2:
                Menu.database.ShowStudentByGPA();
                break;
        }
    }

    private String getFaculty()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter faculty:\n1.FIT\n2.FEOGI\n3.ISE\n4.MKM\n5.BS");
        int choise = scanner.nextInt();
        scanner.nextLine();
        String faculty = "";
        switch (choise)
        {
            case 1:
                faculty = "FIT";
                break;
            case 2:
                faculty = "FEOGI";
                break;
            case 3:
                faculty = "ISE";
                break;
            case 4:
                faculty = "MKM";
                break;
            case 5:
                faculty = "BS";
        }
        return faculty;
    }
}