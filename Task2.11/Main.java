public class Main {
    public static void main(String[] args) {
        int[]a={1,3,4,4,7,6,8};
        int b=0;
        for (int i=0;i<a.length;i++){
            b+=a[i];
            if(b>10){
                System.out.println(i+1);
                break;
            }
        }

    }
}
