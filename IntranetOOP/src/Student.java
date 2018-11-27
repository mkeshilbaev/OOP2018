import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.*;

public class Student extends User implements Serializable, Comparable<Student>
{
    private String faculty;
    private ArrayList<Course> courses;
    private int year_of_study;
    HashMap<Course,Mark> marks;
    private double GPA;

    public Student(String name, String surname, String login,  String faculty, int year_of_study)
    {
        super(name,surname,login, Type.UserType.STUDENT);
        this.faculty = faculty;
        courses = new ArrayList<Course>();
        marks = new HashMap<>();
        this.year_of_study = year_of_study;
        privilege.add("Register for a course");
        privilege.add("View information about the teacher of specific course");
        privilege.add("View attestation");
        privilege.add("View transcript");
    }

    public void setYear_of_study(int year_of_study) {
        this.year_of_study = year_of_study;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void registerForCourse()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("For which course you want register?");
        ArrayList<Course> courseForRegister = Menu.database.getOpenedForRegistrationCourses(this.year_of_study);

        for(int i = 0; i < courseForRegister.size(); i++)
        {
            System.out.println(i+1 + " " + courseForRegister.get(i).getName() + " credits: " + courseForRegister.get(i).getCredits());
        }
        int choise = scanner.nextInt();
        scanner.nextLine();
        courses.add(Menu.database.getOpenedForRegistrationCourses(this.year_of_study).get(choise-1));
    }

    public void ShowStudentCourses()
    {
        for(int i = 0; i < courses.size(); i++)
        {
            System.out.println(i+1 + " name: " + courses.get(i).getName() + " year of study: "
                    + courses.get(i).getYear_of_study() + " credits: " + courses.get(i).getCredits());
        }
    }

    public void ViewInfoAboutTeacherOfSpecificCourse()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("For which course you want see info about teacher?");

        ShowStudentCourses();
        int choise = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0; i < Menu.database.getAllTeachers().size(); i++)
        {
            for (int j = 0; j < Menu.database.getAllTeachers().get(i).getCourses().size(); j++)
            {
                if (Menu.database.getAllTeachers().get(i).getCourses().get(j).getName().equals(courses.get(choise - 1).getName()))
                {
                    System.out.println("surname: " + Menu.database.getAllTeachers().get(i).getSurname() + " name: " + Menu.database.getAllTeachers().get(i).getName());
                }
            }
        }
    }

    public String getFaculty() {
        return faculty;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public double getFirstAttestationMark(Course course)
    {
        double fAttestation = marks.get(course).getFirstAttestation();
        return fAttestation;
    }

    public double getSecondAttestationMark(Course course)
    {
        double sAttestation = marks.get(course).getSecondAttestation();
        return sAttestation;
    }

    public double getFinalResult(Course course)
    {
        double finalResult = marks.get(course).getFinalExam();
        return finalResult;
    }

    public double getOverall(Course course)
    {
        double overall = marks.get(course).getOverall();
        return overall;
    }

    public void viewAttestation()
    {
        for(int i = 0; i < courses.size(); i++)
        {
            if (marks.containsKey(courses.get(i)))
            {
                double fAttestation = getFirstAttestationMark(courses.get(i));
                double sAttestation = getSecondAttestationMark(courses.get(i));
                double finalAttestation = getFinalResult(courses.get(i));
                double overall = getOverall(courses.get(i));
                System.out.println(courses.get(i).getName() + " " + fAttestation
                        + " " + sAttestation + " " + finalAttestation + " " + overall);
            }
            else
            {
                System.out.println(courses.get(i).getName() + " " + 0.0 + " " + 0.0 + " " + 0.0 + " " + 0.0);
            }
        }
    }

    public void viewTranscript()
    {
        // TODO
        int totalCredits = 0;
        for(int i = 0; i < courses.size(); i++)
        {
            totalCredits += courses.get(i).getCredits();
        }
        for(int i = 0; i < courses.size(); i++)
        {
            if (marks.containsKey(courses.get(i))) {
                marks.get(courses.get(i)).calculate_overall();
                System.out.println(courses.get(i).getName() + " " + marks.get(courses.get(i)).getOverall()
                        + " " + marks.get(courses.get(i)).getSymbol_mark() + " " + marks.get(courses.get(i)).getGpa(totalCredits));
            }
            else
                System.out.println(courses.get(i).getName() + " " + 0.0 + " " + "F" + " " + 0.0);
        }
    }

    public double getGPA() {
        int allCredits = 0;
        double overall = 0.0;

        for(int i = 0; i < courses.size(); i++)
        {
            allCredits += courses.get(i).getCredits();
            overall += getOverall(courses.get(i));
        }
        return (overall*allCredits)/allCredits;
    }

    @Override
    public int compareTo(Student o) {
        return surname.compareTo(o.surname);
    }

    public static final Comparator<Student> GPA_COMPARATOR = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            if(o1.getGPA() > o2.getGPA())
                return 1;
            else if(o1.getGPA() < o2.getGPA())
                return -1;
            else
                return 0;
        }
    };
}