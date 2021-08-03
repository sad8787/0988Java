import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Cat cat1=new Cat("Tom",5,6);
        Dog dog1=new Dog("Spike",15,20);
        Mouse mouse1=new Mouse("Jerry",1,7);

    }
}

 class Cat{
    int weight, strength;
    public Cat( String name,int weight,  int strength){
        this.weight=weight;        
        this.strength=strength;
    }

}
class Dog{
    int weight, strength;
    String name;

    public Dog( String name,int weight,  int strength){
        this.weight=weight;        
        this.strength=strength;
        this.name=name;
    }

}
class Mouse {
    String name;
    int height;
    int tail;

    public Mouse(String name, int height, int tail) {
        this.name = name;
        this.height = height;
        this.tail = tail;
    }
}
