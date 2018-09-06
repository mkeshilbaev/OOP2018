import java.util.Scanner;
public class Spisok_quadratov {

    public static void main(String[]args) {

        Scanner input = new Scanner(System.in);

        int a=input.nextInt();
        int b=1;

        while(b*b<=a){
            System.out.println(b*b);
            b++;
        }
    }
}
