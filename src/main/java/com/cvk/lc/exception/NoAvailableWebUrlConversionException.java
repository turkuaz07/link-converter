package com.cvk.lc.exception;

public class NoAvailableWebUrlConversionException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    
    public NoAvailableWebUrlConversionException() {
        super("There is no available web url conversion in historic context!");
    }  
}
