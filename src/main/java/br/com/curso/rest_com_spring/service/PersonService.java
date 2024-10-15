package br.com.curso.rest_com_spring.service;

import br.com.curso.rest_com_spring.dto.PersonDTO;
import br.com.curso.rest_com_spring.dto.PersonDTOV2;

import java.util.List;

public interface PersonService {

    PersonDTO findById(Long id);

    List<PersonDTO> findAll();

    PersonDTO create(PersonDTO personDTO);

    PersonDTO update(PersonDTO personDTO);

    void delete(Long id);

    PersonDTOV2 createV2(PersonDTOV2 personDTOV2);

}
