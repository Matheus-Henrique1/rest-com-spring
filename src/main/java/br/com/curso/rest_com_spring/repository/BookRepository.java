package br.com.curso.rest_com_spring.repository;

import br.com.curso.rest_com_spring.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
