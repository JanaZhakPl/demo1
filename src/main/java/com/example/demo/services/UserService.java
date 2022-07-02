package com.example.demo.services;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getUsers(String name) {
        return userRepository.findAll();
    }

//    public List<User> findAll(){
//        return (List<User>) userRepository.findAll();
//    }


    public User addNewUser(User user) {

        Optional<User> userOptional = userRepository
                .findByEmail(user.getEmail());
        if (userOptional.isPresent()) {
            throw new IllegalStateException("the user have already exists");
        }
        return userRepository.save(user);
    }


//    public boolean addNewUser(User user) {
//        //validation
//        String userEmail = user.getEmail();
//
//        if (userRepository.findByEmail(userEmail) != null)
//            throw new IllegalStateException("the user have already exists");
//        //user.setActive(true);
//        //user.getRoles().add(Role.ROLE_USER);
//        //user.setPassword(passwordEncoder.encode(user.getPassword()));
//        log.info("Saving new User with email: {}", userEmail);
//        return userRepository.save(user);


    }
