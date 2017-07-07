package annotation.anno;

import java.lang.annotation.*;

/**
 * @author 鱼唇的人类
 * @date 2017/7/6
 * @time 17:06
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface Bean {
    String value() default "";
}
