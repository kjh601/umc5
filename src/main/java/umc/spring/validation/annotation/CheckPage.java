package umc.spring.validation.annotation;

import umc.spring.validation.validator.PageCheckValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PageCheckValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPage {

    String message() default "페이지 번호가 0 이하 입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};
}
