package com.example.lab5.controller;

import com.example.lab5.model.RegisterDto;
import com.example.lab5.model.user.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class AccountController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public String register(Model model) {
        RegisterDto registerDto = new RegisterDto();
        model.addAttribute(registerDto);
        model.addAttribute("success", false);
        return "register";
    }

    @PostMapping("/register")
    public String register(Model model, @Valid @ModelAttribute RegisterDto registerDto, BindingResult bindingResult) {
        if (!registerDto.getPassword().equals(registerDto.getConfirmPassword())) {
           bindingResult.addError(new FieldError("password", "confirmPassword", "Passwords do not match"));
        }

        com.example.lab5.model.user.User user = userRepository.findByEmail(registerDto.getEmail());
        if (user != null) {
            bindingResult.addError(new FieldError("registerDto", "email", "Email is already in use"));
        }

        if (bindingResult.hasErrors()) {
            return "register";
        }

        try {
            var bCryptEncoder = new BCryptPasswordEncoder();

            com.example.lab5.model.user.User newUser = new com.example.lab5.model.user.User();
            newUser.setFirstName(registerDto.getFirstName());
            newUser.setLastName(registerDto.getLastName());
            newUser.setAccountCreationDate(new Date());
            newUser.setEmail(registerDto.getEmail());
            newUser.setPassword(bCryptEncoder.encode(registerDto.getPassword()));

            userRepository.save(newUser);

            model.addAttribute("registerDto", new RegisterDto());
            model.addAttribute("success", true);
        } catch (Exception e) {
            bindingResult.addError(new FieldError("registerDto", "firstName", e.getMessage()));
        }

        return "register";
    }
}
