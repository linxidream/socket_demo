package demo1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//socket serverSocket 建立在tcp基础  datagramSocket 建立在udp基础
//Socket类有返回输入输出流的方法  getInputStream()   getOutputStream()
public class EchoServer {

    public static void main(String[] args) {
        Socket socket = null;
        try {
            while(true){
                //向操作系统注册服务
                ServerSocket server = new ServerSocket(8000);
                //等待客户端连接，收到连接返回socket对象
                socket = server.accept();
                System.out.println("New connection accepted " + socket.getInetAddress() + " : " + socket.getPort() + "  " + socket.getLocalPort());

    //            获取输入流， 用bufferreader装饰，并写入数据
                InputStream is = socket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));

    //          获取输出流，用printwriter装饰，并读取输出流数据
                OutputStream socketout = socket.getOutputStream();
                PrintWriter pw = new PrintWriter(socketout);
                String msg = null;

                System.out.println(System.currentTimeMillis());
                while((msg = br.readLine()) != null){
                    System.out.println(msg);
                    pw.println("你输入的信息是：" + msg);
                    if(msg.endsWith("bye")){
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                //断开连接
                if(socket != null){
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }


}
