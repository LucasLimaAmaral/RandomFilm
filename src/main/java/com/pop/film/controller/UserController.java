package com.pop.film.controller;


import org.springframework.web.bind.annotation.*;

import com.pop.film.dto.UserDTO;
import com.pop.film.model.User;
import com.pop.film.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;



@RestController
@RequestMapping(value = "/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/registration")
    public UserDTO showRegistationForm(@ModelAttribute("user") @Valid UserDTO userDTO, HttpServletRequest request, Error errors) {

        try {
        User registered = userService.registerNewUserAccount(userDTO);
    } catch (UserAlreadyExistException uaeEx) {
        mav.addObject("message", "An account for that username/email already exists.");
        return mav;
    }

        return new UserDTO(null, null, null, null, null);
    }
    
}
