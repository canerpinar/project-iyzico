package com.projectiyzico.exceptionhandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NoHandlerFoundException.class)
    public ModelAndView noHandlerFound(Exception ex){
        ModelAndView modelAndView = new ModelAndView("404");
        return modelAndView;
    }


}
