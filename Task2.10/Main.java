import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int[]a={2,3,4,4,7,6,8};
        boolean b=false;
        for (int i=1;i<a.length;i++){
            if(a[i-1]==a[i]){
                b=true;
                break;
            }
        }
        System.out.println(b);
    }
}
