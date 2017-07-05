package design.pattern.observer;

/**
 * @author 鱼唇的人类
 * @date 2017/7/5
 * @time 10:22
 */
public class Main {
    public static void main(String []args){
        IObservable iObservable=new IObservable();
        iObservable.setT("开始");
        IObserver iObserver1=new IObserver();
        iObservable.attach(iObserver1);
        IObserver iObserver2=new IObserver();
        iObservable.attach(iObserver2);
        IObserver iObserver3=new IObserver();
        iObservable.attach(iObserver3);

        System.out.println("3的状态："+iObserver3.getT());
        iObservable.change("结束");
        System.out.println("3的状态："+iObserver3.getT());
    }
}
