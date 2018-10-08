class Animal
{
    String name;
    String poroda;
    int age;

    Animal()
    {
        name = "Aktos";
        poroda = "Laika";
        age = 1;
    }

    public void move()
    {
        System.out.println("Animal moves");
    }

    public void bark()
    {
        System.out.println("Barking!!!!");
    }

    public void info(){
        System.out.println("Name:  " + name);
        System.out.println("Poroda: " + poroda);
        System.out.println("Age: " + age);
    }
}
    class Dog extends Animal
    {
        public Dog()
        {
            super();
        }
        @Override
        public void move()
        {
            System.out.println(name + " is moving fast");
        }
        @Override
        public void bark()
        {
            System.out.println(name + " is barking too loud");
        }

        public void info(String name){
            System.out.println("Name:  " + name);
        }

        public void info(String name, String poroda, int age){
            System.out.println("Name: " + name);
            System.out.println("Poroda: " + poroda);
            System.out.println("Age: " + age);
        }
    }

    class OverrideEx
    {
    public static void main(String[] args)
    {
        Animal a = new Animal();
        Animal d = new Dog();

        a.move();
        d.move();

        a.bark();
        d.bark();

        d.info();
    }
    }


