package com.coherentsolutions.spring.school.section32;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    // Setter for UserRepository
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(String user) {
        // Business logic for registering a user
        System.out.println("Registering user: " + user);
        userRepository.save(user);
    }
}
