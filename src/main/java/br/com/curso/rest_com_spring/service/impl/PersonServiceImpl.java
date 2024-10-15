package br.com.curso.rest_com_spring.service.impl;

import br.com.curso.rest_com_spring.dto.PersonDTOV2;
import br.com.curso.rest_com_spring.exception.RequiredObjectIsNullException;
import br.com.curso.rest_com_spring.exception.ResourceNotFoundException;
import br.com.curso.rest_com_spring.mapper.ObjectMapper;
import br.com.curso.rest_com_spring.mapper.custom.PersonMapper;
import br.com.curso.rest_com_spring.model.Person;
import br.com.curso.rest_com_spring.repository.PersonRepository;
import br.com.curso.rest_com_spring.service.PersonService;
import br.com.curso.rest_com_spring.dto.PersonDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

@RequiredArgsConstructor
@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    private final PersonMapper personMapper;

    private Logger logger = Logger.getLogger(PersonServiceImpl.class.getName());

    @Override
    public PersonDTO findById(Long id) {
        logger.info("Finding one person!");
        var entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        return ObjectMapper.parseObject(entity, PersonDTO.class);
    }

    @Override
    public List<PersonDTO> findAll() {
        logger.info("Finding all people");
        return ObjectMapper.parseListObjects(personRepository.findAll(), PersonDTO.class);
    }

    @Override
    public PersonDTO create(PersonDTO personDTO) {

        if(Objects.isNull(personDTO)){
            throw new RequiredObjectIsNullException();
        }

        logger.info("Create one people");
        var entity = ObjectMapper.parseObject(personDTO, Person.class);
        var entityReturn = personRepository.save(entity);
        return ObjectMapper.parseObject(entityReturn, PersonDTO.class);
    }

    @Override
    public PersonDTO update(PersonDTO personDTO) {

        if(Objects.isNull(personDTO)){
            throw new RequiredObjectIsNullException();
        }

        logger.info("Update one people");

        var entity = personRepository.findById(personDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setFirstName(personDTO.getFirstName());
        entity.setLastName(personDTO.getLastName());
        entity.setAddress(personDTO.getAddress());
        entity.setGender(personDTO.getGender());

        return ObjectMapper.parseObject(personRepository.save(entity), PersonDTO.class);
    }

    @Override
    public void delete(Long id) {
        logger.info("Delete one people");
        var entity = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        personRepository.delete(entity);
    }

    @Override
    public PersonDTOV2 createV2(PersonDTOV2 personDTOV2) {
        logger.info("Create one people");
        var entity = personMapper.convertDTOToEntity(personDTOV2);
        var entityReturn = personRepository.save(entity);
        return personMapper.convertEntityToDTO(entityReturn);
    }

}
