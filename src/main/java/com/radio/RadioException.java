package com.radio;

@SuppressWarnings("serial")
public class RadioException extends RuntimeException{

    public RadioException() { }

    public RadioException(String message) {
        super(message);
    }

    public RadioException(String message, Throwable cause) {
        super(message, cause);
    }

    public RadioException(Throwable cause) {
        super(cause);
    }

}

