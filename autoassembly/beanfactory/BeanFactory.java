package autoassembly.beanfactory;

import annotation.Factory;
import annotation.anno.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author 鱼唇的人类
 * @date 2017/7/7
 * @time 9:51
 */
public class BeanFactory {
    public static Object getBean(Class<?> clazz, Method bean){
        final Object[] object = {new Object()};
        Arrays.stream(clazz.getMethods()).forEach((method)->{
            if (method.isAnnotationPresent(annotation.anno.Bean.class)){
                Factory factory=new Factory();
                try {
                    object[0] =method.invoke(factory);
//                    method.invoke(object,factory);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        });
        return object[0];
    }
}
