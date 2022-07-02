package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;

    @GetMapping("/users")
    public String books(@RequestParam(name = "email", required = false) String email, Model model) {
        model.addAttribute("users", userService.getUsers(email));
        return "users";}

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

//      @PostMapping("/registration")
//    public String createUser(User user, Model model) {
//        if (!userService.addNewUser(user)) {
//            model.addAttribute("errorMessage", "Пользователь с email: " + user.getEmail() + " уже существует");
//            return "registration";
//        }
//        return "redirect:/login";
//    }

    @PostMapping("/registration")
    public String createUser(User user) {
        userService.addNewUser(user);
        return "redirect:/login";
    }
}
