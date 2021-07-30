public class Main {
    public static void main(String[] args) {
      String [] leters= {"Мама", "Мыла", "Раму"};
      for (int i=0;i< leters.length;i++){
          for (int j=0;j< leters.length;j++){
              for (int k=0;k< leters.length;k++){
                  System.out.println(leters[i]+" "+leters[j]+" "+leters[k]);
              }
          }

      }

    }
}
