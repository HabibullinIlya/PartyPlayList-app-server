package ru.khabibullin.demo.controllers;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.khabibullin.demo.models.AppUser;
import ru.khabibullin.demo.repository.AppUserRepository;
import ru.khabibullin.demo.viewModel.RegistrationForm;

@Controller
public class RegistrationController {
    final AppUserRepository userRepository;
    final PasswordEncoder passwordEncoder;

    public RegistrationController(AppUserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @GetMapping("/registration")
    public String registrationForm(@ModelAttribute AppUser user) {
        return "registration";
    }


    @PostMapping("/regisrtration")
    public String registration(@ModelAttribute RegistrationForm registrationForm) {
        userRepository.save(registrationForm.toUser(passwordEncoder));
        return "test";
    }

}
