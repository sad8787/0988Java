import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        System.out.println("Hello There");
        System.out.println("Enter your dog's name ");
        Scanner scanner=new Scanner(System.in);
        String name=scanner.next();
        System.out.println("Enter your dog's age ");
        int age=scanner.nextInt();
        Dog dog=new Dog(name,age);
        System.out.println(dog.data());
        System.out.println("Enter your dog's NEW name ");
        name=scanner.next();       
        System.out.println("Enter your dog's NEW age ");
        age=scanner.nextInt();
        dog.setName(name);
        dog.setAge(age);
        System.out.println(dog.data());
    }
}

class Dog {
    public String name = "безымянный Dog";
    private int age;

    public Dog(String name,int age)
    {
        this.name=name;
        this.age=age;
    }
    public void setName(String name) {
        this.name=name;
    }
    public String getName() {
        return this.name;

    }
    public void setAge(int age) {
        this.age=age;
    }
    public int getAge() {
        return this.age;
    }
    public String data()
    {
        return "Name "+ name+" Age "+ age+"\n";
    }
}
