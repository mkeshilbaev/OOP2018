import java.util.Scanner;
public class Spisok_stepeni_2 {

    public static void main(String[] args){
        int n;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        int k = 1;

        while (k <= n){

                System.out.print( k + " ");
            k *= 2;
        }
    }
}
