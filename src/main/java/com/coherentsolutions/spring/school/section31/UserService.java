package com.coherentsolutions.spring.school.section31;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    //@Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(String user) {
        // Business logic for registering a user
        System.out.println("Registering user: " + user);
        userRepository.save(user);
    }
}
