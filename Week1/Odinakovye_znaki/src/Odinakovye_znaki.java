import java.util.Scanner;

public class Odinakovye_znaki {

    public static void main(String[] args){

        Scanner input=new Scanner(System.in);

        int a = input.nextInt();
        int[] b = new int[a];

        for(int i=0;i<a;i++){
            b[i]=input.nextInt();
        }
        for(int i=0;i<a-1;i++){

            if((b[i]>0 && b[i+1]>0)|| (b[i]<0&& b[i+1]<0)){
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}
