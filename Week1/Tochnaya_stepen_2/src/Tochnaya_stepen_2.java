import java.util.Scanner;
public class Tochnaya_stepen_2 {

    public static void main(String[]args) {

        Scanner input = new Scanner(System.in);

        int a = input.nextInt();
        int b = 1;

        while(b<=a){
            if(b==a){
                System.out.println("YES");
                return;
            }
            b*=2;
        }
        System.out.println("NO");
    }
}
