package com.example.demo.repositories;

import com.example.demo.models.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
  List<Book> findByTitle(String title);

  List<Book> findByAuthor(String author);
}
