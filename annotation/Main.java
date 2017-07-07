package annotation;

import annotation.anno.Auto;
import annotation.anno.Data;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * @author 鱼唇的人类
 * @date 2017/7/6
 * @time 15:51
 */
public class Main {
    public static void main(String args[]) throws IOException {
        System.out.println(Factory.getBean(User.class));

        Service service= (Service) Reflect.getService(Service.class.getName());
        service.test();
        //1.扫描包下的类
//        PackageScanner scanner=new PackageScanner(Main.class.getPackage().getName());
//        scanner.getFullyQualifiedClassNameList().stream().forEach((clazzName)->{
//            try {
//                Class<?> clazz=Class.forName(clazzName);
//                //2.获得类的属性
//                Field[] fields = clazz.getDeclaredFields();
//                Object obj=null;
//                for (int i=0;i<fields.length;i++){
//                    //3.获得属性的注解
//                    if (fields[i].isAnnotationPresent(Auto.class)){
//                        try {
//                            obj=clazz.newInstance();
//                            fields[i].setAccessible(true);
//                            fields[i].set(obj,Factory.getBean(fields[i].getType()));
//                            System.out.println("1>>:"+fields[i].get(obj));
//                        } catch (IllegalAccessException e) {
//                            e.printStackTrace();
//                        } catch (InstantiationException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//                Method methods[]=clazz.getMethods();
//                for (int i=0;i<methods.length;i++){
//
//                }
//                for (int i=0;i<fields.length;i++){
//                    if (fields[i].isAnnotationPresent(Auto.class)) {
//                        try {
//                            obj = clazz.newInstance();
//                            fields[i].setAccessible(true);
//                            System.out.println("2>>:"+fields[i].get(obj));
//                        } catch (InstantiationException e) {
//                            e.printStackTrace();
//                        } catch (IllegalAccessException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            }
//        });
    }
}
