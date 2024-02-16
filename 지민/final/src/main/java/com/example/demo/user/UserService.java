package com.example.demo.user;

import com.example.demo.DataNotFoundException;
import com.example.demo.question.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public SiteUser create(String userName, String email, String password) {
        SiteUser user = new SiteUser();
        user.setUsername(userName);
        user.setEmail(email);
        user.setPassword(this.passwordEncoder.encode(password));
        this.userRepository.save(user);
        return user;
    }
    public SiteUser create(String registrationId, String userName,
                           String email, String password) {
        SiteUser user = new SiteUser();
        user.setUsername(userName);
        user.setEmail(email);
        user.setPassword(password);
        user.setRegisterId(registrationId);
        this.userRepository.save(user);
        return user;
    }

    public SiteUser getUser(String username) {
        Optional<SiteUser> siteUser = this.userRepository.findByusername(username);
        if (siteUser.isPresent()) {
            return siteUser.get();
        } else {
            throw new DataNotFoundException("SiteUser not found!");
        }
    }

    public SiteUser update(SiteUser user, String newPassword) {
        user.setPassword(this.passwordEncoder.encode(newPassword));
        this.userRepository.save(user);
        return user;
    }

    public boolean isMatch(String rawPassword, String encodedPassword) {
        return this.passwordEncoder.matches(rawPassword, encodedPassword);
    }

    public SiteUser getUserByEmail(String email) {
        Optional<SiteUser> siteUser = this.userRepository.findByEmail(email);
        if (siteUser.isPresent()) {
            return siteUser.get();
        } else {
            throw new DataNotFoundException("Email not found!!");
        }
    }

    public SiteUser socialLogin(String registrationId, String username, String email) {
        Optional<SiteUser> user = this.userRepository.findByusername(username);
        if (user.isPresent()) {
            return user.get();
        } else {
            return this.create(registrationId, username, email, "");
        }
    }   	
}

	    