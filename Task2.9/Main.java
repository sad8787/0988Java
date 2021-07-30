public class Main {
    public static void main(String[] args) {
        int[]a={2,3,4,5,6,8};
        boolean b=false;
        for (int i=0;i<a.length;i++){
            if(a[i]==5){
                b=true;
                break;                
            }                
        }
        System.out.println(b);
    }
}
