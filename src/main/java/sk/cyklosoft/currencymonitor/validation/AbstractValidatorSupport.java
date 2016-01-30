package sk.cyklosoft.currencymonitor.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

/**
 * Abstract class as parent for validation classes
 * 
 *
 */
public abstract class AbstractValidatorSupport {
    /** Spring and Java annotation validation implementation bean */
    @Autowired
    private LocalValidatorFactoryBean localValidatorFactoryBean;
    /**
     * Spring Java annotation validation 
     * 
     * @param target
     *               object to be validated
     * @param errors
     */
    public void validate(Object target, Errors errors) {
        localValidatorFactoryBean.validate(target, errors);
    }
}