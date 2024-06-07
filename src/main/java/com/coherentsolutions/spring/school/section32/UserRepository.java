package com.coherentsolutions.spring.school.section32;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    public void save(String user) {
        System.out.println("Saving user: " + user);
    }
}
