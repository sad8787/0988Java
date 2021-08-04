
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] myList ={1,2,3,4,5,6,7,8,9,0,12,13,-5,5};
        List numbers = new ArrayList();
        for (int i=0;i<myList.length;i++){
            if (myList[i]>0 && myList[i]<10)
                numbers.add(myList[i]);
        }
        numbers.forEach((n) -> System.out.print(n+"\t"));
    }
}
