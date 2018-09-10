public class Student {
    String name;
    String id;
    int year;

     public Student(String name, String id, int year){
         this.name = name;
         this.id = id;
         this.year = year;
    }

     void info(){
         System.out.println("Name: " + name + " \nId: " + id + " \nYear: " + year);
     }
    public static void main(String[] args){
         Student s = new Student("Madi", "17BD090493", 2);
         s.info();
    }
}
