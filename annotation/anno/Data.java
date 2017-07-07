package annotation.anno;

import java.lang.annotation.*;

/**
 * @author 鱼唇的人类
 * @date 2017/7/6
 * @time 15:54
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented//说明该注解将被包含在javadoc中
public @interface Data {
}
