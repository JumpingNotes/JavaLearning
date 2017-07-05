package design.pattern.observer;

/**
 * 抽象观察者
 * @author 鱼唇的人类
 * @date 2017/7/5
 * @time 10:05
 */
public abstract class Observer <T>{
    //观察的属性 如商品的价格，快递的状态
    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    //属性更新
    abstract public void update(T t);
}
