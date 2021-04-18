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
                .message(ex.getMessage())
                .path(request.getDescription(false))
                .error(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .status(500)
                .build();
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<ExceptionResponse> handleNotFoundException(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse.ExceptionResponseBuilder()
                .timesTamp(new Date())
                .message(ex.getMessage())
                .path(request.getDescription(false))
                .error(HttpStatus.NOT_FOUND.getReasonPhrase())
                .status(404)
                .build();
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnprocessableEntityException.class)
    public final ResponseEntity<ExceptionResponse> handleUnprocessableEntityException(Exception ex, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse.ExceptionResponseBuilder()
                .timesTamp(new Date())
                .message(ex.getMessage())
                .path(request.getDescription(false))
                .error(HttpStatus.UNPROCESSABLE_ENTITY.getReasonPhrase())
                .status(422)
                .build();
        return new ResponseEntity<>(exceptionResponse, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionResponse exceptionResponse = new ExceptionResponse.ExceptionResponseBuilder()
                .timesTamp(new Date())
                .message(ex.getFieldError().getField() + " " + ex.getFieldError().getDefaultMessage())
                .path(request.getDescription(false))
                .error(status.getReasonPhrase())
                .status(400)
                .build();
        return new ResponseEntity<>(exceptionResponse, status);
    }
}
