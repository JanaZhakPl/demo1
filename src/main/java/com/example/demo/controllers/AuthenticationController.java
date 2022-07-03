package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class AuthenticationController {
  private static final String REGISTRATION_PAGE = "registration";
  private static final String REDIRECT_TO_HOME = "redirect:/";

  private final UserService userService;
  private final PasswordEncoder passwordEncoder;

  @GetMapping("/registration")
  public String registration() {
    return REGISTRATION_PAGE;
  }

  @PostMapping("/registration")
  public String registerUser(User incomeUser) {
    // Здесь желательно, чтобы была валидация данных, если успеешь
    String encodedPassword = passwordEncoder.encode(incomeUser.getPassword());
    incomeUser.setPassword(encodedPassword);
    userService.saveUser(incomeUser);
    return REDIRECT_TO_HOME;
  }
}
