package autoassembly.beanfactory;

import annotation.User;

/**
 * @author 鱼唇的人类
 * @date 2017/7/7
 * @time 14:06
 */
public class Test {
    @Bean("test")
    public User test(){
        User user=new User();
        user.setName("lee");
        user.setAge(21);
        return user;
    }
}
