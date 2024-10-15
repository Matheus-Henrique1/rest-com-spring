package br.com.curso.rest_com_spring.mapper.custom;

import br.com.curso.rest_com_spring.dto.PersonDTOV2;
import br.com.curso.rest_com_spring.model.Person;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PersonMapper {

    public PersonDTOV2 convertEntityToDTO(Person person){
        PersonDTOV2 personDTOV2 = new PersonDTOV2();
        personDTOV2.setId(person.getId());
        personDTOV2.setFirstName(person.getFirstName());
        personDTOV2.setLastName(personDTOV2.getLastName());
        personDTOV2.setGender(person.getGender());
        personDTOV2.setAddress(person.getAddress());
        personDTOV2.setBirthDay(LocalDate.now());
        return personDTOV2;
    }

    public Person convertDTOToEntity(PersonDTOV2 personDTO2){
        Person entity = new Person();
        entity.setId(personDTO2.getId());
        entity.setFirstName(personDTO2.getFirstName());
        entity.setLastName(personDTO2.getLastName());
        entity.setGender(personDTO2.getGender());
        entity.setAddress(personDTO2.getAddress());
        return entity;
    }

}
