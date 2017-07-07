package autoassembly.beanfactory;

import java.lang.annotation.*;

/**
 * @author 鱼唇的人类
 * @date 2017/7/7
 * @time 9:50
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface Bean {
}
