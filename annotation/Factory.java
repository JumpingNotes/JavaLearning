package annotation;

import annotation.anno.Bean;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * @author 鱼唇的人类
 * @date 2017/7/6
 * @time 17:04
 */
public class Factory {
    @Bean
    public User getUser(){
        User user=new User();
        user.setName("lee");
        user.setAge(21);
        return user;
    }

    public static Object getBean(Class<?> clazz){
        final Object[] object = {new Object()};
        Arrays.stream(Factory.class.getMethods()).forEach((method -> {
            if (method.isAnnotationPresent(Bean.class)){
                Factory factory=new Factory();
                try {
                    object[0] =method.invoke(factory);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }));
        return object==null?null:object[0];
    }
}
