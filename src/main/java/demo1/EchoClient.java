package demo1;

import java.io.*;
import java.net.Socket;

public class EchoClient {

    public static void main(String[] args) {
        Socket socket = null;
        try {
            //向服务端发起连接请求
            socket = new Socket("192.168.20.9",8000);
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(new ObjectOutputStream(os));

            BufferedReader localReader = new BufferedReader(new InputStreamReader(System.in));
            String msg = null;
            while((msg = localReader.readLine())!=null){
                System.out.println("输入有值");
                pw.println(msg);
                System.out.println(br.readLine());
                if(msg.equals("bye"))
                    break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //断开连接
            try {
                if(socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
