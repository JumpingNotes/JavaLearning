package design.pattern.abstractfactory;

/**
 * @author 鱼唇的人类
 * @date 2017/7/5
 * @time 11:12
 */
public class FactoryB implements AbstractFactory{
    @Override
    public ProductB createProduct() {
        System.out.println("创建了产品B");
        return new ProductB();
    }
}
