import java.util.Scanner;

public class Power {

    public static double Pwr(double a, int n)
    {
        double res = 1;

        if (n == 0)
            return 1;

            for (int i = 0; i < n; i++) {
                res *= a;
            }
                return res;

    }
    public static void main(String[] args){
        double num;
        int power;
        Scanner input = new Scanner(System.in);

        num = input.nextDouble();
        power = input.nextInt();

        System.out.print(Pwr(num, power));
    }
}
