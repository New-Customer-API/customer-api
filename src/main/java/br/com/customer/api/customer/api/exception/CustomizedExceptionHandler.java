package br.com.customer.api.customer.api.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

/**
 * Intercepts exceptions and sets the correct pattern
 *
 * @author amanda
 */
@ControllerAdvice
@RestController
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InternalServerErrorException.class)
    public final ResponseEntity<ExceptionResponse> handleInternalServerErrorException(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse.ExceptionResponseBuilder()
                .timesTamp(new Date())
                .message(request.getDescription(false))
                .path(request.getContextPath())
                .error(ex.getCause().getMessage())
                .status(500)
                .build();
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundException(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse.ExceptionResponseBuilder()
                .timesTamp(new Date())
                .message(request.getDescription(false))
                .path(request.getContextPath())
                .error(ex.getCause().getMessage())
                .status(404)
                .build();
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse.ExceptionResponseBuilder()
                .timesTamp(new Date())
                .message(ex.getFieldError().getField() + " " + ex.getFieldError().getDefaultMessage())
                .path(request.getContextPath())
                .error(status.getReasonPhrase())
                .status(400)
                .build();
        return new ResponseEntity<>(exceptionResponse, status);
    }
}
