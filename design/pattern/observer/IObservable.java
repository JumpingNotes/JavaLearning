package design.pattern.observer;

/**
 * 具体被观察者
 * @author 鱼唇的人类
 * @date 2017/7/5
 * @time 10:07
 */
public class IObservable  extends Observable<String>{
    public void  change(String state){
        this.setT(state);
        System.out.println("状态改变");
        this.notifyObservers(state);
    }
}
