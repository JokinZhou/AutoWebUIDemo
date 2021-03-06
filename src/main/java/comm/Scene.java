package comm;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Scene {
	String name() default "";

	String version() default "";

	String category() default "";
}
