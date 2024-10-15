package br.com.curso.rest_com_spring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTOV2 implements Serializable {

    private Long id;

    private String firstName;

    private String lastName;

    private String address;

    private String gender;

    private LocalDate BirthDay;

}
