package design.pattern.abstractfactory;

/**
 * @author 鱼唇的人类
 * @date 2017/7/5
 * @time 11:11
 */
public class ProductB implements AbstractProduct{
    @Override
    public void useProduct() {
        System.out.println("使用了产品B");
    }
}
