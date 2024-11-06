package com.example.lab5.services;

import com.example.lab5.model.user.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.springframework.security.core.userdetails.User;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        com.example.lab5.model.user.User user = userRepository.findByEmail(email);

        if (user != null) {
            var springUser = User.withUsername(user.getEmail())
                    .password(user.getPassword())
                    .build();

            return springUser;
        }

        return null;
    }
}
