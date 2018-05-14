package net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.URL;
import java.net.UnknownHostException;

/**
 * @desc:
 * @author: 鱼唇的人类
 * @date: 2017/10/13 11:46
 */
public class Main {
    public static void main(String[] args) throws IOException {
//        InetAddress localHost = InetAddress.getLocalHost();
//        System.out.println(localHost.getHostName());
//        InetAddress inetAddress = InetAddress.getByName("www.HerbSchildt.com");
//        System.out.println(inetAddress);
//        InetAddress[] allByName = InetAddress.getAllByName("www.nba.com");
//        System.out.println(allByName);
        URL url=new URL("http://39.108.134.36:8999");
        System.out.println(url.getProtocol());
        System.out.println(url.getHost());
        System.out.println(url.getPort());
        System.out.println(url.getFile());
        System.out.println(url.toExternalForm());
    }
}
