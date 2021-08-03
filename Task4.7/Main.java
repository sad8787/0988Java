import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Animal p=new Fox();
        Color a= p.getColor();
    }
}

 interface Animal {
    Color getColor();
}

class Fox implements Animal {
     public String getName() {
        return "Fox";
    }
    public Color getColor(){
        System.out.println("Interface Method Implemented");
        return Color.gray;
    }
}
