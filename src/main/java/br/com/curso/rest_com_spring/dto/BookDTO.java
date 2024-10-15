package br.com.curso.rest_com_spring.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@JsonPropertyOrder({"id","author","launchDate","price","title"})
public class BookDTO implements Serializable {

    private static final Long serialVersionUID = 1L;

    private Long id;

    private String author;

    private Date launchDate;

    private Double price;

    private String title;

}
