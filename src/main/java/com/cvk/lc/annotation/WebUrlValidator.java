package com.cvk.lc.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.cvk.lc.common.LinkConversionConstants;
import com.cvk.lc.common.RegexUtil;
import com.cvk.lc.exception.InvalidWebUrlException;

public class WebUrlValidator implements ConstraintValidator<ValidWebUrl, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if ((!RegexUtil.anyMatch(LinkConversionConstants.GENERAL_URL_REGEX, value)) || (!value.startsWith(LinkConversionConstants.WEB_URL_HOSTNAME))) {
			throw new InvalidWebUrlException("Invalid/unacceptable web url address!");
		}
		return true;
	}

}
