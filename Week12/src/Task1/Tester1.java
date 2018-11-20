package Task1;
import java.io.BufferedReader;
import java.io.*;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Tester1{

    private static String InputFileName = "scores.txt";
    private static String OutputFileName = "grades.txt";
    private static String name, score;
    private static int sc;
    private static StringTokenizer tokenizer;
    private static TreeMap<String,Integer> map = new TreeMap<>();
    private static TreeMap<String,String> tree = new TreeMap<>();
    private static int maxi = 0, cnt = 1;

    public static void main(String[] args) {

        try {
            FileReader inputFile = new FileReader(InputFileName);
            FileWriter outputFile = new FileWriter(OutputFileName);

            BufferedReader in = new BufferedReader(inputFile);
            BufferedWriter out = new BufferedWriter(outputFile);

            String line = in.readLine();

            while (line != null) {
                tokenizer = new StringTokenizer(line, " ", false);
                name   = tokenizer.nextToken();
                score = tokenizer.nextToken();
                sc = Integer.parseInt(score);

                map.put(name, sc);
                line = in.readLine();
            }
            maxi = Collections.max(map.values());

            for(Map.Entry<String, Integer> entry: map.entrySet()) {
                int eachEntry = entry.getValue();

                if(maxi - 10 <= eachEntry) {
                    tree.put(entry.getKey(), "A");
                }
                else if(maxi - 20 <= eachEntry) {
                    tree.put(entry.getKey(), "B");
                }
                else if(maxi - 30 <= eachEntry) {
                    tree.put(entry.getKey(), "C");
                }
                else if(maxi - 40 <=eachEntry) {
                    tree.put(entry.getKey(), "D");
                }
                else tree.put(entry.getKey(), "F");
            }

            for (Map.Entry<String, String> entry : tree.entrySet())
            {
                out.write(cnt + ") " + entry.getKey() + " - " + "'" + entry.getValue() + "'");
                out.newLine();
                cnt++;
            }
            in.close();
            out.close();

            inputFile.close();
            outputFile.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





