import java.io.Serializable;

public class Type implements Serializable
{
    public enum UserType
    {
        TEACHER, STUDENT, MANAGER, ADMIN;
    }

    static public char GetSymbolByType(UserType userType)
    {
        if(userType == UserType.TEACHER)
            return '.';
        else if(userType == UserType.STUDENT)
            return '_';
        else
            return '#';
    }

    static public UserType GetTypeByLogin(String login)
    {
        if(login.equals("KARZHAS"))
            return UserType.ADMIN;
        else if(login.contains("."))
            return UserType.TEACHER;
        else if(login.contains("_"))
            return UserType.STUDENT;
        else if(login.contains("#"))
            return UserType.MANAGER;
        else
            return null;
    }
}