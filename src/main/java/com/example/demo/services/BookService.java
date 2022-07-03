package com.example.demo.services;

import com.example.demo.models.Book;
import com.example.demo.models.Image;
import com.example.demo.repositories.BookRepository;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
@Slf4j
@RequiredArgsConstructor
public class BookService {
  private final BookRepository bookRepository;

  public List<Book> listBooks(String title) {
    if (title != null) {
      return bookRepository.findByTitle(title);
    }
    return bookRepository.findAll();
  }

  public void saveBook(Book book, MultipartFile file) throws IOException {
    Image image;
    if (file.getSize() != 0) {
      image = toImageEntity(file);
      book.addImageToBook(image);
    }
    log.info("Saving new Book. Title: {}; Author: {}; ", book.getTitle(), book.getAuthor());
    bookRepository.save(book);
  }

  private Image toImageEntity(MultipartFile file)
      throws IOException { //from Multiparthfile to Image
    Image image = new Image();
    image.setOriginalFileName(file.getOriginalFilename());
    image.setSize(file.getSize());
    image.setBytes(file.getBytes());
    return image;
  }

  public void deleteBook(Long id) {
    bookRepository.deleteById(id);
  }

  public Book getBookById(Long id) {
    return bookRepository.findById(id).orElse(null);
  }

//    public List<Book> searchBooks(String title, String author) {
//        List<Book> searchedBooks = new ArrayList<Book>();
//        if (title != null && author == null) {
//            searchedBooks = bookRepository.findByTitle(title);
//        } else if (title == null && author != null) {
//            searchedBooks = bookRepository.findByAuthor(author);
//        } else if (title != null && author != null) {
//            searchedBooks = getByTitleAndAuthor(title, author);
//        }
//        return searchedBooks;
//    }
//    public List<Book> getByTitleAndAuthor(String title, String author){
//        List<Book> books = new ArrayList<>();
//        for (Book book : bookRepository.findAll()) {
//            if (book.getTitle().toLowerCase().contains(title.toLowerCase()) &&
//                    book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
//                books.add(book);
//            }
//        }
//        return books;
//    }
}