import java.util.Scanner;
import java.lang.Math;

public class Squares {

    public static void main(String[] args){

        Scanner input=new Scanner(System.in);

        int a=input.nextInt();
        int b=input.nextInt();

        for(int i = a; i <= b; i++){
            for(int j = 1; j <= Math.sqrt(b); j++){

                if(j * j == i)
                {
                    System.out.print(i + " ");
                    break;
                }
            }

        }
    }
}
