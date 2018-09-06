import java.util.Scanner;

public class Perestavit_v_obratnom {

    public static void main(String[] args){

        Scanner input=new Scanner(System.in);

        int a = input.nextInt();
        int[] b = new int[a];

        for(int i=0;i<a;i++){
            b[i]=input.nextInt();
        }
        for(int i=0;i<a/2;i++){
            int c=b[i];
            b[i]=b[a-1-i];
            b[a-1-i]=c;
        }
        for(int i=0;i<a;i++){
            System.out.print(b[i]+" ");
        }
    }
}
