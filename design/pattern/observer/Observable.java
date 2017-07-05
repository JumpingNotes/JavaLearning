package design.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象被观察者
 * @author 鱼唇的人类
 * @date 2017/7/5
 * @time 10:06
 */
public abstract class Observable<T> {
    //被关注的属性 如商品的价格，快递的状态
    private T t;

    private List<Observer> observerList=new ArrayList<>();

    public T getT() {
        return t;
    }

    public void setT(T t) {
        if (this.t==null)
            this.t = t;
    }

    public void attach(Observer observer){
        if (observerList==null)
            observerList=new ArrayList<>();
        observer.setT(t);
        observerList.add(observer);
    }

    public void delete(Observer observer){
        observerList.remove(observer);
    }

    public void notifyObservers(T t){
        for (Observer observer:observerList){
            observer.update(t);
        }
    }
}
