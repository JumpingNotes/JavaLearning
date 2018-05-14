package net.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @desc:
 * @author: 鱼唇的人类
 * @date: 2017/10/13 14:33
 */
public class SimpleSocketClient {
    private Socket socket;
    private ServerSocketHandle serverSocketHandle;

    public String send(String sendMsg){
        String ret=null;
        try {
            PrintStream out = new PrintStream(socket.getOutputStream());
            out.println(sendMsg);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            ret = input.readLine();
            out.close();
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ret;
    }

    public SimpleSocketClient() {
    }

    public SimpleSocketClient(String host, int port){
        try {
            this.socket=new Socket(host,port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public SimpleSocketClient(Socket socket) {
        this.socket = socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public void setServerSocketHandle(ServerSocketHandle serverSocketHandle) {
        this.serverSocketHandle = serverSocketHandle;
    }
}
