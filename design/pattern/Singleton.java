package design.pattern;

/**
 * 单例模式 内部Enum模式
 * @author 鱼唇的人类
 * @date 2017/4/10
 * @time 13:56
 */
public class Singleton {
    private Singleton(){}

    public static Singleton getInstance(){
        return EnumSingleton.INSTANCE.getInstance();
    }

    private enum EnumSingleton{
        INSTANCE;
        Singleton singleton;
        EnumSingleton(){
            singleton=new Singleton();
        }
        public Singleton getInstance(){
            return singleton;
        }
    }
}
