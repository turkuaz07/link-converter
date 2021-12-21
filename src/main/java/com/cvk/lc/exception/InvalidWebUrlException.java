package com.cvk.lc.exception;

import javax.validation.ConstraintDeclarationException;

public class InvalidWebUrlException extends ConstraintDeclarationException {

	private static final long serialVersionUID = 1L;

	public InvalidWebUrlException(String message) {
		super(message);
	}
}
