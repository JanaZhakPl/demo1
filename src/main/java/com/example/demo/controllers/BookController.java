package com.example.demo.controllers;

import com.example.demo.models.Book;
import com.example.demo.services.BookService;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
  private final BookService bookService;

  @GetMapping
  public String books(@RequestParam(name = "title", required = false) String title, Model model) {
    model.addAttribute("books", bookService.listBooks(title));
    return "books"; // вынеси всё это в константы
  }

  @GetMapping("/{id}")
  public String productInfo(@PathVariable Long id, Model model) {
    Book book = bookService.getBookById(id);
    model.addAttribute("book", book);
    model.addAttribute("images", book.getImages());
    return "book_info";
  }

  @PostMapping("/create")
  public String createBook(@RequestParam("image") MultipartFile image, Book book)
      throws IOException {
    bookService.saveBook(book, image);
    return "redirect:/books";
  }

  @PostMapping("/delete/{id}")
  public String deleteBook(@PathVariable Long id) {
    bookService.deleteBook(id);
    return "redirect:/";
  }
}
