package com.cvk.lc.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.cvk.lc.common.LinkConversionConstants;
import com.cvk.lc.exception.InvalidDeeplinkException;

public class DeeplinkValidator implements ConstraintValidator<ValidDeeplink, String> {
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		if(!value.startsWith(LinkConversionConstants.DEEPLINK_PREFIX)) {
			throw new InvalidDeeplinkException("Invalid/unacceptable deeplink!");
		}
		return true;
	}

}
