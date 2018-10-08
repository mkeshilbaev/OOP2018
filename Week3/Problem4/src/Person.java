public class Person {
    String name = "Madi";

    public Person(){
        this.name = name;
    }

    public String getName(){
        System.out.println("The person's name is: " + name);
        return name;
    }
}
class Student extends Person{
    @Override
     public String getName(){
         System.out.println("Student's name: " + name);
         return name;
     }
}
class Employee extends Person{
    @Override
    public String getName(){
        System.out.println("Employee's name: " + name);
        return name;
    }
}
class testPerson{
    public static  void main(String[] args){
        Student s = new Student();
        Employee e = new Employee();

        Person p1 = s;
        String temp1 = p1.getName();
    //    System.out.println(temp1);

        Person p2 = e;
        String temp2 = p2.getName();
       // System.out.println(temp2);
    }
}
