import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter money ");
        double money= scanner.nextDouble();
        System.out.println("Enter annual percent");
        double percent= scanner.nextDouble();
      for (int i=0;i<5;i++){
          money=money+((money/100 )*percent);
          System.out.println("Money "+ money);
      }
    }
}
