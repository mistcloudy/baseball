package com.ks.baseball.exception;

public class FMSystemException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String            message;

    public FMSystemException(String message) {
        super();
        this.message = message;
    }

    public FMSystemException(String message, Throwable cause) {
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
