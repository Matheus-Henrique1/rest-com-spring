package br.com.curso.rest_com_spring.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class ExceptionResponse implements Serializable {

    private static final Long serialVersionUID = 1L;

    private Date timestamp;
    private String message;
    private String details;

}
