package com.service.adviceHandler;


import javax.persistence.EntityNotFoundException;


public class ExceptionHandlerControllerAdvice {

    public PropertiesNotFound exceptionResponse(EntityNotFoundException e){
        PropertiesNotFound exResponse = new PropertiesNotFound();
        exResponse.setMessage(e.getMessage());
        return exResponse;
    }

}
