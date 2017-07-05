package design.pattern.abstractfactory;

/**
 * @author 鱼唇的人类
 * @date 2017/7/5
 * @time 11:17
 */
public class Main {
    public static void main(String []args){
        AbstractFactory factory=new FactoryA();
        AbstractProduct product=factory.createProduct();
        product.useProduct();

        factory=new FactoryB();
        product=factory.createProduct();
        product.useProduct();
    }
}
