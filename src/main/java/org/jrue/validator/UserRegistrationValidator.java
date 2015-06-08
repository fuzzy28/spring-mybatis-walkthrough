package org.jrue.validator;

import org.jrue.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping(value="/registration")
public class UserRegistrationValidator implements Validator{

	public boolean supports(Class<?> c) {
		return User.class.isAssignableFrom(c);
	}

	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "field.name.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "department", "field.department.empty");
        if(!isNumber(((User)obj).getEmployeeId())) {
        	errors.rejectValue("employeeId", "field.employeeId.invalidNumber");
        }
	}
	
	private boolean isNumber(String number) {
		boolean isNumber = true;
		for (Character c : number.toCharArray()) {
			if(!Character.isDigit(c)) {
				isNumber = false;
				break;
			}
		}
		return isNumber;
	}
}
