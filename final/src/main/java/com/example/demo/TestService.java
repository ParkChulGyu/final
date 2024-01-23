package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class TestService {
	private UserTestRepository userRepository;

    public List<User> getUserList() {
       return userRepository.findAll();
    }

    public String getUser(Long userId) {
        return "{\n" +
                "\t\t\"idx\": 1,\n" +
                "\t\t\"user_id\": \"김길동\",\n" +
                "\t\t\"user_pw\": 16,\n" +
                "\t}";
    }

}
