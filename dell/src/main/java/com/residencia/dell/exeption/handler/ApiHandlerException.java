package com.residencia.dell.exeption.handler;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import com.residencia.dell.error.ErrorMessage;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ApiHandlerException extends ResponseEntityExceptionHandler{

    // @ExceptionHandler(ResourceNotFoundException.class)
    // public ResponseEntity<?> handlerResourceNotFoundException(ResourceNotFoundException exception){

    //     ErrorMessage errorMessage = new ErrorMessage(
    //         "NotFound :(",
    //         HttpStatus.NOT_FOUND.value(),
    //         exception.getMessage(),
    //         exception.getClass().getName(),
    //         new Date().getTime());

    //     return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    // }

    @ExceptionHandler(ResourceBadRequestException.class)
    public ResponseEntity<?> handlerResourceBadRequestException(ResourceBadRequestException exception){
        ErrorMessage errorrMessage = new ErrorMessage(
            "Bad Request",
            HttpStatus.BAD_REQUEST.value(),
            exception.getMessage(),
            exception.getClass().getName(),
            new Date().getTime());

        return new ResponseEntity<>(errorrMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handlerInternalServerError(Exception exception){
        ErrorMessage errorMessage = new ErrorMessage(
                "Internal Server Error",
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                exception.getMessage(),
                exception.getClass().getName(),
                new Date().getTime());

        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler (value = {ConstraintViolationException.class})
    public ResponseEntity<ErrorMessage> handleConstraintViolation(ConstraintViolationException exception,
             HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorMessage erro = new ErrorMessage (
            "Por favor, verifique os parametros",
            status.value(),
            exception.getLocalizedMessage(),
            exception.getClass().getName(),
            new Date().getTime()
            );
        
        return ResponseEntity.status(status).body(erro);
    }

}