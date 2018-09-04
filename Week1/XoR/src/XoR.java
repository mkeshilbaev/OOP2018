import java.util.Scanner;

public class XoR {
    public static int XOR(int x, int y){
        if (x == y)
            return 0;
        return 1;
    }

    public static void main(String[] args){
        int a, b;

        Scanner input = new Scanner(System.in);

        a = input.nextInt();
        b = input.nextInt();

        System.out.print(XOR(a, b));
    }
}
