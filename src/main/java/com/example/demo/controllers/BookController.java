package com.example.demo.controllers;

import com.example.demo.models.Book;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.BookService;
import com.example.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private  final UserService userService;

    @GetMapping("/books")
    public String books(@RequestParam(name = "title", required = false) String title, Model model) {
        model.addAttribute("books", bookService.listBooks(title));
        return "books";
    }
    @GetMapping("book/{id}")
    public String productInfo(@PathVariable Long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        model.addAttribute("images", book.getImages());
        return "book_info";
    }

    @PostMapping("/book/create")
    public String createBook(@RequestParam("image") MultipartFile image, Book book) throws IOException {
        bookService.saveBook(book, image);
        return "redirect:/books";
    }

    @PostMapping("book/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/";
    }
    @GetMapping("/account")
    public String userBooks( String email, Model model) {
        User user = (User) userService.getUsers(email);
        model.addAttribute("user", user);
        model.addAttribute("products", user.getBooks());
        return "account";
    }

}
