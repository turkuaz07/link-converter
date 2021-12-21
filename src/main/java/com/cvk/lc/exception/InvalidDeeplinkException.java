package com.cvk.lc.exception;

import javax.validation.ConstraintDeclarationException;

public class InvalidDeeplinkException extends ConstraintDeclarationException {

	private static final long serialVersionUID = 1L;

	public InvalidDeeplinkException(String message) {
		super(message);
	}
}
