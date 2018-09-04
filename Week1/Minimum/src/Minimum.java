import java.util.Scanner;

public class Minimum {

    public static int mini(int a, int b, int c, int d){
         int mini = a;

         if (b < mini)
             mini = b;
         if (c < mini)
             mini = c;
         if (d < mini)
             mini = d;

         return mini;

    }

    public static void main(String[] args){
         int e, f, g, h;
         Scanner input = new Scanner(System.in);
         e = input.nextInt();
        f = input.nextInt();
        g = input.nextInt();
        h = input.nextInt();

         int res = mini(e, f, g, h);

         System.out.print((res));
    }

}
