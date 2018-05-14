package net.socket;

import java.net.Socket;

/**
 * @desc:
 * @author: 鱼唇的人类
 * @date: 2017/10/13 14:07
 */
public interface ServerSocketHandle {
    //获取信息处理并返回信息
    String handle(String info);
}
