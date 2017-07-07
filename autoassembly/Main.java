package autoassembly;

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
        //bean的注解在运行时扫描全部路径存到map里面
        //顺序问题没有解决
        User user= (User) BeanFactory.getBean(Test.class,"test");
        System.out.println(user.toString());
        System.out.println(BeanFactory.getBean(Test.class,"test2"));
        TestService testService= (TestService) AutoFactory.getService(TestService.class);
        testService.print();
    }
}
