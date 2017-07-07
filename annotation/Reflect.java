package annotation;

import annotation.anno.Auto;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author 鱼唇的人类
 * @date 2017/7/6
 * @time 15:44
 */
public class Reflect {
    public static Object getService(String clazzName) throws IOException {
        Object object=null;
        try {
            Class<?> clazz = Class.forName(clazzName);
            //2.获得类的属性
            Field[] fields = clazz.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                //3.获得属性的注解
                if (fields[i].isAnnotationPresent(Auto.class)) {
                    try {
                        object = clazz.newInstance();
                        fields[i].setAccessible(true);
                        fields[i].set(object, Factory.getBean(fields[i].getType()));
                        return object;
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }
}
