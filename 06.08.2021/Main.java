import java.io.*;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        String functionalIp="";
        try {
            FileInputStream fin = new FileInputStream("C://text//ip.txt");
            int i;
            String resultIP="";
            while ((i=fin.read()) != -1){//code ascii return -1 como fin de texto
                if(i==13){continue;}//retorno del carro comiensa una nueva linea
                if(i==10){//el final de la linea ascii code 10 fin de linea "\n"
                    //System.out.println(resultIP);
                    String []result=resultIP.split(":");
                    String ip=result[0];
                    int port;

                    if(!ip.equals("") && !result[1].equals("")){
                        port=Integer.parseInt(result[1]);
                        String good =CheckProxy(ip,port);
                        functionalIp+=good;
                    }
                    System.out.print(functionalIp);
                    resultIP="";
                }else if(i==9){ //code ascii return 9 cuando tabulacion  "\t"
                    //System.out.print(":");
                    resultIP+=":";
                }else{
                   // System.out.print((char) i);
                    resultIP+=(char)i;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Writefichero(functionalIp,"C://text//goodip.txt");

    }

    public static String CheckProxy(String ip,int port){
        System.out.print("CheckProxy "+ip+":"+port+" ");
        String stringout="";
        try{
           // Proxy proxy=new Proxy(Proxy.Type.HTTP,new InetSocketAddress("100.0.0.52",8080));
            Proxy proxy=new Proxy(Proxy.Type.HTTP,new InetSocketAddress(ip,port));
            URL url=new URL("https://vozhzhaev.ru/test.php");
            //HttpURLConnection urlConnection= (HttpURLConnection)url.openConnection();//para connection direct
            HttpURLConnection urlConnection= (HttpURLConnection)url.openConnection(proxy);//para connection atraves de proxy
            InputStream is= urlConnection.getInputStream();
            BufferedReader rd= new BufferedReader(new InputStreamReader(is));
            StringBuilder reponse= new StringBuilder();
            String line;
            while ((line=rd.readLine())!=null){
                reponse.append(line);
            }
            System.out.println("reponse= "+reponse+" >");
            rd.close();
            stringout=ip+"\t"+port+"\n";

        }catch (IOException e){
           // System.out.println(e.getMessage());
            System.out.println("The ip does not work");
        }
        return stringout;
    }
    public static void Writefichero(String data,String addres){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(addres);
            pw = new PrintWriter(fichero);
            pw.println(data);
            fichero.close();
        }
        catch (Exception  e){
            System.out.println(e.getMessage());
        }
    }
}
