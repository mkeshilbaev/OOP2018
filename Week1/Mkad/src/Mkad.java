import java.util.Scanner;

public class Mkad {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int k = input.nextInt();

        if(k%109==0){
            System.out.println(0);
            return;
        }
        if(n>0 && k!=0){
            System.out.println(((k*n)%109));
        }
        if(n<0 && k!=0)
            System.out.println((109-Math.abs(n*k)%109));
        if(k==0 || n==0)
            System.out.println(0);
    }
}
