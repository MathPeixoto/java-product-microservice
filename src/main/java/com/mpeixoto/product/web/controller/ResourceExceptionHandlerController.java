package com.mpeixoto.product.web.controller;

import com.mpeixoto.product.exception.BadRequestException;
import com.mpeixoto.product.exception.InternalServerErrorException;
import com.mpeixoto.product.exception.NotFoundException;
import com.mpeixoto.product.web.model.StandardError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Class responsible for handling exceptions.
 *
 * @author Matheus Peixoto
 */
@ControllerAdvice
public class ResourceExceptionHandlerController {

    /**
     * Method responsible for handling an exception when an object is not found.
     *
     * @param e       object of type NotFoundException. It is the exception that was thrown.
     * @param request Request that needs to be handled.
     * @return a ResponseEntity that contains the Standard Error.
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(
            NotFoundException e, HttpServletRequest request) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        StandardError error =
                StandardError.builder()
                        .timestamp(System.currentTimeMillis())
                        .status(httpStatus.value())
                        .error("Not found")
                        .message(e.getMessage())
                        .path(request.getRequestURI())
                        .build();
        return new ResponseEntity<>(error, httpStatus);
    }

    /**
     * Method responsible for handling an exception when an error occurred in the server.
     *
     * @param e       object of type InternalServerErrorException. It is the exception that was thrown.
     * @param request Request that needs to be handled.
     * @return a ResponseEntity that contains the Standard Error.
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<StandardError> internalServerErrorException(
            InternalServerErrorException e, HttpServletRequest request) {
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        StandardError error =
                StandardError.builder()
                        .timestamp(System.currentTimeMillis())
                        .status(httpStatus.value())
                        .error("Internal Server Error")
                        .message(e.getMessage())
                        .path(request.getRequestURI())
                        .build();
        return new ResponseEntity<>(error, httpStatus);
    }


    /**
     * Method responsible for handling an exception when a bad request is made by the client.
     *
     * @param e       object of type BadRequestException. It is the exception that was thrown.
     * @param request Request that needs to be handled.
     * @return a ResponseEntity that contains the Standard Error.
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<StandardError> badRequestException(
            BadRequestException e, HttpServletRequest request) {
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        StandardError error =
                StandardError.builder()
                        .timestamp(System.currentTimeMillis())
                        .status(httpStatus.value())
                        .error("Bad Request")
                        .message(e.getMessage())
                        .path(request.getRequestURI())
                        .build();
        return new ResponseEntity<>(error, httpStatus);
    }
}
