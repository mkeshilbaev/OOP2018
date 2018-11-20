package Task1;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Student {
    private static String name;
    private static int score;

    TreeMap<String, Integer> tree = new TreeMap<>();
    TreeMap<String, String> map = new TreeMap<>();

    Student(String name, int score){
        this.name = name;
        this.score = score;
        tree.put(name, score);
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }

    private int findMax() {
        return Collections.max(tree.values());
    }

    public void getGrade(){

        if(findMax() - 10 <= score) {
            map.put(name, "A");
        }
        else if(findMax() - 20 <= score) {
            map.put(name, "B");
        }
        else if(findMax() - 30 <= score) {
            map.put(name, "C");
        }
        else if(findMax() - 40 <= score) {
            map.put(name, "D");
        }
        else map.put(name, "F");
    }

    @Override
    public String toString() {
        String s = "";
        for (Map.Entry<String, String> entry : map.entrySet())
        {
            s += entry.getKey() + " " + entry.getValue() + "\n";
        }
        return s;
    }
}