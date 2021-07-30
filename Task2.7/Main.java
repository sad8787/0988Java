import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter data number A ");
        int a= scanner.nextInt();
        boolean b=false;
        for(int i=2;i<a;i++){
            if(a%i==0){
                b=true;
                break;
            }
        }
        System.out.println(b);
    }
}
