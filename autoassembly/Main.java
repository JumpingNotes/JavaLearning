package autoassembly;

import annotation.User;
import autoassembly.beanfactory.BeanFactory;
import autoassembly.beanfactory.Test;
import autoassembly.servicefactory.AutoFactory;
import autoassembly.servicefactory.TestService;

/**
 * @author 鱼唇的人类
 * @date 2017/7/7
 * @time 9:46
 */
public class Main {
    public static void main(String[] args) {
        User user= (User) BeanFactory.getBean(Test.class,"test");
        System.out.println(user.toString());
        TestService testService= (TestService) AutoFactory.getService(TestService.class);
        testService.print();
    }
}
