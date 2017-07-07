package autoassembly.servicefactory;

import autoassembly.beanfactory.Bean;
import autoassembly.beanfactory.BeanFactory;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 鱼唇的人类
 * @date 2017/7/7
 * @time 14:48
 */
public class AutoFactory {
    private static Map<String,Object> objectMap=new HashMap<>();
    public static Object getService(Class<?> clazz){
        Object object = new Object();
        try {
            object = clazz.newInstance();
            Field []fields=clazz.getDeclaredFields();
            for (Field field:fields){
                if (field.isAnnotationPresent(Auto.class)){
                    Auto auto=field.getDeclaredAnnotation(Auto.class);
                    String autoName=auto.value();
                    if ("".equals(autoName))
                        autoName=field.getName();
                    field.setAccessible(true);
                    field.set(object, BeanFactory.getBean(autoName));
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return object;
    }
}
