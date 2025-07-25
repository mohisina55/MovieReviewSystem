package com.example.MovieReviewSystem.Service;


import com.example.MovieReviewSystem.Entity.User;
import com.example.MovieReviewSystem.Repository.UserRepo;
import com.example.MovieReviewSystem.Security.JwtUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.Optional;

@Service
public class UserService {


    @Autowired private UserRepo userRepository;
    @Autowired private PasswordEncoder passwordEncoder;
    JwtUtil jwtUtil = new JwtUtil();
    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }
    public String authenticateUser(String email, String password) {
        // Load user from DB
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Validate password
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new BadCredentialsException("Invalid password");
        }

        // Generate JWT Token using your JwtUtil
        return jwtUtil.generateToken(user.getEmail()); // ✅ Updated
    }




}

