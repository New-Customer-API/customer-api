package br.com.customer.api.customer.api.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Represents exceptions
 *
 * @author amanda
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExceptionResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date timesTamp;
    private String message;
    private String path;
    private Integer status;
    private String error;

}

