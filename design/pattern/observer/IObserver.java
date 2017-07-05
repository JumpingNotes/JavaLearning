package design.pattern.observer;

/**
 * 具体观察者
 * @author 鱼唇的人类
 * @date 2017/7/5
 * @time 10:08
 */
public class IObserver extends Observer<String> {
    @Override
    public void update(String state) {
        System.out.println("被观察者的状态改变了："+this.getT()+"->"+state);
        this.setT(state);
    }
}
