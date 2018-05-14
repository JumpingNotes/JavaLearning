package net.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @desc:
 * @author: 鱼唇的人类
 * @date: 2017/10/13 14:06
 */
public class SimpleSocketServer {
    private ServerSocket serverSocket;
    private ServerSocketHandle serverSocketHandle;
    private long handleFrequency=100L;//ms

    public SimpleSocketServer() {
    }

    public SimpleSocketServer(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public SimpleSocketServer(int port,int backlog) {
        try {
            this.serverSocket=new ServerSocket(port, backlog);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void service(){
        while (true){
            try (Socket socket = serverSocket.accept()){
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String inStr = input.readLine();
                String outStr= serverSocketHandle.handle(inStr);
                PrintStream out = new PrintStream(socket.getOutputStream());
                out.println(outStr);
                out.close();
                input.close();
                if (handleFrequency>0){
                    Thread.sleep(handleFrequency);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void setHandleFrequency(long handleFrequency) {
        this.handleFrequency = handleFrequency;
    }

    public void setServerSocketHandle(ServerSocketHandle serverSocketHandle) {
        this.serverSocketHandle = serverSocketHandle;
    }
}
