package autoassembly.servicefactory;

import annotation.User;

/**
 * @author 鱼唇的人类
 * @date 2017/7/7
 * @time 15:10
 */
public class TestService {
    @Auto("test")
    private User user;
    public void print(){
        System.out.println(user.toString());
    }
}
