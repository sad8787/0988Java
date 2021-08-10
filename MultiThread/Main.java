 public static void main(String[]args){
       /* MyThread t1=new MyThread("labar ropa");
        MyThread t2=new MyThread("Labar piso");
        MyThread t3=new MyThread("comer");
        MyThread t4=new MyThread("Correr");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        Thread ta1=new Thread(new MyRumbleThread("dormir"));
        Thread ta2=new Thread(new MyRumbleThread("sonar"));
        ta1.start();
        ta2.start();*/
        Thread tr1=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<100;i++){
                    System.out.println("Tarea tr1 completado al "+i+"%");
                }
            }
        });
        Thread tr2=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<100;i++){
                    System.out.println("Tarea tr2 completado al "+i+"%");
                }
            }
        });
        Thread tr3=new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i<100;i++){
                    System.out.println("Tarea tr3 completado al "+i+"%");
                }
            }
        });
        tr1.start();
        tr2.start();
        tr3.start();
    }

}
class MyThread extends Thread{
    public String task;
    public String getTask() {
        return task;
    }
    public MyThread(String task ){
        super();
        this.task=task;
    }
    @Override
    public void run(){
        for (int i=0;i<100;i++){
            System.out.println("Tarea "+task+" completado al "+i+"%");
        }
    }
}
class MyRumbleThread implements Runnable{
    public String task;
    MyRumbleThread(String task){
        this.task=task;
    }

    @Override
    public void run() {
        for (int i=0;i<100;i++){
            System.out.println("Tarea "+task+" completado al "+i+"%");
        }
    }
}
