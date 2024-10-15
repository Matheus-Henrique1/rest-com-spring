package br.com.curso.rest_com_spring.service.impl;

import br.com.curso.rest_com_spring.dto.BookDTO;
import br.com.curso.rest_com_spring.exception.RequiredObjectIsNullException;
import br.com.curso.rest_com_spring.exception.ResourceNotFoundException;
import br.com.curso.rest_com_spring.mapper.ObjectMapper;
import br.com.curso.rest_com_spring.model.Book;
import br.com.curso.rest_com_spring.repository.BookRepository;
import br.com.curso.rest_com_spring.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;


    private Logger logger = Logger.getLogger(BookServiceImpl.class.getName());

    @Override
    public BookDTO findById(Long id) {
        logger.info("Finding one Book!");
        var entity = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No Book found for this ID!"));
        return ObjectMapper.parseObject(entity, BookDTO.class);
    }

    @Override
    public List<BookDTO> findAll() {
        logger.info("Finding all books");
        return ObjectMapper.parseListObjects(bookRepository.findAll(), BookDTO.class);
    }

    @Override
    public BookDTO create(BookDTO bookDTO) {

        if(Objects.isNull(bookDTO)){
            throw new RequiredObjectIsNullException();
        }

        logger.info("Create one book");
        var entity = ObjectMapper.parseObject(bookDTO, Book.class);
        var entityReturn = bookRepository.save(entity);
        return ObjectMapper.parseObject(entityReturn, BookDTO.class);
    }

    @Override
    public BookDTO update(BookDTO bookDTO) {

        if(Objects.isNull(bookDTO)){
            throw new RequiredObjectIsNullException();
        }

        logger.info("Update one book");

        var entity = bookRepository.findById(bookDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No book found for this ID!"));

        entity.setAuthor(bookDTO.getAuthor());
        entity.setLaunchDate(bookDTO.getLaunchDate());
        entity.setPrice(bookDTO.getPrice());
        entity.setTitle(bookDTO.getTitle());

        return ObjectMapper.parseObject(bookRepository.save(entity), BookDTO.class);
    }

    @Override
    public void delete(Long id) {
        logger.info("Delete one book");
        var entity = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No book found for this ID!"));
        bookRepository.delete(entity);
    }
}
