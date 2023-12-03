package umc.spring.validation.validator;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import umc.spring.base.apiPayload.code.status.ErrorStatus;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.web.controller.UserRestController;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class PageCheckValidator implements ConstraintValidator<CheckPage, Integer> {
    private static final Logger logger = LoggerFactory.getLogger(PageCheckValidator.class);

    @Override
    public void initialize(CheckPage constraintAnnotation) {
        logger.info("initialize called with value: {}", constraintAnnotation);

        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        logger.info("isValid called with value: {}", value);

        boolean isValid = value > 0;

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.INVALID_PAGE_NUMBER.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
