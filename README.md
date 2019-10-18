# socket_demo
demo1：单线程下客户端服务端通信

多线程传输
方式一 ：为每个客户分配一个工作线程。
Thread workThread=new Thread(new Handler(socket)); //创建一个工作线程
workThread.start(); //启动工作线程
                
方式二 ：创建一个线程池，由其中的工作线程来为客户服务。
ThreadPool

方式三 ：利用JDK的Java类库中现成的线程池，由它的工作线程来为客户服务。
java.util.concurrent

非阻塞通信
服务器编程范例
    创建阻塞的EchoServer
    创建非阻塞的EchoServer    【165】
    在EchoServer中混合用阻塞模式与非阻塞模式
客户端编程范例
    创建阻塞的EchoClient
    创建非阻塞的EchoClient
    创建非阻塞的PingClient
    
    
    
4.3.1节的例程4-1：采用阻塞模式，用线程池中的工作线程处理每个客户连接。
4.3.2节的例程4-2：采用非阻塞模式，单个线程同时负责接收多个客户连接，以及与多个客户交换数据的任务。
4.3.3节的例程4-3：由一个线程负责接收多个客户连接，采用阻塞模式；由另一个线程负责与多个客户交换数据，采用非阻塞模式。    



创建http服务器  --198