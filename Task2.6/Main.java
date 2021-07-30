import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter data number A ");
        int a= scanner.nextInt();
        System.out.println("Enter data number B ");
        int b= scanner.nextInt();
        if(a%b==0)
            System.out.println("Делится a/b = "+a/b);
        else
            System.out.println("Делится с остатком "+a%b);

    }
}
