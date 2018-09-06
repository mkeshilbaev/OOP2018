import java.util.Scanner;
public class Min_delitel {

    public static void main(String[]args) {

        Scanner input = new Scanner(System.in);

        int a=input.nextInt();
        int b=2;

        while(b<=a){
            if(a%b==0){
                System.out.println(b);
                break;
            }
            b++;
        }
    }
}
