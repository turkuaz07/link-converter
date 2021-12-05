package com.trendyol.lc.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.trendyol.lc.exception.InvalidWebUrlException;
import com.trendyol.lc.exception.NoAvailableWebUrlConversionException;

@ControllerAdvice
public class ControllerExceptionHandler {

	private final Logger log = LoggerFactory.getLogger(ControllerExceptionHandler.class);
	private static final String ERROR_LOG_PREFIX = "Exception: {0}";

	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Object> handleException(Exception ex) {
		log.error(ERROR_LOG_PREFIX, ex.getMessage());
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = { NoAvailableWebUrlConversionException.class })
	public ResponseEntity<Object> handleNoAvailableWebUrlConversionException(NoAvailableWebUrlConversionException ex) {
		log.error(ERROR_LOG_PREFIX, ex.getMessage());
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = { InvalidWebUrlException.class })
	public ResponseEntity<Object> handleInvalidWebUrlException(InvalidWebUrlException ex) {
		log.error(ERROR_LOG_PREFIX, ex.getMessage());
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
