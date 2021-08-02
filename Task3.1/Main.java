import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println(min(1, 2, 3));
        System.out.println(min(-1, -2, -3));
        System.out.println(min(3, 5, 3));
        System.out.println(min(5, 5, 10));

    }
    public static int min(int a,int b,int c)
    {
        if(a>b){a=b;}
        if(a>c){a=c;}
        return a;
    }
}
