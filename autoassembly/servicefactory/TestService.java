package autoassembly.servicefactory;


import autoassembly.User;

/**
 * @author 鱼唇的人类
 * @date 2017/7/7
 * @time 15:10
 */
public class TestService {
    @Auto("test")
    private User user;
    @Auto("test2")
    private User user2;
    public void print(){
        System.out.println(user.toString());
        System.out.println(user2.toString());
    }
}
