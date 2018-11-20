package Task2;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

public class Course implements Serializable {
    private String courseTitle;
    private Textbook textbook;
    private Instructor instructor;

    public Course(String courseTitle, Textbook textbook, Instructor instructor){
        this.courseTitle = courseTitle;
        this.textbook = textbook;
        this.instructor = instructor;
    }

    public void setCourseTitle(String courseTitle){
        this.courseTitle = courseTitle;
    }

    public String getCourseTitle(){
        return courseTitle;
    }

    @Override
    public boolean equals(Object obj){
        if (this.getClass() != obj.getClass() || obj == null)
            return false;

        Course c = (Course) obj;
        if (c.courseTitle.equals(courseTitle))
            return true;
        return false;
    }

    @Override
    public String toString(){
        return courseTitle;
    }

    public void serialize(Vector<Course> v) {
        try {
            FileOutputStream foi = new FileOutputStream("courses.out");
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
