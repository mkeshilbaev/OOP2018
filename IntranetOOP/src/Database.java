import java.io.*;
import java.nio.file.Files;
import java.util.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Database implements Serializable
{
    transient Scanner scanner = new Scanner(System.in);
    public ArrayList<Student> students;
    public ArrayList<Teacher> teachers;
    public ArrayList<Manager> managers;
    public ArrayList<File> files;
    public ArrayList<Course> courses;
    public ArrayList<String> orders;
    public ArrayList<User> users;
    public Admin admin;

    public Database()
    {
        students = new ArrayList<Student>();
        teachers = new ArrayList<Teacher>();
        managers = new ArrayList<Manager>();
        files = new ArrayList<File>();
        courses = new ArrayList<Course>();
        users = new ArrayList<User>();
        admin = new Admin();
        users.add(admin);
    }

    public  Admin getAdmin() {
        return admin;
    }

    public void save() throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream
                ("C:\\Users\\mkesh\\Desktop\\OOP2018\\IntranetOOP\\objects.dat"));
        ){
            out.writeObject(students);
            out.writeObject(teachers);
            out.writeObject(managers);
            out.writeObject(files);
            out.writeObject(courses);
            out.writeObject(orders);
            out.writeObject(users);
            out.writeObject(admin);
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }

    public void addStudent(Student student)
    {
        students.add(student);
        users.add(student);
    }

    public ArrayList<Course> getOpenedForRegistrationCourses(int year_of_study)
    {
        ArrayList<Course> openedCoursers = new ArrayList<>();
        for(int i = 0; i < courses.size(); i++)
        {
            if(courses.get(i).getisRegistrationOpen() && courses.get(i).getYear_of_study() == year_of_study)
                openedCoursers.add(courses.get(i));
        }
        return openedCoursers;
    }

    public void addTeacher(Teacher teacher)
    {
        teachers.add(teacher);
        users.add(teacher);
    }

    public void addManager(Manager manager)
    {
        managers.add(manager);
        users.add(manager);
    }

    public void addCourseFolder(Teacher teacher, String courseName)
    {
        //FileWorkerJava.createFolder("D:\\KBTU\\OOP\\intranet\\Files\\TeacherFiles\\" + faculty + "\\" + teacherName);
        FileWorkerJava.createFolder("C:\\Users\\mkesh\\Desktop\\OOP2018\\IntranetOOP\\Files\\TeacherFiles\\"
                + teacher.getFaculty() + "\\" + teacher.getName() + "_" + teacher.getSurname() + "\\" + courseName);
        FileWorkerJava.createFolder("C:\\Users\\mkesh\\Desktop\\OOP2018\\IntranetOOP\\Files\\StudentFiles\\"
                + teacher.getFaculty() + "\\" + teacher.getName() + "_" + teacher.getSurname() + "\\" + courseName);

    }

    public void addTeacherFolder(Teacher teacher)
    {
        Path path = Paths.get("C:\\Users\\mkesh\\Desktop\\OOP2018\\IntranetOOP\\Files\\TeacherFiles\\" + teacher.getFaculty());
        if(!Files.exists(path))
            FileWorkerJava.createFolder(path.toString());
        FileWorkerJava.createFolder("C:\\Users\\mkesh\\Desktop\\OOP2018\\IntranetOOP\\Files\\TeacherFiles\\" + teacher.getFaculty()
                + "\\" + teacher.getName() + "_" + teacher.getSurname());

        path = Paths.get("C:\\Users\\mkesh\\Desktop\\OOP2018\\IntranetOOP\\Files\\StudentFiles\\" + teacher.getFaculty());
        if(!Files.exists(path))
            FileWorkerJava.createFolder(path.toString());

        path = Paths.get("C:\\Users\\mkesh\\Desktop\\OOP2018\\IntranetOOP\\Files\\StudentFiles\\" + teacher.getFaculty() + "\\"
                + teacher.getName() + "_" + teacher.getSurname());
        if(!Files.exists(path))
            FileWorkerJava.createFolder(path.toString());
        FileWorkerJava.createFolder(path.toString());
    }

    public boolean removeStudent(String login)
    {
        if(findStudentByLogin(login) != null)
        {
            students.remove(findStudentByLogin(login));
            users.remove(findStudentByLogin(login));
            return true;
        }
        return false;
    }

    public Student findStudentByLogin(String login)
    {
        for(int i = 0; i < students.size(); i++)
        {
            if(students.get(i).getLogin().equals(login))
            {
                return students.get(i);
            }
        }
        return null;
    }

    public Manager findManagerByLogin(String login)
    {
        for(int i = 0; i < managers.size(); i++)
        {
            if(managers.get(i).getLogin().equals(login))
            {
                return managers.get(i);
            }
        }
        return null;
    }

    public Teacher findTeacherByLogin(String login)
    {
        for(int i = 0; i < teachers.size(); i++)
        {
            if(teachers.get(i).getLogin().equals(login))
            {
                return teachers.get(i);
            }
        }
        return null;
    }

    public ArrayList<Student> getAllStudents()
    {
        return students;
    }
    public ArrayList<Teacher> getAllTeachers()
    {
        return teachers;
    }
    public ArrayList<Course> getAllCourses()
    {
        return courses;
    }

    public static List<String> ShowTeacherFiles(Teacher teacher, String courseName)
    {
        return FileWorkerJava.showFilesInDir("C:\\Users\\mkesh\\Desktop\\OOP2018\\IntranetOOP\\Files\\TeacherFiles\\"
                + teacher.getFaculty() + "\\" + teacher.getName() + "_" + teacher.getSurname() + "\\" + courseName);
    }

    public  void AddFilesToCourseFromTeacher(Teacher teacher, String teacherFile, String courseName) throws IOException {
        String teacherDir = "C:\\Users\\mkesh\\Desktop\\OOP2018\\IntranetOOP\\Files\\TeacherFiles\\"
                + teacher.getFaculty() + "\\" + teacher.getName() + "_" + teacher.getSurname()+ "\\" + courseName + "\\";
        String studentDir = "C:\\Users\\mkesh\\Desktop\\OOP2018\\IntranetOOP\\Files\\TeacherFiles\\"
                + teacher.getFaculty() + "\\" + teacher.getName() + "_" + teacher.getSurname() + "\\" + courseName + "\\";
        FileWorkerJava.moveFile(teacherDir+teacherFile, studentDir + teacherFile);
    }

    public  void DeleteCourseFiles(Teacher teacher, String teacherFile, String courseName)
    {
        if(FileWorkerJava.deleteFile("C:\\Users\\mkesh\\Desktop\\OOP2018\\IntranetOOP\\Files\\TeacherFiles\\"
                + teacher.getFaculty() + "\\" + teacher.getName() + "_" + teacher.getSurname() + "\\" + courseName + "\\" + teacherFile) &&
                FileWorkerJava.deleteFile("C:\\Users\\mkesh\\Desktop\\OOP2018\\IntranetOOP\\Files\\StudentFiles\\"
                        + teacher.getFaculty() + "\\" + teacher.getName() + "_" + teacher.getSurname() + "\\" + courseName + "\\" + teacherFile))
            System.out.println("File deleted");
        else
            System.out.println("NO file in directory");
    }

    public  void showFacultyCourses(String faculty)
    {
        for(int i = 0; i < courses.size(); i++)
        {
            if(courses.get(i).getFaculty().equals(faculty))
            {
                System.out.println(i+1 + " " + courses.get(i).getName() + courses.get(i).getCredits() + " credits");
            }
        }
    }

    public  void ShowFacultyTeacher(String faculty)
    {
        for(int i = 0; i < teachers.size(); i++)
        {
            if(teachers.get(i).getFaculty().equals(faculty))
            {
                System.out.println(i+1 + " " + teachers.get(i).getName() + " " +  teachers.get(i).getSurname());
            }
        }
    }

    public  void ShowTeachersByCourse(Course course)
    {
        for(Teacher t : teachers)
        {
            for(int i = 0; i < t.getCourses().size(); i++)
            {
                if (t.getCourses().get(i).getName().equals(course.getName()))
                    System.out.println(t.surname + " " + t.name);
            }
        }
    }

    public  void ShowTeachersByAlphOrder()
    {
        ArrayList<Teacher> teachersByAlphOrder = teachers;
        Collections.sort(teachersByAlphOrder);
        for(Teacher t : teachersByAlphOrder)
        {
            System.out.println(t.surname + " " + t.name + " " + t.getFaculty());
        }
    }

    public  ArrayList<String> getAllOrders()
    {
        return orders;
    }

    public  boolean removeTeacher(Teacher teacher) throws IOException {
        if(findTeacherByLogin(teacher.getLogin())!= null)
        {
            FileWorkerJava.deleteDirectory("C:\\Users\\mkesh\\Desktop\\OOP2018\\IntranetOOP\\"
                    + teacher.getFaculty() + "\\" + teacher.getName() + "_" + teacher.getSurname() );
            FileWorkerJava.deleteDirectory("C:\\Users\\mkesh\\Desktop\\OOP2018\\IntranetOOP\\"
                    + teacher.getFaculty() + "\\" + teacher.getName() + "_" + teacher.getSurname() );

            teachers.remove(findTeacherByLogin(teacher.getLogin()));

            return true;
        }
        return false;
    }

    public  boolean Authentication(Type.UserType type, String login, String password)
    {
        switch (type)
        {
            case TEACHER:
                if(findTeacherByLogin(login).getPassword().equals(password))
                    return true;
                else
                    return false;

            case MANAGER:
                if(findManagerByLogin(login).getPassword().equals(password))
                    return true;
                else
                    return false;

            case STUDENT:
                if(findStudentByLogin(login).getPassword().equals(password))
                    return true;
                else
                    return false;

            case ADMIN:
                if(login.equals(admin.getLogin()) && password.equals(admin.getPassword()))
                    return true;
                else
                    return false;
        }
        return false;
    }

    public  User GetUserByLogin(String login)
    {
        for(User user : users)
        {
            if(user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    public  boolean removeManager(Manager manager)
    {
        if(findManagerByLogin(manager.getLogin()) != null)
        {
            managers.remove(findManagerByLogin(manager.getLogin()));
            users.remove(findManagerByLogin(manager.getLogin()));
            return true;
        }
        return false;
    }

    public void ShowStudentsByAlphOrder()
    {
        ArrayList<Student> studentsByAlphOrder = students;
        Collections.sort(studentsByAlphOrder);
        for(Student s : studentsByAlphOrder)
        {
            System.out.println(s.surname + " " + s.name + " " + s.getFaculty());
        }
    }

    public void ShowStudentByGPA()
    {
        ArrayList<Student> studentsByGPA = students;
        Collections.sort(studentsByGPA, Student.GPA_COMPARATOR);
        for(Student s : studentsByGPA)
        {
            System.out.println(s.surname + " " + s.name + " " + s.getGPA());
        }
    }
}