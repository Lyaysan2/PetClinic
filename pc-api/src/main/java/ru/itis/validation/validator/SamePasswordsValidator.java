package ru.itis.validation.validator;

import org.springframework.beans.BeanWrapperImpl;
import ru.itis.validation.annotation.SamePasswords;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class SamePasswordsValidator implements ConstraintValidator<SamePasswords, Object> {

    private String[] passwords;

    @Override
    public void initialize(SamePasswords constraintAnnotation) {
        this.passwords = constraintAnnotation.passwords();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {
        List<String> passwordValues = new ArrayList<>();
        BeanWrapperImpl bean = new BeanWrapperImpl(object);

        for (String password : passwords) {
            passwordValues.add((String) bean.getPropertyValue(password));
        }

        boolean isValid = passwordValues.get(0).equals(passwordValues.get(1));
        if(!isValid){
            buildConstraintViolationWithTemplate(context, "PASSWORDS_NOT_SAME");
        }
        return isValid;
    }

    private void buildConstraintViolationWithTemplate(ConstraintValidatorContext context, String messageTemplate){
        context.buildConstraintViolationWithTemplate(messageTemplate)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
    }
}