package com.workintech.ecommercebackend.service;

import com.workintech.ecommercebackend.entity.Role;
import com.workintech.ecommercebackend.entity.User;
import com.workintech.ecommercebackend.exception.EcommerceException;
import com.workintech.ecommercebackend.repository.RoleRepository;
import com.workintech.ecommercebackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AuthenticationService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthenticationService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(String name, String email, String password, String role){
        Optional<User> optionalUser = userRepository.findUserByName(name);
        if (optionalUser.isPresent()) {
            throw new RuntimeException("This user is already exist: " + name);
        }
        String encodedPassword = passwordEncoder.encode(password);
        Optional<Role> optionalRole = roleRepository.findByAuthority(role);
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(encodedPassword);
        Role defaultRole = roleRepository.findByAuthority("USER").orElseThrow(() -> new EcommerceException("Default role not found", HttpStatus.BAD_REQUEST));
        user.setRole(optionalRole.orElse(defaultRole));

        return userRepository.save(user);


    }


}
