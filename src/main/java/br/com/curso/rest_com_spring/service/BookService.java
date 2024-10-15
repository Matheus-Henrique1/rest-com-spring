package br.com.curso.rest_com_spring.service;

import br.com.curso.rest_com_spring.dto.BookDTO;

import java.util.List;

public interface BookService {

    BookDTO findById(Long id);

    List<BookDTO> findAll();

    BookDTO create(BookDTO bookDTO);

    BookDTO update(BookDTO bookDTO);

    void delete(Long id);

}
