import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Teacher extends Employee implements Serializable , Comparable<Teacher>
{
    private String faculty;
    private Degree degree;
    private ArrayList<Course> courses;

    public Teacher(String name, String surname, String login, Type.UserType type, double salary, String faculty, Degree degree)
    {
        super(name,surname,login,type,salary);
        this.faculty = faculty;
        this.degree = degree;
        courses = new ArrayList<>();
        privilege.add("Add course");
        privilege.add("Add course files");
        privilege.add("Delete course files");
        privilege.add("Put marks");
    }

    public Teacher(String faculty, String name, String surname)
    {
        this.faculty = faculty;
        this.name = name;
        this.surname = surname;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public String getFaculty() {
        return faculty;
    }


    public void AddCourse()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name of course: \n");
        String courseName = scanner.nextLine();
        System.out.println("Enter count of credits: \n");
        int credits = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter year of study");
        int year_of_study = scanner.nextInt();
        scanner.nextLine();
        courses.add(new Course(faculty, courseName, credits, year_of_study));
        Menu.database.getAllCourses().add(new Course(faculty,courseName,credits, year_of_study));
        Menu.database.addCourseFolder(new Teacher(this.faculty, this.name, this.surname), courseName);
    }

    public void AddCourseFile() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("For which object you want upload file?");
        ViewCoursesInfo();
        int choise = scanner.nextInt();
        scanner.nextLine();
        String courseName = courses.get(choise-1).getName();

        System.out.println("Enter file to copy to students files folder:\n");
        List<String> files = Database.ShowTeacherFiles(new Teacher(this.faculty, this.name, this.surname), courseName);
        choise = scanner.nextInt();
        scanner.nextLine();
        String teacherFile = files.get(choise-1);
        Menu.database.AddFilesToCourseFromTeacher(new Teacher(this.faculty, this.name, this.surname), teacherFile, courseName);
    }

    public void DeleteCourseFile() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("For which object you want delete file?");
        ViewCoursesInfo();
        int choise = scanner.nextInt();
        scanner.nextLine();
        String courseName = courses.get(choise-1).getName();

        System.out.println("Enter file to delete file:\n");
        List<String> files = Database.ShowTeacherFiles(new Teacher(this.faculty, this.name, this.surname), courseName);
        choise = scanner.nextInt();
        scanner.nextLine();
        String teacherFile = files.get(choise-1);
        Menu.database.DeleteCourseFiles(new Teacher(this.faculty, this.name, this.surname), teacherFile, courseName);
    }

    public void ShowCoursesInfo()
    {
        ViewCoursesInfo();
    }

    public void ShowStudentsInfo()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please, select course");
        ViewCoursesInfo();

        int choise = scanner.nextInt();
        scanner.nextLine();

        String courseName = courses.get(choise-1).getName();
        ArrayList<Student> students = Menu.database.getAllStudents();

        for(int i = 0; i < students.size(); i++)
        {
            for(int j = 0; j < students.get(i).getCourses().size(); j++)
            {
                if(students.get(i).getCourses().get(j).getName().equals(courseName))
                {
                    System.out.println(i + 1 + " " + students.get(i).getSurname() + " " + getName()); // TODO + MARK
                    // if(students.get(i).marks.get(students.get(i).getCourses().get(j)))
                }
            }
        }
    }

    private void ViewCoursesInfo()
    {
        for(int i = 0; i < courses.size(); i++)
        {
            System.out.println(i+1 + "." + '\t' + courses.get(i).getName() + " " + courses.get(i).getCredits() + " credits" + '\n');
        }
    }

    public void PutMarks()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please, select course");
        ViewCoursesInfo();
        int choise = scanner.nextInt();
        scanner.nextLine();
        String courseName = courses.get(choise-1).getName();
        ArrayList<Student> students = Menu.database.getAllStudents();
        ArrayList<Student> studentsWhoStudyAtSpecificCourse = new ArrayList<Student>();
        int cnt = 0;

        for(int i = 0; i < students.size(); i++)
        {
            for(int j = 0; j < students.get(i).getCourses().size(); j++)
            {
                if (students.get(i).getCourses().get(j).getName().equals(courseName))
                {
                    System.out.println(cnt + 1 + " " + students.get(i).getSurname() + " " + students.get(i).getName()); // TODO + MARK
                    studentsWhoStudyAtSpecificCourse.add(students.get(i));
                }

            }
        }
        System.out.println("Select student to put mark");
        choise = scanner.nextInt();
        scanner.nextLine();
        System.out.println("1.First attestation\n2.Second attestation\n3.Final");
        int attestation = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter mark:");
        double mark = scanner.nextInt();
        scanner.nextLine();
        studentsWhoStudyAtSpecificCourse.get(choise - 1).marks.put(new Course(courseName, Course.getCreditsByNameOfCourse(courseName)), new Mark(mark,attestation));

        //studentsWhoStudyAtSpecificCourse.get(choise-1).marks.
    }
    @Override
    public int compareTo(Teacher o) {
        return surname.compareTo(o.surname);
    }

}