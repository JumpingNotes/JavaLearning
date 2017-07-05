package design.pattern.singleton;

/**
 * @author 鱼唇的人类
 * @date 2017/7/5
 * @time 11:27
 */
public class Main {
    public static void main(String args[]){
        Singleton singletonA=Singleton.getInstance();
        Singleton singletonB=Singleton.getInstance();
        System.out.println(singletonA.equals(singletonB));
        System.out.println("============================");
        for (int i=0;i<100;i++){
            new Thread(() -> {
                Singleton singletonC=Singleton.getInstance();
                System.out.println(Thread.currentThread().getId()+":"+singletonA.equals(singletonC));
            }).start();
        }
    }
}
