import java.util.Scanner;

public class Hypotenuse
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int a, b;

        a = input.nextInt();
        b = input.nextInt();

        System.out.print(Math.sqrt((a * a) + (b * b)));
    }
}