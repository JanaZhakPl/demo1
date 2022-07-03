package com.example.demo.controllers;

import com.example.demo.services.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class CommonController {
  private static final String HOME_PAGE = "home";
  private static final String MAIN_PAGE = "main";

  private final BookService bookService;

  @GetMapping({"/", "/home"})
  public String home() {
    return HOME_PAGE;
  }

  @GetMapping("/main")
  public String books(@RequestParam(name = "title", required = false) String title, Model model) {
    model.addAttribute("books", bookService.listBooks(title));
    return MAIN_PAGE;
  }
}
