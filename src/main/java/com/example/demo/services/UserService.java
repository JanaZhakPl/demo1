package com.example.demo.services;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public User getUserByEmail(String email) {
    return userRepository.findByEmail(email).orElse(null);
  }

  public void saveUser(User user) {
    // Здесь не должно быть никаких валидаций, валидация в контроллере
    userRepository.save(user);
  }
}
