package net.socket;

/**
 * @desc:
 * @author: 鱼唇的人类
 * @date: 2017/10/13 14:41
 */
public class Main {
    public static void main(String []args) throws InterruptedException {
        SimpleSocketServer server = new SimpleSocketServer(9000, 8);
        server.setServerSocketHandle(new TestServerHandleServer());
        server.setHandleFrequency(0);
        new Thread(()->server.service()).start();
        Runnable runnable=()->{
            SimpleSocketClient client = new SimpleSocketClient("127.0.0.1", 9000);
            client.send(Thread.currentThread().getName());
        };
        for (int i=0;i<100;i++){
            new Thread(runnable).start();
        }
    }
}
