import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.setName("Жужик");
        System.out.println(cat.name);
    }
}

class Cat {
    public String name = "безымянный кот";

    public void setName(String name) {
        this.name=name;

    }
}
