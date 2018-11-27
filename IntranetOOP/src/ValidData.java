import java.io.Serializable;

public class ValidData implements Serializable
{
    private static boolean isHaveDigits(String text)
    {
        for(int i = 0; i < text.length(); i++)
        {
            if(text.charAt(i) >= '0' && text.charAt(i) <= '9')
                return true;
        }
        return false;
    }

    private static boolean isHaveSpace(String text)
    {
        for(int i = 0; i < text.length(); i++)
        {
            if(text.charAt(i) == ' ')
                return true;
        }
        return false;

    }

    public static boolean ValidLogin(String login)
    {
        if(!(login.contains("_") || login.contains("#") || login.contains(".")))
            return false;
        if(isHaveSpace(login))
            return false;
        if(isHaveDigits(login))
            return false;
        return true;
    }

    public static boolean ValidName(String name)
    {
        if(isHaveDigits(name))
            return false;
        if(isHaveSpace(name))
            return false;
        return true;
    }
}