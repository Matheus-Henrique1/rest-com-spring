package br.com.curso.rest_com_spring.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"id","firstName","lastName","address","gender"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonDTO implements Serializable {

    private Long id;

    @JsonProperty("first_name")
    private String firstName;

    private String lastName;

    private String address;

    private String gender;

    public PersonDTO(String firstName, String lastName, String address, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.gender = gender;
    }
}
