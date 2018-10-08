import java.util.Scanner;

abstract class Shapes {
    public void volume(){}
    public void findArea(){}
}
class Cylinder extends Shapes{
    int r, h;

    Cylinder(int r, int h){
        this.r = r;
        this.h = h;
    }

    @Override
    public void volume(){
       System.out.println(Math.PI * r * r * h);
    }
    @Override
    public void findArea(){
        System.out.println((2 * Math.PI * r * r) + (2 * Math.PI * r * h));
    }
}
class Sphere extends Shapes{
    int r;
    Sphere(int r){
        this.r = r;
    }
    @Override
    public void volume(){
        System.out.println(4/3 * Math.PI * r * r * r);
    }
    @Override
    public void findArea(){
        System.out.println(4 * Math.PI * r * r);
    }
}
class Cube extends Shapes{
    int l;

    Cube(int l){
        this.l = l;
    }
    @Override
    public void volume(){
        System.out.println(l * l * l);
    }
    @Override
    public void findArea(){
        System.out.println(6 * l * l);
    }
}

class testCylinder{
    public static void main(String[] args){
    Cylinder c = new Cylinder(5, 10);
    Sphere s = new Sphere(5);
    Cube cb = new Cube(10);

    System.out.print("Volume of the Cylinder: ");
    c.volume();
    System.out.print("Area of the Cylinder: ");
    c.findArea();

        System.out.print("Volume of the Sphere: ");
    s.volume();
        System.out.print("Area of the Sphere: ");
    s.findArea();

        System.out.print("Volume of the Cube: ");
    cb.volume();
        System.out.print("Area of the Cube: ");
    cb.findArea();
    }
}
