package com.service.adviceHandler;


public class PropertiesNotFound extends Exception {

    private String message;

    public PropertiesNotFound(String s) {
        this.message=s;

    }

    public PropertiesNotFound() {

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
