package Adnotacje;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Adnotacja {
    String message() default "";
    String pattern();
}
