import java.util.Scanner;
abstract public class Piece
{
    public abstract void isLegalMove(int x1, int y1, int x2, int y2);
    }

    class King extends Piece
    {
        int x1, y1, x2, y2;

       public King(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
       }
       @Override
        public void isLegalMove(int x1, int y1, int x2, int y2){

           if (Math.abs(x1 - x2)<= 1 && Math.abs(y1 - y2) <= 1){
               System.out.println("King");
           }
       }
    }

    class Rook extends Piece //Это ладья(башня)
    {
        int x1, y1, x2, y2;
        public Rook(int x1, int y1, int x2, int y2){
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
        @Override
        public void isLegalMove(int x1, int y1, int x2, int y2){
            if ((x1 == x2) || (y1 == y2)){
                System.out.println("Rook");
            }
        }
    }

     class Slon extends Piece
     {
         int x1, y1, x2, y2;
            public Slon(int x1, int y1, int x2, int y2){
                this.x1 = x1;
                this.y1 = y1;
                this.x2 = x2;
                this.y2 = y2;
            }
            @Override
            public void isLegalMove(int x1, int y1, int x2, int y2){
                if (Math.abs(x1 - x2) == Math.abs(y1 - y2)){
                    System.out.println("Slon");
                }
            }
        }

        class testChess{
            public static void main(String[] args){
            int x1, y1, x2, y2;
            Scanner sc = new Scanner(System.in);
                x1 = sc.nextInt();
                y1 = sc.nextInt();
                x2 = sc.nextInt();
                y2 = sc.nextInt();

                King k = new King(x1,  y1,  x2, y2);
                Rook r = new Rook(x1,  y1,  x2, y2);
                Slon s = new Slon(x1,  y1,  x2, y2);

                k.isLegalMove(x1,  y1,  x2, y2);
                r.isLegalMove(x1,  y1,  x2, y2);
                s.isLegalMove(x1,  y1,  x2, y2);
            }
        }
