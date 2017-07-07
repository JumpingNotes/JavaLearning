package autoassembly.servicefactory;

import java.lang.annotation.*;

/**
 * @author 鱼唇的人类
 * @date 2017/7/7
 * @time 13:57
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD,ElementType.METHOD})
@Documented
public @interface Auto {
    String value() default "";
}
