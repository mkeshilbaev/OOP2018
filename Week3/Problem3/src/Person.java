import java.util.Vector;
class Person
{
    private String name;
    Person(){
        name="";
    }
    Person(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public String toString(){
        return name;
    }
    public boolean equals(Object obj){
        return this.equals(obj);
    }
}

class Employee extends Person
{
    private double salary;
    private int yearofwork;
    private String insuranceNumber;

    Employee()
    {
        super();
        salary = 0.f;
        yearofwork = 0;
        insuranceNumber = "";
    }
    Employee(String name,double salary,int yearOfwork,String insuranceNumber)
    {
        super(name);
        this.salary = salary;
        this.yearofwork = yearOfwork;
        this.insuranceNumber = insuranceNumber;
    }

    @Override
    public boolean equals(Object obj){
        Person p = (Person) obj;
        if(super.equals(obj))
            return true;
        return false;
    }
    public String toString(){
        return "Name: "+super.toString()+" Salary: "+this.salary+" YearOfWork: "+ this.yearofwork+" InsuranceNUmber: "+this.insuranceNumber;
    }
}

class Manager extends  Employee
{
    public Vector<Employee> employeeVector = new Vector<Employee>();
    private double bonus;
    static int team;

    Manager(){
        super();
        bonus =0;
        employeeVector = null;
    }

    Manager(int bonus,String name,double salary,int yearOfwork,String insuranceNumber)
    {
        super(name,salary,yearOfwork,insuranceNumber);
        this.team++;
        this.bonus = bonus;
    }

    public void AddEmployee(Employee e)
    {
        employeeVector.add(e);
        this.bonus +=bonus;
    }
    public String toString(){
        String s="";
        for(int i = 0; i < employeeVector.size(); i++){
            s += "\n"+employeeVector.get(i).toString();
        }
        return "Team: " + team + " Bonus :" + bonus + "\n" + super.toString() + "" + s;
    }
    @Override
    public boolean equals(Object obj){
        if(super.equals(obj))
            return true;
        return false;
    }
}

class testManager{
    public static  void main(String[] args){
         Object obj = new Object();

        Employee e1 = new Employee("Madi",150000,2,"17BD090493");
        Employee e2 = new Employee("Daur",130000,1,"17BD080903");
        System.out.println(e1.toString());
        System.out.println(e2.toString());

        Manager m1 = new Manager(50,"Madi",200000,10,"15BD080903");
        System.out.println(e1.equals(m1));

 //         m1.AddEmployee(e1);
//          m1.AddEmployee(e2);
          System.out.println(m1.toString());
//
          Manager m2 = new Manager(50,"Islam",210000,12,"14BD010203");
//        m2.AddEmployee(e2);
//        m2.AddEmployee(e1);
//        System.out.println(m2.toString());
//        System.out.println(m2.equals(m1));
    }
}
