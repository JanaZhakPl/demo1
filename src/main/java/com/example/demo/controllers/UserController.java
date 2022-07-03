package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.models.UserPrincipal;
import com.example.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
  private static final String USERS_PAGE = "users";
  private static final String ACCOUNT_PAGE = "account";

  private final UserService userService;

  @GetMapping("/users")
  public String getAllUsers(Model model) {
    model.addAttribute("users", userService.getAllUsers());
    return USERS_PAGE;
  }

  @GetMapping("/account")
  public String userAccount(Model model) {
    // Здесь вытаскиваем информацию о юзере из секюрити контекста
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    UserPrincipal principal = (UserPrincipal) authentication.getPrincipal();
    User user = userService.getUserByEmail(principal.getEmail());
    model.addAttribute("user", user); // По-хорошему вынести все аттрибуты в константы
    model.addAttribute("products", user.getBooks());
    return ACCOUNT_PAGE;
  }

  // TODO : здесь работа конкретно с юзерами, никаких книжек и регистраций и т.д.
}
