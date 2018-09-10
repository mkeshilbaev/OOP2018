import java.util.Scanner;

public class Analyzer {
    public Scanner sc = new Scanner(System.in);

    Data d = new Data();
    public int input;

    Analyzer() {
    }

    public void Info() {
        String s = "Y";
        while (s.equals("Y")) {
            System.out.println("Enter a number: ");
            input = sc.nextInt();
            d.addValue(input);
            System.out.println("Continue?");
            s = sc.next();

        }
        System.out.println("Average = " + d.getAvg());
        System.out.println("\nMaximum = " + d.getMax());
    }
}