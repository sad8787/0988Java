public class Main {
    public static void main(String[] args) {
        Cat cat1=new Cat();
        cat1.age=3;
        cat1.strength=5;
        cat1.weight=3;
        Cat cat2=new Cat();
        cat2.age=2;
        cat2.strength=5;
        cat2.weight=3;
        System.out.println("Cat 1 challenges Cat 2 to a fight. is the victor? "+cat1.fight(cat2));
        System.out.println("Cat 2 challenges Cat 1 to a fight. is the victor? "+cat2.fight(cat1));

    }
}

 class Cat{
    public int weight, age, strength;
    public Cat(){

    }
    public int power(){
        return (weight*strength)*3-age;
    }
    public boolean fight(Cat cat){//
        return (power()>= cat.power());
    }
}
