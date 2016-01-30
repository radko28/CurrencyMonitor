package sk.cyklosoft.currencymonitor.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sk.cyklosoft.currencymonitor.vo.UserVO;

/**
 * Validation implementation to validate change password part of users/profile.jsp page form
 * 
 *
 */
public class PasswordValidator extends AbstractValidatorSupport implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return UserVO.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        UserVO user = (UserVO) obj;

        if(user.getPassword().length() < 1) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "field.required");
        }

        if(user.getConfirm().length() < 1) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirm", "field.required");            
        }

        if (user.getPassword().length() > 15) {
            errors.rejectValue("password", "field.length");
        }
        if (user.getConfirm().length() > 15) {
            errors.rejectValue("confirm", "field.length");
        }
        if (!user.getPassword().equals(user.getConfirm())) {
            errors.rejectValue("password", "field.confirm");
            errors.rejectValue("confirm", "field.confirm");
        }
    }
}
