package stream;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @desc:
 * @author: 鱼唇的人类
 * @date: 2017/11/1 14:41
 */
public class Main {
    public static void main(String []args){
        Child child=new Child();
        child.saveOne("12");
        Optional<Integer> max = Stream.of(1, 2, 3, 4, 5)
                .max(Comparator.comparingInt(o -> o));
        System.out.println("max:" + max.get());
    }
}
