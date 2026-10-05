package com.app.bidforge_security_learning.service;

import com.app.bidforge_security_learning.entity.User;
import com.app.bidforge_security_learning.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    //REGISTER
    public User register(User user){
        String encodedPassword= passwordEncoder.encode(user.getPassword());

        //hashed password stored in db
        user.setPassword(encodedPassword);

        return userRepository.save(user);

    }

    //Login
    public boolean login(String email, String rawPassword){
        //Get DB Email
        User user= userRepository
                .findByEmail(email)
                .orElse(null);

        if (user== null){
            return false;
        }

        //Match Enter and DB Password
        return passwordEncoder.matches(
                rawPassword,
                user.getPassword()

        );
    }

}
