public class Main {
    public static void main(String[] args) {
        System.out.println (min (-20, -10));
        System.out.println (min (-40, -10, -30, 40));
        System.out.println (min (-20, -40, -30, 40));
        System.out.println (min (-20, -10, -40, 40));
        System.out.println (min (-20, -10, -30, -40));

    }
    public static int min(int a, int b, int c, int d) {
        a=min(a,b);
        a=min(a,c);
        a=min(a,d);
        return a;
    }

    public static int min(int a, int b) {
        if(a>b){a=b;}
        return a;
    }
}
