package com.pop.film.service;

import com.pop.film.model.User;
import com.pop.film.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public String createAccount(String email, String password) {

        String criptPsswd = password;
        return criptPsswd;
    }

}
