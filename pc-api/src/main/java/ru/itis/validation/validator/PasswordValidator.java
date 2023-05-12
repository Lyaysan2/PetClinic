package ru.itis.validation.validator;

import ru.itis.validation.annotation.ValidPassword;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;
import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<ValidPassword, Object> {

    private static final String AT_LEAST_ONE_DIGIT = ".*[0-9]+.*";

    private static final String AT_LEAST_ONE_LOWER_CASE = ".*[a-z]+.*";

    private static final String AT_LEAST_ONE_UPPER_CASE = ".*[A-Z]+.*";

    private static final String NO_WHITESPACE = "\\S+$";

    private static final String MIN_CHARACTER = ".{6,}";

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        String password = value.toString();
        boolean valid = true;

        if (Objects.isNull(password)){
            valid = false;
            buildConstraintViolationWithTemplate(context, "PASSWORD_NULL");
        }
        if (! Pattern.compile(MIN_CHARACTER).matcher(password).matches()) {
            valid = false;
            buildConstraintViolationWithTemplate(context, "PASSWORD_TOO_SHORT");
        }
        if (! Pattern.compile(AT_LEAST_ONE_DIGIT).matcher(password).matches()) {
            valid = false;
            buildConstraintViolationWithTemplate(context, "PASSWORD_NOT_CONTAIN_DIGIT");
        }
        if (! Pattern.compile(AT_LEAST_ONE_LOWER_CASE).matcher(password).matches()) {
            valid = false;
            buildConstraintViolationWithTemplate(context, "PASSWORD_NOT_CONTAIN_LOWERCASE_LETTER");
        }
        if (! Pattern.compile(AT_LEAST_ONE_UPPER_CASE).matcher(password).matches()) {
            valid = false;
            buildConstraintViolationWithTemplate(context, "PASSWORD_NOT_CONTAIN_UPPERCASE_LETTER");
        }
        if (! Pattern.compile(NO_WHITESPACE).matcher(password).matches()) {
            valid = false;
            buildConstraintViolationWithTemplate(context, "PASSWORD_CONTAIN_WHITESPACE");
        }
        return valid;
    }

    private void buildConstraintViolationWithTemplate(ConstraintValidatorContext context, String messageTemplate){
        context.buildConstraintViolationWithTemplate(messageTemplate)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
    }
}
