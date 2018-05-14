package net.socket;

/**
 * @desc:
 * @author: 鱼唇的人类
 * @date: 2017/10/13 14:42
 */
public class TestServerHandleServer implements ServerSocketHandle {
    @Override
    public String handle(String info) {
        System.out.println("来自客户端:"+info);
        return "我是服务器01";
    }
}
