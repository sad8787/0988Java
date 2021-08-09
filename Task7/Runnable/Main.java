import java.io.FileInputStream;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
public class Main {
    public static void main(String[] args) {
        String functionalIp = "";
        try {
            FileInputStream fin = new FileInputStream("C://text//ip.txt");
            int i;
            String resultIP = "";
            while ((i = fin.read()) != -1) {//code ascii return -1 como fin de texto
                if (i == 13) {
                    continue;
                }//retorno del carro comiensa una nueva linea
                if (i == 10) {//el final de la linea ascii code 10 fin de linea "\n"
                    //System.out.println(resultIP);
                    String[] result = resultIP.split(":");
                    String ip = result[0];
                    int port;

                    if (!ip.equals("") && !result[1].equals("")) {
                        port = Integer.parseInt(result[1]);
                        Thread chekerip=new Thread(new ProxyChekerRunnable(ip,port));
                        //ProxyCheker a= new ProxyCheker(ip, port);
                        //a.start();
                        chekerip.start();

                    }
                    System.out.print(functionalIp);
                    resultIP = "";
                } else if (i == 9) { //code ascii return 9 cuando tabulacion  "\t"
                    //System.out.print(":");
                    resultIP += ":";
                } else {
                    // System.out.print((char) i);
                    resultIP += (char) i;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ProxyChekerRunnable implements Runnable{
    String ip;
    int port;
    ProxyChekerRunnable(String ip, int port){
        this.ip=ip;
        this.port=port;
    }
    @Override
    public void run() {
        try{
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, port));
            URL url = new URL("https://vozhzhaev.ru/test.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection(proxy);
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
            }
            //System.out.println("Получен ответ, наш ip: "+response);
            System.out.println("Pабочий ip: "+ip+":"+port);
            rd.close();
            FileOutputStream fos = new FileOutputStream("C://text/good_ip.txt", true);//aqui true para que no borre lo que ya esta
            byte[] buffer = (ip+":"+port+"\n").getBytes();
            fos.write(buffer);
            fos.close();
        }catch (IOException e){
            System.out.println("Нерабочий ip: "+ip+":"+port);
        }

    }
}
