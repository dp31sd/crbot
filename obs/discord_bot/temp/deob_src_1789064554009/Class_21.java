import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Class_21 {
   // $VF: renamed from: vkc () Class_402
   Class_402 method_0() default Class_402.NORMAL;
}
