import java.io.*;
import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileWorkerJava implements Serializable
{
    public static void createFolder(String path)
    {
        File file = new File(path);
        if (!file.exists())
        {
            try
            {
                file.mkdir();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    public static List<String> showFilesInDir(String path)
    {
        List<String> results = new ArrayList<String>();

        File[] files = new File(path).listFiles();

        for (File file : files)
        {
            if (file.isFile())
            {
                results.add(file.getName());
            }
        }
        for(int i = 0; i < results.size(); i++)
        {
            System.out.println(i+1 + "." + '\t' + results.get(i));

        }
        return results;
    }

    public static void moveFile(String sourcePath, String destination_dir) throws IOException
    {
        if(!new File(destination_dir).exists())
            Files.copy(new File(sourcePath).toPath(), new File(destination_dir).toPath());
        else
            System.out.println("File already exist");
    }

    public static boolean deleteFile(String path)
    {
        File file = new File(path);
        if(file.delete())
            return true;
        else
            return false;
    }

    public static void deleteDirectory(String path) throws IOException
    {
        File element = new File(path);
        if (element.isDirectory()) {
            for (File sub : element.listFiles()) {
                deleteDirectory(sub.toString());
            }
        }
        element.delete();
    }
}