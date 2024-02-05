package com.example.demo.user;

import java.sql.Date;
import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.DataNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	
	 private final UserRepository userRepository;
	 private final PasswordEncoder passwordEncoder;

	 
	 
	 public void withdrawUser(String username) {
	        SiteUser user = userRepository.findByusername(username)
	                .orElseThrow(() -> new DataNotFoundException("User not found"));

	        userRepository.delete(user);
	    }   
	 
	 public SiteUser create(String username, String phone, String nick, Date birth, String email, String password) {
	        SiteUser user = new SiteUser();
	        user.setUsername(username);
            user.setPhone(phone);
            user.setBirth(birth);
            user.setNick(nick);
            user.setEmail(email);
//	        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//	        빈에 설정해놓고 new하지 않고 사용하는 거
	        user.setPassword(passwordEncoder.encode(password));
	        this.userRepository.save(user);
	        return user;
	    }
	    public SiteUser getUser(String username) {
	        Optional<SiteUser> siteUser = this.userRepository.findByusername(username);
	        if (siteUser.isPresent()) {
	            return siteUser.get();
	        } else {
	            throw new DataNotFoundException("siteuser not found");
	        
	        
	            
	            
	        }
	        
	        
	        
	    }

}
