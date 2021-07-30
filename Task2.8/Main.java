public class Main {
    public static void main(String[] args) {
        int[]a={2,3,4,5};
        int r=a[0];
        for (int i=1;i<a.length;i++){
            r*=a[i];
        }
        System.out.println(r);
    }
}
