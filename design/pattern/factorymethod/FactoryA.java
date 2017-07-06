package design.pattern.factorymethod;

/**
 * @author 鱼唇的人类
 * @date 2017/7/5
 * @time 11:13
 */
public class FactoryA implements Factory {

    @Override
    public ProductA createProduct() {
        System.out.println("创建了A产品");
        return new ProductA();
    }
}
