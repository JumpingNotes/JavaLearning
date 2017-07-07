package annotation;

import annotation.anno.Auto;

/**
 * @author 鱼唇的人类
 * @date 2017/7/6
 * @time 15:42
 */
@annotation.anno.Service
public class Service {
    @Auto
    private User user;
    private User user2;


    public void test(){
        System.out.println(user.toString());
        System.out.println(user2.toString());
    }
}
