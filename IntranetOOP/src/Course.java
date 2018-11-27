import java.io.Serializable;

public class Course implements Serializable
{
    private String faculty;
    private String name;
    private int credits;
    private int year_of_study;
    private boolean isRegistrationOpen;

    public Course(String faculty, String name, int credits)
    {
        this.faculty = faculty;
        this.name = name;
        this.credits = credits;
        isRegistrationOpen = false;
    }

    public Course(String faculty, String name, int credits, int year_of_study)
    {
        this.faculty = faculty;
        this.name = name;
        this.credits = credits;
        this.year_of_study = year_of_study;
        isRegistrationOpen = false;
    }

    public Course(String name, int credits)
    {
        this.faculty = faculty;
        this.name = name;
        this.credits = credits;
        isRegistrationOpen = false;
    }

    static public int getCreditsByNameOfCourse(String courseName)
    {
        for(int i = 0; i < Menu.database.getAllCourses().size(); i++)
        {
            if(Menu.database.getAllCourses().get(i).getName().equals(courseName))
                return Menu.database.getAllCourses().get(i).getCredits();
        }
        return 0;
    }

    public void setRegistrationOpen(boolean registrationOpen) {
        isRegistrationOpen = registrationOpen;
    }

    public boolean getisRegistrationOpen()
    {
        return isRegistrationOpen;
    }
    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public String getFaculty() {
        return faculty;
    }

    public int getYear_of_study() {
        return year_of_study;
    }

    @Override
    public boolean equals(Object obj)
    {
        Course c = (Course)obj;
        if(this.name.equals(c.name))
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}