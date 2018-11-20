package Task1;
import java.io.BufferedReader;
import java.io.*;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Tester2{

    private static String InputFileName = "scores.txt";
    private static String OutputFileName = "grades.txt";
    private static String name, score;
    private static int sc, aver = 0, cnt1 = 0, maxim = 0, minim = 100000;
    private static StringTokenizer tokenizer;
    private static TreeMap<String,Integer> map = new TreeMap<>();

    public static void main(String[] args) {

        try {
            FileReader inputFile = new FileReader(InputFileName);
            FileWriter outputFile = new FileWriter(OutputFileName, true);

            BufferedReader in = new BufferedReader(inputFile);
            BufferedWriter out = new BufferedWriter(outputFile);

            String line = in.readLine();

            while (line != null) {
                tokenizer = new StringTokenizer(line, " ", false);
                name   = tokenizer.nextToken();
                score = tokenizer.nextToken();
                sc = Integer.parseInt(score);

                aver += sc;
                cnt1++;

                if(sc >= maxim)
                    maxim = sc;
                if(sc <= minim)
                    minim = sc;

                line=in.readLine();
            }

            out.newLine();
            out.write("Maximum - " + maxim);
            out.newLine();
            out.write("Average - " + aver / cnt1);
            out.newLine();
            out.write("Minimum - " + minim);

            in.close();
            out.close();
            inputFile.close();
            outputFile.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
