import java.util.Scanner;

public class Prime {

    public static boolean isPrime(int a){
        for (int i = 2; i <= Math.sqrt(a); i++){
            if (a % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[]args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();

        if (isPrime(a) == true)
            System.out.println("prime");

        else
            System.out.print("composite");
    }
}



