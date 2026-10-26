import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//@Retention 和 @Target 叫元注解（给注解用的注解），必须写在 @interface 上面。
@Retention(RetentionPolicy.RUNTIME)//保留到运行期。⚠️ 不写的话默认是 CLASS → 运行时反射读不到
@Target(ElementType.METHOD)//只能贴在方法上。贴到别处 → 编译报错
public @interface MyTest {
    String value() default "";
}

