package validation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = Mackow626Code.class)
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Mackow626 {

    public String value() default "Mackow626";
    public String message() default "must start with Mackow626";
    public Class<?>[] groups() default {};
    public Class<?extends Payload>[] payload( ) default {};
}
