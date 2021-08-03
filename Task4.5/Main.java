public class Main {
    public static void main(String[] args) {
        Horse horse=new Horse("Horse Peres",100,200);
        Pegasus pegasus =new Pegasus("Pegasus Maldovar",70,100);
        horse.running();
        pegasus.flay();
        pegasus.running();
    }
}
//animal, horse, pegasus
 class Animal{
    int weight, strength;
    String name;
    public Animal( String name,int weight,  int strength){
        this.weight=weight;
        this.strength=strength;
        this.name=name;
    }

}
class Horse extends  Animal{

    public Horse( String name,int weight,  int strength){
        super(name,weight,strength);
    }
    public void running(){
        System.out.println(name +" Ran 100 meters");
    }

}
class Pegasus extends Horse  {
    public Pegasus(String name,int weight,  int strength){
        super(name,weight,strength);
    }
    public void flay(){
        System.out.println(name +" Flay 100 meters");
    }

}
