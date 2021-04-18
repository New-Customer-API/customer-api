package br.com.customer.api.customer.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception of not found object error type
 *
 * @author amanda
 */
@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class UnprocessableEntityException extends Exception {

    private static final long serialVersionUID = 1L;

    public UnprocessableEntityException(final String msg) {
        super(msg);
    }

}
