package autoassembly.beanfactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 鱼唇的人类
 * @date 2017/7/7
 * @time 9:51
 */
public class BeanFactory {
    private static Map<String,Object> beanMap=null;

    public static Object getBean(String beanName){
        if (beanMap==null)
            return null;
        else
            return beanMap.get(beanName);
    }

    public static Object getBean(Class<?> clazz, String beanName){
        final Object[] object = {new Object()};
        Arrays.stream(clazz.getDeclaredMethods()).forEach((method)->{
            if (method.isAnnotationPresent(Bean.class)){
                Bean bean=method.getDeclaredAnnotation(Bean.class);
                String value=bean.value();
                if ("".equals(value))
                    value=method.getName();
                if (!"".equals(value)&&value.equals(beanName)) {
                    try {
                        Object o = clazz.newInstance();
                        object[0] = method.invoke(o);
                        if (beanMap==null)
                            beanMap=new HashMap<>();
                        beanMap.put(beanName,object[0]);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        return object[0];
    }
}
