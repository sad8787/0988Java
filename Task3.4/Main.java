import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter data number a");
        int a=scanner.nextInt();
        System.out.println("Enter data number b");
        int b=scanner.nextInt();

        System.out.println ("The expression ("+a+"+"+b+")> 10 is "+GreaterThanTen (a,  b));

    }


    public static boolean GreaterThanTen(int a,int b) {
        return ((a+b)>10);
    }
