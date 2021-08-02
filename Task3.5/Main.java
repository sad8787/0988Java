public class Main {
    public static void main(String[] args) {
       int [] array={1,2,3,4,5,6,7,8,9,0};
        ReadListRecursive(0, array);

    }

    public static void ReadListRecursive(int i,int [] array)
    {
        if(i==array.length-1)
        {
            System.out.print(""+array[i]);
        }
        else
        {
            System.out.print(""+array[i]);
            ReadListRecursive(i+1,array);
        }
    }

   
}
