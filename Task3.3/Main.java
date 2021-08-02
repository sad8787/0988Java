public class Main {
    public static void main(String[] args) {
        System.out.println (equal (-20, -10));
        System.out.println (equal (-40,  40));
        System.out.println (equal (-20,  40));
        System.out.println (equal ( 40, 40));
        System.out.println (equal (-20,  -40));

    }
    public static boolean equal(int a,int b) {
        return (a==b);
    }
}
