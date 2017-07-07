package annotation;

import java.lang.reflect.Field;

/**
 * @author 鱼唇的人类
 * @date 2017/7/6
 * @time 17:54
 */
public class Test {
    private static String str = null;
    public static void main(String[] args) throws Exception {
        if (true){
            Class<?> clazz = Class.forName("annotation.Test");
            Object obj = clazz.newInstance();
            // 可以直接对 private 的属性赋值
            Field field = clazz.getDeclaredField("str");
            field.setAccessible(true);
            field.set(obj, "Java反射机制");
            System.out.println(field.get(obj));
        }
        System.out.println(Test.str);
        Class<?> clazz=Class.forName("annotation.User");
        Object object=clazz.newInstance();
        Field field=clazz.getDeclaredField("name");
        Field field1=clazz.getDeclaredField("age");
        field.setAccessible(true);
        field1.setAccessible(true);
        field.set(object,"lewis");
        field1.set(object,21);
        System.out.println(object);
        User user=new User();
        System.out.println(user.equals(clazz));
        System.out.println(user.toString());
    }
}
