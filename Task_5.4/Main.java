import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        FileReader fr = null;
        BufferedReader br = null;
        ArrayList<Integer> list=new ArrayList();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter address file");
        String text= scanner.nextLine();
        if (text=="")
        {
            text="C:\\Users\\sadiel\\IdeaProjects\\5.4\\text.txt";
        }
        File archivo = new File (text);

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while((linea=br.readLine())!=null)
                list.add(Integer.parseInt(linea));//combert to int
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try{
                if( null != fr ){
                    fr.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
        ArrayList<Integer> numers=new ArrayList();
        for (int n:list){
            if (!numers.contains(n)){
                numers.add(n);
            }
        }
        for (int i=0;i<numers.size();i++){
            for (int j=i+1;j<numers.size();j++){
                if(numers.get(j)<numers.get(i)){
                    int a=numers.get(i);
                    numers.set(i,numers.get(j));
                    numers.set(j,a);
                }
            }
            System.out.print(numers.get(i)+"\t");
        }
    }
}
