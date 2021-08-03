
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Family> families=new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print(" enter Family name  \n");
            String name = scanner.nextLine();
            if (name.isEmpty()) {
                break;
            }
            System.out.print("OK "+name+" enter citie \n");
            String citie = scanner.nextLine();
            if (citie.isEmpty()) {
                System.out.print(" incomplete data,, abort   \n");
                break;
            }
            families.add(new Family (name,citie));
        }
        for (Family f:families){
            System.out.print("The family "+f.getFamily() +" is from  "+f.getAddres()+" \n");
        }

    }
