import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int[]a={1,3,4,4,7,6,8};
        int position=a.length;
        a = Arrays.copyOf(a, a.length+10);
        Scanner scanner=new Scanner(System.in);

        for (int i=position;i<a.length;i++){
            System.out.println("Enter data Number "+( i+1-position));
            a[i]= scanner.nextInt();
        }
        int cont=0;

        for (int i=0;i<a.length;i++){
            int contaux=1;
            for (int j=i+1;j<a.length;j++){
                if(a[i]==a[j]){
                    contaux+=1;
                }
                else
                    break;
            }
            if (contaux>cont)
                cont=contaux;

        }
        for (int i=0;i<a.length;i++)
            System.out.print(a[i]+" ");

        System.out.println("\n"+cont);

    }
}
